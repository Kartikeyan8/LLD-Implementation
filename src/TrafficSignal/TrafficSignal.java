package TrafficSignal;

import java.util.HashMap;
import java.util.Map;

public class TrafficSignal {
    SignalState currentSignalState;
    Map<SignalState, Integer> signalDurations;
    public TrafficSignal(int redDuration,int yellowDuration,int greenDuration)
    {
        signalDurations = new HashMap<>();
        signalDurations.put(SignalState.GREEN,10);
        signalDurations.put(SignalState.YELLOW,5);
        signalDurations.put(SignalState.RED,15);
        this.currentSignalState = SignalState.RED;
    }
    public boolean changeSignalState(SignalState newState)
    {
       this.currentSignalState = newState;
        System.out.println("Signal changed to: " + newState);
       return true;
    }
    public boolean changeDurationOfSignal(SignalState state,int newDuration)
    {
        signalDurations.put(state,newDuration);
        System.out.println("Duration of " + state + " changed to: " + newDuration + " seconds");
        return true;
    }
    public boolean changeState(SignalState newState) {
        if (signalDurations.containsKey(newState)) {
            currentSignalState = newState;
            System.out.println("Signal changed to: " + newState);
            return true;
        } else {
            System.out.println("Invalid signal state: " + newState);
            return false;
        }
    }



}
