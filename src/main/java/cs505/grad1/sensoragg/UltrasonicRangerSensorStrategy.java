package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

class UltrasonicRangerSensorStrategy implements SensorStrategy {

    @Override
    public double getSensorData(GrovePi grovePi, int port) throws IOException {
        GroveUltrasonicRanger sensor;
        try {
            sensor = new GroveUltrasonicRanger(grovePi, port - Grad1Component.digitalOffset);
            return sensor.get();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Ultrasonic Ranger Sensor Strategy";
    }
    @Override
    public int hashCode(){
        return 1;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof SensorStrategy)) return false;
        if (other == this) return true;
        return false;
    }
}
