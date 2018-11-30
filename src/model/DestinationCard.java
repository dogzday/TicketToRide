package model;

public class DestinationCard
{
    private static int numberOfDestinationCards = 0;
    private static int scoreOfAllCards = 0;

    private City source;
    private City destination;
    private int score;

    // ============================== class ==============================

    /**
     * Creates a custom destination card for the game Ticket To Ride which links two cities with
     * a route. Destination cards have a score when a player completes the path.
     * @param source Source City enum.
     * @param destination Destination City enum.
     * @param score Integer >= 0 for the card's score.
     */
    public DestinationCard(City source, City destination, int score)
    {
        this.source = source;
        this.destination = destination;
        this.score = score;

        ++numberOfDestinationCards;
        scoreOfAllCards += score;
    }

    // ============================== other ==============================

    /**
     * String concatenation of the destination card.
     * @return source + destination + score
     */
    @Override
    public String toString()
    {
        return (this.source.toString() + " " + this.destination.toString() + " " + Integer.toString(this.score));
    }

    // ============================== getters ==============================

    public City getSource() { return source; }

    public City getDestination() { return destination; }

    @SuppressWarnings("WeakerAccess")
    public int getScore() { return score; }

    public static int getNumberOfDestinationCards() { return numberOfDestinationCards; }

    public static int getScoreOfAllCards() { return scoreOfAllCards; }

    // ============================== setters ==============================

    public void setSource(City source) { this.source = source; }

    public void setDestination(City destination) { this.destination= destination; }

    public void setScore(int score) { this.score= score; }
}
