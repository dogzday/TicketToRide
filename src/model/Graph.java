package model;

import java.util.ArrayList;

public class Graph
{
    private int vertices;
    private ArrayList<Edge>[] adjList;

    // ============================== class ==============================

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

    public void createTicketToRideDefaultBoard() throws UnsupportedOperationException
    {
        for (int i = 0; i < this.adjList.length; ++i)
        {
            if (this.adjList[i] != null) break;
            throw new UnsupportedOperationException();
        }

        this.addEdge(Cities.VANCOUVER, Cities.CALGARY, GameColor.ANY, 3);
        this.addEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);
        this.addEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);

        this.addEdge(Cities.SEATTLE, Cities.CALGARY, GameColor.ANY, 4);
        this.addEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        this.addEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        this.addEdge(Cities.SEATTLE, Cities.HELENA, GameColor.YELLOW, 6);

        this.addEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.GREEN, 5);
        this.addEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.PURPLE, 5);
        this.addEdge(Cities.PORTLAND, Cities.SALT_LAKE_CITY, GameColor.BLUE, 6);

        this.addEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.YELLOW, 3);
        this.addEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.PURPLE, 3);
        this.addEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.WHITE, 5);
        this.addEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.ORANGE, 5);

        this.addEdge(Cities.HELENA, Cities.SALT_LAKE_CITY, GameColor.PURPLE, 3);

        this.addEdge(Cities.SALT_LAKE_CITY, Cities.LAS_VEGAS, GameColor.ORANGE, 3);

        this.addEdge(Cities.LAS_VEGAS, Cities.LOS_ANGELES, GameColor.ANY, 2);

        this.addEdge(Cities.LOS_ANGELES, Cities.PHOENIX, GameColor.ANY, 3);
        this.addEdge(Cities.LOS_ANGELES, Cities.EL_PASO, GameColor.BLACK, 6);

        this.addEdge(Cities.EL_PASO, Cities.PHOENIX, GameColor.ANY, 3);
        this.addEdge(Cities.EL_PASO, Cities.HOUSTON, GameColor.GREEN, 6);

        this.addEdge(Cities.PHOENIX, Cities.SANTA_FE, GameColor.ANY, 3);
        this.addEdge(Cities.PHOENIX, Cities.DENVER, GameColor.WHITE, 5);

        this.addEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.YELLOW, 3);
        this.addEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.RED, 3);
        this.addEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.BLACK, 4);
        this.addEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.ORANGE, 4);
        this.addEdge(Cities.DENVER, Cities.OKLAHOMA_CITY, GameColor.RED, 4);
        this.addEdge(Cities.DENVER, Cities.SANTA_FE, GameColor.ANY, 2);
        this.addEdge(Cities.DENVER, Cities.HELENA, GameColor.GREEN, 4);
        this.addEdge(Cities.DENVER, Cities.OMAHA, GameColor.PURPLE, 4);

        this.addEdge(Cities.SANTA_FE, Cities.EL_PASO, GameColor.ANY, 2);

        this.addEdge(Cities.OKLAHOMA_CITY, Cities.SANTA_FE, GameColor.BLUE, 3);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.EL_PASO, GameColor.YELLOW, 5);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.LITTLE_ROCK, GameColor.ANY, 2);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);
        this.addEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);

        this.addEdge(Cities.DALLAS, Cities.EL_PASO, GameColor.RED, 4);
        this.addEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        this.addEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        this.addEdge(Cities.DALLAS, Cities.LITTLE_ROCK, GameColor.ANY, 2);

        this.addEdge(Cities.HOUSTON, Cities.NEW_ORLEANS, GameColor.ANY, 2);

        this.addEdge(Cities.NEW_ORLEANS, Cities.LITTLE_ROCK, GameColor.GREEN, 3);
        this.addEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.YELLOW, 4);
        this.addEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.ORANGE, 4);
        this.addEdge(Cities.NEW_ORLEANS, Cities.MIAMI, GameColor.RED, 6);

        this.addEdge(Cities.ATLANTA, Cities.MIAMI, GameColor.BLUE, 5);
        this.addEdge(Cities.ATLANTA, Cities.CHARLESTON, GameColor.ANY, 2);
        this.addEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        this.addEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        this.addEdge(Cities.ATLANTA, Cities.NASHVILLE, GameColor.ANY, 1);

        this.addEdge(Cities.LITTLE_ROCK, Cities.NASHVILLE, GameColor.WHITE, 3);
        this.addEdge(Cities.LITTLE_ROCK, Cities.SAINT_LOUIS, GameColor.ANY, 2);

        this.addEdge(Cities.SAINT_LOUIS, Cities.PITTSBURG, GameColor.GREEN, 5);
        this.addEdge(Cities.SAINT_LOUIS, Cities.NASHVILLE, GameColor.ANY, 2);

        this.addEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.PURPLE, 2);
        this.addEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.BLUE, 2);
        this.addEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);
        this.addEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);

        this.addEdge(Cities.OMAHA, Cities.CHICAGO, GameColor.BLUE, 4);
        this.addEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        this.addEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        this.addEdge(Cities.OMAHA, Cities.HELENA, GameColor.RED, 5);

        this.addEdge(Cities.DULUTH, Cities.HELENA, GameColor.ORANGE, 6);
        this.addEdge(Cities.DULUTH, Cities.WINNIPEG, GameColor.BLACK, 4);
        this.addEdge(Cities.DULUTH, Cities.SAULT_ST_MARIE, GameColor.ANY, 3);
        this.addEdge(Cities.DULUTH, Cities.TORONTO, GameColor.PURPLE, 6);
        this.addEdge(Cities.DULUTH, Cities.CHICAGO, GameColor.RED, 3);

        this.addEdge(Cities.CHICAGO, Cities.TORONTO, GameColor.WHITE, 4);
        this.addEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.ORANGE, 3);
        this.addEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.BLACK, 3);
        this.addEdge(Cities.CHICAGO, Cities.SAINT_LOUIS, GameColor.GREEN, 2);

        this.addEdge(Cities.PITTSBURG, Cities.NASHVILLE, GameColor.YELLOW, 4);
        this.addEdge(Cities.PITTSBURG, Cities.RALEIGH, GameColor.ANY, 2);
        this.addEdge(Cities.PITTSBURG, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.GREEN, 2);
        this.addEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.WHITE, 2);
        this.addEdge(Cities.PITTSBURG, Cities.TORONTO, GameColor.ANY, 2);

        this.addEdge(Cities.NASHVILLE, Cities.RALEIGH, GameColor.BLACK, 3);

        this.addEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        this.addEdge(Cities.RALEIGH, Cities.CHARLESTON, GameColor.ANY, 2);

        this.addEdge(Cities.CHARLESTON, Cities.MIAMI, GameColor.PURPLE, 4);

        this.addEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.ORANGE, 2);
        this.addEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.BLACK, 2);

        this.addEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.RED, 2);
        this.addEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.YELLOW, 2);
        this.addEdge(Cities.NEW_YORK, Cities.MONTREAL, GameColor.BLUE, 3);

        this.addEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);
        this.addEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);

        this.addEdge(Cities.MONTREAL, Cities.TORONTO, GameColor.ANY, 3);
        this.addEdge(Cities.MONTREAL, Cities.SAULT_ST_MARIE, GameColor.BLACK, 5);

        this.addEdge(Cities.SAULT_ST_MARIE, Cities.TORONTO, GameColor.ANY, 2);
        this.addEdge(Cities.SAULT_ST_MARIE, Cities.WINNIPEG, GameColor.ANY, 6);

        this.addEdge(Cities.WINNIPEG, Cities.HELENA, GameColor.BLUE, 4);

        this.addEdge(Cities.HELENA, Cities.CALGARY, GameColor.ANY, 4);

        this.addEdge(Cities.CALGARY, Cities.WINNIPEG, GameColor.WHITE, 6);
    }

    public void printGraph()
    {
        String sourceString;
        String destinationString;
        String distanceString;
        int numberOfEdges;

        for (int i = 0; i < vertices; ++i)
        {
            ArrayList<Edge> list = adjList[i];

            for (int j = 0; j < list.size(); ++j)
            {
                sourceString = adjList[i].get(j).getSource().toString();
                destinationString = adjList[i].get(j).getDestination().toString();
                distanceString = Integer.toString(adjList[i].get(j).getWeight());

                System.out.println(sourceString + " to " + destinationString + " distance " + distanceString);
            }
        }

        numberOfEdges = Edge.getNumberOfEdges();
        System.out.println(numberOfEdges);
    }

    public void addEdge(Cities source, Cities destination, GameColor routeColor, int weight)
    {
        Edge edge = new Edge(source, destination, routeColor, weight);
        this.adjList[source.ordinal()].add(0, edge);
    }

    public void removeEdge(Cities source, Cities destination, GameColor routeColor, int weight)
    {
        // todo
        throw new UnsupportedOperationException();
    }
}