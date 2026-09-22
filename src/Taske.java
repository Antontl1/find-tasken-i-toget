//En taske beskrevet ved sin farve og en kort beskrivelse.
//Som record får den automatisk farve(), beskrivelse(), equals() og hashCode(),
//så to tasker med samme farve og beskrivelse tæller som ens
public record Taske (String farve, String beskrivelse){

    //Pæn tekst der bruges når tasker skrives ud til brugeren
    @Override
    public String toString() {
        return "en " + farve + " taske. Det er en " + beskrivelse;
    }
}
