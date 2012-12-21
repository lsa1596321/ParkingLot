import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    protected ArrayList<ParkPlace> parkPlaces;
    private final Parker parkingLotChooser;
    private int iTotalAvailableNum;
    private int iTotalParkedNum;
    public ParkingBoy(ArrayList<ParkPlace> parkPlaces, Parker parkingLotChooser) {
        //To change body of created methods use File | Settings | File Templates.
        this.parkPlaces =  parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }

    public Ticket parking(Car car) {
        return parkingLotChooser.getAvailablePark(parkPlaces).parking(car);
    }

    public Car GetParkedCar(Ticket ticket)throws NoCarException {
        Car car;
        for (int i=0; i< parkPlaces.size(); i++){
            car = parkPlaces.get(i).GetParkedCar(ticket);
            if(null != car)
            {
                return car;
            }
            continue;
        }
        throw new NoCarException("没有此车 请拨打110！");
    }

    public void ShowParkingLotInfoFromParkingBoy()
    {

        for (int i=0; i< parkPlaces.size(); i++)
        {
            parkPlaces.get(i).ShowParkPlaceInfo(true);
            iTotalParkedNum +=  parkPlaces.get(i).GetParkedNum();
            iTotalAvailableNum += parkPlaces.get(i).GetAvailableNum();
        }
        System.out.println("Total车位数:"+iTotalParkedNum);
        System.out.println("Total空位数:"+iTotalAvailableNum);
    }
    public Integer GetParkedNum()
    {
        return iTotalParkedNum;
    }

    public Integer GetAvailableNum()
    {
        return iTotalAvailableNum;
    }
}
