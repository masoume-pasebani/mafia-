
class godfather extends Player {
    public godfather(String name, Roles role, boolean alive) {
        super(name,Roles.godfather, alive);
    }
    Player p=new Player(name,role,true);
    public void kill() {
        String n = sc.next();
        if (n.equals(p.name)) {
            p.mafia_vote++;
        }
    }
}

