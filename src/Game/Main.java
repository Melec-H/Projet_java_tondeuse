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

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur durant la lecture du fichier");
        }

        // Création de la grille
        Grille grille = new Grille(Integer.parseInt(stockage.get(0)), Integer.parseInt(stockage.get(1)), stockage);
        grille.afficher();

        // Instanciation de la tondeuse
        Tondeuse tondeuse = initTondeuse(stockage);

        // Instanciation des obstacles


        // Instanciation des items


        // Coordonnées de la tondeuse
        System.out.println("Position X: " + tondeuse.getPositionX());
        System.out.println("Position Y: " + tondeuse.getPositionY());
        int tondeusePosX = tondeuse.getPositionX();
        int tondeusePosY = tondeuse.getPositionY();
        System.out.println("direction: " + tondeuse.getDirection());

        System.out.println("------------------------------------------------------------------------");
        System.out.println(" La partie commence ");
        System.out.println("------------------------------------------------------------------------");

        // On montre la grille avec la tondeuse, les items et les obstacles

        // Bloc code important pour les instructions
        int reallyreallyoldx = tondeuse.getPositionX();
        int reallyreallyoldy = tondeuse.getPositionY();
        int reallyreallynewx = tondeuse.getPositionX();
        int reallyreallynewy = tondeuse.getPositionY();
        grille.updateGrille(reallyreallyoldx, reallyreallyoldy, reallyreallynewx, reallyreallynewy);
        showGrille(grille);

        // Récupération de la dernière entrée de la list de tondeuse.txt
        // Script des mouvements

        String lineInstructions = stockage.get(stockage.size()-1);

        for (int i = 0; i <= lineInstructions.length()-1; i++) {
            lineInstructions.charAt(i);
            if(lineInstructions.charAt(i) == 'G') {
                System.out.println("------------------------------------------------------------------------");
                System.out.println(" La tondeuse pivote à gauche ");
                System.out.println("------------------------------------------------------------------------");
                //pivoter à gauche
                //afficher nouvelle position
            }
            else if(lineInstructions.charAt(i) == 'D') {
                System.out.println("------------------------------------------------------------------------");
                System.out.println(" La tondeuse pivote à droite ");
                System.out.println("------------------------------------------------------------------------");
                //pivoter à droite
                //afficher nouvelle position
            }
            else if(lineInstructions.charAt(i) == 'A') {
                System.out.println("------------------------------------------------------------------------");
                System.out.println(" La tondeuse avance si possible ");
                System.out.println("------------------------------------------------------------------------");
                //avancer d'une case sauf
                //si obstacle, et si item dans inventaire, avancer, et item-1
                //si item, item+1, avancer
                //si mur, ne rien faire
                //afficher nouvelle position
            }

        }


        // NOUVEAU MELEC

        //split mouvement
        //While mouvement.lenght
        //test avance 1
        

        //test avance 2
        System.out.println("new positionX tondeuse: " + tondeuse.getPositionX());
        System.out.println("new positionY tondeuse: " + tondeuse.getPositionY());
        int reallyoldx = tondeuse.getPositionX();
        int reallyoldy = tondeuse.getPositionY();
        tondeuse.avancer();
        int reallynewx = tondeuse.getPositionX();
        int reallynewy = tondeuse.getPositionY();
        System.out.println("new positionX tondeuse: " + tondeuse.getPositionX());
        System.out.println("new positionY tondeuse: " + tondeuse.getPositionY());
        grille.updateGrille(reallyoldx, reallyoldy, reallynewx, reallynewy);
        showGrille(grille);

        //test pivot
        System.out.println("----TESTTEST-----");
        tondeuse.pivoterDroite();
        System.out.println(tondeuse.getDirection());

        //test avance 3
        int oldx = tondeuse.getPositionX();
        int oldy = tondeuse.getPositionY();
        tondeuse.avancer();
        int newx = tondeuse.getPositionX();
        int newy = tondeuse.getPositionY();
        grille.updateGrille(oldx, oldy, newx, newy);
        showGrille(grille);
        System.out.println("new positionX tondeuse: " + tondeuse.getPositionX());
        System.out.println("new positionY tondeuse: " + tondeuse.getPositionY());
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
                tondeuse = new Tondeuse((Integer.parseInt(stockage.get(it + 1))-1), (Integer.parseInt(stockage.get(it + 2)))-1);
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

