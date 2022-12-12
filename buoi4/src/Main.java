import java.util.*;

public class Main {
    public static boolean isNumeric(String string) {    //to check if a string is a number
        int intValue;
        float floatValue;
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            floatValue = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    public static int toInt(String myString) {
        Scanner scanner = new Scanner(System.in);
        if (isNumeric(myString)) {
            return Integer.parseInt(toString(myString));
        } else {
            while (isNumeric(myString) == false) {
                myString = (toString(scanner.nextLine()));
            }

            return Integer.parseInt(toString(myString));
        }
    }


    public static float toFloat(String myString) {
        Scanner scanner = new Scanner(System.in);
        if (isNumeric(myString)) {
            return Float.parseFloat(toString(myString));
        } else {
            while (isNumeric(myString) == false) {
                System.out.print("Please input monthly income of company : ");

                myString = (toString(scanner.nextLine()));
            }

            return Integer.parseInt(toString(myString));
        }
    }

    public static String toString(String myString) {
        String[] temp = myString.split(" ");
        String sum = "";
        for (String item : temp
        ) {
            sum += item;
        }
        return sum;
    }

    public static boolean checkExistElement(List<Staff> listStaff, String myString) {
        for (Staff staff : listStaff
        ) {
            if (staff.getId().toLowerCase().equals(myString)) {
                return true;
            }
        }
        return false;
    }

    public static float maxSalaryNormal(List<Staff> listStaff) {
        float max = 0;
        for (Staff staff : listStaff
        ) {
            if (staff.getTotalSalary() > max && staff.getNumber() == 0) {
                max = staff.getTotalSalary();
            }
        }
        return max;
    }

    public static float findMaxCompanyShare(List<Staff> listStaff) {
        float max = 0;
        for (Staff staff : listStaff
        ) {
            if (staff.getNumber() == 2) {
                Director temp = (Director) (staff);
                if (temp.getCompanyShare() > max) {
                    max = temp.getCompanyShare();
                }
            }
        }
        return max;
    }

    public static int maxStaffBelowManager(List<Staff> listStaff) {
        int max = 0;
        for (Staff staff : listStaff
        ) {
            if (staff.getNumber() == 1) {
                Manager temp = (Manager) staff;
                if (temp.getCountWorkingStaff() > max) {
                    max = temp.getCountWorkingStaff();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;
        boolean started = false;
        Company company = new Company();
        List<Staff> listStaff = new ArrayList<>();
        boolean updateSalary = false;
        boolean updateClassify = false;
        List<List<Staff>> listManager = new ArrayList<>();

        do {
            System.out.println("----------------------MENU----------------------");
            System.out.println("1/ Input company informations ");
            System.out.println("2/ Classify staffs to manager ");
            System.out.println("3/ Add/Remove staff information ");
            System.out.println("4/ Output company staffs ");
            System.out.println("5/ Calculate and output all staffs salary ");
            System.out.println("6/ Find normal staffs which have highest salary");
            System.out.println("7/ Find manager which has most staffs ");
            System.out.println("8/ Sort company staffs by alphabet ");
            System.out.println("9/ Sort company staffs by salary descending ");
            System.out.println("10/Find director which has most share company ");
            System.out.println("11/Calculate and output director income ");
            System.out.print("Your choice : ");
            int intChoice = toInt(toString(scanner.nextLine()));

            switch (intChoice) {
                case 0: {
                    choice = false;
                    System.out.println("----------------------Thanks for using service----------------------");
                    break;
                }
                case 1: {
                    //Company
                    company = null;
                    listStaff.clear();
                    String name;
                    String taxId;
                    float monthIncome;
                    System.out.print("Please input name of company: ");
                    name = toString(scanner.nextLine());
                    System.out.print("Please input tax id of company : ");
                    taxId = toString(scanner.nextLine());
                    System.out.print("Please input monthly income of company : ");
                    monthIncome = toFloat(toString(scanner.nextLine()));
                    company = new Company(name, taxId, monthIncome);
                    started = true;
                    //Staffs or managers input for company
                    int count = 0;

                    System.out.print("Please input number of people in company : ");
                    count = toInt(toString(scanner.nextLine()));
                    updateSalary = false;
                    for (int i = 0; i < count; i++) {
                        String position;
                        System.out.print("Choose position (n for normal staff , m for manager ,d for director ,e for exit) : ");
                        position = toString(scanner.nextLine());
                        if (position.equals("m")) {
                            Manager manager = new Manager();
                            manager.input();
                            listStaff.add(manager);
                            System.out.println("----->New manager added completely\n");

                        } else if (position.equals("n")) {

                            NormalStaff staff = new NormalStaff();
                            staff.input();
                            if (i == 0) {
                                listStaff.add(staff);
                                NormalStaff.setListManagerId(staff.getManagerId());
                            } else {
                                listStaff.add(staff);
                            }
                            System.out.println("----->New staff added completely\n");

                        } else if (position.equals("d")) {
                            Director director = new Director();
                            director.input();
                            listStaff.add(director);
                            System.out.println("----->New director added completely\n");
                        } else if (position.equals("e")) {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    if (listStaff.size() != 0) {

                        for (int i = 0; i < listStaff.size(); i++) {
                            if (listStaff.get(i).getNumber() == 0) {
                                System.out.println("===========Manager id for personnel id " + listStaff.get(i).getId());
                                NormalStaff ns = (NormalStaff) listStaff.get(i);
                                ns.setManagerId();
                                System.out.println();
                            }
                        }
                        for (Staff staff : listStaff
                        ) {
                            if (staff.getNumber() == 1) // check each manager
                            {
                                Manager manager = (Manager) staff;
                                List<Staff> tempStaff = new ArrayList<>();
                                for (Staff normalStaff : listStaff
                                ) {
                                    if (normalStaff.getNumber() == 0) // if a normal staff
                                    {
                                        int tempCount = 0;
                                        NormalStaff temp = (NormalStaff) normalStaff;
                                        if (temp.getManagerId().equals(manager.getId()))// if manager id equal to normal staff id
                                        {
                                            tempStaff.add(temp);
                                        }
                                    }
                                }
                                manager.setListBelowStaff(tempStaff);
                            }
                        }
                        System.out.println("------> Classify successfully !\n");
                        updateClassify = true;

                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 3: {
                    String caseThreeChoice;
                    if (listStaff.size() != 0) {
                        do {
                            System.out.print("a for add a personnel , r for remove a personnel :");
                            caseThreeChoice = toString(scanner.nextLine());
                            if (caseThreeChoice.toLowerCase().equals("a")) {
                                updateSalary = false;
                                updateClassify = false;
                                String position;
                                System.out.print("Choose position (n for normal staff , m for manager ,d for director ,e for exit) : ");
                                position = toString(scanner.nextLine());
                                if (position.equals("m")) {
                                    Manager manager = new Manager();
                                    manager.input();
                                    listStaff.add(manager);
                                    System.out.println("----->New manager added completely !\n");
                                } else if (position.equals("n")) {
                                    NormalStaff staff = new NormalStaff();
                                    staff.input();
                                    listStaff.add(staff);
                                    System.out.println("----->New staff added completely !\n");
                                } else if (position.equals("d")) {
                                    Director director = new Director();
                                    director.input();
                                    listStaff.add(director);
                                    System.out.println("----->New director added completely !\n");
                                } else if (position.equals("e")) {
                                    break;
                                }
                            } else if (caseThreeChoice.toLowerCase().equals("r")) {
                                System.out.print("Please input id to delete : ");
                                String deleteId = toString(scanner.nextLine());
                                if (!checkExistElement(listStaff, deleteId)) {
                                    System.out.println("------>Cannot find id to delete !\n");

                                } else {
                                    Iterator itr = listStaff.iterator();
                                    while (itr.hasNext()) {
                                        Staff staff = ((Staff) itr.next());
                                        if (staff.getId().toLowerCase().equals(deleteId.toLowerCase())) {
                                            Staff.deleteExistedId(staff.getId());
                                            itr.remove();
                                        }
                                    }
                                    System.out.println("------>Deleted successfully !\n");
                                }
                            }
                        } while (!caseThreeChoice.toLowerCase().equals("r") && !caseThreeChoice.toLowerCase().equals("a"));
                    } else {
                        if (started == false) {
                            System.out.println("Please fill company information !\n");
                        } else {
                            do {
                                System.out.print("a for add a personnel :");
                                caseThreeChoice = toString(scanner.nextLine());
                                if (caseThreeChoice.toLowerCase().equals("a")) {
                                    updateSalary = false;
                                    updateClassify = false;
                                    String position;
                                    System.out.print("Choose position (n for normal staff , m for manager ,d for director ,e for exit) : ");
                                    position = toString(scanner.nextLine());
                                    if (position.equals("m")) {
                                        Manager manager = new Manager();
                                        manager.input();
                                        listStaff.add(manager);
                                        System.out.println("----->New manager added completely !\n");
                                    } else if (position.equals("n")) {
                                        NormalStaff staff = new NormalStaff();
                                        staff.input();
                                        listStaff.add(staff);
                                        System.out.println("----->New staff added completely !\n");
                                    } else if (position.equals("d")) {
                                        Director director = new Director();
                                        director.input();
                                        listStaff.add(director);
                                        System.out.println("----->New director added completely !\n");
                                    } else if (position.equals("e")) {
                                        break;
                                    }
                                    break;
                                }
                            } while (!caseThreeChoice.toLowerCase().equals("a"));
                        }
                    }
                    break;
                }
                case 4: {
                    if (listStaff.size() != 0) {
                        System.out.println("----------------------" + company.getName() + " COOPERATION----------------------");
                        for (int i = 0; i < listStaff.size(); i++) {
                            System.out.println("=======Personnel " + (i + 1) + "=======");
                            listStaff.get(i).output();
                            System.out.println();
                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }

                case 5: {
                    if (listStaff.size() != 0) {
                        System.out.println("----------------------AFTER UPDATING SALARY----------------------");
                        updateSalary = true;
                        for (Staff staff : listStaff
                        ) {
                            staff.calculateSalary();
                        }
                        for (int i = 0; i < listStaff.size(); i++) {
                            System.out.println("=======Personnel " + (i + 1) + "=======");
                            listStaff.get(i).output();
                            System.out.println();
                        }
                    } else {
                        System.out.println("------> List is empty !\n");
                    }
                    break;
                }
                case 6: {
                    if (listStaff.size() != 0) {
                        if (updateSalary == false) {
                            System.out.println("------> Salary have not been updated !\n");
                        } else {
                            float max = maxSalaryNormal(listStaff);
                            System.out.println("----------------------MAX NORMAL STAFF SALARY LIST----------------------");
                            for (Staff staff : listStaff
                            ) {
                                if (staff.getTotalSalary() == max && staff.getNumber() == 0) {
                                    staff.output();
                                    System.out.println();
                                }
                            }
                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 7: {

                    if (listStaff.size() != 0) {

                        if (updateClassify == false) {
                            System.out.println("------> List has not been classified !\n");
                        } else {
                            System.out.println("----------------------MANAGER HAS MAX STAFFS----------------------");
                            int max = maxStaffBelowManager(listStaff);
                            for (Staff staff : listStaff
                            ) {
                                if (staff.getNumber() == 1) //if a manager
                                {
                                    Manager manager = (Manager) staff;
                                    if (manager.getCountWorkingStaff() == max) {
                                        manager.output();
                                        System.out.println();
                                    }
                                }
                            }

                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 8: {
                    if (listStaff.size() != 0) {
                        Collections.sort(listStaff);
                        System.out.println("------> List is sorted ascending in alphabet successfully\n");
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 9: {
                    if (listStaff.size() != 0) {
                        if (updateSalary == false) {
                            System.out.println("------> Salary have not been updated !\n");

                        } else {
                            Collections.sort(listStaff,
                                    Comparator.comparingDouble(Staff::getTotalSalary).reversed());
                            System.out.println("------> List is sorted descending in total salary successfully\n");
                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 10: {
                    if (listStaff.size() != 0) {
                        System.out.println("----------------------TOP DIRECTOR COMPANY SHARES----------------------");
                        float max = findMaxCompanyShare(listStaff);
                        for (Staff staff : listStaff
                        ) {
                            if (staff.getNumber() == 2) {
                                Director temp = (Director) (staff);
                                if (temp.getCompanyShare() == max) {
                                    temp.output();
                                    System.out.println();
                                }
                            }
                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                case 11: {
                    if (listStaff.size() != 0) {
                        if (updateSalary == false) {
                            System.out.println("------> Salary have not been updated !\n");
                        } else {
                            System.out.println("----------------------TOTAL INCOME OF DIRECTORS----------------------");

                            float getMonthlyIncome = company.getMonthlyIncome();
                            float totalCompanySalary = 0.0f;
                            for (Staff staff : listStaff
                            ) {
                                totalCompanySalary += staff.getTotalSalary();
                            }

                            for (Staff staff : listStaff
                            ) {
                                if (staff.getNumber() == 2) {
                                    Director temp = (Director) (staff);
                                    temp.setTotalIncome(getMonthlyIncome, totalCompanySalary);
                                }
                            }
                            for (Staff staff : listStaff
                            ) {
                                if (staff.getNumber() == 2) {
                                    Director temp = (Director) (staff);
                                    temp.output();
                                    System.out.println();
                                }
                            }

                        }
                    } else {
                        System.out.println("------> List is empty !\n");

                    }
                    break;
                }
                default: {
                    System.out.println("Please input a valid number from 0 to 11");
                }
            }
        } while (choice);
    }

}

