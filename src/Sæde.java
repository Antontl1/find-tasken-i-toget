//Et sæde i en togvogn. Kan enten være tomt eller have en glemt taske liggende
public class Sæde {
    //Tasken der ligger på sædet. Er null hvis sædet er tomt
    private Taske taske;

    //Lægger en taske på sædet
    public void setTaske(Taske taske) {
        this.taske = taske;
    }

    //Henter tasken på sædet (null hvis der ikke ligger nogen)
    public Taske getTaske() {
        return taske;
    }

}
