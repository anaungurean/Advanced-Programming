import java.util.Objects;

abstract class Location {
    protected String name;
    protected int x;
    protected int y;
    public Location() {
    }

    public Location(String modelName, int a, int b)
    {
        name=modelName;
        x=a;
        y=b;
    }
    public void setName(String name) {
        this.name = name;
    }



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return getX() == location.getX() && getY() == location.getY() && getName().equals(location.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY());
    }
}