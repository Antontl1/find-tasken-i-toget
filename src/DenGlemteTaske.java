


public class DenGlemteTaske {
    public void startEftersøgning() {
        Tog tog = new Tog();
        Togvogn denFørsteVogn = tog.getDenFørsteVogn();

        Mille mille = new Mille(denFørsteVogn);
        boolean taskenErFundet = false;
        String taskenHunLederEfter = "rød";
        IO.println("Mille har glemt sin taske i toget. Toget holder nu ved endestationen og hun er gået ind i første vogn for at lede efter den.");
        IO.println("Du kan hjælpe hende med at lede efter tasken ved at bruge nogle simple kommandoer:");
        IO.println("Skriv HVOR for at finde ud af hvor Mille er, KIG for at få hende til at se efter tasken,og VIDERE for at få hende til at gå ind i den næste vogn");

        while (!taskenErFundet) {

            String kommando = IO.readln();

            switch (kommando) {
                case "HVOR" -> {
                    IO.println("Hej Mille! Hvor er du nu?");
                    IO.println("Jeg er i vogn nummer " + mille.hvorErDu());
                }
                case "KIG" -> {
                    IO.println("Kan du se om tasken er der?");
                    if (mille.erTaskenDer(taskenHunLederEfter)) {
                        IO.println("Ja, jeg fandt den!");
                        taskenErFundet = true;
                    } else {
                        IO.println("Nej, desværre, den var ikke i den her vogn.");
                        IO.println("Her er " + mille.kanDuSeNogenTasker());
                    }

                }
                case "VIDERE" -> {
                    System.out.println("Du må hellere prøve at kigge i den næste vogn...");
                    System.out.println("Ja, det vil jeg gøre. Så håber jeg virkelig at den er dér.");
                    mille.gåIndINæsteVogn();
                }
            }
        }

    }

}
