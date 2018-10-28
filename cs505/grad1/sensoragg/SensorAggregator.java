package cs505.grad1.sensoragg;

import java.util.HashMap;
import java.util.Map;

/**
 * SensorAggregator is a public class used to create a list of sensors and start
 * the factory process.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
public class SensorAggregator {

    private Map<Integer, SensorType> sensors = new HashMap<Integer, SensorType>();
    private AbstractAggregatedDataFactory factory;

    /**
     * addSensor adds a sensor to the list. This allows users to collect sensors
     * in one place. Can then use getAllSensorData() to make repeated calls
     * without sending ports/sensors each time
     *
     * @param port is an int for the port the sensor is at
     * @param type is a {@link cs505.grad1.sensoragg.SensorType} for the type of
     * sensor at the specified port
     */
    public void addSensor(int port, SensorType type) {
        sensors.put(port, type);
    }

    /**
     * getAllSensorData return. Allows users to collect sensors in one place,
     * can then use getAllSensorData() to make repeated calls without sending
     * ports/sensors each time
     */
    public AggregatedSensorData getAllSensorData() {
        return factory.MakeAggregatedData(sensors);
    }

}
