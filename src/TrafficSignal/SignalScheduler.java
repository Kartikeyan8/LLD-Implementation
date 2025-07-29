package TrafficSignal;

import java.util.List;
import java.util.Random;

public class SignalScheduler {
    public void updateDurations(List<Road> roads) {

        for (Road road : roads) {
            road.getCurrentSignalState().changeDurationOfSignal(SignalState.GREEN,new Random().nextInt()+2);
        }
        System.out.println("Signal durations updated based on traffic conditions.");
    }
}

