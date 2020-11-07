

/**
 * Class TuilesQuartier
 */
public class TuilesQuartier {

  //
  // Fields
  //

  private Boolean faceSuspect;
  private String Mur;
  private Position place;
  
  //
  // Constructors
  //
  public TuilesQuartier () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of faceSuspect
   * @param newVar the new value of faceSuspect
   */
  public void setFaceSuspect (Boolean newVar) {
    faceSuspect = newVar;
  }

  /**
   * Get the value of faceSuspect
   * @return the value of faceSuspect
   */
  public Boolean getFaceSuspect () {
    return faceSuspect;
  }

  /**
   * Set the value of Mur
   * @param newVar the new value of Mur
   */
  public void setMur (String newVar) {
    Mur = newVar;
  }

  /**
   * Get the value of Mur
   * @return the value of Mur
   */
  public String getMur () {
    return Mur;
  }

  /**
   * Set the value of place
   * @param newVar the new value of place
   */
  public void setPlace (Position newVar) {
    place = newVar;
  }

  /**
   * Get the value of place
   * @return the value of place
   */
  public Position getPlace () {
    return place;
  }

  //
  // Other methods
  //

}
