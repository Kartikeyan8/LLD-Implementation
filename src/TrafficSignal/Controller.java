package TrafficSignal;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Road> roads;
    SignalScheduler signalScheduler;
    EmergencyHandler emergencyHandler;
    public Controller()
    {
        this.roads = new ArrayList<>();
        this.signalScheduler = new SignalScheduler();
        this.emergencyHandler = new EmergencyHandler();
    }

    public void start()
    {
        Road road1 = new Road("Main road1 ",1 , new TrafficSignal(3,2,2));
        Road road2 = new Road("Main road2 ",2 , new TrafficSignal(3,2,2));
        roads.add(road1);
        roads.add(road2);

        while(true)
        {
            for(Road road : roads)
            {
                if(emergencyHandler.detectEmergency(road))
                {
                    emergencyHandler.handleEmergency(roads, road);
                }
                else
                {
                    signalScheduler.updateDurations(roads);
                }
            }
        }
    }
}
