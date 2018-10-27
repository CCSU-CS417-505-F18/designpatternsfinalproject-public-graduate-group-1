package cs505.grad1.sensoragg;

import java.util.Map;

//Array implementation of aggregated data interface
class AggregatedSensorDataArray implements AggregatedSensorData {

	SensorData[] data;

	@Override
	public Map<String, Double> getAllSensorData() {
		//TODO Generate map from data array
		return null;
	}

	@Override
	public double getSensorData(SensorType type) {
		for (SensorData s : data) {
			if (s.type == type) {
				return s.value;
			}
		}
		return -999; //TODO should throw exception if no sensor of type
	}

	@Override
	public double getSensorData(int port, SensorType type) {
		for (SensorData s : data) {
			if (s.type == type && s.port == port) {
				return s.value;
			}
		}
		return -999; //TODO should throw exception if no sensor of type
	}

}
