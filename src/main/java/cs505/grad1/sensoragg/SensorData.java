package cs505.grad1.sensoragg;

/**
 * SensorData is an object that collects the pertinent
 * data from one port on the GrovePi. It is created by the
 * Grad1Component and can then be accessed by outside systems.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class SensorData {

	public SensorType type;
	public int port;
	public Number value;

	//WELL-BEHAVED METHODS
	@Override
	public String toString(){
		String s = "Sensor at port " + port + ": " + value;
		return s;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += port;
		hash += (int)value * 100;
		return hash;
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == null || !(other instanceof SensorData)) return false;
		if (other == this) return true;

		SensorData gOther = (SensorData)other;
		if (gOther.type != type || gOther.port != port || gOther.value != value) return false;
		return true;
	}
}
