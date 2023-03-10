import java.util.ArrayList;

import static java.lang.Math.sqrt;


public class Problem {
    private ArrayList<Location> locations = new ArrayList<Location>();
    private ArrayList<Road> roads = new ArrayList<Road>();
    private int [][] matrixOfRoads;
    private boolean[] visitedLocation;

    public Problem(ArrayList<Location> locations, ArrayList<Road> roads) {
        for (Location location : locations)
            if (!checkExistenceOfLocation(location))
                addLocation(location);

        for (Road road : roads)
            if (!checkExistenceOfRoad(road))
                addRoad(road);
    }

    private boolean checkExistenceOfLocation(Location location) {
        if (locations.contains(location))
            return true;
        else
            return false;

    }

    private void addRoad(Road road) {
        roads.add(road);
    }

    private boolean checkExistenceOfRoad(Road road) {
        if (roads.contains(road))
            return true;
        else
            return false;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "locations=" + locations +
                ", roads=" + roads +
                '}';
    }

    public void checkValidation()
    {
        int valid=1;

        for(Road road : roads )
            if(!checkAppropriateLength (road))
                valid=0;

        for(Location location : locations)
            if(!checkAppropriateCoordinates(location))
                valid=0;


        if(valid==1)
           System.out.println("The problem's instance is valid");
        else
            System.out.println("The problem's instance is NOT valid");


    }

    private boolean checkAppropriateCoordinates(Location location) {

        if(location.getX() <0 || location.getY()<0)
            return false;
        return true;
    }

    private boolean checkAppropriateLength(Road road)
    {
        if(road.getLength() < calculateEuclideanDistance(road.getStartLocation().getX(), road.getStartLocation().getY(),road.getFinalLocation().getX(), road.getFinalLocation().getY()))
            return false;
        return true;

    }

    private double calculateEuclideanDistance(int x1, int y1, int x2, int y2)
    {
        return sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    public void checkExistenceRoad ( Location startLocation, Location finalLocation)
    {
        createMatrixOfRoads();
        visitedLocation = new boolean[matrixOfRoads.length];
        findRoad(locations.indexOf(startLocation));

        if(visitedLocation[locations.indexOf(finalLocation)])
            System.out.println("It exists a road between the given locations");
        else
            System.out.println("It doesn't exist a road between the given locations");
    }

    private void createMatrixOfRoads() {

        matrixOfRoads = new int[locations.size()][locations.size()];

     for(int i=0;i<locations.size();i++)
         for(int j=0;j<locations.size();j++)
             matrixOfRoads[i][j]=0;

        for(Road road : roads)
        {
            matrixOfRoads[locations.indexOf(road.getStartLocation())][locations.indexOf(road.getFinalLocation())]=1;
            matrixOfRoads[locations.indexOf(road.getFinalLocation())][locations.indexOf(road.getStartLocation())]=1; }


    }

    public void displayMatrixOfRoads(){
        for(int i=0;i<locations.size();i++)
        {
            for(int j=0;j<locations.size();j++)
                System.out.print(matrixOfRoads[i][j]);
            System.out.println();
        }

    }

    public void findRoad(int indexOfStartLocation)
    {
        visitedLocation[indexOfStartLocation]=true;
        for(int i=0;i<matrixOfRoads.length;i++)
           if(matrixOfRoads[indexOfStartLocation][i] == 1 && !visitedLocation[i])
               findRoad(i);

    }


}

