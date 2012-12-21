import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Weng Li Dan
 * Date: 12-12-20
 * Time: 下午2:15
 * To change this template use File | Settings | File Templates.
 */
public interface Parker {
    ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList);
}
