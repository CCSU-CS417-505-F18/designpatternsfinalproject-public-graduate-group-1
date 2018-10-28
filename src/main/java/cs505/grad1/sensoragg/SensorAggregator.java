package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;
import org.iot.raspberry.grovepi.GrovePi;

//public class used to create data object/start the factory process
public class SensorAggregator {

	private Map<Integer, SensorType> sensors = new HashMap<Integer, SensorType>();
	private AbstractAggregatedDataFactory factory;

	SensorAggregator(GrovePi grovePi) {
		factory = new AggregatedDataFactory(grovePi);
	}

	//allows users to collect sensors in one place, can then use getAllSensorData()
	//to make repeated calls without sending ports/sensors each time
	public void addSensor(int port, SensorType type) {
		sensors.put(port, type);
	}

	public AggregatedSensorData getAllSensorData() {
		return factory.makeAggregatedData(sensors);
	}

}
