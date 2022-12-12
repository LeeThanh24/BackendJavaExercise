import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

abstract public class Staff implements CalculateSalaryInterface, Comparable<Staff> {
    //attributes
    private String id;
    private String name;
    private String phone;
    private int daysWorking;
    private float dailySalary;
    private float totalSalary;
    private int number; // to tick on position (0 for normal , 1 for manager , 2 for director)
    private static List<String> existedId = new ArrayList<>();  //to store already existed id of all personnels

    //Constructors
    public Staff() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.daysWorking = 0;
        this.dailySalary = 0.0F;
        this.totalSalary = 0.0f;
    }

    public Staff(String id, String name, String phone, int daysWorking) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.daysWorking = daysWorking;
        this.dailySalary = 0.0F;
        this.totalSalary = 0.0f;
    }

    public Staff(String id, String name, String phone, int daysWorking, Manager manager) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.daysWorking = daysWorking;
        this.dailySalary = 0.0F;
        this.totalSalary = 0.0f;
    }


    //getter setter
    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getDaysWorking() {
        return daysWorking;
    }

    public void setDaysWorking(int daysWorking) {
        this.daysWorking = daysWorking;
    }


    public float getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(float dailySalary) {
        this.dailySalary = dailySalary;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public static List<String> getExistedId() {
        return existedId;
    }

    public static void setExistedId(String id) {
        Staff.existedId.add(id);
    }

    public static void deleteExistedId(String id) {
        Staff.existedId.remove(id);
    }


    //other methods
    protected static boolean isNumeric(String string) {  //to check a string cam be parse into an intger number
        int intValue;
        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    protected static int toInt(String myString) {    //parse from string to intger number
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

    protected static String toString(String myString) {   // make string without any "space"
        String[] temp = myString.split(" ");
        String sum = "";
        for (String item : temp
        ) {
            sum += item;
        }
        return sum;
    }

    public boolean checkExistedId(List<String> listStaff, String x) {   //check existed id in listExistedId
        for (String staff : listStaff
        ) {
            if (staff.toLowerCase().equals(x.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    //input output
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String i;
        do {
            System.out.print("Please input staff id : ");
            i = toString(scanner.nextLine());
        } while (checkExistedId(existedId, i));
        existedId.add(i);
        this.setId(i); //input id

        System.out.print("Please input staff name : "); //input name
        this.setName(toString(scanner.nextLine()));

        System.out.print("Please input staff phone number : "); //input phone
        this.setPhone(toString(scanner.nextLine()));

        int days;
        do {
            System.out.print("Please input staff days working : ");
            days = toInt(toString(scanner.nextLine()));

        } while (!(days >= 0 && days <= 31));
        this.setDaysWorking(days); //input days

    }

    public void output() {
        System.out.println("Staff id : " + id);
        System.out.println("Staff name : " + name);
        System.out.println("Staff phone number : " + phone);
        System.out.println("Staff days working : " + daysWorking);
    }


    //overide function  in Sort library
    @Override
    public int compareTo(Staff compareFruit) {
        String compareString = ((Staff) compareFruit).getName();
        //ascending order
        return this.getName().compareTo(compareString);
    }


}

