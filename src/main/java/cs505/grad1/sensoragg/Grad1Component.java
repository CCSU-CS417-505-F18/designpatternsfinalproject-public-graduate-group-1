package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;
import org.iot.raspberry.grovepi.GrovePi;
import cs505.grad1.sensoragg.mock.*;

/**
 * Grad1Component is a public class used to create a list of sensors and start
 * the factory process.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class Grad1Component {

	private Map<Integer, SensorType> sensors = new HashMap();
	private AbstractAggregatedDataFactory factory;

	/**
	 * Port offset to avoid HashMap collisions between analog and digital ports
	 */
	static final int digitalOffset = 32;

	/**
	 * Port offset to avoid HashMap collisions between a sensors which share a port
	 */
	static final int secondarySensorOffset = 16;

	public Grad1Component(MockGrovePi mock) {
			this.factory = new MockFactory(mock);
	};

	public Grad1Component(GrovePi grovepi) {
			this.factory = new AggregatedDataFactory(grovepi);
	}

	public Grad1Component(Builder builder) {
			this.sensors = builder.sensors;
			if (builder.grovePi != null)
				this.factory = new AggregatedDataFactory(builder.grovePi);
			else
				this.factory = new MockFactory(builder.mock);
	}

	/**
	 * Inner class for BUILDER PATTERN. Rather than instantiating a {@link Grad1Component} object using a
	 * constructor and then adding on the various
	 * sensors using the user can "build" the
	 * Grad1Component with the help of this inner class. For example:
	 * Grad1Component grad1 = new Grad1Component.Builder().sensor(1, SensorType.LIGHT).sensor(2, SensorType.RANGER).grovePi(new GrovePi4J).build();
	 */
	public static class Builder {
			private Map<Integer, SensorType> sensors = new HashMap();
			private GrovePi grovePi;
			private MockGrovePi mock;

			public Builder sensor(int port, SensorType type) {
				// Duplicate code here from outer class's addSensor method.
				// Necessary because using the builder is optional. No way to refactor.
				if (type == SensorType.HUMID || type == SensorType.TEMP || type == SensorType.RANGER)
					port += digitalOffset;
				if (type == SensorType.HUMID)
					port += secondarySensorOffset;
				this.sensors.put(port, type);
				return this;
			}

			public Builder grovePi(GrovePi grovePi) {
				if (this.mock != null) // can't use a mock and a real grovePi at same time
					throw new IllegalStateException();
				this.grovePi = grovePi;
				return this;
			}

			public Builder mock(MockGrovePi mock) {
				if (this.grovePi != null) // can't use a mock and a real grovePi at same time
					throw new IllegalStateException();
				this.mock = mock;
				return this;
			}

			public Grad1Component build() {
				return new Grad1Component(this);
			}
	}

	/**
	 * addSensor adds a sensor to the list. This allows users to collect sensors
	 * in one place. Can then use getAllSensorData() to make repeated calls
	 * without sending ports/sensors each time
	 *
	 * @param port is an int for the port the sensor is at
	 * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of
	 * sensor at the specified port
	 * @return {@link Grad1Component}
	 */
	public Grad1Component addSensor(int port, SensorType type) {
		//apply offset for digital sensors
		if (type == SensorType.HUMID || type == SensorType.TEMP || type == SensorType.RANGER)
		{
			port += digitalOffset;
		}
		//apply offset for secondary value of common port
		if (type == SensorType.HUMID)
		{
			port += secondarySensorOffset;
		}
		sensors.put(port, type);
		return this;
	}

	/**
	 * getAllSensorData returns a map of all active ports with their current
	 * sensor data.
	 *
	 * @return Map<Integer, SensorData> is a map of ports and SensorData that
	 * can be accessed
	 */
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
