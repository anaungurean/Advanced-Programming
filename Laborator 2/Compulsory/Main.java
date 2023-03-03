import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Location myObj1 = new Location("Vienna",LocationType.CITIES ,101,892);
        Location myObj2 =  new Location("Prague",LocationType.CITIES ,131,812);
        Road myObj3 = new Road(RoadTypes.COUNTRY, 900, 90);
        Road myObj4 = new Road(RoadTypes.EXPRESS, 300, 120);
        System.out.println(myObj1);
        System.out.println(myObj2);
        System.out.println(myObj3);
        System.out.println(myObj4);



    }
}