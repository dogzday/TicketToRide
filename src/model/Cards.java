package model;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

public class Cards
{
    public static final int SHUFFLE_MULTIPLIER = 1;
    public static final int TRAINCARDS_LIMIT = 110;
    public static final int DESTINATIONCARDS_LIMIT = 30;

    private RouteColor[] trainCardsArray;
    private DestinationCard[] destinationCardsArray;

    private Stack<RouteColor> trainCardsStack;
    private Stack<DestinationCard> destinationCardsStack;

    public Cards()
    {
        trainCardsArray = new RouteColor[TRAINCARDS_LIMIT];
        destinationCardsArray = new DestinationCard[DESTINATIONCARDS_LIMIT];
        trainCardsStack = new Stack<>();
        destinationCardsStack = new Stack<>();

        fillCardsToPrivateArrays();

        for (int i = 0; i < SHUFFLE_MULTIPLIER; ++i)
        {
            randomizeArray(trainCardsArray);
            randomizeArray(destinationCardsArray);
        }

        for (RouteColor i : trainCardsArray) trainCardsStack.push(i);
        for (DestinationCard i : destinationCardsArray) destinationCardsStack.push(i);
    }

    // ========== getters ==========

    public RouteColor getNextTrainCard()
    {
        if (trainCardsStack.peek() == null) throw new EmptyStackException();

        return trainCardsStack.pop();
    }

    public DestinationCard getNextDestinationCard()
    {
        if (destinationCardsStack.peek() == null) throw new EmptyStackException();

        return destinationCardsStack.pop();
    }

    // ========== setters ==========

    public void addTrainCardToBottom(RouteColor trainCard)
    {
        if (this.trainCardsStack.size() >= TRAINCARDS_LIMIT) throw new ArithmeticException();

        trainCardsStack.add(trainCard);
    }

    public void addTrainCardToTop(RouteColor trainCard)
    {
        if (this.trainCardsStack.size() >= TRAINCARDS_LIMIT) throw new ArithmeticException();

        trainCardsStack.add(0, trainCard);
    }

    public void addDestinationCardToBottom(DestinationCard destinationCard)
    {
        if (this.destinationCardsStack.size() >= DESTINATIONCARDS_LIMIT) throw new ArithmeticException();

        destinationCardsStack.add(destinationCard);
    }

    public void addDestinationCardToTop(DestinationCard destinationCard)
    {
        if (this.destinationCardsStack.size() >= DESTINATIONCARDS_LIMIT) throw new ArithmeticException();

        destinationCardsStack.add(0, destinationCard);
    }

    // ========== helpers  ==========

    private <T> void randomizeArray(T[] array)
    {
        if (array == null) throw new NullPointerException();

        Random rand = new Random();

        for (int i = 0; i < array.length; ++i)
        {
            int randomPosition = rand.nextInt(array.length);
            T temp = array[i];

            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
    }

    private void fillCardsToPrivateArrays()
    {
        Arrays.fill(trainCardsArray, 0, 11, RouteColor.PURPLE);
        Arrays.fill(trainCardsArray, 12, 23, RouteColor.WHITE);
        Arrays.fill(trainCardsArray, 24, 35, RouteColor.BLUE);
        Arrays.fill(trainCardsArray, 36, 47, RouteColor.YELLOW);
        Arrays.fill(trainCardsArray, 48, 59, RouteColor.ORANGE);
        Arrays.fill(trainCardsArray, 60, 71, RouteColor.BLACK);
        Arrays.fill(trainCardsArray, 72, 83, RouteColor.RED);
        Arrays.fill(trainCardsArray, 84, 95, RouteColor.GREEN);
        Arrays.fill(trainCardsArray, 96, 110, RouteColor.ANY); // 14 wildcards

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
    }
}
