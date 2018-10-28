package cs505.grad1.sensoragg;

import java.util.Map;

/**
 * AggregatedSensorDataArray is an array implementation of
 * {@link cs505.grad1.sensoragg.AggregatedSensorData} which gathers and reports
 * data from sensors.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
class AggregatedSensorDataArray implements AggregatedSensorData {

    SensorData[] data;

    /**
     * getAllSensorData is a method to fetch the current values at each sensor
     *
     * @return a {@link java.util.Map} of every active port's description (e.g.
     * "Light", "Temperature") and corresponding readout value.
     */
    @Override
    public Map<String, Double> getAllSensorData() {
        //TODO Generate map from data array
        return null;
    }

    /**
     * getSensorData is a method to fetch the current value at a sensor of the specified type
     *
     * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of sensor you want the information from
     * @return a double with the value of the first sensor of the requested type
     */
    @Override
    public double getSensorData(SensorType type) {
        for (SensorData s : data) {
            if (s.type == type) {
                return s.value;
            }
        }
        return -999; //TODO should throw exception if no sensor of type
    }

    /**
     * getSensorData is a method to fetch the current values at the specified sensor
     *
     * @param port is an int for the port the requested sensor is at
     * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of sensor at the specified port
     * @return a double with the value of the sensor at the specified port
     */
    @Override
    public double getSensorData(int port, SensorType type) {
        for (SensorData s : data) {
            if (s.type == type && s.port == port) {
                return s.value;
            }
        }
        return -999; //TODO should throw exception if no sensor of type
    }

}
