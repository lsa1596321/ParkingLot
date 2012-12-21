import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailableParker implements Parker {
    @Override
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        int maxAvailableNum=0;
        int maxAvailableParkIndex=0;
        for (int i=0; i< parkPlaceList.size(); i++){
            if (parkPlaceList.get(i).GetAvailableNum() >  maxAvailableNum) {
                maxAvailableParkIndex = i;
                maxAvailableNum = parkPlaceList.get(i).GetAvailableNum();
            }
        }

        return parkPlaceList.get(maxAvailableParkIndex);
    }
}
