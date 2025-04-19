package INSA.TD.models;

public class Operateur extends Personne {

    private boolean libre;

    public Operateur(String id, String nom, String prenom) {
        this.setIdPersonne(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.libre = true;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
