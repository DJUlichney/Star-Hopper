import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anomaly implements Object {
    private String flavorText, goodChoice, badChoice, goodOutcome, badOutcome;
    private int fuelGain, metalGain, metalLoss;
    private boolean wins_Game, loses_Game;
    private static ArrayList<String []> anomalies = new ArrayList<>();
    private static Scanner choice = new Scanner(System.in);

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("anomalies.txt"));

            String line;
            while ((line = reader.readLine()) != null){
                anomalies.add(line.split("/"));
            }
            reader.close();
        }
        catch (FileNotFoundException notFoundException){
            System.err.println("Could not find the anomalies file.");
        }
        catch (IOException ioException){
            System.err.println("Could not read the anomalies file.");
        }
    }

    public Anomaly(){
        String [] anomaly = anomalies.get((int)(Math.random() * anomalies.size()));
        this.flavorText = anomaly[0];
        this.goodChoice = anomaly[1];
        this.badChoice = anomaly[2];
        this.goodOutcome = anomaly[3];
        this.badOutcome = anomaly[4];
        this.fuelGain = Integer.parseInt(anomaly[5]);
        this.metalGain = Integer.parseInt(anomaly[6]);
        this.metalLoss = Integer.parseInt(anomaly[7]);
        this.wins_Game = Boolean.parseBoolean(anomaly[8]);
        this.loses_Game = Boolean.parseBoolean(anomaly[9]);
    }

    @Override
    public String print(){
        return "!!! Anomaly Detected !!!";
    }

    @Override
    public boolean explore(Ship exodus){
        System.out.println(this.flavorText);

        while (true) {
            String decision = choice.nextLine();

            // Handles good choices.
            if (decision.equalsIgnoreCase(this.goodChoice)) {
                if (!this.wins_Game) {
                    System.out.println(this.goodOutcome);
                    System.out.format("\nFuel gained: %d, Integrity gained: %d\n", Math.min(100 - exodus.getFuel(), this.fuelGain), Math.min(100 - exodus.getIntegrity(), this.metalGain));
                    exodus.gain(this.metalGain, this.fuelGain);
                    return false;
                } else {
                    System.out.println(this.goodOutcome);
                    return true;
                }
            }

            // Handles bad choices.
            else if (decision.equalsIgnoreCase(this.badChoice)) {
                if (!this.loses_Game) {
                    System.out.println(this.badOutcome);
                    if (this.metalLoss >= exodus.getIntegrity()) {
                        System.err.println("GAME OVER - The ship was destroyed.");
                        return true;
                    } else {
                        System.out.format("\nDamage Sustained: %d\n", this.metalLoss);
                        exodus.damage(this.metalLoss);
                        return false;
                    }
                } else {
                    System.out.println(this.badOutcome);
                    System.err.println("GAME OVER");
                    return true;
                }
            }

            // Handles invalid choices.
            else {
                System.out.println("Please type in one of the choices.");
            }
        }
    }
}
