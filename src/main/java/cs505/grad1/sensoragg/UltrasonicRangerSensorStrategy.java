package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

/**
 * The UltrasonicRangerSensorStrategy acts as an adapter between
 * the component and the Grove Pi ultrasonic ranger sensor.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
class UltrasonicRangerSensorStrategy implements SensorStrategy {

    /**
     * GetSensorData will return the sensor's current value as a double.
     *
     * @param grovePi is the GrovePi object representing the physical card
     * @param port is the port into which the sensor is plugged
     * @return the current value of the sensor, provided as a double
     */
    @Override
    public double getSensorData(GrovePi grovePi, int port) throws IOException {
        GroveUltrasonicRanger sensor;
        try {
            sensor = new GroveUltrasonicRanger(grovePi, port - Grad1Component.digitalOffset);
            return sensor.get();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Ultrasonic Ranger Sensor Strategy";
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
