public class Driver{
    public static void main(String[] args) {
        System.out.println("Ent \n1) To create an employee: \n2)To create an employee:");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if(choice==1){
            
            System.out.println("Enter student's Name: ");  
            String name = input.nextLine();
            System.out.println("Enter student's Status: ");
            String status = input.nextLine();
            System.out.println("Enter student's Address: ");
            String address = input.nextLine();
            System.out.println("Enter student's Phone Number: ");
            String phoneNumber = input.nextLine();
            System.out.println("Enter student's Email Address: ");
            String email = input.nextLine();
            
            Student p == new Student(name, status, address, phoneNumber, email);
            System.out.println(p.toString);
        }
        else if(choice==2){
            Employee r = new Employee();
        }
        Person p = new Person();

    }
}

class Person {
    String name;// = "";
    String address;// = "";
    String phoneNumber;//="";
    String emailAddress;// ="";

    Person(){

    }
   
}

public class Student extends Person{
    final String status = "Freshman";

    Student(){

    }
    String(String na, String st, String ad, String ph, String em){
        name = na;
        status = st;
        address = ad;
        phoneNumber = ph;
        emailAddress = em;
    }

    public String toString(){
        String toReturn = "Student: " + name + "\n" + 
            "Status: " + status + "\n" +
            "Address: " + address + "\n" +
            "PhoneNumber: " + phoneNumber + "\n" +
            "EmailAddress: " + emailAddress + "\n";
        return toReturn;
    }
}

/* Student p = new Student;
System.out.println(p.toString());
*/
public class Employee extends Person{
    private int office;
    private int salary;
    private MyDate dateHired;

    Employee(){

    } 
}

class MyDate{
    private String date;
    public MyDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
}

class Faculty extends Employee{
    private String officeHours;
    private String rank;

    Faculty(){

    }

    public String toString(){
        String toReturn = "Faculty: " + name + "\n" +
            "Rank: " + rank + "\n" +
            "Salary: " + salary + "\n" +
            "Date Hired: " + dateHired + "\n" +
            "Office Hours: " + officeHours + "\n" +
            "Office                              : " + office + "\n" +
            "Address: " + address + "\n" +
            "PhoneNumber: " + phoneNumber + "\n" +
            "EmailAddress: " + emailAddress+ "\n" ;
        return toReturn;
    }
}

class Staff extends Employee{
    private String title;
    String a; 
}