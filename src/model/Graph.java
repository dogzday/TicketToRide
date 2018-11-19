package model;

import java.util.LinkedList;

public class Graph
{
    private int vertices;
    private LinkedList<Edge>[] adjList;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; ++i)
        {
            adjList[i] = new LinkedList<>();
        }
    }

    public void printGraph()
    {
        String sourceString;
        String destinationString;
        String distanceString;
        int numberOfEdges;

        for (int i = 0; i < vertices; ++i)
        {
            LinkedList<Edge> list = adjList[i];

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
        adjList[source.ordinal()].addFirst(edge);
    }
}