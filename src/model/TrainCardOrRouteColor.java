package model;

/**
 * Contains all colors used to represent a TrainCard or a RouteColor. TrainCards are used by
 * Players. A Player draws TrainCards of a certain TrainCardOrRouteColor. RouteColor is used for
 * Graph (the game board map).
 */
public enum TrainCardOrRouteColor
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

    private static TrainCardOrRouteColor[] allValues = values();

    public static TrainCardOrRouteColor fromOrdinal(int n) { return allValues[n]; }
}
