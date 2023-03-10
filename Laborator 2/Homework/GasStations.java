public class GasStations extends Location{

   private double gasPrice;

    public GasStations(String modelName, int a, int b, double gasPrice) {
        super(modelName, a, b);
        this.gasPrice = gasPrice;
    }

    public GasStations(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
}
