package model;

/**
 * Contains all colors used to represent a Player's team. TeamColor is used by Player.
 */
public enum TeamColor
{
    BLUE,
    RED,
    GREEN,
    YELLOW,
    BLACK;

    private static TeamColor[] allValues = values();

    public static TeamColor fromOrdinal(int n) { return allValues[n]; }
}
