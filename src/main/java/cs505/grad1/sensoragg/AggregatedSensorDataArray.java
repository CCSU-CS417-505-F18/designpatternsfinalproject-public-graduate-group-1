package cs505.grad1.sensoragg;

import java.util.Map;
import java.util.HashMap;

//Array implementation of aggregated data interface
class AggregatedSensorDataArray implements AggregatedSensorData {

	private int size = 0;
	SensorData[] data = new SensorData[size];

	@Override
	public Map<String, Double> getAllSensorData() {
		Map<String, Double> map = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			map.put(data[i].type.toString() + data[i].port, data[i].value);
		}
		return map;
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

	public void addSensor(SensorData sd) {
		data[size] = sd;
		size++;
	}

}
