package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveLed;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
import cs505.grad1.sensoragg.mock.MockGrovePi;


public class Main {

  public static void main(String[] args) throws Exception {
    MockGrovePi mock = new MockGrovePi();
    //your stuff here
    //test light sensor
    //test

    Grad1Component sag = new Grad1Component.Builder().sensor(1, SensorType.LIGHT)
                                                     .sensor(0, SensorType.ROTARY)
                                                     .sensor(4, SensorType.RANGER)
                                                     .sensor(3, SensorType.TEMP)
                                                     .sensor(3, SensorType.HUMID)
                                                     .mock(mock)
                                                     .build();

    Grad1Component sag1 = new Grad1Component(mock);
    sag1.addSensor(1, SensorType.LIGHT);
    sag1.addSensor(0, SensorType.ROTARY);
    sag1.addSensor(4, SensorType.RANGER);
    sag1.addSensor(3, SensorType.TEMP);
    sag1.addSensor(3, SensorType.HUMID);
    sag1.addSensor(2, SensorType.SOUND);
    System.out.println(sag.getAllSensorData());
    System.out.println(sag1.getAllSensorData());
    System.exit(0);
  }

}
