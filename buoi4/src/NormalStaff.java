import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NormalStaff extends Staff implements CalculateSalaryInterface {

    //attributes
    private String managerId;
    private static List<String> listManagerId = new ArrayList<>();


    //Constructors
    public NormalStaff() {
        super();
        this.managerId = "";
        super.setDailySalary(100);
        super.setNumber(0);
    }

    public NormalStaff(String id, String name, String phone, int daysWorking) {
        super(id, name, phone, daysWorking);
        this.managerId = "";
        super.setDailySalary(100);
        super.setNumber(0);

    }

    public NormalStaff(String id, String name, String phone, int daysWorking, String manager) {
        super(id, name, phone, daysWorking);
        this.managerId = manager;
        super.setDailySalary(100);
        super.setNumber(0);
    }

    //getter setter
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId() {
        Scanner scanner = new Scanner(System.in);
        String maId;
        do {
            System.out.print("      Please input manager id (if not , tpye -1) : ");
            maId = (toString(scanner.nextLine()));
            if (maId.toLowerCase().equals("1")) {
                break;
            }
        } while (maId.toLowerCase().equals(this.getId()) || !checkManagerId(listManagerId, maId));
        this.managerId = maId;
    }

    public static List<String> getListManagerId() {
        return listManagerId;
    }

    public static void setListManagerId(String id) {
        listManagerId.add(id);
    }

    public void deleteManagerId(String id) {
        listManagerId.remove(id);
    }


    //other methods
    public boolean checkManagerId(List<String> myList, String id) {  //check if a manager id existed in listManagerId
        for (String string : myList
        ) {
            if (string.toLowerCase().equals(id.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    //input output
    public void input() {
        super.input();
    }

    public void output() {
        super.output();
        System.out.println("Staff daily salary : " + this.getDailySalary() + "$");
        System.out.println("Staff monthly salary : " + this.getTotalSalary() + "$");
        System.out.println("Staff manager id : " + this.getManagerId());
    }


    //override function in interface
    @Override
    public void calculateSalary() {
        this.setTotalSalary(this.getDailySalary() * this.getDaysWorking());
    }


}
