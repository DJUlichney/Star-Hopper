import java.util.ArrayList;
import java.util.Scanner;

public class Planet implements Object {
    private String temperature, tempType, radiation, toxicity, type;
    private boolean is_habitable;
    private int fuel, metal;

    private static ArrayList<String> extremity = new ArrayList<>();
    private static ArrayList<String> types = new ArrayList<>();
    private static ArrayList<String> tempTypes = new ArrayList<>();

    static {
        extremity.add("mild");
        extremity.add("moderate");
        extremity.add("severe");
        extremity.add("extreme");

        types.add("terrestrial world");
        types.add("gas giant");

        tempTypes.add("hot");
        tempTypes.add("cold");
    }

    public Planet(){
        this.type = types.get((int)(Math.random()*2));
        //TODO: If there is extra time, you could take a planet's position to determine the temperature and its type.
        this.temperature = extremity.get((int)(Math.random()*4));
        this.tempType = tempTypes.get((int)(Math.random()*2));
        this.radiation = extremity.get((int)(Math.random()*4));
        this.toxicity = extremity.get((int)(Math.random()*4));
        if (this.type.equals("terrestrial world")){
            this.fuel = (int)(Math.random()*10);
            this.metal = (int)(Math.random()*25);
            //TODO: If there is extra time, you could have there be varying degrees of habitability.
            this.is_habitable = (this.temperature.equals("mild") | this.temperature.equals("moderate")) & (this.radiation.equals("mild") | this.radiation.equals("moderate")) & (this.toxicity.equals("mild") | this.toxicity.equals("moderate"));
        }

        else if (this.type.equals("gas giant")){
            this.fuel = (int)(Math.random()*40);
            this.metal = (int)(Math.random()*5);
            this.is_habitable = false;
        }
    }

    @Override
    public String print(){
        return String.format("Type: %s, Temperature: %sly %s, Radiation: %s, Toxicity: %s, Fuel: %d, Metal: %d", this.type, this.temperature, this.tempType, this.radiation, this.toxicity, this.fuel, this.metal);
    }

    @Override
    public boolean explore(Ship exodus){
        if (!this.is_habitable) {
            System.out.format("\nFuel gained: %d, Integrity gained: %d\n", Math.min(100 - exodus.getFuel(), this.fuel), Math.min(100 - exodus.getIntegrity(), this.metal));
            exodus.mine(this);
            return false;
        }
        else {
            System.out.println("Scans indicate this planet can be colonized, would you like to colonize it? (Yes - finish game / No - continue game)");
            while (true) {
                Scanner choice = new Scanner(System.in);
                String will_colonize = choice.nextLine();

                if (will_colonize.equalsIgnoreCase("yes")) {
                    System.out.println("You and your crew successfully colonize the planet and live happily ever after.");
                    return true;
                }
                else if (will_colonize.equalsIgnoreCase("no")) {
                    System.out.format("\nFuel gained: %d, Integrity gained: %d\n", Math.min(100 - exodus.getFuel(), this.fuel), Math.min(100 - exodus.getIntegrity(), this.metal));
                    exodus.mine(this);
                    return false;
                }
                else {
                    System.out.println("Please type in either a yes or a no.");
                }
            }
        }
    }

    public int getFuelAmount (){
        return this.fuel;
    }

    public int getMetalAmount (){
        return this.metal;
    }
}
