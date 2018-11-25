package model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest
{
    static String playerName;
    static TeamColor playerTeam;
    static Player player;
    static Cards cards;

    @BeforeClass
    public static void before()
    {
        playerName = "TestPlayer";
        playerTeam = TeamColor.BLACK;

        player = new Player(playerName, playerTeam);
        cards = new Cards();

        for (int i = 0; i < Cards.TRAINCARDS_LIMIT; ++i)
        {
            player.addTrainCardToHand(cards.getNextTrainCard());
        }
    }

    @Test
    public void containsEnoughTrainCardsTest()
    {
        assertTrue(player.containsTrainCards(GameColor.BLACK, Cards.COLORED_TRAINCARDS_LIMIT));
    }

    @Test
    public void containsNotEnoughTrainCardsTest()
    {
        assertFalse(player.containsTrainCards(GameColor.RED, 13));
    }
}