import java.util.Objects;

public class Road {

    private RoadTypes type;
    private int length;
    private int speedLimit;
    private Location startLocation;
    private Location finalLocation;


    public Road(RoadTypes type, int length, int speedLimit, Location startLocation, Location finalLocation) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.startLocation = startLocation;
        this.finalLocation = finalLocation;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getFinalLocation() {
        return finalLocation;
    }

    public void setFinalLocation(Location finalLocation) {
        this.finalLocation = finalLocation;
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
                ", startLocation=" + startLocation +
                ", finalLocation=" + finalLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return getLength() == road.getLength() && getSpeedLimit() == road.getSpeedLimit() && getType() == road.getType() && getStartLocation().equals(road.getStartLocation()) && getFinalLocation().equals(road.getFinalLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLength(), getSpeedLimit(), getStartLocation(), getFinalLocation());
    }
}