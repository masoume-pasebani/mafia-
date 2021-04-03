
import javax.management.relation.Role;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player_names;
        String name = new String();
        Roles role = null;
        boolean alive = true;
        Player p = new Player(name, role, alive);
        int num;

        int number_of_mafias = 0;
        int number_of_villagers=0;
        int number_of_detective=0;
        int number_of_doctor=0;
        int number_of_Joker=0;


        if (sc.next().equals("create_game")) {
            player_names = sc.nextLine();
            String[] arr = player_names.split(" ");
            num = arr.length - 1;
            int isalive = num;
            Player[] players = new Player[num];
            for (int i = 0; i < num; i++) {
                players[i] = new Player(name, role, alive);
            }
            String[] a;
            int number_of_roles = num;

            for (int i = 0; i < num; i++) {
                String str = sc.nextLine();
                a = str.split(" ");
                players[i].name = a[1];
                players[i].role = Roles.valueOf(a[2]);
                if ((players[i].role == Roles.mafia) || (players[i].role == Roles.silencer) || (players[i].role == Roles.godfather)) {
                    number_of_mafias += 1;
                } else if (players[i].role == Roles.Joker) {
                    number_of_Joker += 1;
                } else {
                    number_of_villagers += 1;
                }
                if ((players[i].role == Roles.doctor)) {
                    number_of_doctor++;
                }
                if ((players[i].role == Roles.detective)) {
                    number_of_detective++;
                }
                while (!players[i].name.equals(arr[i + 1])) {
                    System.out.println("user not found:/.enter the correct name:");
                    players[i].name = sc.next();
                }
                while ((players[i].role!=Roles.villager) && (players[i].role!=Roles.mafia) && (players[i].role!=Roles.godfather) && (players[i].role!=Roles.silencer) && (players[i].role!=Roles.doctor) && (players[i].role!=Roles.detective) && (players[i].role!=Roles.Joker) && (players[i].role!=Roles.bulletproof)) {
                    System.out.println("role not found:/");
                }

            }

            if (sc.next().equals("start_game")) {
                for (int i = 0; i < num; i++) {
                    System.out.println(" " + players[i].name + ":" + players[i].role);

                }
                System.out.println();

                System.out.println(" ->Ready? Set! Go.<-");
            } else if (sc.next().equals("start_game")) {
                System.out.println("no game created:/");
            }

            int number_of_day = 0;
            int number_of_night = 0;
            outer:while (number_of_mafias != 0 || number_of_villagers > number_of_mafias) {
                number_of_day++;
                System.out.println(" Day" + number_of_day);
                for (int i = 0; i < num; i++) {
                    players[i].vote();
                }
                int max = 0;
                String max_name = " ";
                String max_role = " ";

                if (sc.next().equals("end_vote")) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            if (players[i].name.equals(players[j].votee_name)) {
                                players[i].count++;
                            }
                        }
                    }
                    int index = 0;
                    for (int i = 0; i < num; i++) {
                        if (players[i].count > max) {
                            max = players[i].count;
                            max_name = players[i].name;
                            max_role = String.valueOf(players[i].role);
                            index = i;
                        }
                    }
                    for (int i = 0; i < num; i++) {
                        if (max > players[i].count && max_role.equals("Joker")) {
                            System.out.println(" Joker won!");
                            System.exit(0);
                        } else if (max > players[i].count) {
                            System.out.println(max_name + " died");
                            players[index].alive = false;
                            if (players[index].role == Roles.mafia || players[index].role == Roles.silencer || players[index].role == Roles.godfather) {
                                number_of_mafias -= 1;
                            } else
                                number_of_villagers -= 1;
                            break;
                        } else {
                            System.out.println("nobody died");
                            break;
                        }
                    }
                }
                if (p.alive == false) {
                    players[num--] = p;
                }
                number_of_night++;
                System.out.println(" Night " + number_of_night);
                for (int i = 0; i < num; i++) {
                    if ((players[i].alive && players[i].role == Roles.mafia) || (players[i].alive && players[i].role == Roles.godfather) || (players[i].alive && players[i].role == Roles.silencer) || (players[i].alive && players[i].role == Roles.doctor) || (players[i].alive && players[i].role == Roles.detective)) {
                        System.out.println(players[i].name + ":" + players[i].role);
                    }
                }
                while (sc.hasNextLine()) {
                    if (sc.next().equals("end_night")) {
                        break;
                    } else {
                        String[] b=sc.next().split("");
                              if ((b[0].equals(p.name)) && (p.role == Roles.detective)) {
                                  ((detective) p).choose(sc.next());
                              }
                          }

                }
            }

                while (sc.next().equals("get_game_state")) {
                    System.out.println("Mafia =" + number_of_mafias+'\n' + "Villager =" + number_of_villagers);

                }

            if(number_of_mafias==0){
                System.out.println("Villagers won!\n");
            }else if(number_of_mafias>=number_of_villagers){
                System.out.println("Mafia won!\n");
            }
        }
        else
            System.out.println("no game created:/");
        }
}





