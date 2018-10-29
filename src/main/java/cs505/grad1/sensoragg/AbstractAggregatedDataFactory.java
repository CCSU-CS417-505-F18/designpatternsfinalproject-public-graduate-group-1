package cs505.grad1.sensoragg;

import java.util.Map;

interface AbstractAggregatedDataFactory {

	//generates data based on map of ports and sensor types
	//concrete factory will implement GrovePi APIs to access appropriate sensors
	Map<Integer, SensorData> makeAggregatedData(Map<Integer, SensorType> sensors);

}
