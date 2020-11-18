package src.jetons;

import java.util.Scanner;

public class jetonWatsonToby {
    jetons.Detectives detective;

    public void deplacementWatson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisi 1 ou 2 pas");
        int choix = scanner.nextInt();
        if(detective.getNom() == "Watson"){
            detective.setPlace(detective.getPlace()+choix);
            switch(detective.getPlace()){
                case 13:
                    detective.setPlace(1);
                    break;
                case 14:
                    detective.setPlace(2);
                    break;
            }
        }
    }

    public void deplacementToby(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisi 1 ou 2 pas");
        int choix = scanner.nextInt();
        if(detective.getNom() == "Toby"){
            detective.setPlace(detective.getPlace()+choix);
            switch(detective.getPlace()){
                case 13:
                    detective.setPlace(1);
                    break;
                case 14:
                    detective.setPlace(2);
                    break;
            }
        }
    }
}
