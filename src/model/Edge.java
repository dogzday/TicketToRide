package model;

public class Edge
{
    private static int numberOfEdges = 0;
    private static int weightOfAllEdges = 0;

    private City source;
    private City destination;
    private GameColor routeColor;
    private int weight;
    private boolean visited;

    // ============================== class ==============================

    public Edge(City source, City destination, GameColor routeColor, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.routeColor = routeColor;
        this.visited = false;

        ++numberOfEdges;
        weightOfAllEdges += weight;
    }

    // ============================== other ==============================

    @Override
    public String toString()
    {
        String sourceString = this.source.toString();
        String destinationString = this.destination.toString();
        String routeColorString = this.routeColor.toString();
        String weightString = Integer.toString(weight);

        return (sourceString + " " + destinationString + " " + routeColorString + " " + weightString);
    }

    // ============================== getters ==============================

    public City getSource() { return this.source; }

    public City getDestination() { return this.destination; }

    public static int getWeightOfAllEdges() { return weightOfAllEdges; }

    public static int getNumberOfEdges() { return numberOfEdges; }

    public int getWeight() { return this.weight; }

    public boolean getVisited() { return this.visited; }

    public GameColor getRouteColor() { return this.routeColor; }

    // ============================== setters ==============================

    public void setSource(City source) { this.source = source; }

    public void setDestination(City destination) { this.destination = destination; }

    public void setWeight(int weight) throws IllegalArgumentException
    {
        if (weight <= 0) throw new IllegalArgumentException();

        weightOfAllEdges -= this.weight;
        weightOfAllEdges += weight;
    }

    public void setRouteColor(GameColor routeColor) { this.routeColor = routeColor; }

    public void setVisited(boolean visited) { this.visited = visited; }
}