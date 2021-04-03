import java.util.Scanner;

public  class Player{
    protected String name;
    protected Roles role;
    String voter_name;
    String votee_name;
    int count=0;
    int mafia_vote=0;
    boolean alive;
    Scanner sc=new Scanner(System.in);
    public Player(String name,Roles role,boolean alive){
        this.name=name;
        this.role=role;
        this.alive=true;
    }

    protected void vote(){
        String str=sc.nextLine();
        String a[]=str.split(" ");
        voter_name=a[0];
        votee_name=a[1];
    }

}
