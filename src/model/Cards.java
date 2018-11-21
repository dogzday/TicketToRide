package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards
{
    public static final int SHUFFLE_MULTIPLIER = 1;
    public static final int TRAINCARDS_LIMIT = 110;
    public static final int DESTINATIONCARDS_LIMIT = 30;

    private Random trainCardsRandomShuffler;
    private Random destinationCardsRandomShuffler;

    private List<GameColor> trainCardsList;
    private List<DestinationCard> destinationCardsList;

    private GameColor[] trainCardsArray;
    private DestinationCard[] destinationCardsArray;

    // ============================== class ==============================

    /**
     * Create a Cards object which holds all of the cards of the game. Players may have some of
     * these cards in their hand. Players normally draw TrainCards and DestinationCards from the
     * deck.
     */
    public Cards()
    {
        trainCardsList = new ArrayList<>();
        destinationCardsList = new ArrayList<>();

        trainCardsArray = new GameColor[TRAINCARDS_LIMIT];
        destinationCardsArray = new DestinationCard[DESTINATIONCARDS_LIMIT];

        trainCardsRandomShuffler = new Random();
        destinationCardsRandomShuffler = new Random();

        createAndFillArraysToList();

        for (int i = 0; i < SHUFFLE_MULTIPLIER; ++i)
        {
            Collections.shuffle(trainCardsList, trainCardsRandomShuffler);
            Collections.shuffle(destinationCardsList, destinationCardsRandomShuffler);
        }
    }

    // ============================== getters ==============================

    /**
     * The trainCardsRandomShuffler is a Random object used to shuffle the Cards such that we
     * can produce unique matches each time the game is played.
     * @return The Random seed that is fed into the shuffling of the cards.
     */
    public Random getTrainCardsRandomShuffler() { return trainCardsRandomShuffler; }

    /**
     * The trainCardsRandomShuffler is a Random object used to shuffle the Cards such that we
     * can produce unique matches each time the game is played.
     * @return The Random seed that is fed into the shuffling of the cards.
     */
    public Random getDestinationCardsRandomShuffler() { return destinationCardsRandomShuffler; }

    /**
     * This method gives the next trainCard from the deck as if you were drawing a card from the
     * top of the deck. This method is used to return a GameColor enum (it simply
     * returns the color specifying the TrainCard color of the TrainCard that a Player drew). The
     * Player will add this to their hand. Typical usage:<br>
     *     player.addTrainCardToHand(cards.getNextTrainCard());
     * @return The next TrainCard from the top of the deck.
     */
    public GameColor getNextTrainCard() throws NullPointerException
    {
        if (trainCardsList.isEmpty()) throw new NullPointerException();

        return trainCardsList.remove(0);
    }

    /**
     * This method gives the next destinationCard from the deck as if you were drawing a card from
     * the top of the deck. This method is used to return a DestinationCard object. The Player will
     * add this to their hand. Typical usage:<br>
     *     player.addDestinationCardToHand(cards.getNextDestinationCard());
     * @return The next DestinationCard from the top of the deck.
     */
    public DestinationCard getNextDestinationCard() throws NullPointerException
    {
        if (destinationCardsList.isEmpty()) throw new NullPointerException();

        return destinationCardsList.remove(0);
    }

    // ============================== setters ==============================

    /**
     * This method is used in any event where we need to store a TrainCard to the bottom of the
     * deck. An example of this would be if a Player wishes to discard a card for some reason or to
     * create a complex game rule where, for example, a Player can discard 9 TrainCards to the
     * bottom of the deck and redraw up to half that many rounded down (draw 4).
     * @param trainCard The trainCard to add to the bottom of the deck.
     */
    public void addTrainCardToBottom(GameColor trainCard) throws NullPointerException
    {
        if (this.trainCardsList.size() >= TRAINCARDS_LIMIT) throw new NullPointerException();

        trainCardsList.add(trainCard);
    }

    /**
     * This method is used in any event where we need to store a TrainCard to the top of the
     * deck. An example of this would be if a Player wishes to "peek" or "scry."
     * @param trainCard The trainCard to add to the top of the deck.
     */
    public void addTrainCardToTop(GameColor trainCard) throws NullPointerException
    {
        if (this.trainCardsList.size() >= TRAINCARDS_LIMIT) throw new NullPointerException();

        trainCardsList.add(0, trainCard);
    }

    /**
     * This method is used in any event where we need to store a DestinationCard to the bottom of
     * the deck. An example of this would be, in vanilla, if a Player draws 3 DestinationCards but
     * they only wish to keep 1 or 2, the remaining 2 or 1 cards would have to be placed back into
     * the destinationCards list. A Player would not want to keep DestinationCards if the routes
     * those cards have are not favorable to a Player's score - which is determined in vanilla, at
     * the end of the game.
     * @param destinationCard The destinationCard to add to the bottom of the deck, if for example,
     * the Player wishes not to keep some of the cards they drew.
     */
    public void addDestinationCardToBottom(DestinationCard destinationCard) throws NullPointerException
    {
        if (this.destinationCardsList.size() >= DESTINATIONCARDS_LIMIT) throw new NullPointerException();

        destinationCardsList.add(destinationCard);
    }

    /**
     * This method is used in any event where we need to store a DestinationCard to the top of the
     * deck. An example of this would be if there were some game rule where DestinationCards would
     * have to be discarded to the top of the DestinationCard deck. The gameplay this produces makes
     * players hesitant on discarding DestinationCards because redrawing would give them those same
     * DestinationCards again.
     * @param destinationCard The destinationCard to add back to the top of the deck where a Player
     * drew it from.
     */
    public void addDestinationCardToTop(DestinationCard destinationCard) throws NullPointerException
    {
        if (this.destinationCardsList.size() >= DESTINATIONCARDS_LIMIT) throw new NullPointerException();

        destinationCardsList.add(0, destinationCard);
    }

    // ============================== helpers ==============================

    private void createAndFillArraysToList()
    {
        Arrays.fill(trainCardsArray, 0, 11, GameColor.PURPLE);
        Arrays.fill(trainCardsArray, 12, 23, GameColor.WHITE);
        Arrays.fill(trainCardsArray, 24, 35, GameColor.BLUE);
        Arrays.fill(trainCardsArray, 36, 47, GameColor.YELLOW);
        Arrays.fill(trainCardsArray, 48, 59, GameColor.ORANGE);
        Arrays.fill(trainCardsArray, 60, 71, GameColor.BLACK);
        Arrays.fill(trainCardsArray, 72, 83, GameColor.RED);
        Arrays.fill(trainCardsArray, 84, 95, GameColor.GREEN);
        Arrays.fill(trainCardsArray, 96, 110, GameColor.ANY); // 14 wildcards

        destinationCardsArray[0] = new DestinationCard(Cities.DENVER, Cities.EL_PASO, 4);
        destinationCardsArray[1] = new DestinationCard(Cities.KANSAS_CITY, Cities.HOUSTON, 5);
        destinationCardsArray[2] = new DestinationCard(Cities.NEW_YORK, Cities.ATLANTA, 6);
        destinationCardsArray[3] = new DestinationCard(Cities.CHICAGO, Cities.NEW_ORLEANS, 7);
        destinationCardsArray[4] = new DestinationCard(Cities.CALGARY, Cities.SALT_LAKE_CITY, 7);
        destinationCardsArray[5] = new DestinationCard(Cities.HELENA, Cities.LOS_ANGELES, 8);
        destinationCardsArray[6] = new DestinationCard(Cities.DULUTH, Cities.HOUSTON, 8);
        destinationCardsArray[7] = new DestinationCard(Cities.SAULT_ST_MARIE, Cities.NASHVILLE, 8);
        destinationCardsArray[8] = new DestinationCard(Cities.MONTREAL, Cities.ATLANTA, 9);
        destinationCardsArray[9] = new DestinationCard(Cities.SAULT_ST_MARIE, Cities.OKLAHOMA_CITY, 9);
        destinationCardsArray[10] = new DestinationCard(Cities.SEATTLE, Cities.LOS_ANGELES, 9);
        destinationCardsArray[11] = new DestinationCard(Cities.CHICAGO, Cities.SANTA_FE, 9);
        destinationCardsArray[12] = new DestinationCard(Cities.DULUTH, Cities.EL_PASO, 10);
        destinationCardsArray[13] = new DestinationCard(Cities.TORONTO, Cities.MIAMI, 10);
        destinationCardsArray[14] = new DestinationCard(Cities.PORTLAND, Cities.PHOENIX, 11);
        destinationCardsArray[15] = new DestinationCard(Cities.DALLAS, Cities.NEW_YORK, 11);
        destinationCardsArray[16] = new DestinationCard(Cities.DENVER, Cities.PITTSBURG, 11);
        destinationCardsArray[17] = new DestinationCard(Cities.WINNIPEG, Cities.LITTLE_ROCK, 11);
        destinationCardsArray[18] = new DestinationCard(Cities.WINNIPEG, Cities.HOUSTON, 12);
        destinationCardsArray[19] = new DestinationCard(Cities.BOSTON, Cities.MIAMI, 12);
        destinationCardsArray[20] = new DestinationCard(Cities.VANCOUVER, Cities.SANTA_FE, 13);
        destinationCardsArray[21] = new DestinationCard(Cities.CALGARY, Cities.PHOENIX, 13);
        destinationCardsArray[22] = new DestinationCard(Cities.MONTREAL, Cities.NEW_ORLEANS, 13);
        destinationCardsArray[23] = new DestinationCard(Cities.LOS_ANGELES, Cities.CHICAGO, 16);
        destinationCardsArray[24] = new DestinationCard(Cities.SAN_FRANCISCO, Cities.ATLANTA, 17);
        destinationCardsArray[25] = new DestinationCard(Cities.PORTLAND, Cities.NASHVILLE, 17);
        destinationCardsArray[26] = new DestinationCard(Cities.VANCOUVER, Cities.MONTREAL, 20);
        destinationCardsArray[27] = new DestinationCard(Cities.LOS_ANGELES, Cities.MIAMI, 20);
        destinationCardsArray[28] = new DestinationCard(Cities.LOS_ANGELES, Cities.NEW_YORK, 21);
        destinationCardsArray[29] = new DestinationCard(Cities.SEATTLE, Cities.NEW_YORK, 22);

        Collections.addAll(trainCardsList, trainCardsArray);
        Collections.addAll(destinationCardsList, destinationCardsArray);
    }
}
