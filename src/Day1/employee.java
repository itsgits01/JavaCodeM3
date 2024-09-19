package Day1;

public class employee {
    public String name;
    public int age;
    public String city;
    public int eployeeId;


    public void printDeatils(){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("city"+city);
        System.out.println("employeeID:"+eployeeId);

    }

    employee(){
        this.name="gitesh";
        this.age=23;
        this.city="mumbai";
        this.eployeeId=12345;
        printDeatils();
    }

    public void setDetails(int age, String name,String city, int employeeid) {
        this.age = age;
        this.city=city;
        this.name=name;
        this.eployeeId=employeeid;
        //printDeatils();
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        employee emp1= new employee();

        emp1.setDetails(12,"ram","Pune",166);
        //System.out.println(emp1.getAge());
        emp1.printDeatils();
    }
}
