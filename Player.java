import java.util.Scanner;

public  class Player{
    protected String name;
    protected String role;
    String voter_name;
    String votee_name;
    int count=0;
    Scanner sc=new Scanner(System.in);

    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }

    protected void vote(){
        String str=sc.nextLine();
        String a[]=str.split(" ");
        voter_name=a[0];
        votee_name=a[1];
    }



}
