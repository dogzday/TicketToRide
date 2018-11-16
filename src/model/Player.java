package model;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    public static final int TRAINPIECE_LIMIT = 45;

    private static int NUM_PLAYERS = 0;

    private String name;
    private TeamColor teamColor;
    private int trainPieces;
    private int score;
    private List<TrainCardOrRouteColor> trainCards;
    private List<DestinationCard> destinationCards;

    // ============================== class ==============================

    public Player(String name, TeamColor teamColor)
    {
        score = 0;
        trainPieces = TRAINPIECE_LIMIT;
        trainCards = new ArrayList<>(Cards.TRAINCARDS_LIMIT);
        destinationCards = new ArrayList<>(Cards.DESTINATIONCARDS_LIMIT);

        this.name = name;
        this.teamColor = teamColor;

        ++NUM_PLAYERS;
    }

    // ============================== other ==============================

    public void addTrainCardToHand(TrainCardOrRouteColor trainCardColor){ trainCards.add(trainCardColor); }
    public void addDestinationCardToHand(DestinationCard destinationCard) { destinationCards.add(destinationCard); }

    public void displayTrainCards() { for (TrainCardOrRouteColor i : trainCards) System.out.println(i); }

    public void displayDestinationCards()
    {
        String sourceString;
        String destinationString;
        String scoreString;

        for (DestinationCard card : destinationCards)
        {
            sourceString = card.getSource().toString();
            destinationString = card.getDestination().toString();
            scoreString = Integer.toString(card.getScore());
            System.out.println(sourceString + " " + destinationString + " " + scoreString);
        }
    }

    @Override
    public String toString()
    {
        return (name + "\n" +
                teamColor.toString() + "\n" +
                Integer.toString(trainPieces) + "\n" +
                Integer.toString(score) + "\n" +
                trainCards.toString() + "\n" +
                destinationCards.toString());
    }

    // ============================== getters ==============================

    public String getName() { return name; }
    public TeamColor getTeamColor() { return teamColor; }
    public int getTrainPieces() { return trainPieces; }
    public int getScore() { return score; }
    public List<TrainCardOrRouteColor> getTrainCards() { return trainCards; }
    public List<DestinationCard> getDestinationCards() { return destinationCards; }

    // ============================== setters ==============================

    public void setName(String name) { this.name = name; }
    public void setTeamColor(TeamColor teamColor) { this.teamColor = teamColor; }
    public void setTrainPieces(int trainPieces) { this.trainPieces = trainPieces; }
    public void setScore(int score) { this.score = score; }

    public void setTrainCards(List<TrainCardOrRouteColor> trainCards) { this.trainCards = new ArrayList<>(trainCards); }
    public void setDestinationCards(List<DestinationCard> destinationCards) { this.destinationCards = new ArrayList<>(destinationCards); }

    public void addTrainPiece()
    {
        if (this.trainPieces >= TRAINPIECE_LIMIT) throw new ArithmeticException();

        ++this.trainPieces;
    }

    public void removeTrainPiece()
    {
        if (this.trainPieces <= 0) throw new ArithmeticException();

        --this.trainPieces;
    }

    public boolean containsTrainCards(TrainCardOrRouteColor trainCard, int quantity)
    {
        int trainCardQuantity = 0;

        for (TrainCardOrRouteColor i : this.trainCards) if (this.trainCards.contains(trainCard)) ++trainCardQuantity;

        return (trainCardQuantity == quantity);
    }

    public void removeTrainCards(TrainCardOrRouteColor trainCard, int quantity)
    {
        if (!containsTrainCards(trainCard, quantity)) throw new ArithmeticException();

        for (int i = 0; i < quantity; ++i) this.trainCards.remove(trainCard);
    }
}
