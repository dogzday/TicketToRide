package model;

public class Edge
{
    private static int numberOfEdges = 0;
    private static int weightOfAllEdges = 0;

    private Cities source;
    private Cities destination;
    private GameColor routeColor;
    private int weight;

    // ============================== class ==============================

    public Edge(Cities source, Cities destination, GameColor routeColor, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.routeColor = routeColor;

        ++numberOfEdges;
        weightOfAllEdges += weight;
    }

    // ============================== getters ==============================

    public Cities getSource() { return this.source; }

    public Cities getDestination() { return this.destination; }

    public GameColor getRouteColor() { return this.routeColor; }

    public int getWeight() { return this.weight; }

    public static int getNumberOfEdges() { return numberOfEdges; }

    public static int getWeightOfAllEdges() { return weightOfAllEdges; }

    // ============================== setters ==============================

    public void setSource(Cities source) { this.source = source; }

    public void setDestination(Cities destination) { this.destination = destination; }

    public void setRouteColor(GameColor routeColor) { this.routeColor = routeColor; }

    public void setWeight(int weight) throws IllegalArgumentException
    {
        if (weight <= 0) throw new IllegalArgumentException();

        weightOfAllEdges -= this.weight;
        weightOfAllEdges += weight;
    }
}