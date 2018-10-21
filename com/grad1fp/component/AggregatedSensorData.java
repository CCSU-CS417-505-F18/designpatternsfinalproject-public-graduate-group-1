package com.grad1fp.component;

include java.util.Map;
include com.grad1fp.SensorType;

public interface AggregatedSensorData {
  Map<String,Number> getAllSensorData(Map<int, SensorType>);
}
