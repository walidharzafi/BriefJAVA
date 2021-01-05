package sample;

public class Proprietaire {
    private int idProp;
    private String nom;
    private String prenom;
    private String adress;
    private String contact;

    public Proprietaire(){

    }
    public Proprietaire(int idProp, String nom, String prenom, String adress, String contact) {
        this.idProp = idProp;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.contact = contact;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
