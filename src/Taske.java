public class Taske {
    private String farve;
    private String beskrivelse;

    public Taske(String farve, String beskrivelse) {
        this.farve = farve;
        this.beskrivelse = beskrivelse;
    }

    public String getFarve() {
        return farve;
    }

    public String getBeskrivelse(){
        return beskrivelse;
    }

    @Override
    public String toString() {
        return "en " + farve + " taske. Det er en " + beskrivelse;
    }
}
