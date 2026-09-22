import java.util.ArrayList;

//En enkelt togvogn. Hver vogn kender vognen bagved sig, så vognene tilsammen
//danner en kæde (en slags lænket liste) som man kan gå igennem fra første til sidste vogn
public class Togvogn {
    private int vognnummer;
    //Næste vogn i toget. Er null i den sidste vogn
    private Togvogn vognenBagved;
    //Alle sæder i vognen. Rækkefølgen i listen er også sædernes rækkefølge
    private ArrayList<Sæde> sæder;


    public Togvogn(int vognnummer, ArrayList<Sæde> sæder) {
        this.vognnummer = vognnummer;
        this.sæder = sæder;
    }

    public Togvogn getVognenBagved() {
        return vognenBagved;
    }

    //Kobler denne vogn sammen med den næste vogn i toget
    public void setVognenBagved(Togvogn vognenBagved) {
        this.vognenBagved = vognenBagved;
    }


    //Leder efter en bestemt taske i vognen. Returnerer tasken hvis den findes, ellers null
    public Taske kigEfterTaske(Taske taskenHunLederEfter) {
        Taske fundetTaske = null;
        //Løber alle sæder igennem og tjekker om der ligger den rigtige taske
        for (Sæde sæde : sæder) {
            if (sæde.getTaske() != null && sæde.getTaske().equals(taskenHunLederEfter)) {
                fundetTaske = sæde.getTaske();
            }
        }
        return fundetTaske;
    }

    //Finder sædenummeret hvor tasken ligger. Returnerer -1 hvis tasken ikke er i vognen
    public int hvilketNrSædeErTaskenFundetPå(Taske taskenHunLederEfter){
        int sædeHvorTaskenLigger = -1;
        //Bruger en almindelig for-løkke, fordi vi har brug for at kende indexet (= sædets plads)
        for (int i = 0; i < sæder.size(); i++) {
            if (sæder.get(i).getTaske() != null && sæder.get(i).getTaske().equals(taskenHunLederEfter)) {
                //+1 fordi lister starter på 0, men sæder tælles fra 1
                sædeHvorTaskenLigger = i + 1;
            }
        }
        return sædeHvorTaskenLigger;
    }


    public int getVognnummer() {
        return vognnummer;
    }

    //Laver en tekst med alle de glemte tasker der ligger i vognen
    public String hvilkeTaskerErIVognen() {
        String result = "";
        for (Sæde sæde : sæder) {
            if (sæde.getTaske() != null) {
                result += sæde.getTaske().toString() + "\n";
            }
        }
        //Ingen tasker fundet, så giv en besked i stedet for en tom tekst
        if (result.isEmpty()) {
            result = "ingen glemte tasker i vognen";
        }
        return result;
    }
}
