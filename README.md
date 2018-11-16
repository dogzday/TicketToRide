## TicketToRide
This is the **nonprofit purely academic** console/textual version of the game [Ticket To Ride](https://www.daysofwonder.com/tickettoride/en/usa/ "Ticket To Ride") by [Days of Wonder](https://www.daysofwonder.com/en/ "Days of Wonder"). Our aim is to represent it as closely as possible. **No copyright infringement intended**. Game written from the ground-up.

## Motivation
Our team wants to get familiar with Github with a small project to understand workflow.

## Code style
Any - **be readable**. For classes **other than** `model.ControllerModel.java` or `view.ControllerView.java`, please follow code style for consistency.

## Screenshots
N/A

## Built With
**IDE**

- [IntelliJ Idea](https://www.jetbrains.com/idea/)

**Tech**

- [JavaFX](https://docs.oracle.com/javase/8/javafx/api/toc.htm "JavaFX")

## Features
N/A

## Example
Mostly all methods exist for standard gameplay purposes already. **Do not** modify classes other than `model.ControllerModel.java` or `view.ControllerView.java` unless adding features. In that case, follow the code style for those classes.

`ControllerModel.java` handles game flow.

`Cards.java` contains the decks as a `java.util.List` of class `DestinationCard` and enum `TrainCardOrRouteColor`.

`DestinationCard.java` contains information about a single destination card - source, destination, and score.

`Cities.java` contains the list of all cities in the game.

`Graph.java` is a basic graph which contains a `java.util.LinkedList` of `Edge.java`.

`Edge.java` is the route from a `Cities` to another `Cities`.

`Player.java` contains all data for a player. Update each player data accordingly to gameplay.

`TeamColor.java` contains the list of all possible team colors - 5 in the base game. More could be added for complicated gameplay for example.

`TrainCardOrRouteColor.java` contains the list of all possible train cards/route colors, since they mutually correspond.

## Installation
N/A

## API Reference
N/A - will add javadocs *soon*.

## Tests
N/A - will use JUnit 4 testing.

## Usage
N/A

## Contribute
N/A

## Credit, References, and Resources
[Ticket To Ride](https://www.daysofwonder.com/tickettoride/en/usa/ "Ticket To Ride")

[Ticket To Ride on Steam](https://store.steampowered.com/app/108200/Ticket_to_Ride/ "Ticket To Ride on Steam")

[Days of Wonder](https://www.daysofwonder.com/en/ "Days of Wonder")

[TicketToRide Rules](https://ncdn0.daysofwonder.com/tickettoride/en/img/tt_rules_2015_en.pdf)

[Tutorial Video](https://www.youtube.com/watch?v=ClokNHi-aJM)

## License
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

MIT © [Reynold Prasad]() and [Jasleen Kaur]() and [Gabriel Concepcion]()
