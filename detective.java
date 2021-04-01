
class detective extends Player{
    @Override
    public void setRole(Roles role) {
        super.setRole(Roles.detective);
    }
    Player p=new Player();
    public void choose(){
        String n=sc.next();
        if((p.name.equals(n) && p.role==Roles.mafia)||(p.name.equals(n)  && p.role==Roles.silencer)){
            System.out.println(" Yes");
        }
        else
            System.out.println("No");
    }
}


