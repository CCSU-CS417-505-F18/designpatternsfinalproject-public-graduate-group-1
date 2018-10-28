package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import java.util.HashMap;
import java.util.Map;

public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;

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
        sd.value = 0.5;
        sagHash.put(v.name(), sd);
      });
      return sagHash;
  }


}
