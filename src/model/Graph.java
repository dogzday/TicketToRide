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

        //initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; ++i)
        {
            adjList[i] = new LinkedList<>();
        }
    }

    public void printGraph()
    {
        for (int i = 0; i < vertices; ++i)
        {
            LinkedList<Edge> list = adjList[i];

            for (int j = 0; j < list.size(); ++j)
            {
                System.out.println("vertex-" + i + " is connected to " + list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }
    }

    private void addEdge(int source, int destination, int weight)
    {
        Edge edge = new Edge(source, destination, weight);
        adjList[source].addFirst(edge);
        adjList[destination].addFirst(edge);
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);

        graph.printGraph();
    }
}