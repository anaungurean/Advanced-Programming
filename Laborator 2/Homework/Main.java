import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Cities("Iasi",47,25,507100));
        locations.add(new Cities("Radauti",47,51,23822));
        locations.add(new Cities("Iasi",47,25,507100));
        locations.add(new AirPorts("SuceavaAirport",47,26,1));
        locations.add(new AirPorts("IasiAirport",47,27,3));
        locations.add(new AirPorts("SuceavaAirport",47,26,1));
        locations.add(new GasStations("OMVIasi",47,25,7.5));
        locations.add(new GasStations("OMVRadauti",47,49,7.5));
        locations.add(new Cities("Bucuresti",44,26,1883425));
        locations.add(new AirPorts("BucrestiAirport",44,23,3));
        locations.add(new GasStations("OMVSuceava",-47,49,7.5));


        ArrayList<Road> roads = new ArrayList<>();
        roads.add(new Road(RoadTypes.HIGHWAYS,182,130,locations.get(0),locations.get(1)));
        roads.add(new Road(RoadTypes.EXPRESS,45,100,locations.get(1),locations.get(3)));
        roads.add(new Road(RoadTypes.EXPRESS,20,100,locations.get(0),locations.get(4)));
        roads.add(new Road(RoadTypes.COUNTRY,10,90,locations.get(1),locations.get(7)));
        roads.add(new Road(RoadTypes.COUNTRY,20,90,locations.get(0),locations.get(6)));
        roads.add(new Road(RoadTypes.EXPRESS,25,100,locations.get(8),locations.get(9)));
        // roads.add(new Road(RoadTypes.COUNTRY,20,90,locations.get(6),locations.get(7)));


        Problem myObj1 = new Problem(locations,roads);
        myObj1.checkValidation();
        myObj1.checkExistenceRoad(locations.get(1),locations.get(9) );


    }
}