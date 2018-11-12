package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * SensorAggHashMap is the main data structure associated with the Grad1Component.
 * It is a {@link Map} of {@link Integer} keys to {@link SensorData} values.
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class SensorAggHashMap extends HashMap<Integer, SensorData> {

    private DataIterator iterator;

    /**
     * getValue will iterate over each entry in the SensorAggHashMap to find an entry of the
     * matching type. It will then return the value in that entry as a double.
     *
     * @param sensorType is the SensorType enum reflecting the type of sensor that is being viewed
     * @return the value detected by the sensor, represented as a double
     */
    public double getValue(SensorType sensorType) {
        SensorData data;
        do
        {
            data = getIterator().next().getValue();
            if (data.getSensorType() == sensorType)
                return data.getValue();
        }
        while(getIterator().hasNext());

        //USING JAVA ITERATOR
       // for (Map.Entry<Integer, SensorData> entry : this.entrySet())
       // {
       //     SensorData data = entry.getValue();
       //     if (data.getSensorType() == sensorType)
       //         return data.getValue();
       // }
        //TODO: Throw sensor not included exception?
        return -999;
    }

    /**
     * getIterator will access this instance's iterator object, or create one if none exists
     *
     * @return the iterator for this instance, as a DataIterator
     */
    private DataIterator getIterator() {
        if (iterator == null)
        {
            iterator = new DataIterator(this);
        }
        return iterator;
    }

    //WELL-BEHAVED METHODS
    @Override
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
    public boolean equals(Object other) {
        if (other == null || !(other instanceof SensorAggHashMap)) return false;
        if (other == this) return true;

        SensorAggHashMap sOther = (SensorAggHashMap) other;
        if ((!sOther.toString().equals(toString())))
        {
            return false;
        }
        return true;
    }

    private class DataIterator implements Iterator<Entry<Integer, SensorData>> {

        Map.Entry<Integer, SensorData>[] entryArray;
        int currentPosition = 0;

        DataIterator(SensorAggHashMap sag)
        {
            entryArray = sag.entrySet().toArray(new Entry[0]);
        }

        /**
         * hasNext confirms if there are additional entries past the iterator's current position
         *
         * @return a boolean if there are additional entries remaining
         */
        @Override
        public boolean hasNext() {
            return currentPosition < entryArray.length;
        }

        /**
         * next returns the next entry in the hashmap, if one exists, and increments the current position
         *
         * @return the next entry in the hash map, as Entry<Integer, SensorData>
         */
        @Override
        public Entry<Integer, SensorData> next() {
            if (hasNext())
            {
                return entryArray[currentPosition++];
            }
            return null;
        }

        //WELL-BEHAVED METHODS
        @Override
        public String toString() {
            String str = "Aggregated Data Iterator, Size " + entryArray.length;
            return str;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            if (entryArray != null)
            {
                hash += entryArray.length;
            }
            return hash;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof DataIterator)) return false;
            if (other == this) return true;

            DataIterator dOther = (DataIterator)other;
            if ((dOther.hashCode() != hashCode()))
            {
                return false;
            }
            return true;
        }
    }
}
