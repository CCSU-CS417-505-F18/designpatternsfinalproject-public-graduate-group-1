package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;

public class SensorAggHashMap extends HashMap<Integer, SensorData> {
  public String toString() {
    String str = "";
    for (Map.Entry<Integer, SensorData> entry : this.entrySet()) {
      str += "Port " + entry.getKey() + " (" + entry.getValue().type.name() + "): " + entry.getValue().value + "\n";
    }
    return str;
  }
}
