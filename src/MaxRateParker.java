import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public class MaxRateParker implements Parker {
    @Override
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        int maxVacancyRateParkIndex=0;
        int maxVacancyRate=0;
        int VacancyRate=0;
        for (int i=0; i< parkPlaceList.size(); i++){
            VacancyRate = parkPlaceList.get(i).GetAvailableNum()/parkPlaceList.get(i).GetMaxParkingNum();
            if ((VacancyRate >  maxVacancyRate)) {
                maxVacancyRateParkIndex = i;
                maxVacancyRate = VacancyRate;
            }
        }

        return parkPlaceList.get(maxVacancyRateParkIndex);
    }
}
