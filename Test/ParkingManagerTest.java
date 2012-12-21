import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest{
    @Test
    public void parkingManager_ShouldParkCar(){
        Car car1=new Car();
        Car car2=new Car();
        int maxParkingNum1 = 20;
        int maxParkingNum2 = 20;
        int maxParkingNum3 = 20;
        int maxParkingNum4 = 20;

        ParkPlace parPlace1 = new ParkPlace(maxParkingNum1, 1);
        ParkPlace parPlace2 = new ParkPlace(maxParkingNum2, 2);
        ParkPlace parPlace3 = new ParkPlace(maxParkingNum3, 3);
        ParkPlace parPlace4 = new ParkPlace(maxParkingNum4, 4);

        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace1);
        parkPlaces.add(parPlace2);
        parkPlaces.add(parPlace3);
        parkPlaces.add(parPlace4);

        ArrayList<ParkingBoy> parkingBoys =new ArrayList<ParkingBoy>();

        ParkingManager parkingManager =new ParkingManager(parkPlaces,parkingBoys, new RandomParker());
        Ticket ticket1 = parkingManager.parking(car1);
        Ticket ticket2 = parkingManager.parking(car2);

        Assert.assertNotSame(ticket1.parkPlaceIndex, ticket2.parkPlaceIndex);
        Assert.assertSame(car1, parkingManager.GetParkedCar(ticket1));
        Assert.assertSame(car2, parkingManager.GetParkedCar(ticket2));
    }

    @Test
    public void parkingManager_ShouldManageParkBoy(){
        Car car1=new Car();

        int maxParkingNum1 = 20;
        int maxParkingNum2 = 20;
        int maxParkingNum3 = 20;
        int maxParkingNum4 = 20;

        ParkPlace parPlace1 = new ParkPlace(maxParkingNum1, 1);
        ParkPlace parPlace2 = new ParkPlace(maxParkingNum2, 2);
        ParkPlace parPlace3 = new ParkPlace(maxParkingNum3, 3);
        ParkPlace parPlace4 = new ParkPlace(maxParkingNum4, 4);

        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace1);
        parkPlaces.add(parPlace2);
        parkPlaces.add(parPlace3);
        parkPlaces.add(parPlace4);


        ParkingBoy parkingBoy =new ParkingBoy(parkPlaces, new FirstAvailableParker());
        ParkingBoy smartParkingBoy =new ParkingBoy(parkPlaces, new MaxAvailableParker());
        ParkingBoy superParkingBoy =new ParkingBoy(parkPlaces, new MaxRateParker());

        ArrayList<ParkingBoy> parkingBoys =new ArrayList<ParkingBoy>();
        parkingBoys.add(parkingBoy);
        parkingBoys.add(smartParkingBoy);
        parkingBoys.add(superParkingBoy);

        ParkingManager parkingManager =new ParkingManager(parkPlaces,parkingBoys, new RandomParker());

        Ticket ticket1 = parkingManager.GetParkingBoy(1).parking(car1);
        Assert.assertSame(car1, parkingManager.GetParkedCar(ticket1));

    }
}
