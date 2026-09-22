public class Mille {
    private Togvogn denVognHunErI;

    public Mille(Togvogn denFørsteVognHunGårIndI) {
        this.denVognHunErI = denFørsteVognHunGårIndI;
    }

    public boolean gåIndINæsteVogn() {

        denVognHunErI = denVognHunErI.getVognenBagved();
        return denVognHunErI != null;
    }

    public int hvorErDu() {
        return denVognHunErI.getVognnummer();
    }

    public int påHvilketSædeLåTasken(Taske taskenHunLederEfter){return denVognHunErI.hvilketNrSædeErTaskenFundetPå(taskenHunLederEfter);}

    public boolean erTaskenDer(Taske taskenHunLederEfter) {
        return denVognHunErI.kigEfterTaske(taskenHunLederEfter) != null;
    }

    public String kanDuSeNogenTasker() {
        return denVognHunErI.hvilkeTaskerErIVognen();
    }
}
