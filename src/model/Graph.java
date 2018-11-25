package model;

import java.util.ArrayList;

public class Graph
{
    private int vertices;
    private ArrayList<Edge>[] adjList;

    // ============================== class ==============================

    /**
     * Creates a graph with specified number of vertices/nodes.
     * @param vertices Number of vertices/nodes.
     */
    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjList = new ArrayList[vertices];

        for (int i = 0; i < vertices; ++i)
        {
            adjList[i] = new ArrayList<>();
        }
    }

    // ============================== other ==============================

    /**
     * Creates the full Ticket To Ride game board automatically.
     * @throws UnsupportedOperationException If board is initialized already, cannot create another.
     */
    public void createTicketToRideDefaultBoard() throws UnsupportedOperationException
    {
        // todo add check, if an Edge exists, throw UnsupportedOperationException

        this.addUndirectedEdge(Cities.VANCOUVER, Cities.CALGARY, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);

        this.addUndirectedEdge(Cities.SEATTLE, Cities.CALGARY, GameColor.ANY, 4);
        this.addUndirectedEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.SEATTLE, Cities.HELENA, GameColor.YELLOW, 6);

        this.addUndirectedEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.GREEN, 5);
        this.addUndirectedEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.PURPLE, 5);
        this.addUndirectedEdge(Cities.PORTLAND, Cities.SALT_LAKE_CITY, GameColor.BLUE, 6);

        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.YELLOW, 3);
        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.PURPLE, 3);
        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.WHITE, 5);
        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.ORANGE, 5);

        this.addUndirectedEdge(Cities.HELENA, Cities.SALT_LAKE_CITY, GameColor.PURPLE, 3);

        this.addUndirectedEdge(Cities.SALT_LAKE_CITY, Cities.LAS_VEGAS, GameColor.ORANGE, 3);

        this.addUndirectedEdge(Cities.LAS_VEGAS, Cities.LOS_ANGELES, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.LOS_ANGELES, Cities.PHOENIX, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.LOS_ANGELES, Cities.EL_PASO, GameColor.BLACK, 6);

        this.addUndirectedEdge(Cities.EL_PASO, Cities.PHOENIX, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.EL_PASO, Cities.HOUSTON, GameColor.GREEN, 6);

        this.addUndirectedEdge(Cities.PHOENIX, Cities.SANTA_FE, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.PHOENIX, Cities.DENVER, GameColor.WHITE, 5);

        this.addUndirectedEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.YELLOW, 3);
        this.addUndirectedEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.RED, 3);
        this.addUndirectedEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.BLACK, 4);
        this.addUndirectedEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.ORANGE, 4);
        this.addUndirectedEdge(Cities.DENVER, Cities.OKLAHOMA_CITY, GameColor.RED, 4);
        this.addUndirectedEdge(Cities.DENVER, Cities.SANTA_FE, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.DENVER, Cities.HELENA, GameColor.GREEN, 4);
        this.addUndirectedEdge(Cities.DENVER, Cities.OMAHA, GameColor.PURPLE, 4);

        this.addUndirectedEdge(Cities.SANTA_FE, Cities.EL_PASO, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.SANTA_FE, GameColor.BLUE, 3);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.EL_PASO, GameColor.YELLOW, 5);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.LITTLE_ROCK, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.DALLAS, Cities.EL_PASO, GameColor.RED, 4);
        this.addUndirectedEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.DALLAS, Cities.LITTLE_ROCK, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.HOUSTON, Cities.NEW_ORLEANS, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.NEW_ORLEANS, Cities.LITTLE_ROCK, GameColor.GREEN, 3);
        this.addUndirectedEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.YELLOW, 4);
        this.addUndirectedEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.ORANGE, 4);
        this.addUndirectedEdge(Cities.NEW_ORLEANS, Cities.MIAMI, GameColor.RED, 6);

        this.addUndirectedEdge(Cities.ATLANTA, Cities.MIAMI, GameColor.BLUE, 5);
        this.addUndirectedEdge(Cities.ATLANTA, Cities.CHARLESTON, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.ATLANTA, Cities.NASHVILLE, GameColor.ANY, 1);

        this.addUndirectedEdge(Cities.LITTLE_ROCK, Cities.NASHVILLE, GameColor.WHITE, 3);
        this.addUndirectedEdge(Cities.LITTLE_ROCK, Cities.SAINT_LOUIS, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.SAINT_LOUIS, Cities.PITTSBURG, GameColor.GREEN, 5);
        this.addUndirectedEdge(Cities.SAINT_LOUIS, Cities.NASHVILLE, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.PURPLE, 2);
        this.addUndirectedEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.BLUE, 2);
        this.addUndirectedEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);
        this.addUndirectedEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);

        this.addUndirectedEdge(Cities.OMAHA, Cities.CHICAGO, GameColor.BLUE, 4);
        this.addUndirectedEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.OMAHA, Cities.HELENA, GameColor.RED, 5);

        this.addUndirectedEdge(Cities.DULUTH, Cities.HELENA, GameColor.ORANGE, 6);
        this.addUndirectedEdge(Cities.DULUTH, Cities.WINNIPEG, GameColor.BLACK, 4);
        this.addUndirectedEdge(Cities.DULUTH, Cities.SAULT_ST_MARIE, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.DULUTH, Cities.TORONTO, GameColor.PURPLE, 6);
        this.addUndirectedEdge(Cities.DULUTH, Cities.CHICAGO, GameColor.RED, 3);

        this.addUndirectedEdge(Cities.CHICAGO, Cities.TORONTO, GameColor.WHITE, 4);
        this.addUndirectedEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.ORANGE, 3);
        this.addUndirectedEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.BLACK, 3);
        this.addUndirectedEdge(Cities.CHICAGO, Cities.SAINT_LOUIS, GameColor.GREEN, 2);

        this.addUndirectedEdge(Cities.PITTSBURG, Cities.NASHVILLE, GameColor.YELLOW, 4);
        this.addUndirectedEdge(Cities.PITTSBURG, Cities.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.PITTSBURG, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.GREEN, 2);
        this.addUndirectedEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.WHITE, 2);
        this.addUndirectedEdge(Cities.PITTSBURG, Cities.TORONTO, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.NASHVILLE, Cities.RALEIGH, GameColor.BLACK, 3);

        this.addUndirectedEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.RALEIGH, Cities.CHARLESTON, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.CHARLESTON, Cities.MIAMI, GameColor.PURPLE, 4);

        this.addUndirectedEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.ORANGE, 2);
        this.addUndirectedEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.BLACK, 2);

        this.addUndirectedEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.RED, 2);
        this.addUndirectedEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.YELLOW, 2);
        this.addUndirectedEdge(Cities.NEW_YORK, Cities.MONTREAL, GameColor.BLUE, 3);

        this.addUndirectedEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);

        this.addUndirectedEdge(Cities.MONTREAL, Cities.TORONTO, GameColor.ANY, 3);
        this.addUndirectedEdge(Cities.MONTREAL, Cities.SAULT_ST_MARIE, GameColor.BLACK, 5);

        this.addUndirectedEdge(Cities.SAULT_ST_MARIE, Cities.TORONTO, GameColor.ANY, 2);
        this.addUndirectedEdge(Cities.SAULT_ST_MARIE, Cities.WINNIPEG, GameColor.ANY, 6);

        this.addUndirectedEdge(Cities.WINNIPEG, Cities.HELENA, GameColor.BLUE, 4);

        this.addUndirectedEdge(Cities.HELENA, Cities.CALGARY, GameColor.ANY, 4);

        this.addUndirectedEdge(Cities.CALGARY, Cities.WINNIPEG, GameColor.WHITE, 6);
    }

    /**
     * Creates a small game board to experiment on.
     * @throws UnsupportedOperationException If board is initialized already, cannot create another.
     */
    public void createTicketToRideSampleBoard() throws UnsupportedOperationException
    {
        // todo add check, if an Edge exists, throw UnsupportedOperationException

        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.RED, 6);
        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.SEATTLE, GameColor.GREEN, 10);
        this.addUndirectedEdge(Cities.SAN_FRANCISCO, Cities.LAS_VEGAS, GameColor.ANY, 4);
        this.addUndirectedEdge(Cities.LAS_VEGAS, Cities.PHOENIX, GameColor.ORANGE, 10);
    }

    /**
     * Lists the graph 1 per line in the format:<br>
     * source + destination + weight + color
     */
    public void printGraph()
    {
        String sourceString;
        String destinationString;
        String distanceString;
        String routeColorString;
        int numberOfEdges;

        for (int i = 0; i < vertices; ++i)
        {
            ArrayList<Edge> list = adjList[i];

            for (int j = 0; j < list.size(); ++j)
            {
                sourceString = adjList[i].get(j).getSource().toString();
                destinationString = adjList[i].get(j).getDestination().toString();
                distanceString = Integer.toString(adjList[i].get(j).getWeight());
                routeColorString = adjList[i].get(j).getRouteColor().toString();

                System.out.println(sourceString + " to " + destinationString + " distance " + distanceString + " " + routeColorString);
            }
        }

        numberOfEdges = Edge.getNumberOfEdges();
        System.out.println(numberOfEdges);
    }

    /**
     * Creates a new Edge and adds it to the Graph.
     * @param source Cities source node.
     * @param destination Cities destination node.
     * @param routeColor GameColor enum route's color.
     * @param weight Weight of route.
     */
    public void addUndirectedEdge(Cities source, Cities destination, GameColor routeColor, int weight)
    {
        Edge sourceToDestination = new Edge(source, destination, routeColor, weight);
        Edge destinationToSource = new Edge(destination, source, routeColor, weight);
        this.adjList[source.ordinal()].add(0, sourceToDestination);
    }

    public void removeUndirectedEdge(Cities source, Cities destination, GameColor routeColor)
    {
        // todo
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the edge/route specified with a source, destination, and a color. TIn this method, 3
     * keys are used to find a unique edge. An example of this would be there are no "shortcuts" nor
     * "alternate paths" between the same source and destination.
     * @param source Cities enum specifiying first node.
     * @param destination Cities enum specifiying last node.
     * @param routeColor GameColor enum specifying route's color.
     * @return INDEX IF FOUND.<br>
     * -1 IF NOT FOUND. Other negative integers specify a specific code.<br>
     * -2 if no such source exists.<br>
     * -3 if no adjacency list exists.<br>
     */
    public int findEdge(Cities source, Cities destination, GameColor routeColor)
    {
        if (this.adjList[source.ordinal()] == null ) return -2;
        if (this.adjList[source.ordinal()].size() == 0) return -3;

        for (int i = 0; i < this.adjList[source.ordinal()].size(); ++i)
        {
            if ((this.adjList[source.ordinal()].get(i).getDestination() == destination) &&
                (this.adjList[source.ordinal()].get(i).getRouteColor() == routeColor)) return i;
        }

        return -1;
    }

    /**
     * Returns the edge/route specified with a source, destination, and a color. In this method, 4
     * keys are used to find a unique edge. An example of this would be there are "shortcuts"
     * or an "alternate path" between the same source and destination.
     * @param source Cities enum specifiying first node.
     * @param destination Cities enum specifiying last node.
     * @param routeColor GameColor enum specifying route's color.
     * @param weight Weight int specifying route's weight.
     * @return INDEX IF FOUND.<br>
     * -1 IF NOT FOUND. Other negative integers specify a specific code.<br>
     * -2 if no such source exists.<br>
     * -3 if no adjacency list exists.<br>
     */
    public int findEdge(Cities source, Cities destination, GameColor routeColor, int weight)
    {
        if (this.adjList[source.ordinal()] == null ) return -2;
        if (this.adjList[source.ordinal()].size() == 0) return -3;

        for (int i = 0; i < this.adjList[source.ordinal()].size(); ++i)
        {
            if ((this.adjList[source.ordinal()].get(i).getDestination() == destination) &&
                (this.adjList[source.ordinal()].get(i).getRouteColor() == routeColor) &&
                (this.adjList[source.ordinal()].get(i).getWeight() == weight)) return i;
        }

        return -1;
    }
}