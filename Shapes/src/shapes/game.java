package shapes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author x13114352
 */
public class game {
     //Variables
    private String image;
    
    
    //constructor
    public game() {
    image = "/images/redCircle.jpg";
    
    }

    public String getRedCircle() {
        return image;
    }

    public void setRedCircle(String redCircle) {
        this.image = redCircle;
    }
}
