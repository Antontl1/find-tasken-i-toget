import java.util.ArrayList;
import java.util.Random;

//Toget bygger hele togsættet: vogne, sæder og de glemte tasker.
//Udefra kender man kun den første vogn - resten finder man ved at gå bagud i kæden
public class Tog {
    private Togvogn denFørsteVogn;

    //Så snart et tog oprettes, bygges hele togsættet
    public Tog() {
        lavTogsæt();
    }


    public Togvogn getDenFørsteVogn() {
        return denFørsteVogn;
    }



    //Bygger togsættet: først sæder, så tasker der smides, så vognene der kobles sammen
    private void lavTogsæt() {

        //Hver vogn får sin egen liste af sæder (de fire sidste vogne er større)
        ArrayList<Sæde> sæder1 = lavSæder(16);
        ArrayList<Sæde> sæder2 = lavSæder(16);
        ArrayList<Sæde> sæder3 = lavSæder(16);
        ArrayList<Sæde> sæder4 = lavSæder(16);
        ArrayList<Sæde> sæder5 = lavSæder(20);
        ArrayList<Sæde> sæder6 = lavSæder(20);
        ArrayList<Sæde> sæder7 = lavSæder(20);

        //Opret tasker
        Taske fjellræv = new Taske("blå", "Fjellræv");
        Taske lædertaske = new Taske("rød", "lille lædertaske");
        Taske bæltetaske = new Taske("hvid","bæltetaske");
        Taske mappe = new Taske("sort", "mappe");


        //Læg taskerne i bestemte vogne, men på et tilfældigt sæde.
        //Bæltetasken er den Mille leder efter, og den ligger altid i vogn 2
        smidTaske(sæder5, fjellræv);
        smidTaske(sæder3, mappe);
        smidTaske(sæder7, lædertaske);
        smidTaske(sæder2, bæltetaske);


        //Opret vognene med deres nummer og sæder
        Togvogn vogn1 = new Togvogn(1, sæder1);
        Togvogn vogn2 = new Togvogn(2, sæder2);
        Togvogn vogn3 = new Togvogn(3, sæder3);
        Togvogn vogn4 = new Togvogn(4, sæder4);
        Togvogn vogn5 = new Togvogn(5, sæder5);
        Togvogn vogn6 = new Togvogn(6, sæder6);
        Togvogn vogn7 = new Togvogn(7, sæder7);

        denFørsteVogn = vogn4;

        //Kobl vognene sammen i rækkefølge. Vogn 7 får ingen vogn bagved, så dér stopper toget
        vogn4.setVognenBagved(vogn2);
        vogn2.setVognenBagved(vogn3);
        vogn3.setVognenBagved(vogn4);
        vogn1.setVognenBagved(vogn5);
        vogn5.setVognenBagved(vogn6);
        vogn6.setVognenBagved(vogn7);
    }

    //Laver en liste med det ønskede antal tomme sæder, så vognene kan få sæder
    //uden at man skal skrive én linje pr. sæde
    private ArrayList<Sæde> lavSæder(int antal) {
        ArrayList<Sæde> sæder = new ArrayList<>();
        for (int i = 0; i < antal; i++) {
            //Et nyt sæde er altid tomt, dvs. dets taske er null
            sæder.add(new Sæde());
        }
        return sæder;
    }

    //generer random sædenummer og sætter det 
    //Lægger tasken på et tilfældigt sæde i den liste der sendes ind
    private void smidTaske(ArrayList<Sæde> sæder, Taske taske) {
        Random random = new Random();
        //nextInt giver et tal fra 0 til size()-1, så det passer altid på listen
        int sædeNummer = random.nextInt(sæder.size());
        //get() giver en reference til sædet i listen (ikke en kopi),
        //så setTaske ændrer det sæde der faktisk står i vognen
        Sæde sædetTaskenBliverSmidtPå = sæder.get(sædeNummer);
        sædetTaskenBliverSmidtPå.setTaske(taske);
    }
}
