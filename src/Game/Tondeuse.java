package Game;

import java.util.ArrayList;

public class Tondeuse {

    Integer positionX;
    Integer positionY;
    String direction;

    // Constructeur simple
    public Tondeuse(){

    }

    // Constructeur en fonction des coordonnées initiales de la tondeuse
    public Tondeuse(Integer positionX, Integer positionY){

        this.positionX = positionX;
        this.positionY = positionY;
    }

    // Setter de direction
    public void setDirection(String direction){
        this.direction = direction;
    }

    // Setter de position ligne
    public void setPositionX(Integer position){
        this.positionX = position;
    }

    // Setter de position colonne
    public void setPositionY(Integer position){
        this.positionY = position;
    }

    // Getter de position ligne
    public Integer getPositionX(){
        return positionX;
    }

    // Getter de position colonne
    public Integer getPositionY(){
        return positionY;
    }

    // Getter de direction
    public String getDirection(){
        return direction;
    }

    // Méthode : Pivoter à gauche
    public void pivoterGauche(){
        switch (this.direction){
            case "N":
                this.direction = "W";
                break;
            case "W":
                this.direction = "S";
                break;
            case "S":
                this.direction = "E";
                break;
            case "E":
                this.direction = "N";
                break;
        }
    }

    // Méthode : Pivoter à gauche
    public void pivoterDroite(){
        switch (this.direction){
            case "N":
                this.direction = "E";
                break;
            case "E":
                this.direction = "S";
                break;
            case "S":
                this.direction = "W";
                break;
            case "W":
                this.direction = "N";
                break;
        }
    }

    // Méthode : Avancer
    public void avancer(){
        switch (this.direction){
            case "N":
                setPositionX(this.positionX - 1);
                break;
            case "S":
                setPositionX(this.positionX + 1);
                break;
            case "E":
                setPositionY(this.positionY + 1);
                break;
            case "W":
                setPositionY(this.positionY - 1);
                break;
        }
    }
}
//public ArrayList<Object> setPositionInGrille(int positionX, int positionY) {

//}



