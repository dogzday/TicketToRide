package model;

public class DestinationCard
{
    private static int numberOfDestinationCards = 0;
    private static int scoreOfAllCards = 0;

    private Cities source;
    private Cities destination;
    private int score;

    // ============================== class ==============================

    public DestinationCard(Cities source, Cities destination, int score)
    {
        this.source = source;
        this.destination = destination;
        this.score = score;

        ++numberOfDestinationCards;
        scoreOfAllCards += score;
    }

    // ============================== other ==============================

    @Override
    public String toString()
    {
        return (this.source.toString() + " " + this.destination.toString() + " " + Integer.toString(this.score));
    }

    // ============================== getters ==============================

    public Cities getSource() { return source; }
    public Cities getDestination() { return destination; }
    public int getScore() { return score; }
    public static int getNumberOfDestinationCards() { return numberOfDestinationCards; }
    public static int getScoreOfAllCards() { return scoreOfAllCards; }

    // ============================== setters ==============================

    public void setSource(Cities source) { this.source = source; }
    public void setDestination(Cities destination) { this.destination= destination; }
    public void setScore(int score) { this.score= score; }
}
