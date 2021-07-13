import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Player
{
    String p_name;
    String p_team;
    int matchesPlayed;


    Player(String name, String team, int match)
    {
        this.p_name = name;
        this.p_team = team;
        this.matchesPlayed = match;

    }
}

class Team
{
    String teamName;
    String fixture;
    String venue;
    ArrayList<Player> players = new ArrayList<>();
    String battingCoach;
    String bowlingCoach;
    String fieldingCoach;


    public Team(String teamName, String fixture,String venue, String battingCoach, String bowlingCoach, String fieldingCoach)
    {
        this.teamName = teamName;
        this.fixture = fixture;
        this.venue = venue;
        this.battingCoach = battingCoach;
        this.bowlingCoach = bowlingCoach;
        this.fieldingCoach = fieldingCoach;
    }

    public void addPlayer(Player player)

    {
        players.add(player);
    }

}

public class KPL
{
    public static void main(String[] args)
    {
        HashSet<Team> hSet = new HashSet<>();
        HashSet<Player> hSet2 = new HashSet<>();


        Player p1t1 = new Player("megha","Sunflower_Group",19);
        Player p2t1 = new Player("virat","Sunflower_Group",22);
        Player p3t1 = new Player("hardik","Sunflower_Group",30);
        Player p4t1 = new Player("marco","Sunflower_Group",15);
        Player p5t1 = new Player("anushka","Sunflower_Group",26);
        Player p6t1 = new Player("mary","Sunflower_Group",40);
        Player p7t1 = new Player("marco","Sunflower_Group",27);
        Player p8t1 = new Player("arjun","Sunflower_Group",22);
        Player p9t1 = new Player("chris","Sunflower_Group",22);
        Player p10t1 = new Player("wanda","Sunflower_Group",23);
        Player p11t1 = new Player("wanda","Sunflower_Group",22);

        Player p1t2 = new Player("kareena","Rose_Group",17);
        Player p2t2 = new Player("amir","Rose_Group",25);

        Team t1 = new Team("Sunflower_Group","Z", "Delhi", "raman", "orange", "green");
        Team t2 = new Team("Rose_Group","Y", "Mumbai","ray","fruty","parth");


        t1.addPlayer(p1t1);
        t1.addPlayer(p2t1);
        t1.addPlayer(p3t1);
        t1.addPlayer(p4t1);
        t1.addPlayer(p5t1);
        t1.addPlayer(p6t1);
        t1.addPlayer(p7t1);
        t1.addPlayer(p8t1);
        t1.addPlayer(p9t1);
        t1.addPlayer(p10t1);
        t1.addPlayer(p11t1);





        t2.addPlayer(p1t2);
        t2.addPlayer(p2t2);

        hSet.add(t1);
        hSet.add(t2);

        hSet2.add(p1t1);
        hSet2.add(p2t1);
        hSet2.add(p3t1);
        hSet2.add(p4t1);
        hSet2.add(p5t1);
        hSet2.add(p6t1);
        hSet2.add(p7t1);
        hSet2.add(p8t1);
        hSet2.add(p9t1);
        hSet2.add(p10t1);
        hSet2.add(p11t1);





        hSet2.add(p1t2);
        hSet2.add(p2t2);




        Scanner scanner = new Scanner(System.in);
        int ch=0;
        String t_name;
        String playerName;

        while (ch != 4) {
            System.out.println("Enter 1 : To View the Team details (fixtures and venue)");
            System.out.println("Enter 2 : To View the Player's profile");
            System.out.println("Enter 3:  To View the Team players");
            System.out.println("Enter 4 : To Terminate the program\n");
            System.out.println("Type your choice: ");
            ch = scanner.nextInt();
            scanner.nextLine();
            if (ch == 1) {
                System.out.println("Enter name of the Team");
                t_name = scanner.nextLine();
                for (Team t : hSet) {
                    if (t_name.equals(t.teamName)) {

                        System.out.println("The Team name is :" + t.teamName);
                        System.out.println("Fixture: this Team will play against team " + t.fixture);
                        System.out.println("Venue for match is :" + t.venue);


                    }
                }
            } else if (ch == 2) {

                System.out.println("Enter name of the Player");
                playerName = scanner.nextLine();

                for (Player p : hSet2)
                {
                    if (playerName.equals(p.p_name))
                    {


                        System.out.println("The Player name is :" + p.p_name);
                        System.out.println("This player belongs to team " + p.p_team);
                        System.out.println("This player has played:" + p.matchesPlayed + "matches.");

                    }
                }


            } else if (ch == 3) {
                System.out.println("Enter name of the Team whose players you want to display");

                t_name = scanner.nextLine();
                for (Team t : hSet) {

                    if (t_name.equals(t.teamName)) {

                        System.out.println("These are the Players:-");
                        for (Player p : t.players) {
                            System.out.println(p.p_name);
                        }
                        System.out.println("These are the coaches:-");
                        System.out.println("Batting Coach:" + t.battingCoach);
                        System.out.println("Bowling Coach:" + t.bowlingCoach);

                        System.out.println("Fielding Coach:" + t.fieldingCoach);
                    }


                }

            } else if (ch == 4) {
                System.out.println("Exiting");
            } else
                System.out.println("Invalid Request");

        }
    }



}


