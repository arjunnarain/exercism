import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>(cars);

        rankedCars.sort(
                Comparator.comparingInt(ProductionRemoteControlCar::getNumberOfVictories)
                          .reversed()
        );

        return rankedCars;
    }
}
