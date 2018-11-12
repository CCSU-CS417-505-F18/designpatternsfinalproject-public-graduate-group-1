package cs505.grad1.sensoragg;

import java.io.IOException;

public interface MockSensorStrategy {

  public double getSensorData(MockGrovePi grovePi, int port) throws IOException;

}
