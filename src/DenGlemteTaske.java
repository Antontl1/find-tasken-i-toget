

//Styrer selve spillet: skriver beskeder ud, læser brugerens kommandoer
//og holder eftersøgningen i gang indtil tasken er fundet eller toget er slut
public class DenGlemteTaske {

    public void startEftersøgning() {
        //Bygger toget og sætter Mille ind i den første vogn
        Tog tog = new Tog();
        Togvogn denFørsteVogn = tog.getDenFørsteVogn();
        Mille mille = new Mille(denFørsteVogn);
        //Vuderer om eftersøgningen stadig er i gang
        boolean eftersøgningenErSlut = false;
        //Den taske spillet handler om. Skal matche en af taskerne i Tog for at kunne findes
        Taske taskenHunLederEfter = new Taske ("hvid","bæltetaske");
        IO.println("Mille har glemt sin taske i toget. Det er en "+ taskenHunLederEfter.farve() + " "+ taskenHunLederEfter.beskrivelse() +". Toget holder nu ved endestationen og hun er gået ind i første vogn for at lede efter den.");
        IO.println("Du kan hjælpe hende med at lede efter tasken ved at bruge nogle simple kommandoer:");
        IO.println("Skriv HVOR for at finde ud af hvor Mille er, KIG for at få hende til at se efter tasken,og VIDERE for at få hende til at gå ind i den næste vogn: ");

        //mens boolean er true
        while (!eftersøgningenErSlut) {

            //Læser en linje fra brugeren. Der skal skrives med STORE bogstaver for at ramme en case
            String kommando = IO.readln();

            //Menu med valgmuligheder der tager parameteret kommando til at vægle en mulighed
            //f.eks. "KIG" menuen, hvis man vælger den.
            switch (kommando) {
                case "HVOR" -> {
                    IO.println("Hej Mille! Hvor er du nu?");
                    IO.println("Jeg er i vogn nummer " + mille.hvorErDu());
                }
                case "KIG" -> {
                    IO.println("Kan du se om tasken er der?");
                    //Er den rigtige taske i vognen? Så er spillet vundet
                    if (mille.erTaskenDer(taskenHunLederEfter)) {
                        IO.println("Ja, jeg fandt den!");
                        IO.println("Den lå i vogn "+mille.hvorErDu()+ " på sæde "+ mille.påHvilketSædeLåTasken(taskenHunLederEfter));
                        eftersøgningenErSlut = true;
                    } else {
                        //Ellers får spilleren et hint: hvilke andre tasker ligger her
                        IO.println("Nej, desværre, den var ikke i den her vogn.");
                        IO.println("Her er " + mille.kanDuSeNogenTasker());
                    }

                }
                case "VIDERE" -> {
                    IO.println("Du må hellere prøve at kigge i den næste vogn...");
                    IO.println("Ja, det vil jeg gøre. Så håber jeg virkelig at den er dér.");
                    //gåIndINæsteVogn giver false hvis der ikke er flere vogne, altså spillet tabt
                    if(!mille.gåIndINæsteVogn()){
                        IO.println("Næ, hov. Det var den sidste vogn. Toget er ikke længere. Så har jeg vist mistet den taske...");
                        eftersøgningenErSlut=true;
                    }
                }
            }
        }

    }

}
