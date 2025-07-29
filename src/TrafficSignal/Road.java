package TrafficSignal;

public class Road {
    String name;
    int roadId;
    Sensor sensor;
    TrafficSignal signal;
    public Road(String name,int roadId, TrafficSignal signal)
    {
        this.name = name;
        this.roadId = roadId;
        this.signal = signal;
        this.sensor = new Sensor();
    }
    public Sensor getSensor() {
        return sensor;
    }
    public TrafficSignal getCurrentSignalState() {
        return signal;
    }
}
