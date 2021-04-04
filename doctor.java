
class doctor extends Player {
    public doctor(String name, Roles role, boolean alive) {
        super(name,Roles.doctor, alive);
    }
    Player saved=new Player(name,role,true);
    public Object save(String a){
        saved.name=a;
        return saved.name;
    }
}