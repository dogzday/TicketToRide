package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerModel
{
    public static void main(String[] args)
    {
        Graph gameBoard = new Graph(City.values().length);
        Cards cards = new Cards();
        List<Player> players = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        String tempName = null;
        int tempTeamOrdinal = 0;
        int numberOfPlayers = 0;
        TeamColor tempTeamColor;

        gameBoard.createTicketToRideDefaultBoard();
        gameBoard.printGraph();

        System.out.println("Welcome to Ticket To Ride.");
        System.out.println("How many players will play the game?");

        numberOfPlayers = input.nextInt();

        System.out.println();

        for (int i = 0; i < numberOfPlayers; ++i)
        {
            while (!input.hasNext())
            {
                System.out.print("Please enter a valid name for player #" + i + ": ");
                tempName = input.next();
                System.out.println();
            }

            System.out.println();

            while (!input.hasNextInt())
            {
                System.out.print("Please enter " + tempName + "'s team [" + "0 - " + TeamColor.values().length + "]: ");
                tempTeamOrdinal = input.nextInt();
                System.out.println();
            }

            tempTeamColor = TeamColor.fromOrdinal(tempTeamOrdinal);

            System.out.println();

            players.add(new Player(tempName, tempTeamColor));
        }

        // this is our end condition when a player has <= 2 trains left
        boolean playersHaveTrains = true;

        // at start of game, players each draw 3 destinationCards
        // players must choose 2 or 3 before continuing
        // then, every player getse a total of 4 cards to start

        // main game loop
        while(playersHaveTrains)
        {
            // todo pre-game from above comment

            for (Player player : players)
            {
                playerTurn(player, cards);

                // the SOLE end condition for the game
                if (player.getTrainPieces() <= 2) playersHaveTrains = false;
            }
        }
    }

    private static void playerTurn(Player player, Cards cards)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("[1] to draw Train cards.");
        System.out.println("[2] to claim a route.");
        System.out.println("[3] for draw Destination Tickets.");
        System.out.print("Choose an option: ");

        int choice = input.nextInt();
        System.out.println();

        while (choice < 1 || choice > 3)
        {
            System.out.print("Choose a valid option: ");
            choice = input.nextInt();
        }

        switch (choice)
        {
            case 1:
                drawTrainCards(player, cards);
                break;
            case 2:
                claimRoute(player, cards);
                break;
            case 3:
                drawDestinationTickets(player, cards);
                break;
        }
    }

    // todo modify
    private static void drawTrainCards(Player player, Cards cards)
    {
        int timesDrawn = 0;
        boolean hasDrawnWildcard = false;
        System.out.println("Please draw two cards.");

        //loop till player picks up at least 2 train cards or picks up 1 wild card from face up
        //if choice is 1 pick up from face up, timesdrawn++
        //2 pick up from face down, timesdrawn++
        //end loop
        while(timesDrawn < 2 || hasDrawnWildcard)
        {
            System.out.println("1 for Draw From Face Up Deck");
            System.out.println("2 for Draw From Face Down Deck");
            System.out.print("Choose an option: ");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("\nDrawing from face up Deck:"); // add face up deck
                    // draw from face up deck and add to player hand
                    // todo if card is wildcard, wildcard = true;
                    ++timesDrawn;
                    break;
                case 2:
                    System.out.println("\nDrawing from face down Deck:");
                    // draw from face down and add to player hand
                    player.addTrainCardToHand(cards.getNextTrainCard());
                    player.displayTrainCards();
                    ++timesDrawn;
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    // todo modify
    private static void claimRoute(Player player, Cards cards)
    {
        System.out.println("Choose a Train Car color: ");
        // display players different train car card colors
        player.displayTrainCards();

        System.out.println("Choose a route: "); // todo use train car color to choose a route? or have player type in a starting point
        // display routes for user to choose from

        // if train card color == routes Color and players train cards == number of route cards
        // place players trainCards, decrement their trainCards, decrement their train cars
        // else return false
        // take out the claimed route from map.
    }

    // todo modify
    private static void drawDestinationTickets(Player player, Cards cards)
    {
        int desCards = 0;
        int choice = 0;
        boolean[] prevChoices = {false, false, false}; // marks true so that player does not choose same card
        Scanner input = new Scanner(System.in);
        System.out.println("Choose which destinations to keep...");

        DestinationCard destinationCard1 = cards.getNextDestinationCard();
        DestinationCard destinationCard2 = cards.getNextDestinationCard();
        DestinationCard destinationCard3 = cards.getNextDestinationCard();

        System.out.println("1 - " + destinationCard1.toString());
        System.out.println("2 - " + destinationCard2.toString());
        System.out.println("3 - " + destinationCard3.toString());
        System.out.println(("4 - for Done"));
        // todo handle discarded destination cards

        while((desCards < 3 && choice != 4) || desCards == 0) //while picked cards are < 3 then keep picking or if done = true stop loop
        {
            System.out.print("=> "); // pick an option
            choice = input.nextInt();

            while(choice == 4 && desCards == 0)
            {
                System.out.println("Must choose at least 1 Card!");
                System.out.print("=> ");
                choice = input.nextInt();
            }

            if( (choice > 0 && choice < 4) && prevChoices[choice-1] != true)
            {   // add destination card to players hand
                switch(choice)
                {
                    case 1:
                        player.addDestinationCardToHand(destinationCard1);
                        break;
                    case 2:
                        player.addDestinationCardToHand(destinationCard2);
                        break;
                    case 3:
                        player.addDestinationCardToHand(destinationCard3);
                        break;
                }
                ++desCards;
                prevChoices[choice-1] = true;
            }
            else if(choice != 4)
            {
                System.out.println("Destination already selected.");
            }
        }
        System.out.println("\nTotal Destination Cards:");
        player.displayDestinationCards();
    }
}
