package cs505.grad1.sensoragg;

public enum SensorType {
  //BUTTON("digital"), //Grove - Button
  LIGHT_SENSOR("analog")//, //Grove - Light sensor
  //BUZZER("digital"), //Grove - Buzzer
  //SOUND("analog"), //Grove - Sound sensor
  //LED("digital"), //Grove - Red LED
  //BACKLIGHT("analog"); //Grove - LCD RGB Backlight
  // ROTARY, //Grove - Rotary angle sensor
  // TEMP_HUMID, //Grove - Temperature and humidity sensor
  // RANGER, //Grove - Ultrasonic ranger
  // RELAY //Grove - Relay
  ;
  private String inputMethod;

  public String getInputMethod() {
    return this.inputMethod;
  }

  private SensorType(String inputMethod) {
    this.inputMethod = inputMethod;
  }


}
