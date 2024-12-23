import java.util.ArrayList;

public class SolarSystem {
    private ArrayList<Object> objects = new ArrayList<>();
    private int size, distance;

    public SolarSystem(){
        this.size = (int)(Math.random()*10) + 1;
        this.distance = (int)(Math.random()*50) + 1;

        for (int i = 0; i < size; i++){
            int typeControl = (int)(Math.random()*10);
            this.objects.add(new Planet());
            if (typeControl < 8) {
                this.objects.add(new Planet());
            }
            else {
                this.objects.add(new Anomaly());
            }
        }
    }

    public String printSystem(){
        return "Number of Objects: " + this.size + ", Fuel Cost: " + this.distance;
    }

    public void printObjects(){
        for (int i = 0; i < this.size; i++){
            System.out.println("Object " + (i+1) + ": " + this.objects.get(i).print());
        }
    }

    public int getSize(){
        return this.size;
    }

    public int getDistance(){
        return this.distance;
    }

    public Object getObject(int i){
        return objects.get(i);
    }
}
