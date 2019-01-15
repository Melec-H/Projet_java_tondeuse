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

        // Compteur d'items acquis pour le parcours
        Integer compteurItems = 0;

        // Déclaration d'une array list pour stocker les informations du fichier .txt
        ArrayList<String> stockage = new ArrayList<>();

        // Système Try/Catch
        try {
            // Création de l'objet fileReader
            FileReader fileReader = new FileReader(str);
            // Création de l'objet bufferedReader
            BufferedReader bufferedReader = new BufferedReader((fileReader));

            // Déclaration d'une variable string de valeur null ('' fonctionne aussi)
            String line = null;

            // Boucle afin de récupérer chaque information du .txt dans "line"
            while ((line = bufferedReader.readLine()) != null) {
                // Eclatage via la méthode split en enlevant les espaces
                for (String retval : line.split(" ")) {
                    // Attribution dans notre array list stockage
                    stockage.add(retval);

                }
            }
        // Gérer les exceptions et retourner un message dans la console
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur durant la lecture du fichier");
        }

        // Création de la grille
        Grille grille = new Grille(Integer.parseInt(stockage.get(0)), Integer.parseInt(stockage.get(1)), stockage);

        // Instanciation de la tondeuse
        Tondeuse tondeuse = initTondeuse(stockage);

        // Début de la partie
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

        // Boucle pour lire le script
        for (int i = 0; i <= lineInstructions.length()-1; i++) {
            lineInstructions.charAt(i);
            if(lineInstructions.charAt(i) == 'G') {

                tondeuse.pivoterGauche();

                System.out.println("------------------------------------------------------------------------");
                System.out.println(" La tondeuse pivote à gauche et se trouve maintenant en direction : " + tondeuse.getDirection());
                System.out.println("------------------------------------------------------------------------");

            }
            else if(lineInstructions.charAt(i) == 'D') {

                tondeuse.pivoterDroite();

                System.out.println("------------------------------------------------------------------------");
                System.out.println(" La tondeuse pivote à droite et se trouve maintenant en direction : " + tondeuse.getDirection());
                System.out.println("------------------------------------------------------------------------");

            }
            else if(lineInstructions.charAt(i) == 'A') {

                // Encore un Try/Catch (gérer le cas en dehors de la grille)
                try{
                    int oldx = tondeuse.getPositionX();
                    int oldy = tondeuse.getPositionY();

                    tondeuse.avancer();

                    int newx = tondeuse.getPositionX();
                    int newy = tondeuse.getPositionY();

                    if (Character.toString(grille.getGrille(newx, newy)).equals("O")){
                        if(compteurItems>0){
                            compteurItems--;

                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" La tondeuse rencontre un obstacle, elle utilise son item et avance ");
                            System.out.println("------------------------------------------------------------------------");

                            grille.updateGrille(oldx, oldy, newx, newy);

                            // si on tombe sur un obstacle et qu'on a des items, on valide l'avance
                        }

                        else if (compteurItems == 0){

                            tondeuse.annulerAvancement();

                            System.out.println("------------------------------------------------------------------------");
                            System.out.println(" La tondeuse rencontre un obstacle, elle ne possède pas d'item, n'avance pas");
                            System.out.println("------------------------------------------------------------------------");

                            // on annule l'avance si pas d'item
                        }
                        showGrille(grille);
                    }
                    else if(Character.toString(grille.getGrille(newx, newy)).equals(" ")) {

                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" La tondeuse avance ");
                        System.out.println("------------------------------------------------------------------------");

                        grille.updateGrille(oldx, oldy, newx, newy);
                        showGrille(grille);

                    }
                    else if(Character.toString(grille.getGrille(newx, newy)).equals("I")){
                        compteurItems++;

                        System.out.println("------------------------------------------------------------------------");
                        System.out.println(" La tondeuse rencontre un item, elle le récupère et avance ");
                        System.out.println("------------------------------------------------------------------------");

                        grille.updateGrille(oldx, oldy, newx, newy);
                        showGrille(grille);
                    }

                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(" La tondeuse ne peut pas sortir du jardin, elle ne bouge pas ");
                    System.out.println("------------------------------------------------------------------------");
                    tondeuse.annulerAvancement();
                }

                }


            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(" Position finale de tondeuse : " + (tondeuse.getPositionX()+1) + " : " + (tondeuse.getPositionY()+1));
            System.out.println("------------------------------------------------------------------------");


    }

    // Montrer la grille (visuel)
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

    // Init de la tondeuse
    public static Tondeuse initTondeuse(ArrayList<String> stockage) {
        Tondeuse tondeuse = new Tondeuse(1,1);
        for (Integer it = 2; it < (stockage.size() - 1); it++) {


            String valeur = stockage.get(it);

            if (valeur.equals("T")) {
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

