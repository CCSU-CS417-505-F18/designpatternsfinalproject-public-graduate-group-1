package cs505.grad1.sensoragg;

public class AggregatedDataFactory implements AbstractAggregatedDataFactory {

  private GrovePi grovePi;

  AggregatedDataFactory(GrovePi grovePi) {
    this.grovePi = grovePi;
  }

  @Override
  public AggregatedSensorData makeAggregatedData(Map<Integer, SensorType> sensors) {
    // ping all viable sensors and populate AggregaterdSensorData object
  }

}
