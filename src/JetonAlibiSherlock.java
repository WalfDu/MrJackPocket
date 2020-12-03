package src;

import src.Detectives;

import java.util.Scanner;

public class JetonAlibiSherlock {
    Detectives detective;

    public void deplacement(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisi 1 ou 2 pas");
        int choix = scanner.nextInt();
        if(detective.getNom() == "Sherlock"){
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
