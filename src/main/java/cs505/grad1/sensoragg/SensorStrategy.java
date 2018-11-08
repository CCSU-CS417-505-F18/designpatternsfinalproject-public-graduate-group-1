package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

/**
 * The SensorStrategy interface provides a universal method,
 * GetSensorData to access values from a sensor. It serves as both
 * a strategy for the Aggregated Data Factory, and its subclasses
 * are adaptors to the third-party Grove Pi sensor classes.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
interface SensorStrategy {

    /**
     * GetSensorData will return the sensor's current value as a double.
     *
     * @param grovePi is the GrovePi object representing the physical card
     * @param port is the port into which the sensor is plugged
     * @return SensorAggHashMap is the Map object of the provided sensors with their values
     */
    double GetSensorData(GrovePi grovePi, int port) throws IOException;

}
