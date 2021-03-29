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
            num = arr.length;
            Player[] players = new Player[num];
            for (int i = 0; i < num - 1; i++) {
                players[i] = new Player();
            }
            String[] a;
            for (int i = 0; i < num - 1; i++) {
                String str = sc.nextLine();
                a = str.split(" ");
                players[i].name = a[1];
                players[i].role = a[2];
                if (!players[i].name.equals(arr[i+1])) {
                    System.out.println("user not found");
                }

            }
            if (sc.next().equals("start_game")) {
                for (int i = 0; i < num - 1; i++) {
                    System.out.println(" " + players[i].name + ":" + players[i].role);

                }
                System.out.println();

                System.out.println(" ->Ready? Set! Go.<-");
            }
            else
                System.out.println("no game created");
            while () {
                int number_of_day = 0;
                System.out.println(" Day" + number_of_day + 1);
                for (int i = 0; i < num - 1; i++) {
                    players[i].vote();
                }
                int max = 0;
                String max_name = " ";
                String max_role = " ";

                if (sc.next().equals("end_vote")) {
                    for (int i = 0; i < num - 1; i++) {
                        for (int j = i; j < num - 1; j++) {
                            if (players[i].name.equals(players[j].votee_name)) {
                                players[i].count += 1;
                            }
                        }
                    }
                    for (int i = 0; i < num - 1; i++) {
                        if (players[i].count > max) {
                            max = players[i].count;
                            max_name = players[i].name;
                            max_role = players[i].role;
                        }
                    }
                    for (int i = 0; i < num - 1; i++) {
                        if (max > players[i].count && max_role.equals("Joker")) {
                            System.out.println(" Joker won!");
                            System.exit(0);
                        } else if (max > players[i].count) {
                            System.out.println(" " + max_name + " died");
                            break;
                        } else {
                            System.out.println(" nobody died");
                            break;
                        }

                    }
                }
            }
            while () {
                int number_of_night = 0;
                System.out.println(" Night " + number_of_night + 1);



            }
        }
        else
            System.out.println("no game created");
    }
}


