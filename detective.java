
class detective extends Player {
    public detective(String name, Roles role, boolean alive) {
        super(name, Roles.detective, alive);
    }

    Player p = new Player(name, role, true);
    public void choose(String s){
        String a[]=s.split("");
        p.name=a[1];
        if(p.role==Roles.mafia || p.role==Roles.silencer){
            System.out.println("Yes");
        }
        else
            System.out.println("No");

    }


}
