package jetons;
import Autres.*;

import java.util.Scanner;

public class JetonRotationDeplacement {
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

    public void deplacement(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisi le detective à deplacer");
        int choix = scanner.nextInt();
        if(Detectives.getNom() == "Watson"){
            Detectives.setPlace(Detectives.getPlace()+choix);
            switch(Detectives.getPlace()){
                case 13:
                    Detectives.setPlace(1);
                    break;
                case 14:
                    Detectives.setPlace(2);
                    break;
            }
        }
    }
}
