package cs505.grad1.sensoragg;

import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor;
import org.iot.raspberry.grovepi.GrovePi;

import java.io.IOException;

public class HumiditySensorStrategy implements SensorStrategy {

    @Override
    public double getSensorData(GrovePi grovePi, int port) throws IOException {
        GroveTemperatureAndHumiditySensor sensor;
        try {
            sensor = new GroveTemperatureAndHumiditySensor(grovePi, port - Grad1Component.digitalOffset - Grad1Component.secondarySensorOffset, GroveTemperatureAndHumiditySensor.Type.DHT11);
            return sensor.get().getHumidity();
        } catch (IOException e) {
            throw e;
        }
    }

    //Well behaved methods
    @Override
    public String toString(){
        return "Humidity Sensor Strategy";
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
