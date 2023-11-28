package data;

import org.json.JSONArray;

import java.math.BigDecimal;

public class Device extends Emotiv {

  private Integer batteryLevel, batteryPercent;
  private JSONArray sensorsQuality;
  private BigDecimal wirelessSignal;

  public Device() {
    super("device");
  }

  public Device addBatteryLevel(Object o) {
    batteryLevel = (Integer) o;
    return this;
  }

  public Device addWirelessSignal(Object o) {
    wirelessSignal = (BigDecimal) o;
    return this;
  }

  public Device addSensorsQuality(Object o) {
    sensorsQuality = (JSONArray) o;
    return this;
  }


  public Device addBatteryPercent(Object o) {
    batteryPercent = (Integer) o;
    return this;
  }

  public String toString() {
    return "Device: {battery:" + batteryLevel + ",battery%:" + batteryPercent + ",signal:" + wirelessSignal + ",quality:" + sensorsQuality + "}";
  }


}
