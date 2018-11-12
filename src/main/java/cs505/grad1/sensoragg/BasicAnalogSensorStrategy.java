package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveAnalogInputDevice;
import org.iot.raspberry.grovepi.devices.GroveLightSensor;
import org.iot.raspberry.grovepi.devices.GroveSoundSensor;

import java.io.IOException;

/**
 * The BasicAnalogSensorStrategy acts as an adapter between
 * the component and the Grove Pi light and sound sensors.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
class BasicAnalogSensorStrategy implements SensorStrategy {

    /**
     * Abstract class which can contain the light sensor or sound sensor
     * */
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

    /**
     * GetSensorData will return the sensor's current value as a double.
     *
     * @param grovePi is the GrovePi object representing the physical card
     * @param port is the port into which the sensor is plugged
     * @return the current value of the sensor, provided as a double
     */
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
