//Mille er personen der leder efter tasken. Hun holder styr på hvilken vogn hun står i
//og sender spørgsmålene videre til den vogn hun er i
public class Mille {
    private Togvogn denVognHunErI;

    public Mille(Togvogn denFørsteVognHunGårIndI) {
        this.denVognHunErI = denFørsteVognHunGårIndI;
    }

    //Flytter Mille til vognen bagved. Returnerer false hvis hun stod i den sidste vogn
    public boolean gåIndINæsteVogn() {

        denVognHunErI = denVognHunErI.getVognenBagved();
        return denVognHunErI != null;
    }

    //Nummeret på den vogn hun står i lige nu
    public int hvorErDu() {
        return denVognHunErI.getVognnummer();
    }

    //Sædenummeret hvor tasken blev fundet i den nuværende vogn
    public int påHvilketSædeLåTasken(Taske taskenHunLederEfter){return denVognHunErI.hvilketNrSædeErTaskenFundetPå(taskenHunLederEfter);}

    //Er den rigtige taske i denne vogn? kigEfterTaske giver null hvis den ikke er der
    public boolean erTaskenDer(Taske taskenHunLederEfter) {
        return denVognHunErI.kigEfterTaske(taskenHunLederEfter) != null;
    }

    //Beskrivelse af alle glemte tasker i den vogn hun står i
    public String kanDuSeNogenTasker() {
        return denVognHunErI.hvilkeTaskerErIVognen();
    }
}
