import java.util.Scanner;

class silencer extends Player{
    @Override
    public void setRole(String role) {
        super.setRole("silencer");
    }
    Scanner s=new Scanner(System.in);
    public void silent(){
        String n=s.next();
    }
}



