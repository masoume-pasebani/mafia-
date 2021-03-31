
class detective extends Player{
    @Override
    public void setRole(String role) {
        super.setRole("detective");
    }
    Player p=new Player();
    public void choose(){
        String n=sc.next();
        if(p.name.equals(n) && p instanceof mafia || p instanceof silencer){
            System.out.println(" Yes");
        }
        else
            System.out.println("No");
    }
}


