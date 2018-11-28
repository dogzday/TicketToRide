package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest
{
    static Graph graph;

    @BeforeClass
    public static void before()
    {
        graph = new Graph(City.values().length);
        graph.createTicketToRideDefaultBoard();
    }

    @Test
    public void printGraphTest()
    {
        graph.printGraph();
    }

    @Test
    public void correctEdgeTest()
    {
        Assert.assertEquals(3, graph.findEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.YELLOW));
    }

    @Test
    public void incorrectEdgeTest()
    {
        Assert.assertEquals(-1, graph.findEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.BLACK));
    }

//    @Test
//    public void getAdjacentEdgesTest()
//    {
//        List<Edge> toCompare = new ArrayList<>();
//        Edge edge1 = new Edge(City.SAN_FRANCISCO, City.SALT_LAKE_CITY, GameColor.ORANGE, 5);
//        Edge edge2 = new Edge(City.SAN_FRANCISCO, City.SALT_LAKE_CITY, GameColor.WHITE, 5);
//        Edge edge3 = new Edge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.PURPLE, 3);
//        Edge edge4 = new Edge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.YELLOW, 3);
//
//        toCompare.add(edge1);
//        toCompare.add(edge2);
//        toCompare.add(edge3);
//        toCompare.add(edge4);
//
//        for (int i = 0; i < graph.getNumberOfEdges(); ++i)
//        {
//
//        }
//    }
}