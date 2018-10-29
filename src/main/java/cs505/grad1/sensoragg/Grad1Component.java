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

	public Map<Integer, SensorData> getAllSensorData() {
		return factory.makeAggregatedData(sensors);
	}

	//WELL-BEHAVED METHODS
	@Override
	public String toString(){
		String s = "Graduate 1 Component: ";
		if (sensors.isEmpty()){
			s += "Uninitialized";
		}
		else
		{
			s += "Sensors at ports ";
			for (Integer key : sensors.keySet())
			{
				s += key.toString() + " ";
			}
		}
		return s;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		if (!sensors.isEmpty())
		{
			for (Integer key : sensors.keySet())
			{
				hash += key;
			}
		}
		return hash;
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == null || !(other instanceof Grad1Component)) return false;
		if (other == this) return true;

		Grad1Component gOther = (Grad1Component)other;
		if ((!gOther.toString().equals(toString())))
		{
			return false;
		}
		return true;
	}

}
