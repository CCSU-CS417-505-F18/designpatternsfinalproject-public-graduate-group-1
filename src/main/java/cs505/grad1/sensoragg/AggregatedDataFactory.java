package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;
import java.util.Map;

/**
 * AggregatedDataFactory is a concrete AbstractAggregatedDataFactory
 * which is responsible for generating the SensorAggHashMap.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;
  private SensorStrategy sensorStrategy;

  AggregatedDataFactory(GrovePi grovePi) {
    this.grovePi = grovePi;
  }

/**
 * makeAggregatedData will return a SensorAggHashMap object based on the sensors provided
 * by the user.  It will display the ports and the values provided by the sensors.
 *
 * @param sensors is the Map oject that stores the user inputted sensor data
 * @return SensorAggHashMap is the Map object of the provided sensors with their values
 */
  public SensorAggHashMap makeAggregatedData(Map<Integer, SensorType> sensors) {
      SensorAggHashMap sagHash = new SensorAggHashMap();
      sensors.forEach((k, v) -> {
        SensorData sd = new SensorData(v, k);
          // choose strategy based on SensorType
          // Strategy is also an object Adapter to GrovePi sensors
          switch (v){
              case LIGHT:
              case SOUND:
                  try {
                      sensorStrategy = new BasicAnalogSensorStrategy(grovePi, k, v);
                  }
                  catch (IOException e)
                  {
                      sensorStrategy = null;
                  }
                  break;
              case ROTARY:
                  sensorStrategy = new RotaryAngleSensorStrategy();
                  break;
              case TEMP:
                  sensorStrategy = new TemperatureSensorStrategy();
                  break;
              case HUMID:
                  sensorStrategy = new HumiditySensorStrategy();
                  break;
              case RANGER:
                  sensorStrategy = new UltrasonicRangerSensorStrategy();
                  break;
              default:
                  sensorStrategy = null;
                  break;
          }
        if (sensorStrategy != null) {
          try {
            sd.setValue(sensorStrategy.getSensorData(grovePi, k));
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        sagHash.put(k, sd);
      });
      return sagHash;
  }

<<<<<<< HEAD
=======
  //reflection implementation method
  protected Number digital(int port) {
    try {
      return grovePi.getDigitalIn(port).get() ? 1 : 0;
    } catch (Exception e) {return -999;}
  }


>>>>>>> 9ce1be2f71a129142f8bf3602c1ef39fcc950755
  //Well behaved methods
  @Override
  public String toString(){
	  return "AggregatedDataFactory";
  }

  @Override
  public int hashCode(){
	  int hash = 0;
	  hash += grovePi.hashCode();
	  return hash;
  }

  @Override
  public boolean equals(Object other) {
      if (other == null || !(other instanceof AggregatedDataFactory)) return false;
      if (other == this) return true;
      if (other.hashCode() == this.hashCode()) return true;
      else
          return false;
  }
}
