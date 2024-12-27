How to Play:

Star-Hopper is a text-based space survival game where your goal is to find a habitable planet to colonize. Planets are generated with several stats affecting their overall habitability.
You win the game when you find a planet that can be safely colonized.

To do this, you will need to manage the fuel and integrity of your ship. Fuel is used when you travel to another star system and integrity is lost if your spaceship is damaged in an event. The game ends when either runs out.

All planets in the game will have an amount of fuel or metal to be extracted with gas giants having more fuel and terrestrial planets having more metal. Collecting metal recovers ship integrity.

In each solar system, you will be able to select one world to explore, after which you will be given a set of solar systems to travel to, with different fuel costs.

Additionally, you will also occassionally encounter anomalies when exploring which can have good or bad results depending on your response. These scenarios are customizable and are drawn from the anomalies text file.


File Descriptions:

Main.java - Runs the Star-Hopper game using the classes established in the other files.

Object.java - Establishes the "Object" interface, which is used by planets and anomalies.

Anomaly.java - Establishes the anomaly class, providing methods for creating and interacting with them making use of the anomalies text file.

anomalies.txt - Contains all anomaly scenarios and their information in the following format: scenario text/good answer/bad answer/good outcome text/bad outcome text/fuel amount gained with good answer/metal amount gained with good answer/integrity lost with bad answer/Wins game with good answer(true/false)/Loses game with bad answer(true/false)

Planet.java - Establishes the planet class, providing methods for creating and interacting with them.

SolarSystem.java - Establishes the solar system class, making use of the planet and anomaly classes to provide methods to create and interact with solar systems.

Ship.java - Establishes the ship class, which is used to track the fuel and integrity values of the player's ship as well as providing methods for the game to use.
