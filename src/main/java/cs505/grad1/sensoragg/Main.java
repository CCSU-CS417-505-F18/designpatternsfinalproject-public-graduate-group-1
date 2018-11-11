package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveLed;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;

public class Main {

  public static void main(String[] args) throws Exception {
    GrovePi grovePi = new GrovePi4J();
    //your stuff here
    //test light sensor
    //test 
    int pin = 4;
    GroveLed led = new GroveLed(grovePi, pin);
    led.set(true);
    Thread.sleep(1000);
    led.set(false);
    Grad1Component sag = new Grad1Component(grovePi);
    sag.addSensor(0, SensorType.LIGHT);
    //sag.addSensor(0, SensorType.ROTARY);
    //sag.addSensor(4, SensorType.RANGER);
    sag.addSensor(3, SensorType.TEMP);
    sag.addSensor(3, SensorType.HUMID);
    //sag.addSensor(2, SensorType.SOUND);
    SensorAggHashMap data = (SensorAggHashMap)sag.getAllSensorData();
    System.out.println("Light: " + data.getValue(SensorType.LIGHT));
    System.out.println("Temp: " + data.getValue(SensorType.TEMP));
    System.out.println("Humidity: " + data.getValue(SensorType.HUMID));
    System.exit(0);
  }

}
