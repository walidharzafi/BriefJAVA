package sample;

public class Immobilier {
    private int id;
    private String type;
    private String surface;
    private String adress;
    private int prix;

    public Immobilier(){

    }
    public Immobilier(int id, String type, String surface, String adress, int prix) {
        this.id = id;
        this.type = type;
        this.surface = surface;
        this.adress = adress;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
