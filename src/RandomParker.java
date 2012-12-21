import java.util.List;
import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public class RandomParker implements Parker {
    @Override
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        Boolean bHaveAvailablePark = false;
        for(ParkPlace parkPlace:parkPlaceList){
            if(parkPlace.GetAvailableNum()>0)
            {
                bHaveAvailablePark =true;
            }
        }
        if (true != bHaveAvailablePark)
        {
            return null;
        }
        Random rnd = new Random();
        return parkPlaceList.get(rnd.nextInt(parkPlaceList.size()));
    }
}
