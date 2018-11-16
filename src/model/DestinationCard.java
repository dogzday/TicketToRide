package model;

public class DestinationCard
{
    private Cities source;
    private Cities destination;
    private int score;

    public DestinationCard(Cities source, Cities destination, int score)
    {
        this.source = source;
        this.destination = destination;
        this.score = score;
    }

    public Cities getSource() { return source; }
    public Cities getDestination() { return destination; }
    public int getScore() { return score; }

    @Override
    public String toString()
    {
        return (source.toString() + " " + destination.toString() + " " + Integer.toString(score));
    }
}
