package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import java.io.IOException;

interface SensorStrategy {

    double getSensorData(GrovePi grovePi, int port) throws IOException;

}
