package example;

import model.Cards;
import model.City;
import model.Graph;
import model.Player;
import model.TeamColor;

public class UsingGraph
{
    public static void main(String[] args)
    {
        // create the player (only 1 for this example)
        String player1Name = "Harry";

        Player player1 = new Player(player1Name, TeamColor.BLACK);

        // create the deck of cards
        Cards cards = new Cards();

        // create the graphs, initially empty
        Graph graph1 = new Graph(City.values().length);
        Graph graph2 = new Graph(City.values().length);

        // graph1 is the board, graph2 contains a blank board
        // we can compare graph1 to graph2 for Edge existence
        graph1.createTicketToRideDefaultBoard();


    }
}
