package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cards;
import model.GameColor;
import model.Player;
import model.TeamColor;

// a short example of players drawing cards from a deck as a game
// this is mainly a quick example using cards
// players draw cards until they have enough cards of a specific color they specify for their team

public class UsingCards
{
    public static void main(String[] args)
    {
        int winningAmount = 5;
        int winningPlayer = -1;
        boolean teamDoesNotHaveCards = true;

        // the people who will play
        String player1Name = "Harry";
        String player2Name = "Helga";
        String player3Name = "Archibald";
        String player4Name = "Angelica";

        // create the deck of cards
        Cards cards = new Cards();

        // create Player objects and add them to an ArrayList
        List<Player> players = new ArrayList<>();
        players.add(new Player(player1Name, TeamColor.BLACK));
        players.add(new Player(player2Name, TeamColor.GREEN));
        players.add(new Player(player3Name, TeamColor.RED));
        players.add(new Player(player4Name, TeamColor.BLUE));

        // create GameColor objects and add them to an ArrayList
        List<GameColor> playerCardColors = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        String playerCardColor;

        for (int i = 0; i < players.size(); ++i)
        {
            // todo needs error checking
            System.out.print("Enter " + players.get(i).getName() + "'s card color: ");
            playerCardColor = input.next();
            playerCardColors.add(GameColor.valueOf(playerCardColor));
        }

        while (teamDoesNotHaveCards)
        {
            for (int i = 0; i < players.size(); ++i)
            {
                try
                {
                    players.get(i).addTrainCardToHand(cards.getNextTrainCard());
                }
                catch (NullPointerException e)
                {
                    System.out.println("No more cards to draw!");
                    teamDoesNotHaveCards = false;
                    break;
                }

                if (players.get(i).containsTrainCards(playerCardColors.get(i), winningAmount))
                {
                    winningPlayer = i;
                    teamDoesNotHaveCards = false;
                }
            }
        }

        if (winningPlayer >= 0)
        {
            System.out.println("Congrats " + players.get(winningPlayer).getName() + "! You won!");
            System.out.println(players.get(winningPlayer).toString());
        }
    }
}
