package example;

import java.util.ArrayList;
import java.util.List;

import model.Cards;
import model.Player;
import model.TeamColor;

public class ControllerExample
{
    public static void main(String[] args)
    {
        // the people who will play
        String player1Name = "Harry";
        String player2Name = "Helga";
        String player3Name = "Archibald";
        String player4Name = "Angelica";

        // create the deck of cards
        Cards cards = new Cards();

        // create a list of players and add them to a list
        List<Player> players = new ArrayList<>();
        players.add(new Player(player1Name, TeamColor.BLACK));
        players.add(new Player(player2Name, TeamColor.BLACK));
        players.add(new Player(player3Name, TeamColor.RED));
        players.add(new Player(player3Name, TeamColor.BLUE));

        //todo continue
    }
}
