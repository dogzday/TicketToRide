package model;

/**
 * Contains all the cities which serve as endpoints of a route in the game. Edge and DestinationCard
 * uses this. Edge creates a route between the two City. DestinationCard does the same but does
 * not create a new Edge - rather it is used for gameplay for the placement of a Player's
 * trainPieces given they have enough trainCards.
 */
public enum City
{
    ATLANTA,
    BOSTON,
    CALGARY,
    CHARLESTON,
    CHICAGO,
    DALLAS,
    DENVER,
    DULUTH,
    EL_PASO,
    HELENA,
    HOUSTON,
    KANSAS_CITY,
    LAS_VEGAS,
    LITTLE_ROCK,
    LOS_ANGELES,
    MIAMI,
    MONTREAL,
    NASHVILLE,
    NEW_ORLEANS,
    NEW_YORK,
    OKLAHOMA_CITY,
    OMAHA,
    PHOENIX,
    PITTSBURG,
    PORTLAND,
    RALEIGH,
    SAINT_LOUIS,
    SALT_LAKE_CITY,
    SAN_FRANCISCO,
    SANTA_FE,
    SAULT_ST_MARIE,
    SEATTLE,
    TORONTO,
    VANCOUVER,
    WASHINGTON,
    WINNIPEG;

    private static City[] allValues = values();

    public static City fromOrdinal(int n) { return allValues[n]; }
}
