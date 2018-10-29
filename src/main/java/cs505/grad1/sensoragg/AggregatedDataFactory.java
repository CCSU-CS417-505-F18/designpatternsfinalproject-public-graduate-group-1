package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;
  private SensorStrategy sensorStrategy;

  AggregatedDataFactory(GrovePi grovePi) {
    this.grovePi = grovePi;
  }

  @Override
  public SensorAggHashMap makeAggregatedData(Map<Integer, SensorType> sensors) {
      SensorAggHashMap sagHash = new SensorAggHashMap();
      sensors.forEach((k, v) -> {
        SensorData sd = new SensorData();
        sd.type = v;
        sd.port = k;
        // explicit strategy pattern here
        if (v == SensorType.LIGHT_SENSOR) {
          sensorStrategy = new LightSensorStrategy();
          try {
            sd.value = sensorStrategy.GetSensorData(grovePi, k);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        //alternate approach using reflection in a strategy-like way
        //try {
        //  sd.value = (Number) this.getClass().getDeclaredMethod(v.getInputMethod(), int.class).invoke(this, k);
        //} catch (Exception e) {}
        sagHash.put(k, sd);
      });
      return sagHash;
  }

  //reflection implementation method
  protected Number digital(int port) {
    try {
      return grovePi.getDigitalIn(port).get() ? 1 : 0;
    } catch (Exception e) {return -999;}
  }
  //Well behaved methods
  @Override
  public String toString(){
	  return "AggregatedDataFactory";
  }
  @Override
  public int hashCode(){
	  int hash = 0;
	  has += grovePi;
	  return hash;
  }
  @Override
  public boolean equals(Object other){
	if (other == null || !(other instanceof AggregatedDataFactory)) return false;
	if (other == this) return true;
	if (other.grovePi == this.grovePi && other.hashCode() == this.hashCode()) return true;
	else
		return false;
}
