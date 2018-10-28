package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;

public class SensorAggHashMap extends HashMap<String, SensorData> {
  public String toString() {
    String str = "";
    for (Map.Entry<String, SensorData> entry : this.entrySet()) {
      str += entry.getKey() + " (port " + entry.getValue().port + ") = " + entry.getValue().value + "\n";
    }
    return str;
  }
}
