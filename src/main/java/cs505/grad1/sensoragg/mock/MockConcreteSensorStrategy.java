package cs505.grad1.sensoragg;

import java.util.Random;

public class MockConcreteSensorStrategy implements MockSensorStrategy {
  public double getSensorData(MockGrovePi grovePi, int port) {
    Random r = new Random();
    return r.nextDouble()*100;
  }
}
