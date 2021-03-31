import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player_names;
        Player p = new Player();
        int num;


        if (sc.next().equals("create_game")) {
            player_names = sc.nextLine();
            String[] arr = player_names.split(" ");
            num = arr.length-1;
            int isalive=num;
            Player[] players = new Player[num];
            for (int i = 0; i < num ; i++) {
                players[i] = new Player();
            }
            String[] a;
            int number_of_roles=num;
            for (int i = 0; i < num ; i++) {
                String str = sc.nextLine();
                a = str.split(" ");
                players[i].name = a[1];
                players[i].role = a[2];
                while (!players[i].name.equals(arr[i+1])) {
                    System.out.println("user not found:/.enter the correct name:");
                    players[i].name=sc.next();
                }while (number_of_roles!=num){
                    System.out.println("role not found:/");
                }

            }

            if (sc.next().equals("start_game")) {
                for (int i = 0; i < num ; i++) {
                    System.out.println(" " + players[i].name + ":" + players[i].role);

                }
                System.out.println();

                System.out.println(" ->Ready? Set! Go.<-");
            }
            else if(sc.next().equals("start_game"))
                System.out.println("no game created:/");
            int number_of_day = 0;
            int number_of_night = 0;
            while (isalive!=0) {
                number_of_day++;
                System.out.println(" Day" + number_of_day);
                for (int i = 0; i < num ; i++) {
                    players[i].vote();
                }
                int max = 0;
                String max_name = " ";
                String max_role = " ";

                if (sc.next().equals("end_vote")) {
                    for (int i = 0; i < num ; i++) {
                        for (int j = i; j < num - 1; j++) {
                            if (players[i].name.equals(players[j].votee_name)) {
                                players[i].count += 1;
                            }
                        }
                    }
                    for (int i = 0; i < num ; i++) {
                        if (players[i].count > max) {
                            max = players[i].count;
                            max_name = players[i].name;
                            max_role = players[i].role;
                        }
                    }
                    for (int i = 0; i < num ; i++) {
                        if (max > players[i].count && max_role.equals("Joker")) {
                            System.out.println(" Joker won!");
                            System.exit(0);
                        } else if (max > players[i].count) {
                            System.out.println(" " + max_name + " died");
                            players[i].alive=false;
                            break;
                        } else {
                            System.out.println(" nobody died");
                            break;
                        }

                    }
                }
                    number_of_night++;
                    System.out.println(" Night " + number_of_night);
                    for (int i=0;i<num;i++){
                        if((players[i].alive==true && p instanceof mafia)|| (players[i].alive==true && p instanceof godfather )|| (players[i].alive==true && p instanceof silencer)|| (players[i].alive==true && p instanceof detective) || (players[i].alive==true && p instanceof doctor)) {
                            System.out.println(players[i].name+":"+players[i].role);
                        }
                    }
                    for(int i=0;i<4;i++) {
                        p.name = sc.next();
                        if (p instanceof doctor) {
                            ((doctor) p).save();
                        } else if (p instanceof silencer) {
                            ((silencer) p).silent();
                        }
                        else if(p instanceof mafia || p instanceof godfather || p instanceof silencer){
                            p.vote();
                        }
                        else if(p instanceof detective){
                            ((detective) p).choose();
                        }
                    }



            }

        }
        else
            System.out.println("no game created:/");
    }
}


