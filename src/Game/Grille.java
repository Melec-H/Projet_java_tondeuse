package Game;

import java.util.*;

public class Grille {

    // Attributs
    private int nbLig;
    private int nbCol;
    private char[][] grille;
    ArrayList<String> stockage;

    // Constructeur
    public Grille(int n, int p, ArrayList<String> stockage){
        nbLig = n;
        nbCol = p;
        grille = new char[nbLig][nbCol];


        grilleInit();
        affectGrille(stockage);

    }

    // Init de la grille vierge
   private void grilleInit(){
       for(int i=0; i<nbLig; i++){
           for(int j=0; j<nbCol; j++){

               grille[i][j] = ' ';

           }
       }
   }

    // Affectation des obstacles et des items
   private void affectGrille(ArrayList<String> stockage){

       for (int it = 2;  it < (stockage.size() - 2); it++) {


           String valeur = stockage.get(it);

           if (valeur.equals("O")) {
               this.grille[Integer.parseInt(stockage.get(it + 1)) -1][Integer.parseInt(stockage.get(it + 2)) -1] = 'O';

           } else if (valeur.equals("I")) {
               this.grille[Integer.parseInt(stockage.get(it + 1)) -1][Integer.parseInt(stockage.get(it + 2)) -1] = 'I';
           }
       }
   }

   // Gére le déplacement de la tondeuse sur notre grille
   public void updateGrille(int oldX, int oldY, int newX, int newY){
        this.grille[oldX][oldY] = ' ';
        this.grille[newX][newY] = 'T';
   }

   public char getGrille(int x, int y){
        return grille[x][y];
   }

   public int getNbLig(){
        return this.nbLig;
   }
   public int getNbCol(){
        return this.nbCol;
    }



}