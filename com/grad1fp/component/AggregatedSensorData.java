package com.grad1fp.component;

import java.util.Map;

public interface AggregatedSensorData {
  Map<String,Number> getAllSensorData(Map<int, SensorType>);
}
