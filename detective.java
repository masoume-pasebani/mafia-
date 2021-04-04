
class detective extends Player {
    public detective(String name, Roles role, boolean alive) {
        super(name, Roles.detective, alive);
    }

    Player p = new Player(name, role, true);
    public String  choose(String s){
        p.name=s;
        if(p.role==Roles.mafia || p.role==Roles.silencer){
            return "Yes";
        }
        else
            return "No";

    }


}
