package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveLightSensor;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

/**
 * makeAggregatedData will return a Map object based on the sensors provided
 * by the user.  It will display the ports and the values provided by the sensors.
 *
 * @param sensors is the Map oject that stores the user inputted sensor data
 * @return SensorAggHashMap is the Map object of the provided sensors with their values
 */
public class LightSensorStrategy implements SensorStrategy {

    @Override
    public double GetSensorData(GrovePi grovePi, int port) throws IOException {
        GroveLightSensor sensor;
        try {
            sensor = new GroveLightSensor(grovePi, port);
            return sensor.get();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Light Sensor Strategy" ;
    }
    @Override
    public int hashCode(){
        return 1;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof SensorStrategy)) return false;
        if (other == this) return true;
        return false;
    }
}
