import processing.core.PApplet;
import processing.core.PVector;


public class Ting {
    //Tings position
    float colorR = 100;
    PVector location, speed, rgb = new PVector(100,100,100);
    int diameter = 30;
    boolean mouseOver = false , blue = false;
    float spring = (float) 0.05;
    PApplet p;

    Ting(PApplet p, float inputX, float inputY) {

        //Opgave 2: Her skal du skrive kode der sætter positionen for tingen x og y
        location = new PVector(inputX , inputY);
        this.p = p;
    }

    public void tegn() {
        //Opgave 3: Her skal du skrive kode der tegner denne "Ting"
        if (mouseOver == true) {
            rgb = new PVector(255,0,0);
        } else if  (blue == true) {
            rgb = new PVector(0,0,255);
        } else {
            rgb = new PVector(100,100,100);
        }

        p.fill(rgb.x, rgb.y, rgb.z);
        p.ellipse(location.x,location.y, diameter, diameter);
    }

    void flyv() {
        //Opgave 4: Her skal du skrive kode der flytter "Ting"
        //ps: Husk de må ikke flytte sig uden for skærmen...
        speed = new PVector(p.random(-2,2), p.random(-2,2));

        location.add(speed);

        if (location.x > p.width - diameter) {
            location.x = p.width - diameter;
            speed.x *= -1;
        } else if (location.x < 0) {

            location.x = diameter;
            speed.x *= -1;
        }

        // Check top and bottom
        if (location.y > p.height - diameter) {
            speed.y *= -1;
            location.y = p.height - diameter;

        } else if (location.y < 0 ) {
            speed.y *= -1;
            location.y = diameter;
        }

    }

    void collide(Ting[] liste) {
        for (int i = 0; i < liste.length; i++) {
            Ting other = liste[i];
            if (other == this)
                continue;

            float dx = other.location.x - location.x;
            float dy = other.location.y - location.y;
            float distance = p.sqrt(dx*dx + dy*dy);
            float minDist = other.diameter/2 + diameter/2;

            if (distance < minDist) {
                blue = true;
                p.println("hej fra:" + i);
            } /*else {
                blue = false;
                p.println("farvel fra: " +i);
            }*/
        }
    }


    }
