package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveLightSensor;

import java.io.IOException;

public class LightSensorStrategy implements SensorStrategy {

    @Override
    public double GetSensorData(GrovePi grovePi, int port) throws IOException {
        GroveLightSensor sensor;
        try {
            sensor = new GroveLightSensor(grovePi, port);
        } catch (IOException e) {
            throw e;
        }
        return sensor.get();
    }
}
