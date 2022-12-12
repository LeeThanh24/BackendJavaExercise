import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Manager extends Staff implements CalculateSalaryInterface {
    //attributes
    private List<Staff> listBelowStaff;


    //Constructors
    public Manager() {
        super();
        super.setDailySalary(200);
        super.setNumber(1);
        listBelowStaff = new ArrayList<>();

    }

    public Manager(String id, String name, String phone, int daysWorking) {
        super(id, name, phone, daysWorking);
        super.setDailySalary(200);
        super.setNumber(1);
        listBelowStaff = new ArrayList<>();

    }

    public Manager(String id, String name, String phone, int daysWorking, int countWorkingStaff) {
        super(id, name, phone, daysWorking);
        super.setDailySalary(200);

        super.setNumber(1);
        listBelowStaff = new ArrayList<>();
    }


    //getter setter
    public List<Staff> getListBelowStaff() {
        return listBelowStaff;
    }

    public void setListBelowStaff(List<Staff> listBelowStaff) {
        this.listBelowStaff = listBelowStaff;
    }

    public int getCountWorkingStaff() {
        return listBelowStaff.size();
    }


    //input output
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String maId;
        do {
            System.out.print("Please input manager id : ");
            maId = (toString(scanner.nextLine()));
        } while (checkExistedId(Staff.getExistedId(), maId));
        Staff.setExistedId(maId);
        NormalStaff.setListManagerId(maId); //input id

        this.setId(maId);
        System.out.print("Please input manager name : ");
        this.setName(toString(scanner.nextLine()));  //input name

        System.out.print("Please input manager phone number : ");
        this.setPhone(toString(scanner.nextLine()));    //input phone

        int days;
        do {
            System.out.print("Please input manager days working : ");
            days = toInt(toString(scanner.nextLine()));
        } while (!(days >= 0 && days <= 31));
        this.setDaysWorking(days);//input days working
    }

    public void output() {
        System.out.println("Manager id : " + this.getId());
        System.out.println("Manager name : " + this.getName());
        System.out.println("Manager phone number : " + this.getPhone());
        System.out.println("Manager days working : " + this.getDaysWorking());
        System.out.println("Manager daily salary : " + this.getDailySalary() + "$");
        System.out.println("Manager monthly salary : " + this.getTotalSalary() + "$");
        System.out.println("Number of staffs working for manager id " + this.getId() + " : " + this.getCountWorkingStaff());
    }


    //override function in interface
    @Override
    public void calculateSalary() {
        this.setTotalSalary(this.getDailySalary() * this.getDaysWorking() + 100 * this.getCountWorkingStaff());
    }
}


 