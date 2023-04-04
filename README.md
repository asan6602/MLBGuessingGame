# MLBGuessingGame
main is located in front\src\main\java\com\example\App.java

https://youtu.be/7f_X7o0f__8

-javafx application with connection to postgresSQL

-strategy pattern

-backend documentation in MLB Guessing Game Design Document.pdf


![image](https://user-images.githubusercontent.com/110870409/225184219-32023dfd-cb7b-450b-82ba-3f9df247121a.png)


[MLB Guessing Game Design Document-2.pdf](https://github.com/asan6602/MLBGuessingGame/files/11005998/MLB.Guessing.Game.Design.Document-2.pdf)

# Summary

MLB Guessing Game is a game in which a user is given the year by year statistics and is tasked with guessing who that player is.  In the standard setting the pool of players begins in 1920 as that marks the beginning of what is known as the live-ball era.  However, the pool of players for the game can be adjusted to include only hall of famers, only major award winners (MVP or CY Young), or debut date by decade.  
When playing a game, a player's year by year statistics and a hidden version of that player’s name are displayed to the user.  The user has the option to guess the player, reveal more of the player’s name, or give up.  Upon successful completion of a game, the time it takes for the user to guess the player, the amount of hints the user used, and the player’s name is displayed back to the user.

# Game
The Game subsystem handles the functionality that goes into playing the game.  This subsystem can be broken down into two major components: initializing a game, and playing and completing a game.
Games are initialized with a game setting that dictates the pool of players.  The game settings are All Players, Hall of Famers, Major Award Winners (MVP or CY Young), and decade of debut starting from the 1920s to the 2010s and beyond.  For all settings the pool of players only includes players with 1000 games played, and pitchers with 200 games played.  In order to better achieve the game settings, the strategy pattern is applied. The strategy pattern makes it so that a family of player-sourcing algorithms can be used interchangeably.  The application of the strategy pattern helps the system adhere to Open-Closed Principle as new game settings can be added by implementing the existing interface.  The strategy pattern also increases cohesion as it leads to the creation of smaller classes with more narrowly defined responsibilities, these classes being the various concrete strategies.
![Screenshot 2023-04-04 190502](https://user-images.githubusercontent.com/110870409/229941446-b8ca23d6-90a9-42af-83da-f6f9e530da41.png)

# Player Data
The Player Data Subsystem handles the storage of player data.  Data is stored using the PostgreSQL database. There are Four databases. All databases have a playerkey entry which is used to link entries in different databases.  The first database is called Players which stores a player’s first and last name, their debut date, and their final game date.  The second database is called Awards which stores the MVP and CY Young winners.  The third database is called Hof and it stores Baseball Hall of Famers.  The fourth database is called Pitching which stores pitching statistics, and the fifth database is called Hitting which stores hitting statistics.  The statistical databases store entries per year.  A pitching entry includes games, team, wins, loses, saves, earned run average, strikeouts, and innings.  A hitting entry includes games, team, at-bats, runs, hits, doubles, triples, homeruns, runs-batted-in, steals, and walks.  Data is initialized into PostgreSQL from a csv file.  There is also a utility file which helps with PostgreSQL functionality.
![Screenshot 2023-04-04 190605](https://user-images.githubusercontent.com/110870409/229941677-48b76853-10da-4ba7-88fb-e4615d37cfdb.png)
