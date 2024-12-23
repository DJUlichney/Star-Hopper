public class Ship {
    private int integrity, fuel;

    public Ship(){
        //TODO: If you have extra time, a ship upgrade system may be a good addition.
        this.integrity = 100;
        this.fuel = 100;
    }

    public int getIntegrity(){
        return this.integrity;
    }

    public int getFuel(){
        return this.fuel;
    }

    public void jump(int cost){
        this.fuel = this.fuel - cost;
    }

    public void mine(Planet planet){
        //TODO: It might be a good idea to have the ship take damage based on the conditions of a planet.
        this.integrity = Math.min((this.integrity + planet.getMetalAmount()), 100);
        this.fuel = Math.min((this.fuel + planet.getFuelAmount()), 100);
    }

    public void gain(int metalGain, int fuelGain){
        this.integrity = Math.min((this.integrity + metalGain), 100);
        this.fuel = Math.min((this.fuel + fuelGain), 100);
    }

    public void damage(int damage){
        this.integrity = Math.max(0, this.integrity - damage);
    }
}
