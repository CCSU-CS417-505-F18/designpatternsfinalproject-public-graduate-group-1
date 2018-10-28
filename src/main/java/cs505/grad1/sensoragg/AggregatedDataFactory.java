package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import java.util.Map;
import java.util.HashMap;

public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;

  AggregatedDataFactory(GrovePi grovePi) {
    this.grovePi = grovePi;
  }

  @Override
  public Map<String, SensorData> makeAggregatedData(Map<Integer, SensorType> sensors) {
      Map<String, SensorData> map = new SensorAggHashMap();
      sensors.forEach((k, v) -> {
        SensorData sd = new SensorData();
        sd.type = v;
        sd.port = k;
        sd.value = 0.5;
        map.put(v.name(), sd);
      });
      return map;
  }


}
