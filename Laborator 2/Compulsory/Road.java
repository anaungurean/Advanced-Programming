public class Road {

    private RoadTypes type;
    private int length;
    private int speedLimit;



    public  Road(RoadTypes modelType, int modelLength, int modelSpeedLimit)
    {
        type=modelType;
        length=modelLength;
        speedLimit= modelSpeedLimit;
    }

    public void setType(RoadTypes type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public RoadTypes getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
