package cs505.grad1.sensoragg;

class SensorData {

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
