package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveLightSensor;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

public class LightSensorStrategy implements SensorStrategy {

    @Override
    public double getSensorData(GrovePi grovePi, int port) throws IOException {
        GroveLightSensor sensor;
        try {
            sensor = new GroveLightSensor(grovePi, port);
        } catch (IOException e) {
            throw e;
        }
        return sensor.get();
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
        if (other == null || !(other instanceof AggregatedDataFactory)) return false;
        if (other == this) return true;
        return false;
    }
}
