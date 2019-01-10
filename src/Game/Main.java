package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Initialisation du jeu avec demande d'accès du fichier pour lecture
        Scanner FileToLink = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu - Tondeuse à cheveux de Boubou 2019");
        System.out.println("Veuillez renseignez un chemin de fichier : ");
        String str = FileToLink.nextLine();
        System.out.println("Le chemin d'accès du fichier renseigné est le suivant : " + str);

        String x;
        String y;
        ArrayList<String> stockage = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader((fileReader));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                for (String retval : line.split(" ")) {
                    stockage.add(retval);

                }
            }
            System.out.println("stockage est: " + stockage);


            // Récupération de la dernière entrée de la list de tondeuse.txt
            // Script des mouvements


            String lineInstructions = stockage.get(stockage.size()-1);

            System.out.println(" dernier : " + lineInstructions);

            for (int i = 0; i <= lineInstructions.length()-1; i++) {
                lineInstructions.charAt(i);
                if(lineInstructions.charAt(i) == 'G') {
                    //pivoter à gauche
                    //afficher nouvelle position
                }
                else if(lineInstructions.charAt(i) == 'D') {
                    //pivoter à droite
                    //afficher nouvelle position
                }
                else if(lineInstructions.charAt(i) == 'A') {
                    //avancer d'une case sauf
                    //si obstacle, et si item dans inventaire, avancer, et item-1
                    //si item, item+1, avancer
                    //si mur, ne rien faire
                    //afficher nouvelle position
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur durant la lecture du fichier");
        }
        Grille grille = new Grille(Integer.parseInt(stockage.get(0)), Integer.parseInt(stockage.get(1)), stockage);
        grille.afficher();

        //Instanciation de la tondeuse
        Tondeuse tondeuse = initTondeuse(stockage);
        //Coordonnée de la tondeuse
        System.out.println("Position X: " + tondeuse.getPositionX());
        System.out.println("Position Y: " + tondeuse.getPositionY());
        int tondeusePosX = tondeuse.getPositionX();
        int tondeusePosY = tondeuse.getPositionY();
        System.out.println("direction: " + tondeuse.getDirection());
        //show?

        showGrille(grille);

        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println("-----------");
        //simulation de deplacement
        grille.updateGrille(tondeusePosX-1, tondeusePosY-1, 7, 1);

        //on reshow la grille dans la console
        showGrille(grille);
    }

    private static void updateGrille(Grille grille){

    }
    public static void showGrille(Grille grille){
        int nbCol = grille.getNbCol();
        int nbLig = grille.getNbLig();

        for(int i=0; i<nbLig; i++){
            for(int j=0; j<nbCol; j++){


                // generation avec valeur
                System.out.print(" | " + grille.getGrille(i, j));

            }
            System.out.println(" | ");
        }
    }

    public static Tondeuse initTondeuse(ArrayList<String> stockage) {
        Tondeuse tondeuse = new Tondeuse(1,1);
        for (Integer it = 2; it < (stockage.size() - 1); it++) {


            String valeur = stockage.get(it);

            if (valeur.equals("T")) {
                System.out.println("T detected");
                tondeuse = new Tondeuse(Integer.parseInt(stockage.get(it + 1)), Integer.parseInt(stockage.get(it + 2)));

            }
            else if (valeur.equals("N")){
                tondeuse.setDirection(valeur);
            }
            else if (valeur.equals("S")){
                tondeuse.setDirection(valeur);
            }
            else if (valeur.equals("E")){
                tondeuse.setDirection(valeur);
            }
            else if (valeur.equals("W")){
                tondeuse.setDirection(valeur);
            }
        }
        return tondeuse;
    }
}

