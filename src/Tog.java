import java.util.ArrayList;
import java.util.Random;

public class Tog {
    private Togvogn denFørsteVogn;

    public Tog() {
        lavTogsæt();
    }

    public Togvogn getDenFørsteVogn() {
        return denFørsteVogn;
    }



    private void lavTogsæt() {

        ArrayList<Sæde> sæder1 = lavSæder(16);
        ArrayList<Sæde> sæder2 = lavSæder(16);
        ArrayList<Sæde> sæder3 = lavSæder(16);
        ArrayList<Sæde> sæder4 = lavSæder(16);
        ArrayList<Sæde> sæder5 = lavSæder(20);
        ArrayList<Sæde> sæder6 = lavSæder(20);
        ArrayList<Sæde> sæder7 = lavSæder(20);

        Taske fjellræv = new Taske("blå", "Fjellræv");
        Taske læder = new Taske("rød", "lille lædertaske");
        Taske mappe = new Taske("sort", "mappe");
        smidTaske(sæder5, fjellræv);
        smidTaske(sæder3, mappe);
        smidTaske(sæder7, læder);

        Togvogn vogn1 = new Togvogn(1, sæder1);
        Togvogn vogn2 = new Togvogn(2, sæder2);
        Togvogn vogn3 = new Togvogn(3, sæder3);
        Togvogn vogn4 = new Togvogn(4, sæder4);
        Togvogn vogn5 = new Togvogn(5, sæder5);
        Togvogn vogn6 = new Togvogn(6, sæder6);
        Togvogn vogn7 = new Togvogn(7, sæder7);

        denFørsteVogn = vogn1;

        vogn1.setVognenBagved(vogn2);
        vogn2.setVognenBagved(vogn3);
        vogn3.setVognenBagved(vogn4);
        vogn4.setVognenBagved(vogn5);
        vogn5.setVognenBagved(vogn6);
        vogn6.setVognenBagved(vogn7);
    }
    private ArrayList<Sæde> lavSæder(int antal) {
        ArrayList<Sæde> sæder = new ArrayList<>();
        for (int i = 0; i < antal; i++) {
            sæder.add(new Sæde());
        }
        return sæder;
    }

    private void smidTaske(ArrayList<Sæde> sæder, Taske taske) {
        Random random = new Random();
        int sædeNummer = random.nextInt(sæder.size());
        Sæde sædetTaskenBliverSmidtPå = sæder.get(sædeNummer);
        sædetTaskenBliverSmidtPå.setTaske(taske);
    }
}
