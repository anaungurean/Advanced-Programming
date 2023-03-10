public class Cities extends  Location{
   private int population;

    public Cities(int population) {
        this.population = population;
    }

    public Cities(String modelName, int a, int b, int population) {
        super(modelName, a, b);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
