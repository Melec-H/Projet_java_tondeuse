package Game;

import java.util.ArrayList;

public class Tondeuse {

    Integer positionX;
    Integer positionY;
    String direction;

    public Tondeuse(){

    }
    public Tondeuse(Integer positionX, Integer positionY){

        this.positionX = positionX;
        this.positionY = positionY;
    }

    //seter direction
    public void setDirection(String direction){
        this.direction = direction;
    }

    public void setPositionX(Integer position){
        this.positionX = position;
    }

    public void setPositionY(Integer position){
        this.positionY = position;
    }

    public Integer getPositionX(){
        return positionX;
    }
    public Integer getPositionY(){
        return positionY;
    }

    public String getDirection(){
        return direction;
    }

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

    public void avancer(){
        switch (this.direction){
            case "N":
                this.positionY = this.positionY - 1;
            case "S":
                this.positionY = this.positionY + 1;
            case "E":
                this.positionY = this.positionX + 1;
            case "W":
                this.positionY = this.positionX - 1;
        }
    }
}
    //public ArrayList<Object> setPositionInGrille(int positionX, int positionY) {

    //}



