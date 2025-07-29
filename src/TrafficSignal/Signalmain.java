package TrafficSignal;

import java.util.ArrayList;
import java.util.List;

public class Signalmain {

    public void run() throws InterruptedException {

        Controller controller = new Controller();
        controller.start();
    }


}
