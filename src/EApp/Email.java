package EApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private String alternateEmail;
    private int mailboxCapacity=50;
    private int defaultPasswordLength=10;
    private String companySufffix="company.com";

    //constructor to receive name
    public Email(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
        //System.out.println("EMAIL CREATED FOR: " + this.firstName+" "+this.lastName );

        //calling method asking for department
        this.department=setDepartment();
        //System.out.println("Department: "+department);

        //calling method which returns a random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Password: "+this.password);

        //generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySufffix;
        //System.out.println(email);

    }
    //ask for department
    private String setDepartment() {
        System.out.println(firstName+"Department Codes\n 1 for sales\n 2 for development\n 3 for accounting\n 0 for none\n Enter a department code:");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if(choice ==1)
            return "sales";
        else if(choice==2) return "dev";
        else if(choice==3) return "acc";
        else return "";
    }
    //generate password
    private String randomPassword(int n){
        String pset="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789@&#_";
        char password[] =new char[n];
        for(int i=0;i<n;i++)
        {
            int r=(int)(Math.random()*pset.length());
            password[i] = pset.charAt(r);
        }
        return new String(password);
    }
    //set mail capacity
    public void setMailboxCapacity(int capacity) {
        mailboxCapacity=capacity;
    }
    //set alternate mail
    public void setAlternateEmail(String altMail){
        alternateEmail=altMail;
    }
    //change password
    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public void showInfo(){
        System.out.println("Display name: "+firstName+" "+lastName);
        System.out.println("Company Email: "+email);
        System.out.println("Mailbox capacity: "+mailboxCapacity+"units");
    }




}
