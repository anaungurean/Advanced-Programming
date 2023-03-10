public class AirPorts extends Location{

   private int numberOfTerminals;

    public AirPorts(String modelName, int a, int b, int numberOfTerminals) {
        super(modelName, a, b);
        this.numberOfTerminals = numberOfTerminals;
    }

    public AirPorts(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
}
