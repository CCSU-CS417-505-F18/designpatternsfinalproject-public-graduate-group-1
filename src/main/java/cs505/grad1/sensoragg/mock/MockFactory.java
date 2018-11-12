package cs505.grad1.sensoragg;

import java.util.Map;
import java.io.IOException;


public class MockFactory implements AbstractAggregatedDataFactory {

  private MockSensorStrategy sensorStrategy;
  private MockGrovePi grovePi;

  MockFactory(MockGrovePi grovePi) {
    this.grovePi = grovePi;
  }

  public SensorAggHashMap makeAggregatedData(Map<Integer, SensorType> sensors) {
      SensorAggHashMap sagHash = new SensorAggHashMap();
      sensors.forEach((k, v) -> {
        SensorData sd = new SensorData(v, k);
          // choose strategy based on SensorType
          // Strategy is also an object Adapter to GrovePi sensors
            sensorStrategy = new MockConcreteSensorStrategy();
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

}
