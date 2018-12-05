package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph
{
    private List<Edge>[] adjacencyList;
    private int vertices;
    private int numberOfEdges = 0;

    // ============================== class ==============================

    /**
     * Creates a graph with specified number of vertices/nodes.
     * @param vertices Number of vertices/nodes.
     */
    @SuppressWarnings("unchecked")
    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];

        for (int i = 0; i < vertices; ++i)
        {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    // ============================== other ==============================

    @Override
    public String toString()
    {
        String returnString = "";
        String sourceString;
        String destinationString;
        String distanceString;
        String routeColorString;
        int numberOfEdges;

        for (int i = 0; i < vertices; ++i)
        {
            List<Edge> list = adjacencyList[i];

            for (int j = 0; j < list.size(); ++j)
            {
                sourceString = adjacencyList[i].get(j).getSource().toString();
                destinationString = adjacencyList[i].get(j).getDestination().toString();
                distanceString = Integer.toString(adjacencyList[i].get(j).getWeight());
                routeColorString = adjacencyList[i].get(j).getRouteColor().toString();

                returnString.concat(sourceString + " to " + destinationString + " distance " + distanceString + " " + routeColorString + "\n");
            }
        }

        return returnString;
    }

    /**
     * Creates the full Ticket To Ride game board automatically.
     * @throws UnsupportedOperationException If board is initialized already, cannot create another.
     */
    public void createTicketToRideDefaultBoard() throws UnsupportedOperationException
    {
        if (this.numberOfEdges > 0) throw new UnsupportedOperationException();

        this.addUndirectedEdge(City.VANCOUVER, City.CALGARY, GameColor.ANY, 3);
        this.addUndirectedEdge(City.VANCOUVER, City.SEATTLE, GameColor.ANY, 1);
        this.addUndirectedEdge(City.VANCOUVER, City.SEATTLE, GameColor.ANY, 1);

        this.addUndirectedEdge(City.SEATTLE, City.CALGARY, GameColor.ANY, 4);
        this.addUndirectedEdge(City.SEATTLE, City.PORTLAND, GameColor.ANY, 1);
        this.addUndirectedEdge(City.SEATTLE, City.PORTLAND, GameColor.ANY, 1);
        this.addUndirectedEdge(City.SEATTLE, City.HELENA, GameColor.YELLOW, 6);

        this.addUndirectedEdge(City.PORTLAND, City.SAN_FRANCISCO, GameColor.GREEN, 5);
        this.addUndirectedEdge(City.PORTLAND, City.SAN_FRANCISCO, GameColor.PURPLE, 5);
        this.addUndirectedEdge(City.PORTLAND, City.SALT_LAKE_CITY, GameColor.BLUE, 6);

        this.addUndirectedEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.YELLOW, 3);
        this.addUndirectedEdge(City.SAN_FRANCISCO, City.LOS_ANGELES, GameColor.PURPLE, 3);
        this.addUndirectedEdge(City.SAN_FRANCISCO, City.SALT_LAKE_CITY, GameColor.WHITE, 5);
        this.addUndirectedEdge(City.SAN_FRANCISCO, City.SALT_LAKE_CITY, GameColor.ORANGE, 5);

        this.addUndirectedEdge(City.HELENA, City.SALT_LAKE_CITY, GameColor.PURPLE, 3);

        this.addUndirectedEdge(City.SALT_LAKE_CITY, City.LAS_VEGAS, GameColor.ORANGE, 3);

        this.addUndirectedEdge(City.LAS_VEGAS, City.LOS_ANGELES, GameColor.ANY, 2);

        this.addUndirectedEdge(City.LOS_ANGELES, City.PHOENIX, GameColor.ANY, 3);
        this.addUndirectedEdge(City.LOS_ANGELES, City.EL_PASO, GameColor.BLACK, 6);

        this.addUndirectedEdge(City.EL_PASO, City.PHOENIX, GameColor.ANY, 3);
        this.addUndirectedEdge(City.EL_PASO, City.HOUSTON, GameColor.GREEN, 6);

        this.addUndirectedEdge(City.PHOENIX, City.SANTA_FE, GameColor.ANY, 3);
        this.addUndirectedEdge(City.PHOENIX, City.DENVER, GameColor.WHITE, 5);

        this.addUndirectedEdge(City.DENVER, City.SALT_LAKE_CITY, GameColor.YELLOW, 3);
        this.addUndirectedEdge(City.DENVER, City.SALT_LAKE_CITY, GameColor.RED, 3);
        this.addUndirectedEdge(City.DENVER, City.KANSAS_CITY, GameColor.BLACK, 4);
        this.addUndirectedEdge(City.DENVER, City.KANSAS_CITY, GameColor.ORANGE, 4);
        this.addUndirectedEdge(City.DENVER, City.OKLAHOMA_CITY, GameColor.RED, 4);
        this.addUndirectedEdge(City.DENVER, City.SANTA_FE, GameColor.ANY, 2);
        this.addUndirectedEdge(City.DENVER, City.HELENA, GameColor.GREEN, 4);
        this.addUndirectedEdge(City.DENVER, City.OMAHA, GameColor.PURPLE, 4);

        this.addUndirectedEdge(City.SANTA_FE, City.EL_PASO, GameColor.ANY, 2);

        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.SANTA_FE, GameColor.BLUE, 3);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.EL_PASO, GameColor.YELLOW, 5);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.DALLAS, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.DALLAS, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.LITTLE_ROCK, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.KANSAS_CITY, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OKLAHOMA_CITY, City.KANSAS_CITY, GameColor.ANY, 2);

        this.addUndirectedEdge(City.DALLAS, City.EL_PASO, GameColor.RED, 4);
        this.addUndirectedEdge(City.DALLAS, City.HOUSTON, GameColor.ANY, 1);
        this.addUndirectedEdge(City.DALLAS, City.HOUSTON, GameColor.ANY, 1);
        this.addUndirectedEdge(City.DALLAS, City.LITTLE_ROCK, GameColor.ANY, 2);

        this.addUndirectedEdge(City.HOUSTON, City.NEW_ORLEANS, GameColor.ANY, 2);

        this.addUndirectedEdge(City.NEW_ORLEANS, City.LITTLE_ROCK, GameColor.GREEN, 3);
        this.addUndirectedEdge(City.NEW_ORLEANS, City.ATLANTA, GameColor.YELLOW, 4);
        this.addUndirectedEdge(City.NEW_ORLEANS, City.ATLANTA, GameColor.ORANGE, 4);
        this.addUndirectedEdge(City.NEW_ORLEANS, City.MIAMI, GameColor.RED, 6);

        this.addUndirectedEdge(City.ATLANTA, City.MIAMI, GameColor.BLUE, 5);
        this.addUndirectedEdge(City.ATLANTA, City.CHARLESTON, GameColor.ANY, 2);
        this.addUndirectedEdge(City.ATLANTA, City.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(City.ATLANTA, City.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(City.ATLANTA, City.NASHVILLE, GameColor.ANY, 1);

        this.addUndirectedEdge(City.LITTLE_ROCK, City.NASHVILLE, GameColor.WHITE, 3);
        this.addUndirectedEdge(City.LITTLE_ROCK, City.SAINT_LOUIS, GameColor.ANY, 2);

        this.addUndirectedEdge(City.SAINT_LOUIS, City.PITTSBURG, GameColor.GREEN, 5);
        this.addUndirectedEdge(City.SAINT_LOUIS, City.NASHVILLE, GameColor.ANY, 2);

        this.addUndirectedEdge(City.KANSAS_CITY, City.SAINT_LOUIS, GameColor.PURPLE, 2);
        this.addUndirectedEdge(City.KANSAS_CITY, City.SAINT_LOUIS, GameColor.BLUE, 2);
        this.addUndirectedEdge(City.KANSAS_CITY, City.OMAHA, GameColor.ANY, 1);
        this.addUndirectedEdge(City.KANSAS_CITY, City.OMAHA, GameColor.ANY, 1);

        this.addUndirectedEdge(City.OMAHA, City.CHICAGO, GameColor.BLUE, 4);
        this.addUndirectedEdge(City.OMAHA, City.DULUTH, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OMAHA, City.DULUTH, GameColor.ANY, 2);
        this.addUndirectedEdge(City.OMAHA, City.HELENA, GameColor.RED, 5);

        this.addUndirectedEdge(City.DULUTH, City.HELENA, GameColor.ORANGE, 6);
        this.addUndirectedEdge(City.DULUTH, City.WINNIPEG, GameColor.BLACK, 4);
        this.addUndirectedEdge(City.DULUTH, City.SAULT_ST_MARIE, GameColor.ANY, 3);
        this.addUndirectedEdge(City.DULUTH, City.TORONTO, GameColor.PURPLE, 6);
        this.addUndirectedEdge(City.DULUTH, City.CHICAGO, GameColor.RED, 3);

        this.addUndirectedEdge(City.CHICAGO, City.TORONTO, GameColor.WHITE, 4);
        this.addUndirectedEdge(City.CHICAGO, City.PITTSBURG, GameColor.ORANGE, 3);
        this.addUndirectedEdge(City.CHICAGO, City.PITTSBURG, GameColor.BLACK, 3);
        this.addUndirectedEdge(City.CHICAGO, City.SAINT_LOUIS, GameColor.GREEN, 2);

        this.addUndirectedEdge(City.PITTSBURG, City.NASHVILLE, GameColor.YELLOW, 4);
        this.addUndirectedEdge(City.PITTSBURG, City.RALEIGH, GameColor.ANY, 2);
        this.addUndirectedEdge(City.PITTSBURG, City.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(City.PITTSBURG, City.NEW_YORK, GameColor.GREEN, 2);
        this.addUndirectedEdge(City.PITTSBURG, City.NEW_YORK, GameColor.WHITE, 2);
        this.addUndirectedEdge(City.PITTSBURG, City.TORONTO, GameColor.ANY, 2);

        this.addUndirectedEdge(City.NASHVILLE, City.RALEIGH, GameColor.BLACK, 3);

        this.addUndirectedEdge(City.RALEIGH, City.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(City.RALEIGH, City.WASHINGTON, GameColor.ANY, 2);
        this.addUndirectedEdge(City.RALEIGH, City.CHARLESTON, GameColor.ANY, 2);

        this.addUndirectedEdge(City.CHARLESTON, City.MIAMI, GameColor.PURPLE, 4);

        this.addUndirectedEdge(City.WASHINGTON, City.NEW_YORK, GameColor.ORANGE, 2);
        this.addUndirectedEdge(City.WASHINGTON, City.NEW_YORK, GameColor.BLACK, 2);

        this.addUndirectedEdge(City.NEW_YORK, City.BOSTON, GameColor.RED, 2);
        this.addUndirectedEdge(City.NEW_YORK, City.BOSTON, GameColor.YELLOW, 2);
        this.addUndirectedEdge(City.NEW_YORK, City.MONTREAL, GameColor.BLUE, 3);

        this.addUndirectedEdge(City.BOSTON, City.MONTREAL, GameColor.ANY, 2);
        this.addUndirectedEdge(City.BOSTON, City.MONTREAL, GameColor.ANY, 2);

        this.addUndirectedEdge(City.MONTREAL, City.TORONTO, GameColor.ANY, 3);
        this.addUndirectedEdge(City.MONTREAL, City.SAULT_ST_MARIE, GameColor.BLACK, 5);

        this.addUndirectedEdge(City.SAULT_ST_MARIE, City.TORONTO, GameColor.ANY, 2);
        this.addUndirectedEdge(City.SAULT_ST_MARIE, City.WINNIPEG, GameColor.ANY, 6);

        this.addUndirectedEdge(City.WINNIPEG, City.HELENA, GameColor.BLUE, 4);

        this.addUndirectedEdge(City.HELENA, City.CALGARY, GameColor.ANY, 4);

        this.addUndirectedEdge(City.CALGARY, City.WINNIPEG, GameColor.WHITE, 6);
    }

    /**
     * Lists the graph 1 per line in the format:<br>
     * source + destination + weight + color
     */
    @SuppressWarnings("WeakerAccess")
    public void printGraph()
    {
        String sourceString;
        String destinationString;
        String distanceString;
        String routeColorString;
        int numberOfEdges;

        for (int i = 0; i < vertices; ++i)
        {
            List<Edge> list = adjacencyList[i];

            for (int j = 0; j < list.size(); ++j)
            {
                sourceString = adjacencyList[i].get(j).getSource().toString();
                destinationString = adjacencyList[i].get(j).getDestination().toString();
                distanceString = Integer.toString(adjacencyList[i].get(j).getWeight());
                routeColorString = adjacencyList[i].get(j).getRouteColor().toString();

                System.out.println(sourceString + " to " + destinationString + " distance " + distanceString + " " + routeColorString); // NON-NLS
            }
        }

        System.out.println("Number of Edges: " + this.numberOfEdges); // NON-NLS
    }

    /**
     * Returns the edge/route specified with a source, destination, and a color. TIn this method, 3
     * keys are used to find a unique edge. An example of this would be there are no "shortcuts" nor
     * "alternate paths" between the same source and destination.
     * @param source City enum specifiying first node.
     * @param destination City enum specifiying last node.
     * @param routeColor GameColor enum specifying route's color.
     * @return INDEX IF FOUND.<br>
     * -1 IF NOT FOUND. Other negative integers specify a specific code.<br>
     * -2 if no such source exists.<br>
     * -3 if no adjacency list exists.<br>
     */
    @SuppressWarnings("WeakerAccess")
    public int findSpecificEdge(City source, City destination, GameColor routeColor)
    {
        if (this.adjacencyList[source.ordinal()] == null ) return -2;
        if (this.adjacencyList[source.ordinal()].size() == 0) return -3;

        for (int i = 0; i < this.adjacencyList[source.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[source.ordinal()].get(i).getDestination() == destination) &&
                    (this.adjacencyList[source.ordinal()].get(i).getRouteColor() == routeColor)) return i;
        }

        return -1;
    }

    /**
     * Returns the edge/route specified with a source, destination, and a color. In this method, 4
     * keys are used to find a unique edge. An example of this would be there are "shortcuts"
     * or an "alternate path" between the same source and destination.
     * @param source City enum specifiying first node.
     * @param destination City enum specifiying last node.
     * @param routeColor GameColor enum specifying route's color.
     * @param weight Weight int specifying route's weight.
     * @return INDEX IF FOUND.<br>
     * -1 IF NOT FOUND. Other negative integers specify a specific code.<br>
     * -2 if no such source exists.<br>
     * -3 if no adjacency list exists.<br>
     */
    public int findSpecificEdge(City source, City destination, GameColor routeColor, int weight)
    {
        if (this.adjacencyList[source.ordinal()] == null ) return -2;
        if (this.adjacencyList[source.ordinal()].size() == 0) return -3;

        for (int i = 0; i < this.adjacencyList[source.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[source.ordinal()].get(i).getDestination() == destination) &&
                    (this.adjacencyList[source.ordinal()].get(i).getRouteColor() == routeColor) &&
                    (this.adjacencyList[source.ordinal()].get(i).getWeight() == weight)) return i;
        }

        return -1;
    }

    public int findUnspecificEdge(City node1, City node2, GameColor routeColor)
    {
        if (this.adjacencyList[node1.ordinal()] == null ) return -2;
        if (this.adjacencyList[node1.ordinal()].size() == 0) return -3;

        if (this.adjacencyList[node2.ordinal()] == null ) return -4;
        if (this.adjacencyList[node2.ordinal()].size() == 0) return -5;

        for (int i = 0; i < this.adjacencyList[node1.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[node1.ordinal()].get(i).getDestination() == node2) &&
                    (this.adjacencyList[node1.ordinal()].get(i).getRouteColor() == routeColor)) return i;
        }

        for (int i = 0; i < this.adjacencyList[node2.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[node2.ordinal()].get(i).getDestination() == node1) &&
                    (this.adjacencyList[node2.ordinal()].get(i).getRouteColor() == routeColor)) return i;
        }

        return -1;
    }

    public int findUnspecificEdge(City node1, City node2, GameColor routeColor, int weight)
    {
        if (this.adjacencyList[node1.ordinal()] == null ) return -2;
        if (this.adjacencyList[node1.ordinal()].size() == 0) return -3;

        if (this.adjacencyList[node2.ordinal()] == null ) return -4;
        if (this.adjacencyList[node2.ordinal()].size() == 0) return -5;

        for (int i = 0; i < this.adjacencyList[node1.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[node1.ordinal()].get(i).getDestination() == node2) &&
                    (this.adjacencyList[node1.ordinal()].get(i).getRouteColor() == routeColor) &&
                    (this.adjacencyList[node1.ordinal()].get(i).getWeight() == weight)) return i;
        }

        for (int i = 0; i < this.adjacencyList[node2.ordinal()].size(); ++i)
        {
            if ((this.adjacencyList[node2.ordinal()].get(i).getDestination() == node1) &&
                    (this.adjacencyList[node2.ordinal()].get(i).getRouteColor() == routeColor)) return i;
        }

        return -1;
    }

    // todo finish
    /**
     * This returns the longest possible path in the graph. If you are to use this in the game
     * Ticket to Ride, you should create 2 graphs - one for the game board, and one to track player
     * game piece placement progress. If you evoke this method on the game board itself, it will
     * simply determine the longest possible path. This will be time consuming to determine in that
     * case.
     * @return // todo
     * @throws UnsupportedOperationException
     */
    //@SuppressWarnings("UnusedAssignment")
    public TeamColor findTeamWithLongestPath() throws UnsupportedOperationException
    {
        // todo remove when fully implemented
        if (true) throw new UnsupportedOperationException();

        // treat pathfinder as a queue, the variables below track path data
        List<Edge> pathfinder;
        Edge currentEdge;
        int currentWeight = 0;
        int edgeListIndex = 0;

        List<TeamColor> teamColors = Arrays.asList(TeamColor.values());
        List<Integer> teamLongestPaths = new ArrayList<>(TeamColor.values().length);

        setAllEdgesVisitStatus(false);

        // how to do?
        // maybe enqueue travel path until we reach end, for ALL paths in adjacency list that is NOT null
        // all while summing up the weight of each edge and store total weight
        // and store teamcolor if the current total weight is greater than max
        // when we backtrack, decrement the weight of the edge we will pop
        // and then search or continue to other connected edges if any
        // if there's nothing else to do, return the teamcolor with the larger total weight

        // this for loop says: for every city that is not null (checking null for safety)...
        // traverse all possible connections, backtrack if there are no connections
        // if there are no connections, then size() of the list should be 0
        for (int i = 0; i < this.adjacencyList.length; ++i)
        {

        }

        // todo change return null to return TeamColor
        return null;
    }

    // ============================== getters ==============================

    public int getNumberOfEdges() { return numberOfEdges; }

    public List<Edge> getAdjacentEdges(City source) throws NullPointerException
    {
        if (source == null) throw new NullPointerException();
        if (this.adjacencyList[source.ordinal()] == null) throw new NullPointerException();

        return this.adjacencyList[source.ordinal()];
    }

    // ============================== setters ==============================

    public void setAllEdgesVisitStatus(boolean state)
    {
        for (int i = 0; i < adjacencyList.length; ++i)
        {
            for (Edge edge : adjacencyList[i])
            {
                edge.setVisited(state);
            }
        }
    }

    /**
     * Creates a new Edge and adds it to the Graph.
     * @param source City source node.
     * @param destination City destination node.
     * @param routeColor GameColor enum route's color.
     * @param weight Weight of route.
     */
    @SuppressWarnings("WeakerAccess")
    public void addUndirectedEdge(City source, City destination, GameColor routeColor, int weight)
    {
        Edge sourceToDestination = new Edge(source, destination, routeColor, weight);
        this.adjacencyList[source.ordinal()].add(0, sourceToDestination);
        ++this.numberOfEdges;
    }

    @SuppressWarnings("WeakerAccess")
    public void removeUndirectedEdge(City source, City destination, GameColor routeColor) throws UnsupportedOperationException
    {
        List<Edge> temp = this.adjacencyList[source.ordinal()];

        for (int i = 0; i < temp.size(); ++i)
        {
            if ((temp.get(i).getDestination() == destination) && (temp.get(i).getRouteColor() == routeColor))
            {
                Edge.setWeightOfAllEdges(Edge.getWeightOfAllEdges() - temp.get(i).getWeight());
                Edge.setNumberOfAllEdges(Edge.getNumberOfAllEdges() - 1);
                temp.remove(i);
                --this.numberOfEdges;
                break;
            }
        }
    }

    // ============================== helpers ==============================

    private void sumEdges()
    {
        for (List<Edge> anAdjacencyList : this.adjacencyList)
        {
            this.numberOfEdges += anAdjacencyList.size();
        }
    }
}
