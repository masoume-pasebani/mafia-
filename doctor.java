
class doctor extends Player {
    public doctor(String name, Roles role, boolean alive) {
        super(name,Roles.doctor, alive);
    }
    Player p=new Player(name,role,true);
String namee;
    public void save(){
        namee=sc.next();
    }
}