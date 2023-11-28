package data;

import java.math.BigDecimal;

public class Face extends Emotiv {

  private String actionEye, actionUpperFace, actionLowerFace;
  private BigDecimal powerUpperFace, powerlowerFace;

  public Face() {
    super("face");
  }

  public Face addActionEye(Object o) {
    actionEye = (String) o;
    return this;
  }

  public Face addActionUpperFace(Object o) {
    actionUpperFace = (String) o;
    return this;
  }

  public Face addActionLowerFace(Object o) {
    actionLowerFace = (String) o;
    return this;
  }

  public Face addActionUpperFacePower (Object o) {
    powerUpperFace = (BigDecimal) o;
    return this;
  }

  public Face addActionLowerFacePower(Object o) {
    powerlowerFace = (BigDecimal) o;
    return this;
  }

  public String toString() {
    return "Face: {eye:" + actionEye + ",upperFaceAction:" + actionUpperFace + ",upperFacePower:" + powerUpperFace + ",lowerFaceAction:" + actionLowerFace  + ",lowerFacePower: " + powerlowerFace +"}";
  }

}
