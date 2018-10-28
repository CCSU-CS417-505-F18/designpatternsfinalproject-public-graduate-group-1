package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import java.util.Map;

public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;

  AggregatedDataFactory(GrovePi grovePi) {
    this.grovePi = grovePi;
  }

  @Override
  public AggregatedSensorData makeAggregatedData(Map<Integer, SensorType> sensors) {
      AggregatedSensorDataArray agg = new AggregatedSensorDataArray();
      sensors.forEach((k, v) -> {
        SensorData sd = new SensorData();
        sd.type = v;
        sd.port = k;
        sd.value = 0.5;
        agg.addSensor(sd);
      });
      return agg;
  }


}
