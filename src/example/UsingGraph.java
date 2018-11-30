package example;

import java.util.ArrayList;
import java.util.List;

import model.Cards;
import model.City;
import model.Edge;
import model.Graph;
import model.Player;
import model.TeamColor;

public class UsingGraph
{
    public static void main(String[] args)
    {
        List<Edge> adjEdges = new ArrayList<>();

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

        adjEdges = graph1.getAdjacentEdges(City.DENVER);

        for (int i = 0; i < adjEdges.size(); ++i)
        {
            System.out.println(adjEdges.get(i).toString());
        }
    }
}
