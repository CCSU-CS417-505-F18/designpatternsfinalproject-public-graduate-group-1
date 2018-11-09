package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * SensorAggHashMap is a map implementation to gather and relay
 * sensor data. Each key represents a connected port, and the
 * value is the associated SensorData. Functionality is as a normal
 * Map in Java.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class SensorAggHashMap extends HashMap<Integer, SensorData> {

    private DataIterator iterator;

    public double getValue(SensorType sensorType)
    {
        //USING CUSTOM ITERATOR
        do
        {
            SensorData data = getIterator().next().getValue();
            if (data.getSensorType() == sensorType)
                return data.getValue();
        }
        while(getIterator().hasNext());

        //USING JAVA ITERATOR
//        for (Map.Entry<Integer, SensorData> entry : this.entrySet())
//        {
//            SensorData data = entry.getValue();
//            if (data.getSensorType() == sensorType)
//                return data.getValue();
//        }
        //TODO: Throw sensor not included exception?
        return -999;
    }

    private DataIterator getIterator (){
        if (iterator == null)
        {
            iterator = new DataIterator(this);
        }
        return iterator;
    }

    //WELL-BEHAVED METHODS
    public String toString() {
        String str = "";
        for (Map.Entry<Integer, SensorData> entry : this.entrySet()) {
            str += "Port " + entry.getKey() + " (" + entry.getValue().getSensorType().name() + "): " + entry.getValue().getValue() + "\n";
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

    private class DataIterator implements Iterator<Entry<Integer, SensorData>> {

        Entry<Integer, SensorData>[] entryArray;
        int currentPosition = 0;

        DataIterator(SensorAggHashMap sag)
        {
            entryArray = sag.entrySet().toArray(new Entry[0]);
        }

        @Override
        public boolean hasNext() {
            return currentPosition < entryArray.length;
        }

        @Override
        public Entry<Integer, SensorData> next() {
            if (hasNext())
            {
                return entryArray[currentPosition++];
            }
            return null;
        }
    }
}
