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


        if (sc.next().equals("create_game")) {
            player_names = sc.nextLine();
            String[] arr = player_names.split(" ");
            num = arr.length - 1;
            int isalive = num;
            Player[] players = new Player[num];
            for (int i = 0; i < num; i++) {
                players[i] = new Player(p.name, p.role, p.alive);
            }
            String[] a;
            int number_of_roles = num;
            int number_of_mafias = 0;
            for (int i = 0; i < num; i++) {
                String str = sc.nextLine();
                a = str.split(" ");
                players[i].name = a[1];
                players[i].role = Roles.valueOf(a[2]);
                if ((players[i].role == Roles.mafia) || (players[i].role == Roles.silencer) || (players[i].role == Roles.godfather)) {
                    number_of_mafias += 1;
                }
                while (!players[i].name.equals(arr[i + 1])) {
                    System.out.println("user not found:/.enter the correct name:");
                    players[i].name = sc.next();
                }
                while (number_of_roles != num) {
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
            while (number_of_mafias != 0 || number_of_roles - number_of_mafias > number_of_mafias) {
                number_of_day++;
                System.out.println(" Day" + number_of_day);
                for (int i = 0; i < num; i++) {
                    players[i].vote();
                }
                int max = num / 2;
                String max_name = " ";
                String max_role = " ";

                if (sc.next().equals("end_vote")) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num - 1 - i; j++) {
                            if (players[i].name.equals(players[j].votee_name)) {
                                players[i].count++;
                            }
                        }
                    }
                    for (int i = 0; i < num; i++) {
                        if (players[i].count > max) {
                            max = players[i].count;
                            max_name = players[i].name;
                            max_role = String.valueOf(players[i].role);
                        }
                    }
                    for (int i = 0; i < num; i++) {
                        if (max > players[i].count && max_role.equals("Joker")) {
                            System.out.println(" Joker won!");
                            System.exit(0);
                        } else if (max > players[i].count) {
                            System.out.println(max_name + " died");
                            players[i].alive = false;
                            break;
                        } else {
                            System.out.println("nobody died");
                            break;
                        }
                    }
                }
                number_of_night++;
                System.out.println(" Night " + number_of_night);
                for (int i = 0; i < num; i++) {
                    if ((players[i].alive && players[i].role == Roles.mafia) || (players[i].alive && players[i].role == Roles.godfather) || (players[i].alive && players[i].role == Roles.silencer) || (players[i].alive && players[i].role == Roles.doctor) || (players[i].alive && players[i].role == Roles.detective)) {
                        System.out.println(players[i].name + ":" + players[i].role);
                    }
                }
                doctor d = new doctor(name, Roles.doctor, true);
                detective de = new detective(name, Roles.detective, true);
                mafia m = new mafia(name, Roles.mafia, true);
                godfather g = new godfather(name, Roles.godfather, true);
                silencer s = new silencer(name, Roles.silencer, true);
                String names;
                while (sc.next() != "end_night") {
                    names = sc.next();
                    if (names.equals(d.name)) {
                        d.save();
                    } else if ((names.equals(m.name)) || (names.equals(g.name)) || (names.equals(s.name))) {
                        m.kill();
                    } else if (names.equals(s.name)) {
                        s.silent();
                    } else if (names.equals(de.name)) {
                        de.choose();
                    }
                }
                continue;

            }
        }
        else
            System.out.println("no game created:/");
        }
    }



