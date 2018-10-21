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
     * 
     * @param Map - The active ports (int) and their corresponding SensorTypes ( i.e. Light, Temperature)
	 * @return Map - The SensorType and their corresponding readout values
     */
	Map<String,Number> getAllSensorData(Map<int, SensorType>);
}
