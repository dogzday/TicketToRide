package model;

import java.util.Scanner;

public class ControllerModel
{
    public static void main(String[] args)
    {
        Graph gameBoard = new Graph(Cities.values().length);
        Cards cards = new Cards();
        createMap(gameBoard);

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

    private static void createMap(Graph graph)
    {
        graph.addEdge(Cities.VANCOUVER, Cities.CALGARY, GameColor.ANY, 3);
        graph.addEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);
        graph.addEdge(Cities.VANCOUVER, Cities.SEATTLE, GameColor.ANY, 1);

        graph.addEdge(Cities.SEATTLE, Cities.CALGARY, GameColor.ANY, 4);
        graph.addEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        graph.addEdge(Cities.SEATTLE, Cities.PORTLAND, GameColor.ANY, 1);
        graph.addEdge(Cities.SEATTLE, Cities.HELENA, GameColor.YELLOW, 6);

        graph.addEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.GREEN, 5);
        graph.addEdge(Cities.PORTLAND, Cities.SAN_FRANCISCO, GameColor.PURPLE, 5);
        graph.addEdge(Cities.PORTLAND, Cities.SALT_LAKE_CITY, GameColor.BLUE, 6);

        graph.addEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.YELLOW, 3);
        graph.addEdge(Cities.SAN_FRANCISCO, Cities.LOS_ANGELES, GameColor.PURPLE, 3);
        graph.addEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.WHITE, 5);
        graph.addEdge(Cities.SAN_FRANCISCO, Cities.SALT_LAKE_CITY, GameColor.ORANGE, 5);

        graph.addEdge(Cities.HELENA, Cities.SALT_LAKE_CITY, GameColor.PURPLE, 3);

        graph.addEdge(Cities.SALT_LAKE_CITY, Cities.LAS_VEGAS, GameColor.ORANGE, 3);

        graph.addEdge(Cities.LAS_VEGAS, Cities.LOS_ANGELES, GameColor.ANY, 2);

        graph.addEdge(Cities.LOS_ANGELES, Cities.PHOENIX, GameColor.ANY, 3);
        graph.addEdge(Cities.LOS_ANGELES, Cities.EL_PASO, GameColor.BLACK, 6);

        graph.addEdge(Cities.EL_PASO, Cities.PHOENIX, GameColor.ANY, 3);
        graph.addEdge(Cities.EL_PASO, Cities.HOUSTON, GameColor.GREEN, 6);

        graph.addEdge(Cities.PHOENIX, Cities.SANTA_FE, GameColor.ANY, 3);
        graph.addEdge(Cities.PHOENIX, Cities.DENVER, GameColor.WHITE, 5);

        graph.addEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.YELLOW, 3);
        graph.addEdge(Cities.DENVER, Cities.SALT_LAKE_CITY, GameColor.RED, 3);
        graph.addEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.BLACK, 4);
        graph.addEdge(Cities.DENVER, Cities.KANSAS_CITY, GameColor.ORANGE, 4);
        graph.addEdge(Cities.DENVER, Cities.OKLAHOMA_CITY, GameColor.RED, 4);
        graph.addEdge(Cities.DENVER, Cities.SANTA_FE, GameColor.ANY, 2);
        graph.addEdge(Cities.DENVER, Cities.HELENA, GameColor.GREEN, 4);
        graph.addEdge(Cities.DENVER, Cities.OMAHA, GameColor.PURPLE, 4);

        graph.addEdge(Cities.SANTA_FE, Cities.EL_PASO, GameColor.ANY, 2);

        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.SANTA_FE, GameColor.BLUE, 3);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.EL_PASO, GameColor.YELLOW, 5);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.DALLAS, GameColor.ANY, 2);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.LITTLE_ROCK, GameColor.ANY, 2);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);
        graph.addEdge(Cities.OKLAHOMA_CITY, Cities.KANSAS_CITY, GameColor.ANY, 2);

        graph.addEdge(Cities.DALLAS, Cities.EL_PASO, GameColor.RED, 4);
        graph.addEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        graph.addEdge(Cities.DALLAS, Cities.HOUSTON, GameColor.ANY, 1);
        graph.addEdge(Cities.DALLAS, Cities.LITTLE_ROCK, GameColor.ANY, 2);

        graph.addEdge(Cities.HOUSTON, Cities.NEW_ORLEANS, GameColor.ANY, 2);

        graph.addEdge(Cities.NEW_ORLEANS, Cities.LITTLE_ROCK, GameColor.GREEN, 3);
        graph.addEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.YELLOW, 4);
        graph.addEdge(Cities.NEW_ORLEANS, Cities.ATLANTA, GameColor.ORANGE, 4);
        graph.addEdge(Cities.NEW_ORLEANS, Cities.MIAMI, GameColor.RED, 6);

        graph.addEdge(Cities.ATLANTA, Cities.MIAMI, GameColor.BLUE, 5);
        graph.addEdge(Cities.ATLANTA, Cities.CHARLESTON, GameColor.ANY, 2);
        graph.addEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        graph.addEdge(Cities.ATLANTA, Cities.RALEIGH, GameColor.ANY, 2);
        graph.addEdge(Cities.ATLANTA, Cities.NASHVILLE, GameColor.ANY, 1);

        graph.addEdge(Cities.LITTLE_ROCK, Cities.NASHVILLE, GameColor.WHITE, 3);
        graph.addEdge(Cities.LITTLE_ROCK, Cities.SAINT_LOUIS, GameColor.ANY, 2);

        graph.addEdge(Cities.SAINT_LOUIS, Cities.PITTSBURG, GameColor.GREEN, 5);
        graph.addEdge(Cities.SAINT_LOUIS, Cities.NASHVILLE, GameColor.ANY, 2);

        graph.addEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.PURPLE, 2);
        graph.addEdge(Cities.KANSAS_CITY, Cities.SAINT_LOUIS, GameColor.BLUE, 2);
        graph.addEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);
        graph.addEdge(Cities.KANSAS_CITY, Cities.OMAHA, GameColor.ANY, 1);

        graph.addEdge(Cities.OMAHA, Cities.CHICAGO, GameColor.BLUE, 4);
        graph.addEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        graph.addEdge(Cities.OMAHA, Cities.DULUTH, GameColor.ANY, 2);
        graph.addEdge(Cities.OMAHA, Cities.HELENA, GameColor.RED, 5);

        graph.addEdge(Cities.DULUTH, Cities.HELENA, GameColor.ORANGE, 6);
        graph.addEdge(Cities.DULUTH, Cities.WINNIPEG, GameColor.BLACK, 4);
        graph.addEdge(Cities.DULUTH, Cities.SAULT_ST_MARIE, GameColor.ANY, 3);
        graph.addEdge(Cities.DULUTH, Cities.TORONTO, GameColor.PURPLE, 6);
        graph.addEdge(Cities.DULUTH, Cities.CHICAGO, GameColor.RED, 3);

        graph.addEdge(Cities.CHICAGO, Cities.TORONTO, GameColor.WHITE, 4);
        graph.addEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.ORANGE, 3);
        graph.addEdge(Cities.CHICAGO, Cities.PITTSBURG, GameColor.BLACK, 3);
        graph.addEdge(Cities.CHICAGO, Cities.SAINT_LOUIS, GameColor.GREEN, 2);

        graph.addEdge(Cities.PITTSBURG, Cities.NASHVILLE, GameColor.YELLOW, 4);
        graph.addEdge(Cities.PITTSBURG, Cities.RALEIGH, GameColor.ANY, 2);
        graph.addEdge(Cities.PITTSBURG, Cities.WASHINGTON, GameColor.ANY, 2);
        graph.addEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.GREEN, 2);
        graph.addEdge(Cities.PITTSBURG, Cities.NEW_YORK, GameColor.WHITE, 2);
        graph.addEdge(Cities.PITTSBURG, Cities.TORONTO, GameColor.ANY, 2);

        graph.addEdge(Cities.NASHVILLE, Cities.RALEIGH, GameColor.BLACK, 3);

        graph.addEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        graph.addEdge(Cities.RALEIGH, Cities.WASHINGTON, GameColor.ANY, 2);
        graph.addEdge(Cities.RALEIGH, Cities.CHARLESTON, GameColor.ANY, 2);

        graph.addEdge(Cities.CHARLESTON, Cities.MIAMI, GameColor.PURPLE, 4);

        graph.addEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.ORANGE, 2);
        graph.addEdge(Cities.WASHINGTON, Cities.NEW_YORK, GameColor.BLACK, 2);

        graph.addEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.RED, 2);
        graph.addEdge(Cities.NEW_YORK, Cities.BOSTON, GameColor.YELLOW, 2);
        graph.addEdge(Cities.NEW_YORK, Cities.MONTREAL, GameColor.BLUE, 3);

        graph.addEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);
        graph.addEdge(Cities.BOSTON, Cities.MONTREAL, GameColor.ANY, 2);

        graph.addEdge(Cities.MONTREAL, Cities.TORONTO, GameColor.ANY, 3);
        graph.addEdge(Cities.MONTREAL, Cities.SAULT_ST_MARIE, GameColor.BLACK, 5);

        graph.addEdge(Cities.SAULT_ST_MARIE, Cities.TORONTO, GameColor.ANY, 2);
        graph.addEdge(Cities.SAULT_ST_MARIE, Cities.WINNIPEG, GameColor.ANY, 6);

        graph.addEdge(Cities.WINNIPEG, Cities.HELENA, GameColor.BLUE, 4);

        graph.addEdge(Cities.HELENA, Cities.CALGARY, GameColor.ANY, 4);

        graph.addEdge(Cities.CALGARY, Cities.WINNIPEG, GameColor.WHITE, 6);
    }
}
