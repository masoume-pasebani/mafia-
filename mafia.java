class mafia extends Player{

    public mafia(String name, Roles role, boolean alive) {
        super(name,Roles.mafia, alive);
    }
    Player p=new Player(name,role,alive);
    public Object kill(String s){
        String a[]=s.split("");
        p.name=a[1];
        return p;
    }
}
