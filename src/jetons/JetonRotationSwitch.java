public class jetonRotationSwitch{
    public TuilesQuartiers choixTuile(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Entrez abscisse puis ordonne de la tuile")
        int abscisse = scanner.nextInt();
        int ordonne = scanner.nextInt();
        return TableauTuiles[abscisse][ordonne];
    }


    public void rotation(){
        boolean choixDef = false;

        while(!choixDef){
            TuilesQuartier choix = choixTuile();
            choix.setMur(int );
        }
    }
}