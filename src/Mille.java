public class Mille {
    private Togvogn denVognHunErI;

    public Mille(Togvogn denFørsteVognHunGårIndI) {
        this.denVognHunErI = denFørsteVognHunGårIndI;
    }

    public void gåIndINæsteVogn() {
        denVognHunErI = denVognHunErI.getVognenBagved();
    }

    public int hvorErDu() {
        return denVognHunErI.getVognnummer();
    }

    public int påHvilketSædeLåTasken(String søgekriterie){return denVognHunErI.hvilketNrSædeErTaskenFundetPå(søgekriterie);}

    public boolean erTaskenDer(String søgekriterie) {
        return denVognHunErI.kigEfterTaske(søgekriterie) != null;
    }

    public String kanDuSeNogenTasker() {
        return denVognHunErI.hvilkeTaskerErIVognen();
    }
}
