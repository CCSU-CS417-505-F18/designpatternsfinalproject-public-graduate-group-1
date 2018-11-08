package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveAnalogInputDevice;
import org.iot.raspberry.grovepi.devices.GroveLightSensor;
import org.iot.raspberry.grovepi.devices.GroveRotarySensor;
import org.iot.raspberry.grovepi.devices.GroveSoundSensor;

import java.io.IOException;

public class BasicAnalogSensorStrategy implements SensorStrategy {

    private GroveAnalogInputDevice<Double> sensor;

    BasicAnalogSensorStrategy(GrovePi grovePi, int port, SensorType sensorType) throws IOException
    {
        switch (sensorType) {
            case LIGHT:
                sensor = new GroveLightSensor(grovePi, port);
                break;
            case SOUND:
                sensor = new GroveSoundSensor(grovePi, port);
                break;
            default:
                break;
        }
    }

    @Override
    public double getSensorData(GrovePi grovePi, int port) throws IOException
    {
        try {
            return sensor.get();
        }
        catch (IOException e)
        {
            throw e;
        }
    }
}
