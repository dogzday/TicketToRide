package model;

public class Edge
{
    public static int numberOfEdges = 0;

    private Cities source;
    private Cities destination;
    private RouteColor routeColor;
    private int weight;

    public Edge(Cities source, Cities destination, RouteColor routeColor, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.routeColor = routeColor;

        ++numberOfEdges;
    }

    public Cities getSource() { return this.source; }
    public Cities getDestination() { return this.destination; }
    public RouteColor getRouteColor() { return this.routeColor; }
    public int getWeight() { return this.weight; }
}