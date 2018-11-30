package model;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    @SuppressWarnings("WeakerAccess")
    public static final int TRAINPIECE_LIMIT = 45;

    private static int NUM_PLAYERS = 0;
    private static int TOTAL_SCORE = 0;

    private String name;
    private TeamColor teamColor;
    private int trainPieces;
    private int score;
    private List<GameColor> trainCards;
    private List<DestinationCard> destinationCards;

    // ============================== class ==============================

    /**
     * Initializes a Player. A Player contains:
     * <ul>
     *     <li>private String name;</li>
     *     <li>private TeamColor teamColor;</li>
     *     <li>private int trainPieces;</li>
     *     <li>private int score;</li>
     *     <li>private List&lt;GameColor&gt; trainCards;</li>
     *     <li>private List&lt;DestinationCard&gt; destinationCards;</li>
     * </ul>
     *
     * @param name Initializes a Player's name. Can be any name, nickname recommended.
     * @param teamColor TeamColor enum.
     */
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

    /**
     * Prints all of a player's trainCards to console, 1 per line.
     */
    @SuppressWarnings("WeakerAccess")
    public void displayTrainCards() { for (GameColor i : trainCards) System.out.println(i); }

    /**
     * Prints all of a player's destinationCards to console, 1 per line. It is formatted:<br>
     *     sourceString + destinationString + scoreString
     */
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

    /**
     * This method is used to test if a Player contains quantity of a certain color trainCard. If
     * you want to check if a player has 3 red TrainCards, evoke this method with
     * player.containsTrainCards(GameColor.RED, 3);
     * @param trainCard GameColor enum.
     * @param quantity Number of occurrences to check for.
     * @return If Player has quantity trainCards, return true, else false.
     */
    public boolean containsTrainCards(GameColor trainCard, int quantity)
    {
        int trainCardQuantity = 0;

        for (GameColor trainCard1 : this.trainCards)
        {
            if (trainCard1 == trainCard) ++trainCardQuantity;
        }

        return (trainCardQuantity == quantity);
    }

    @Override
    public String toString()
    {
        return (name + "\n" +
                "Name: " + teamColor.toString() + "\n" +             // NON-NLS
                "Pieces: " + Integer.toString(trainPieces) + "\n" +  // NON-NLS
            "Score: " + Integer.toString(score) + "\n" +             // NON-NLS
                "TrainCards: " + trainCards.toString() + "\n" +      // NON-NLS
                "DestinationCards" + destinationCards.toString());   // NON-NLS
    }

    // ============================== getters ==============================

    /**
     * @return Player's name, most likely a nickname.
     */
    public String getName() { return this.name; }

    /**
     * @return TeamColor enum representing the team a Player is on. Used for distinguising game
     * token pieces from Player to Player. Can be used for team-based gaming.
     */
    public TeamColor getTeamColor() { return this.teamColor; }

    /**
     * @return The number of trainPieces a player has. In vanilla, when a Player has less than or
     * equal to 2 trainPieces remaining, each player has 1 final turn.
     */
    @SuppressWarnings("WeakerAccess")
    public int getTrainPieces() { return this.trainPieces; }

    /**
     * @return A Player's score. Score is usually calculated at the very end.
     */
    public int getScore() { return this.score; }

    /**
     * @return A List of a Player's trainCards.
     */
    public List<GameColor> getTrainCards() { return this.trainCards; }

    /**
     * @return A List of a Player's destinationCards.
     */
    public List<DestinationCard> getDestinationCards() { return this.destinationCards; }

    // ============================== setters ==============================

    /**
     * Adds a single trainCard of a specific GameColor to a Player's hand. This is
     * useful for whenever a Player needs to draw a card. The cards are guaranteed to always be
     * shuffled if they are from Cards. You will need to add a trainCard from Cards which contains
     * the entire deck of cards.
     * @param trainCardColor Enum GameColor.
     */
    public void addTrainCardToHand(GameColor trainCardColor) { trainCards.add(trainCardColor); }

    /**
     * Adds a single destinationCard to a Player's hand. This is useful for whenever a Player needs
     * to draw a card. The cards are guaranteed to always be shuffled if they are from Cards. You
     * will need to add a destinationCard from Cards which contains the entire deck of cards.
     * @param destinationCard DestinationCard object.
     */
    @SuppressWarnings("WeakerAccess")
    public void addDestinationCardToHand(DestinationCard destinationCard) { destinationCards.add(destinationCard); }

    /**
     * Set's a Player's name. This is the name that other human players will see. Do not use a
     * personal identification number to identify a Player - it's recommended to use a nickname.
     * @param name The name assigned to a human player that is known to everyone.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Set's a Player's TeamColor. There can be multiple Players on the same team with special
     * game rules you can define. In vanilla, there is at most 1 Player per TeamColor.
     * @param teamColor A player's TeamColor.
     */
    public void setTeamColor(TeamColor teamColor) { this.teamColor = teamColor; }

    /**
     * This sets the number of trainPieces a Player has. In vanilla, the end condition for the game
     * is when a Player has 2 or less trainPieces remaining - then all Players will have 1 more
     * turn, then the scores are calculated.
     * @param trainPieces Set the number of trainPieces a player has.
     */
    public void setTrainPieces(int trainPieces) throws IllegalArgumentException
    {
        if (trainPieces < 0) throw new IllegalArgumentException();

        this.trainPieces = trainPieces;
    }

    /**
     * Sets a Player's score. In vanilla, this is determined at the end. The end occurs after the
     * final turn. The final turn triggers when a Player has 2 or less trainPieces remaining. A
     * Player's score at the end is the determiner of who won the game.
     * @param score Sets the Player's score with a nonnegative integer.
     */
    public void setScore(int score) throws IllegalArgumentException
    {
        if (score < 0) throw new IllegalArgumentException();

        TOTAL_SCORE -= this.score;
        this.score = score;
    }

    /**
     * Adds 1 point to a Player's score. In vanilla, this is determined at the end. The end occurs
     * after the final turn. The final turn triggers when a Player has 2 or less trainPieces
     * remaining. A Player's score at the end is the determiner of who won the game.
     */
    public void addPointToScore()
    {
        ++TOTAL_SCORE;
        ++this.score;
    }

    /**
     * Subtracts 1 point to a Player's score. In vanilla, this is determined at the end. The end
     * occurs after the final turn. The final turn triggers when a Player has 2 or less trainPieces
     * remaining. A Player's score at the end is the determiner of who won the game.
     */
    public void subtractPointFromScore() throws ArithmeticException
    {
        if ((score - 1) < 0) throw new ArithmeticException();

        --TOTAL_SCORE;
        --this.score;
    }

    /**
     * Sets a Player's trainCards (a Player's hand). This is useful for whenever a Player needs to
     * draw a lot of cards without a loop. The cards are guaranteed to always be shuffled if they
     * are from Cards. You will need to add a trainCard from Cards which contains the entire deck of
     * cards.
     * @param trainCards List containing GameColor enum objects.
     */
    public void setTrainCards(List<GameColor> trainCards) { this.trainCards = new ArrayList<>(trainCards); }

    /**
     * Sets a Player's destinationCards (a Player's hand). This is useful for whenever a Player
     * needs to draw a lot of cards without a loop. The cards are guaranteed to always be shuffled
     * if they are from Cards. You will need to add a trainCard from Cards which contains the entire
     * deck of cards.
     * @param destinationCards List containing DestinationCard objects.
     */
    public void setDestinationCards(List<DestinationCard> destinationCards) { this.destinationCards = new ArrayList<>(destinationCards); }

    /**
     * This adds 1 to the number of trainPieces a Player has. In vanilla, the end condition for the
     * game is when a Player has 2 or less trainPieces remaining - then all Players will have 1 more
     * turn, then the scores are calculated.
     */
    public void addTrainPiece() throws ArithmeticException
    {
        if (this.trainPieces >= TRAINPIECE_LIMIT) throw new ArithmeticException();

        ++this.trainPieces;
    }

    /**
     * This subtracts 1 to the number of trainPieces a Player has. In vanilla, the end condition for
     * the game is when a Player has 2 or less trainPieces remaining - then all Players will have 1
     * more turn, then the scores are calculated.
     */
    public void removeTrainPiece() throws ArithmeticException
    {
        if (this.trainPieces <= 0) throw new ArithmeticException();

        --this.trainPieces;
    }

    /**
     * Removes trainCards of a specific GameColor from a Player's hand. This is useful
     * for whenever a Player needs to place trainPieces on the game board - in vanilla a Player can
     * play trainPieces if the Player has enough trainCards of the GameColor the
     * trainPieces will be place on. The cards are guaranteed to always be shuffled if they are from
     * Cards. You will need to add a trainCard from Cards which contains the entire deck of cards.
     * @param trainCard The trainCard of a color to remove from a Player's hand.
     * @param quantity The amount of the trainCards to remove from a Player's hand.
     */
    public void removeTrainCardsFromHand(GameColor trainCard, int quantity) throws ArithmeticException
    {
        if (!containsTrainCards(trainCard, quantity)) throw new ArithmeticException();

        for (int i = 0; i < quantity; ++i) this.trainCards.remove(trainCard);
    }
}
