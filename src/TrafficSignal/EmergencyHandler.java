package TrafficSignal;

import java.util.List;

public class EmergencyHandler {
    public boolean detectEmergency(Road road)
    {
        return road.getSensor().detectEmergencies();
    }
    public void handleEmergency(List<Road> roads , Road road)
    {
       for(Road r : roads)
       {
           if(r == road)
               continue;
            r.getCurrentSignalState().changeSignalState(SignalState.RED);
       }
         road.getCurrentSignalState().changeSignalState(SignalState.GREEN);
        System.out.println("Emergency handled! All other roads set to RED, " +
                "and " + road.name + " set to GREEN.");
    }

}
