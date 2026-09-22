import java.util.ArrayList;

public class Togvogn {
    private int vognnummer;
    private Togvogn vognenBagved;
    private ArrayList<Sæde> sæder;

    public Togvogn(int vognnummer, ArrayList<Sæde> sæder) {
        this.vognnummer = vognnummer;
        this.sæder = sæder;
    }

    public Togvogn getVognenBagved() {
        return vognenBagved;
    }

    public void setVognenBagved(Togvogn vognenBagved) {
        this.vognenBagved = vognenBagved;
    }


    public Taske kigEfterTaske(Taske taskenHunLederEfter) {
        Taske fundetTaske = null;
        for (Sæde sæde : sæder) {
            if (sæde.getTaske() != null && sæde.getTaske().equals(taskenHunLederEfter)) {
                fundetTaske = sæde.getTaske();
            }
        }
        return fundetTaske;
    }

    public int hvilketNrSædeErTaskenFundetPå(Taske taskenHunLederEfter){
        int sædeHvorTaskenLigger = -1;
        for (int i = 0; i < sæder.size(); i++) {
            if (sæder.get(i).getTaske() != null && sæder.get(i).getTaske().equals(taskenHunLederEfter)) {
                sædeHvorTaskenLigger = i + 1;
            }
        }
        return sædeHvorTaskenLigger;
    }


    public int getVognnummer() {
        return vognnummer;
    }

    public String hvilkeTaskerErIVognen() {
        String result = "";
        for (Sæde sæde : sæder) {
            if (sæde.getTaske() != null) {
                result += sæde.getTaske().toString() + "\n";
            }
        }
        if (result.isEmpty()) {
            result = "ingen glemte tasker i vognen";
        }
        return result;
    }
}
