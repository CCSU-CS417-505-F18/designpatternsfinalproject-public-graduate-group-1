# CS505 Graduate Students - Group 1: Final Project Component
The `Grad1Component` provides Java developers building Raspberry Pi/Grove Pi applications with an easy way to access all sensor input data at once.

## Authors
* **Colin Kelly**
* **Ben Marshalkowski**
* **Kathleen McKay**
* **Phil Murray**

### Prerequisites
JDK 8.0 or greater

### How to use
Prior to using the `Grad1Component`, you must know which sensors on your RPi are associated with which ports. `Grad1Component` only supports the standard Grove Pi sensors listed below:

  * SOUND, //Grove - Sound sensor
  * LIGHT, //Grove - Light sensor
  * ROTARY, //Grove - Rotary angle sensor
  * HUMIDITY, //Grove - Temperature and humidity sensor
  * TEMPERATURE, //Grove - Temperature and humidity sensor
  * RANGER, //Grove - Ultrasonic ranger

### Sample usage
To use this component, you must pass in a `org.iot.raspberry.grovepi.GrovePi` object to a new instance of `Grad1Component`.
```java
GrovePi grovePi = new GrovePi4J();
Grad1Component component = new Grad1Component(grovePi);
```
Then, provide the component with information about which sensor is associated with which port using the `enum SensorType` provided with the `Grad1Component`.
```java
component.addSensor(1, SensorType.LIGHT);
component.addSensor(0, SensorType.ROTARY);
component.addSensor(4, SensorType.RANGER);
component.addSensor(3, SensorType.TEMP);
component.addSensor(3, SensorType.HUMID);
component.addSensor(2, SensorType.SOUND);
```
Note: Grove Pi has a "Temperature/Humidity" sensor, which is why port 3 needed to be loaded twice.

Now that you have loaded the component with the appropriate sensor information, you can call `getAllSensorData()`, which will return a `SensorAggHashMap` collection data structure. This structure implements `Map<Integer, SensorData>`, where `Integer` refers to the port number.
```java
SensorAggHashMap sah = (SensorAggHashMap) component.getAllSensorData();
```
This `SensorAggHashMap` can be pretty printed, iterated over, etc.
```java
// invoke the toString() method on the SensorAggHashMap
System.out.println(sah);

// get the value of a specific sensor.
double currentTemp = sah.getValue(SensorType.TEMP);

// foreach over the entire collection of sensors
for (Map.Entry<Integer, SensorData> entry : sah.entrySet()) {
  System.out.println(entry.getKey() + " --> " + entry.getValue());
}
```
