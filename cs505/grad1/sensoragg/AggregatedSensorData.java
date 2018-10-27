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
	* @param portsAndSensors a {@link java.util.Map} of the active ports (Integer) and their corresponding SensorTypes ( i.e. Light, Temperature)
	* @return a {@link java.util.Map} of every active port's description (e.g. "Light", "Temperature") and corresponding readout value.
	*/
    public Map<String, Double> getAllSensorData(); //returns a map of all sensors and values
    public double getSensorData(SensorType type); // returns value of first sensor of requested type
    public double getSensorData(int port, SensorType type); // returns value of sensor of requested type at port
}
