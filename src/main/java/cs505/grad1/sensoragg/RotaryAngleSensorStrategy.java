package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveRotarySensor;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

public class RotaryAngleSensorStrategy implements SensorStrategy {

    @Override
    public double GetSensorData(GrovePi grovePi, int port) throws IOException {
        GroveRotarySensor sensor;
        try {
            sensor = new GroveRotarySensor(grovePi, port);
            return sensor.get().getDegrees();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Rotary Angle Sensor Strategy";
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
