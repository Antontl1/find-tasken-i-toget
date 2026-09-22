public record Taske (String farve, String beskrivelse){

    @Override
    public String toString() {
        return "en " + farve + " taske. Det er en " + beskrivelse;
    }
}
