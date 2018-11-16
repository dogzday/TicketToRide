package model;

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
