package hotel;

public class Chambre {
    private int numero;
    private String type;
    private boolean Disponible;

    public Chambre(int numero, String type) {
        this.numero = numero;
        this.type = type;
        this.Disponible = true;
    }
    public int getNumero() {
        return numero;
    }
    public String getType() {
        return type;
    }
    public boolean Disponible() {
        return Disponible;
    }
    public void reserver(){
        this.Disponible = false;
    }
    public void liberer(){
        this.Disponible = true;
    }
}
