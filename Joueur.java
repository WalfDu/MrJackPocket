

/**
 * Class Joueur
 */
public class Joueur {

  //
  // Fields
  //

  private Boolean roles;
  private String nom;
  private int nombreSablier;
  
  //
  // Constructors
  //
  public Joueur () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of roles
   * @param newVar the new value of roles
   */
  public void setRoles (Boolean newVar) {
    roles = newVar;
  }

  /**
   * Get the value of roles
   * @return the value of roles
   */
  public Boolean getRoles () {
    return roles;
  }

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

  //
  // Other methods
  //

}
