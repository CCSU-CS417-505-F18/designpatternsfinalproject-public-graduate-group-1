package cs505.grad1.sensoragg;

import java.util.Map;

/**
 * AggregatedSensorData is an interface for collecting and mapping sensor data
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public interface AggregatedSensorData {

    /**
     * getAllSensorData is a method to fetch the current values at each sensor
     *
     * @return a {@link java.util.Map} of every active port's description (e.g.
     * "Light", "Temperature") and corresponding readout value.
     */
    public Map<String, Double> getAllSensorData();

    /**
     * getSensorData is a method to fetch the current value at a sensor of the specified type
     *
     * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of sensor you want the information from
     * @return a double with the value of the first sensor of the requested type
     */
    public double getSensorData(SensorType type);

    /**
     * getSensorData is a method to fetch the current values at the specified sensor
     *
     * @param port is an int for the port the requested sensor is at
     * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of sensor at the specified port
     * @return a double with the value of the sensor at the specified port
     */
    public double getSensorData(int port, SensorType type);
}
