package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;

public class SensorAggHashMap extends HashMap<Integer, SensorData> {

    //WELL-BEHAVED METHODS

    public String toString() {
        String str = "";
        for (Map.Entry<Integer, SensorData> entry : this.entrySet()) {
            str += "Port " + entry.getKey() + " (" + entry.getValue().type.name() + "): " + entry.getValue().value + "\n";
        }
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (isEmpty())
        {
            for (Integer key : keySet())
            {
                hash += key;
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null || !(other instanceof SensorAggHashMap)) return false;
        if (other == this) return true;

        Grad1Component gOther = (Grad1Component)other;
        if ((!gOther.toString().equals(toString())))
        {
            return false;
        }
        return true;
    }
}
