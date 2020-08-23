import processing.core.PApplet;

public class Main extends PApplet{
    //....Denne variabel kan bruges til at
    static PApplet p;

    //Denne liste SKAL indholde alle de "Ting", der er på skærmen!
    Ting[] listeTing = new Ting[20];

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        super.settings();
        size(500,500);

        //...Alle processing kommandoer er nu inde i p....
        p = this;

        // Opgave 1 : Her skal du oprette listen "listeTing" med plads til 20 ting
        listeTing = new Ting[20];

        //Opgave 5 : Her skal du skrive kode der laver alle "Ting"
        for(int i = 0; i < 20; i++){
            listeTing[i] = new Ting(this, p.random(0, width), p.random(0, height));
            println(i);
        }

    }

    public void draw() {
        //... Eksempel på processing kommando (som den bør bruges i andre klasser!!)
        clear();
        Main.p.fill(200,200,200);
        Main.p.rect(10,10,480,480);

        //OPGAVE 8 (SVÆR) : Her skal du skrive kode der ændrer farven til rød din "Ting"  rører ved musen...
        for (int k = 0; k < listeTing.length; ++k) {
            Ting f = listeTing[k];

            float dx = f.location.x - mouseX;
            float dy = f.location.y - mouseY;

            float dist = sqrt(dx * dx + dy * dy);

            if(dist < f.diameter/2){
                f.mouseOver = true;

            } else {
                f.mouseOver = false;
            }
        }

        //Opgave 6 : Her skal du skrive kode, der tegner alle "Ting"
        //ps: Du SKAL kalde "tegn metoden" på ALLE "Ting"
        for (int j = 0; j < listeTing.length; ++j) {
            Ting t = listeTing[j];
            t.tegn();

            //Opgave 7 : Her skal du skrive kode, der får alle "Ting" til at flytte sig
            //ps: DU SKAL kalde "
            t.flyv();

            //EKSPERT 2:
            //Hvis to ting rører hinanden skal de blive blå!
            t.collide(listeTing);
        }
    }
}