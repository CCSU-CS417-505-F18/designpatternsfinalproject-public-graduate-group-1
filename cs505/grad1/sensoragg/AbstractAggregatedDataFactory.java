package cs505.grad1.sensoragg;

import java.util.Map;

/**
 * AbstractAggregatedDataFactory is an interface for factories that will be used
 * by {@link cs505.grad1.sensoragg.AggregatedSensorData}. The concrete factory
 * will implement GrovePi APIs to access appropriate sensors.
 *
 * @version 1.0.0
 * @author Colin Kelly
 * @author Ben Marshalkowski
 * @author Kathleen McKay
 * @author Phil Murray
 */
interface AbstractAggregatedDataFactory {

    /**
     * MakeAggregatedData is a method to generate the sensor data based on a map
     * of ports and sensor types
     *
     * @param sensors is a {@link java.util.Map} of every active port (int) and
     * the sensor ({@link cs505.grad1.sensoragg.SensorType}) at that port
     */
    AggregatedSensorData MakeAggregatedData(Map<Integer, SensorType> sensors);

}
