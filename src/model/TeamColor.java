package model;

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
