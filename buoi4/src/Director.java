import java.util.Scanner;

class Director extends Staff implements CalculateSalaryInterface {
    //attributes
    private float companyShare;
    private float totalIncome;

    //Contructors
    public Director() {
        super();
        this.companyShare = 0.0f;
        this.totalIncome = 0.0f;
        super.setDailySalary(300);
        super.setNumber(2);
    }

    public Director(String id, String name, String phone, int daysWorking, float companyShare) {
        super(id, name, phone, daysWorking);
        super.setDailySalary(300);
        this.companyShare = companyShare;
        super.setNumber(2);
        this.totalIncome = 0.0f;
    }


    //getter setter
    public float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(float getMonthlyIncome, float totalCompanySalary) {
        float revenue = getMonthlyIncome - totalCompanySalary;
        this.totalIncome = this.getTotalSalary() + this.getCompanyShare() * revenue;
    }

    public float getCompanyShare() {
        return this.companyShare;
    }

    public void setCompanyShare(float companyShare) {
        if ((companyShare >= 0 && companyShare <= 100)) {
            this.companyShare = companyShare;
        } else {
            this.companyShare = 0.0f;
        }
    }

    public int getNumber() {
        return super.getNumber();
    }


    //input output
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String maId;
        do {
            System.out.print("Please input director id : ");
            maId = (toString(scanner.nextLine()));
        } while (checkExistedId(Staff.getExistedId(), maId));
        Staff.setExistedId(maId);
        this.setId(maId);     //input id

        System.out.print("Please input director name : ");
        this.setName(toString(scanner.nextLine()));   //input name

        System.out.print("Please input director phone number : ");
        this.setPhone(toString(scanner.nextLine()));  //input phone

        int days;
        do {
            System.out.print("Please input director days working : ");
            days = toInt(toString(scanner.nextLine()));

        } while (!(days >= 0 && days <= 31));    //input days working

        this.setDaysWorking(days);
        do {
            System.out.print("Please input director company share : ");
            days = toInt(toString(scanner.nextLine()));
        } while (!(days >= 0 && days <= 100));
        this.setCompanyShare((float) days);    //input company share
    }

    public void output() {
        System.out.println("Director id : " + this.getId());
        System.out.println("Director name : " + this.getName());
        System.out.println("Director phone number : " + this.getPhone());
        System.out.println("Director days working : " + this.getDaysWorking());
        System.out.println("Director daily salary : " + this.getDailySalary() + "$");
        System.out.println("Director monthly salary : " + this.getTotalSalary() + "$");
        System.out.println("Director total income : " + this.getTotalIncome() + "$");
        System.out.println("Company shares of director id " + this.getId() + " : " + this.getCompanyShare() + "%");
    }


    //override function in interface
    @Override
    public void calculateSalary() {
        this.setTotalSalary(this.getDailySalary() * this.getDaysWorking());
    }

}