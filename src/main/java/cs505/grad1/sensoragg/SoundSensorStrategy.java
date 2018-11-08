package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveSoundSensor;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

public class SoundSensorStrategy implements SensorStrategy {

    @Override
    public double GetSensorData(GrovePi grovePi, int port) throws IOException {
        GroveSoundSensor sensor;
        try {
            sensor = new GroveSoundSensor(grovePi, port);
            return sensor.get();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Sound Sensor Strategy";
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
