
class doctor extends Player {
    public doctor(String name, Roles role, boolean alive) {
        super(name,Roles.doctor, alive);
    }
    Player p=new Player(name,role,true);

    public void save(){
        p.name=sc.next();
    }
}