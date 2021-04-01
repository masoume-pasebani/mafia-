class mafia extends Player{

    public mafia(String name, Roles role, boolean alive) {
        super(name,Roles.mafia, alive);
    }
    Player p=new Player(name,role,alive);
    public void kill(){
        String n=sc.next();
        if(n.equals(p.name)){
            p.count++;
        }
    }
}
