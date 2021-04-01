
class detective extends Player {
    public detective(String name, Roles role, boolean alive) {
        super(name, Roles.detective, alive);
    }

    Player p = new Player(name, role, true);

    public void choose() {
        String n = sc.next();
        if ((n.equals(p.name) && p.role == Roles.mafia) || (n.equals(p.name) && p.role == Roles.silencer)) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }
}
