package com.grad1fp.component;

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
	* @param portsAndSensors - a {@link java.util.Map} of the active ports (int) and their corresponding SensorTypes ( i.e. Light, Temperature)
	* @return a {@link java.util.Map} of every active port's description (e.g. "Light", "Temperature") and corresponding readout value.
	*/
  Map<String, Number> getAllSensorData(Map<int, SensorType> portsAndSensors);
}
