package data;

import org.json.JSONArray;

import java.util.Observable;
import java.util.Stack;

/**
 * Shared data repository.
 *
 *  @author javiersgs
 *  @version 0.1
 */
public class Blackboard extends Observable {

  private Stack<Emotiv> stack = new Stack<Emotiv>();
  private String status;

  private static Blackboard instance;

  /**
   * Constructor for the singleton
   */
  private Blackboard() {
  }

  /**
   * Accessor for the singleton instance.
   *
   * @return The singleton instance.
   */
  public static Blackboard getInstance() {
    if (instance == null)
      instance = new Blackboard();
    return instance;
  }

  /**
   * Adds a message to the status bar.
   *
   * @param data        The message to add.
   * @param deviceClass
   */
  public void add (Emotiv data, Class c) {
    stack.push(data);
    if (data.getClass() == Affect.class) {
      setChanged();
      notifyObservers(c);
    }
  }

  public String getData () {
    return stack.peek().toString();
  }

  public String getStatus () {
    return status;
  }

  public void addFace(float time, JSONArray array) {
    Face face = new Face ()
      .addActionEye(array.get(0))
      .addActionUpperFace(array.get(1))
      .addActionUpperFacePower(array.get(2))
      .addActionLowerFace(array.get(3))
      .addActionLowerFacePower(array.get(4));
    status = "Face added.";
    add(face, Face.class);
  }

  public void addDevice(float time, JSONArray array) {
    Device device = new Device ()
      .addBatteryLevel (array.get(0))
      .addWirelessSignal (array.get(1))
      .addSensorsQuality (array.get(2))
      .addBatteryPercent (array.get(3));
    status = "Device added.";
    add(device, Device.class);
  }

  public void addAffect(float time, JSONArray array) {
    Affect affect = new Affect ()
      .addActiveFocus(array.get(0))
      .addFocus(array.get(1))
      .addActiveEngagement(array.get(2))
      .addEngagement(array.get(3))
      .addActiveExcitement(array.get(4))
      .addExcitement(array.get(5))
      .addLongTermExcitement(array.get(6))
      .addActiveStress(array.get(7))
      .addStress(array.get(8))
      .addActiveRelaxation(array.get(9))
      .addRelaxation(array.get(10))
      .addActiveInterest(array.get(11))
      .addInterest(array.get(12));
    status = "Affect added.";
    add(affect, Affect.class);
  }
  public void addPAD(float time, JSONArray array) {
    PadData data = new PadData(array);
    add(data, PadData.class);
    status = "PAD added.";
  }

}
