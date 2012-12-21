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
public class parkPlaceTest {

    @Test
    public void parkPlace_Parking_HavePlace(){

        ParkPlace  PP = new  ParkPlace(20, 1);
        Car C = new Car();
        Ticket proof = PP.parking(C) ;
        Assert.assertNotNull(proof);
    }

    @Test ( expected = NoPlaceException.class)
    public void parkPlace_Parking_NoPlace()   {
        ParkPlace  PP = new  ParkPlace(1, 1);
        PP.parking( new Car()) ;
        Ticket proof = PP.parking( new Car()) ;
        Assert.assertFalse(true);
    }

    @Test
    public void parkPlace_GetCar(){

        ParkPlace  PP = new  ParkPlace(20, 1);
        Car car = new Car();
        Ticket proof =  PP.parking(car) ;

        Assert.assertSame(car, PP.GetParkedCar(proof));

    }
    @Test    ( expected = NoCarException.class)
    public void parkPlace_GetCar_NoThisCar() {

        ParkPlace  PP = new  ParkPlace(20,1);
        Ticket proof =  PP.parking( new Car()) ;
        PP.GetParkedCar(proof);

        PP.GetParkedCar(proof);


    }
    @Test
    public void parkPlace_ShowAvailableNum()  {
        int maxParkingNum = 20;
        ParkPlace  PP = new  ParkPlace(maxParkingNum, 1);
        PP.parking( new Car()) ;
        PP.parking( new Car()) ;
        Assert.assertEquals(Integer.valueOf(maxParkingNum-2),PP.GetAvailableNum());
    }

    @Test
    public void parkBoy_ShouldParkCar(){
        Car car=new Car();
        int maxParkingNum = 20;
        ParkPlace parPlace = new ParkPlace(maxParkingNum, 1);
        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace);
        ParkingBoy parkingBoy =new ParkingBoy(parkPlaces, new FirstAvailableParker());
        Ticket ticket = parkingBoy.parking(car);

        Assert.assertEquals(new Integer(maxParkingNum-1), parPlace.GetAvailableNum());

    }

    @Test
    public void parkBoy_ShouldGetParkedCar(){
        Car car=new Car();
        int maxParkingNum = 20;
        ParkPlace parPlace = new ParkPlace(maxParkingNum, 1);
        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace);
        ParkingBoy parkingBoy =new ParkingBoy(parkPlaces, new FirstAvailableParker());
        Ticket ticket = parkingBoy.parking(car);
        Assert.assertSame(car, parkingBoy.GetParkedCar(ticket));
    }

    @Test
    public void smartParkBoy_ShouldParkCar(){
        Car car1=new Car();
        int maxParkingNum = 20;
        ParkPlace parPlace1 = new ParkPlace(maxParkingNum, 1);
        ParkPlace parPlace2 = new ParkPlace(maxParkingNum, 2);
        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace1);
        parkPlaces.add(parPlace2);

        ParkingBoy parkingBoy =new ParkingBoy(parkPlaces, new FirstAvailableParker());
        Ticket ticket1 = parkingBoy.parking(car1);

        ParkingBoy smartParkingBoy =new ParkingBoy(parkPlaces, new MaxAvailableParker());
        Car car2=new Car();
        Ticket ticket2 = smartParkingBoy.parking(car2);

        Assert.assertEquals(parPlace1.GetAvailableNum(), parPlace2.GetAvailableNum());
    }

    @Test
    public void superParkBoy_ShouldParkCar(){
        Car car1=new Car();
        int maxParkingNum1 = 10;
        int maxParkingNum2 = 20;
        ParkPlace parPlace1 = new ParkPlace(maxParkingNum1, 1);
        ParkPlace parPlace2 = new ParkPlace(maxParkingNum2, 2);
        ArrayList<ParkPlace> parkPlaces =new ArrayList<ParkPlace>();
        parkPlaces.add(parPlace1);
        parkPlaces.add(parPlace2);

        ParkingBoy parkingBoy =new ParkingBoy(parkPlaces, new FirstAvailableParker());
        Ticket ticket1 = parkingBoy.parking(car1);

        ParkingBoy smartParkingBoy =new ParkingBoy(parkPlaces, new MaxAvailableParker());
        Car car2=new Car();
        Ticket ticket2 = smartParkingBoy.parking(car2);

        ParkingBoy superParkingBoy =new ParkingBoy(parkPlaces, new MaxRateParker());
        Car car3=new Car();
        Ticket ticket3 = smartParkingBoy.parking(car3);

        Assert.assertEquals(Integer.valueOf(maxParkingNum2-2), parPlace2.GetAvailableNum());
    }
}
