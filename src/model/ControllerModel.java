package model;

import java.util.Scanner;

public class ControllerModel
{
    public static void main(String[] args)
    {
        Graph gameBoard = new Graph(City.values().length);
        Cards cards = new Cards();

        gameBoard.createTicketToRideDefaultBoard();
        gameBoard.printGraph();

        Player jas = new Player("Jas", TeamColor.BLACK);
        Player rey = new Player("Rey", TeamColor.RED);
        Player gabe = new Player("Gabe", TeamColor.GREEN);

        // this is our end condition when a player has <= 2 trains left
        boolean playersHaveTrains = true;

        // at start of game, players each draw 3 destinationCards
        // players must choose 2 or 3 before continuing
        // then, every player getse a total of 4 cards to start
        // then, main game loop where players choose what they want to do

        // main game loop
        while(playersHaveTrains)
        {
            playerTurn(jas, cards);
            playerTurn(rey, cards);
            playerTurn(gabe, cards);

            // the SOLE end condition for the game
            if (rey.getTrainPieces() <= 2 || jas.getTrainPieces() <= 2 || gabe.getTrainPieces() <= 2) break;
        }
    }

    private static boolean playerTurn(Player player, Cards cards)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("1 for Draw Train Cards");
        System.out.println("2 for Claim a Route");
        System.out.println("3 for Draw Destination Tickets");
        System.out.print("Choose an option: ");
        System.out.println();

        int choice = input.nextInt();

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

        return false;
    }

    private static void drawTrainCards(Player player, Cards cards) {

        int timesDrawn = 0;
        boolean wildcard = false;
        System.out.println("Please draw Two cards...");

        //loop till player picks up at least 2 train cards or picks up 1 wild card from face up
        //if choice is 1 pick up from face up, timesdrawn++
        //2 pick up from face down, timesdrawn++
        //end loop
        while(timesDrawn < 2 || wildcard == true)
        {
            System.out.println("1 for Draw From Face Up Deck");
            System.out.println("2 for Draw From Face Down Deck");
            System.out.print("Choose an option: ");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Drawing from face up Deck"); // add face up deck
                    // draw from face up deck and add to player hand
                    // todo if card is wildcard, wildcard = true;
                    ++timesDrawn;
                    break;
                case 2:
                    System.out.println("Drawing from face down Deck");
                    // draw from face down and add to player hand
                    player.addTrainCardToHand(cards.getNextTrainCard());
                    // player.displayTrainCards();
                    ++timesDrawn;
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    private static void claimRoute(Player player, Cards cards)
    {
        System.out.println("Choose a Train Car color");
        // display players different train car card colors
        player.displayTrainCards(); // doesnt work...

        System.out.println("Choose a route: ");
        // display routes for user to choose from

        // if train card color == routes Color and players train cards == number of route cards
        // place players trainCards, decrement their trainCards, decrement their train cars
        // else return false
        // take out the claimed route from map.
    }

    private static void drawDestinationTickets(Player player, Cards cards)
    {
        // draw 3 and show the player

        int desCards = 0;
        int choice = 0;
        boolean[] prevChoices = {false, false, false}; // marks true so that player does not choose same card
        Scanner input = new Scanner(System.in);
        System.out.println("Choose which destinations to keep...");

        // get the destination cards
        DestinationCard destinationCard1 = cards.getNextDestinationCard();
        DestinationCard destinationCard2 = cards.getNextDestinationCard();
        DestinationCard destinationCard3 = cards.getNextDestinationCard();
        // display 3 destination cards
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

        // player.displayDestinationCards();
    }
}
