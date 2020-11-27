package jetons;
import Autres.*;

import java.util.Scanner;

public class jetonRotationSwitch{
    public TuilesQuartier choixTuile(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Entrez abscisse puis ordonne de la tuile");
        int abscisse = scanner.nextInt();
        int ordonne = scanner.nextInt();
        return TableauTuiles[abscisse][ordonne];
    }


    public void rotation(){
        boolean choixDef = false;

        while(!choixDef){
            System.out.println("numero entre 1 et 4");
            Scanner scanner  = new Scanner(System.in);
            int nombreMur = scanner.nextInt();
            TuilesQuartier choix = choixTuile();
            choix.setMur(int nombreMur);
        }
    }

    public void echanger(){
        TuilesQuartier choix1 = choixTuile();
        TuilesQuartier choix2 = choixTuile();

    }
}