package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;
import org.iot.raspberry.grovepi.GrovePi;

//public class used to create data object/start the factory process
public class Grad1Component {

	private Map<Integer, SensorType> sensors = new HashMap<Integer, SensorType>();
	private AbstractAggregatedDataFactory factory;

	Grad1Component(GrovePi grovePi) {
		factory = new AggregatedDataFactory(grovePi);
	}

	//allows users to collect sensors in one place, can then use getAllSensorData()
	//to make repeated calls without sending ports/sensors each time
	public Grad1Component addSensor(int port, SensorType type) {
		sensors.put(port, type);
		return this;
	}

	public Map<String, SensorData> getAllSensorData() {
		return factory.makeAggregatedData(sensors);
	}

}
