
class godfather extends Player {
    public godfather(String name, Roles role, boolean alive) {
        super(name,Roles.godfather, alive);
    }
    Player p=new Player(name,role,true);
    public Object kill(String s){
        String a[]=s.split("");
        p.name=a[1];
        return p;
    }
}

