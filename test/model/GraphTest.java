package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void correctEdgeTest()
    {
        Assert.assertEquals(3, graph.findEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.YELLOW));
    }

    @Test
    public void incorrectEdgeTest()
    {
        Assert.assertEquals(-1, graph.findEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.BLACK));
    }
}