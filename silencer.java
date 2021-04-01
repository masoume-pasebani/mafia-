
class silencer extends Player{
    public silencer(String name, Roles role, boolean alive) {
        super(name,Roles.silencer, alive);
    }
    Player p=new Player(name,role,true);
    public void silent(){
        String n=sc.next();
        if(p.name.equals(n)){

        }
    }
}



