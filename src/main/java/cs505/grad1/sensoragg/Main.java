package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveLed;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;

public class Main {

  public static void main(String[] args) throws Exception {
    GrovePi grovePi = new GrovePi4J();
    //your stuff here
    int pin = 4;
    GroveLed led = new GroveLed(grovePi, pin);
    led.set(true);
    Thread.sleep(1000);
    led.set(false);
    Grad1Component sag = new Grad1Component(grovePi);
    sag.addSensor(1, SensorType.LIGHT);
    sag.addSensor(0, SensorType.ROTARY);
    sag.addSensor(4, SensorType.RANGER);
    sag.addSensor(3, SensorType.TEMP);
    //sag.addSensor(3, SensorType.HUMID);
    sag.addSensor(2, SensorType.SOUND);
    System.out.println(sag.getAllSensorData());
    System.exit(0);
  }

}
