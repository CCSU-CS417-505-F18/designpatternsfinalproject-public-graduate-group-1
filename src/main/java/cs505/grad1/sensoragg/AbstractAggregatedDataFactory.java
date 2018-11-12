package cs505.grad1.sensoragg;

import java.util.Map;

/**
 * AbstractAggregatedDataFactory is an interface for factories that will be used
 * by SensorAggHashMap. The concrete factory
 * will implement GrovePi APIs to access appropriate sensors
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public interface AbstractAggregatedDataFactory {

	/**
	 * MakeAggregatedData is a method to generate the sensor data based on a map
	 * of ports and sensor types
	 *
	 * @param sensors is a Map of every active port (int) and
	 * the sensor SensorType at that port
	 */
	Map<Integer, SensorData> makeAggregatedData(Map<Integer, SensorType> sensors);

}
