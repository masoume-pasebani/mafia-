
class silencer extends Player {
    public silencer(String name, Roles role, boolean alive) {
        super(name, Roles.silencer, alive);
    }

    Player p = new Player(name, role, true);

    public void silent(String n) {
        if (p.name.equals(n)) {
            if(p.voter_name.equals(n)){
                System.out.println("voter is silenced");
            }
        }
    }
    public Object kill(String s){
        String a[]=s.split("");
        p.name=a[1];
        return p;
    }
}



