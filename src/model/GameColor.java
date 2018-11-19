package model;

/**
 * Contains all colors used to represent a TrainCard or a RouteColor. TrainCards are used by
 * Players. A Player draws TrainCards of a certain GameColor. RouteColor is used for
 * Graph (the game board map).
 */
public enum GameColor
{
    PURPLE,
    BLUE,
    ORANGE,
    WHITE,
    GREEN,
    YELLOW,
    BLACK,
    RED,
    ANY;

    private static GameColor[] allValues = values();

    public static GameColor fromOrdinal(int n) { return allValues[n]; }
}
