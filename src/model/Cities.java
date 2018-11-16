package model;

public enum Cities
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

    private static Cities[] allValues = values();

    public static Cities fromOrdinal(int n) { return allValues[n]; }
}
