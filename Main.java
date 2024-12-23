import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Ship exodus = new Ship();
        ArrayList<SolarSystem> choices = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to space! Please select a solar system to explore:");

        while (true){
            // Displays ship stats.
            System.out.println("Fuel: " + exodus.getFuel() + ", Integrity: " + exodus.getIntegrity());

            // Creates and prints out the solar systems.
            for (int i = 0; i < (int)(Math.random()*4)+2; i++) {
                choices.add(new SolarSystem());
                System.out.println("System " + (i+1) + ": " + choices.get(choices.size()-1).printSystem());
            }

            // Handles the user's choice of solar system.
            boolean choice_Made = false;
            SolarSystem chosenSystem = null;
            while (true) {
                // This will crash if the user does not give a purely numerical input.
                System.out.println("Which system will you travel to? (Please enter the number)");
                int systemChoice = Integer.parseInt(input.nextLine());

                if ((systemChoice - 1 <= choices.size() - 1) & (systemChoice - 1 > -1)) {
                    chosenSystem = choices.get(systemChoice-1);
                    break;
                }
                else{
                    System.out.println("Please enter a valid number.");
                }
            }

            // Calculates remaining fuel and ends the game if the player runs out.
            exodus.jump(chosenSystem.getDistance());
            if (exodus.getFuel() < 1){
                System.err.println("GAME OVER: Out of fuel.");
                break;
            }

            // Displays the objects in a Solar System and lets the user select one.
            System.out.println("\n");
            chosenSystem.printObjects();
            Object chosenObject;

            while (true) {
                // This will crash if the user does not give a purely numerical input.
                System.out.println("Which object will you explore? (Please enter a number)");
                int objectChoice = Integer.parseInt(input.nextLine());
                if ((objectChoice - 1 <= chosenSystem.getSize() - 1) & (objectChoice - 1 > -1)) {
                    chosenObject = chosenSystem.getObject(objectChoice - 1);
                    break;
                }
                else {
                    System.out.println("Please enter a valid number.");
                }
            }

            // Determines if the user's interaction with the object ends the game or not.
            if (chosenObject.explore(exodus)) {
                break;
            }
            choices.clear();
        }
    }
}
