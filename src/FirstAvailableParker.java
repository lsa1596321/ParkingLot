import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public class FirstAvailableParker implements Parker{
    @Override
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        for(ParkPlace parkPlace:parkPlaceList){
            if(parkPlace.GetAvailableNum()>0) return parkPlace;
        }
       return null;
    }
}
