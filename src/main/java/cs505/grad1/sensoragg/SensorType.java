package cs505.grad1.sensoragg;

/**
 * The SensorType enum provides a list of the available
 * sensors which can be aggregated.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public enum SensorType {
  LIGHT("Light"), //Grove - Light sensor
  SOUND("Sound"), // Grove - Sound Sensor
  ROTARY("Rotary Angle"), //Grove - Rotary angle sensor
  TEMP("Temperature"), // Grove - Temperature Sensor
  HUMID("Humidity"), //Grove - Humidity Sensor
  RANGER("Ultrasonic Ranger"), //Grove - Ultrasonic Ranger Sensor (digital port)
  ;
  private final String name;
  public String toString() {
    return name;
  }
  private SensorType(String name) {
    this.name = name;
  }
}
