package data;

import java.math.BigDecimal;

public class Affect extends Emotiv {

  private BigDecimal excitement, engagement, longTermExcitement, stress, relaxation, interest, focus;
  private boolean activeEngagement, activeExcitement, activeStress, activeFocus, activeInterest, activeRelaxation;

  public Affect() {
    super("affect");
  }

  public Affect addEngagement(Object o) {
    engagement = (BigDecimal) o;
    return this;
  }

  public Affect addExcitement(Object o) {
    excitement = (BigDecimal) o;
    return this;
  }

  public Affect addLongTermExcitement(Object o) {
    longTermExcitement = (BigDecimal) o;
    return this;
  }

  public Affect addStress(Object o) {
    stress = (BigDecimal) o;
    return this;
  }

  public Affect addRelaxation(Object o) {
    relaxation = (BigDecimal) o;
    return this;
  }

  public Affect addInterest(Object o) {
    interest = (BigDecimal) o;
    return this;
  }

  public Affect addFocus(Object o) {
    focus = (BigDecimal) o;
    return this;
  }

  public Affect addActiveEngagement(Object o) {
    activeEngagement = (boolean) o;
    return this;
  }

  public Affect addActiveExcitement(Object o) {
    activeExcitement = (boolean) o;
    return this;
  }

  public Affect addActiveStress(Object o) {
    activeStress = (boolean) o;
    return this;
  }

  public Affect addActiveRelaxation(Object o) {
    activeRelaxation = (boolean) o;
    return this;
  }

  public Affect addActiveInterest(Object o) {
    activeInterest = (boolean) o;
    return this;
  }

  public Affect addActiveFocus(Object o) {
    activeFocus = (boolean) o;
    return this;
  }

  public String toString() {
    return "Affect: {" +
      "engagement: " + engagement +
      ",excitement: " + excitement +
      ",longTermExcitement: " + longTermExcitement +
      ",stress: " + stress +
      ",relaxation: " + relaxation +
      ",interest: " + interest +
      ",focus: " + focus +
      ",isENG: " + activeEngagement +
      "isEXC: " + activeExcitement +
      "isSTR: " + activeStress +
      "isREL: " + activeRelaxation +
      "isINT: " + activeInterest +
      "isFOC: " + activeFocus + "}";
  }

//      return "Face: {eye:" + actionEye + ",upperFaceAction:" + actionUpperFace + ",upperFacePower:" + powerUpperFace + ",lowerFaceAction:" + actionLowerFace  + ",lowerFacePower: " + powerlowerFace;

}

