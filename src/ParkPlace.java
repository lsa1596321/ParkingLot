import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

public class ParkPlace {
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    private Integer maxParkingNum;
    private Integer parkPlaceIndex;

    public Integer GetAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }

    public ParkPlace(int maxParkingNum, int parkPlaceIndex ) {
        this.maxParkingNum = maxParkingNum;
        this.parkPlaceIndex = parkPlaceIndex;
    }

    public Ticket parking(Car c) throws NoPlaceException {
        if (GetAvailableNum() == 0) {
            throw new NoPlaceException("没有停车位了！");
        }
        Ticket ticket = new Ticket();
        ticket.parkPlaceIndex = parkPlaceIndex;
        parkedCarList.put(ticket, c);
        return ticket;
    }

    public Car GetParkedCar(Ticket pp) {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        //return null;

        throw new NoCarException("没有此车 请拨打110！");

    }

    public Integer GetMaxParkingNum ()
    {
        return maxParkingNum;
    }

    public Integer GetParkedNum ()
    {
        return parkedCarList.size();
    }

    public void ShowParkPlaceInfo(Boolean boFromBoyList)
    {
        if (!boFromBoyList)
        {
            System.out.println("停车场编号:" + parkPlaceIndex);
            System.out.print("    ");
            System.out.println("车位数:" + parkedCarList.size());
            System.out.print("    ");
            System.out.println("空位数:" + GetAvailableNum());
        }
        else
        {
            System.out.println("    停车场编号:" + parkPlaceIndex);
            System.out.print("        ");
            System.out.println("车位数:" + parkedCarList.size());
            System.out.print("        ");
            System.out.println("空位数:" + GetAvailableNum());
        }
    }
}
