import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BouttonTest {
    private ImageView personnage;

    public ImageView getPersonnage() {
        return personnage;
    }

    public void setPersonnage(ImageView personnage) {
        this.personnage = personnage;
    }

    public BouttonTest(String nomImage) {
        ImageView personnage = new ImageView(getClass().getResource(nomImage).toString());
        this.personnage = personnage;
    }

    BouttonTest bouttonJohnSmith = new BouttonTest("JohnSmith-recto.png");


}
