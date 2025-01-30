package hotel;

public class Client {
    private String nom;
    private String mail;

    public Client(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    public String getNom() {
        return nom;
    }
}
