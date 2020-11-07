

/**
 * Class Detectives
 */
public class Detectives {

  //
  // Fields
  //

  private String nom;
  private Position place;
  
  //
  // Constructors
  //
  public Detectives () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of nom
   * @param newVar the new value of nom
   */
  public void setNom (String newVar) {
    nom = newVar;
  }

  /**
   * Get the value of nom
   * @return the value of nom
   */
  public String getNom () {
    return nom;
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
