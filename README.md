"# designpatternsfinalproject-public-graduate-group-1"
# CS505 Graduate Students - Group 1: Final Project Component
Our component offers functionality to connect with a suite of sensors and provide the data from each sensor back in a convenient aggregated Map object.
Users can call getAllSensorData(Map<Integer, SensorType> portsAndSensors), with port numbers for each sensor requests (Integer) and a type using the SensoryType enum as parameters. The output would be a Map object with sensor data stored as individual human-readable variables.

## Authors
* **Colin Kelly**
* **Ben Marshalkowski**
* **Kathleen McKay**
* **Phil Murray**

### Prerequisites
JDK 8.0 or greater

### How to use
Prior to using this component, you must know which sensors on your RPi are associated with which port. This component only supports the standard Grove Pi parts listed below:

  * BUTTON, //Grove - Button
  * LIGHT_SENSOR, //Grove - Light sensor
  * BUZZER, //Grove - Buzzer
  * SOUND, //Grove - Sound sensor
  * RED_LED, //Grove - Red LED
  * BLUE_LED, //Grove - Blue LED
  * GREEN_LED, //Grove - Green LED
  * BACKLIGHT, //Grove - LCD RGB Backlight
  * ROTARY, //Grove - Rotary angle sensor
  * TEMP_HUMID, //Grove - Temperature and humidity sensor
  * RANGER, //Grove - Ultrasonic ranger
  * RELAY //Grove - Relay

### Sample usage
```java
// Initalize config Map
Map<Integer, SensorType> config = new HashMap<Integer, SensorType>();

// Port 1 has a button
config.put(1, SensorType.BUTTON);

// Port 3 has an ultrasonic ranger
config.put(3, SensorType.RANGER);

// Port 4 has a red LED
config.put(4, SensorType.RED_LED);

AggregateSensorData concreteAggregate = new StandardAggregateSensorData();
HashMap<String, Number> prettyData = concreteAggregate.getAllSensorData(config);
```
Note that `StandardAggregateSensorData` is not in our library yet. It will be in the months to come. To get around this, simply create your own class that implements the AggregateSensorData interface.
