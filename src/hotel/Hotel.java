package hotel;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Hotel> hotels= new ArrayList<Hotel>();
    private String nom;
    private String adresse;
    private String ville;
    private ArrayList<Chambre> chambre;
    private ArrayList<Reserver> reservations;

    public Hotel(String nom, String adresse, String ville) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.chambre = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void ajouterChambre(Chambre chambre1) {
        this.chambre.add(chambre1);
    }

    public void afficherChambresDisponibles() {
        System.out.println("Chambres disponibles dans " + nom +":");
        for (Chambre chambre : chambre) {
            if (chambre.Disponible()) {
                System.out.println("Chambre" +chambre.getNumero() + "de type" +chambre.getType());
            }
        }
    }

    public void reserverChambre(Client client, Chambre chambre, String dateDebut, String dateFin) {
        if(chambre.Disponible()) {
            chambre.reserver();
            Reserver reservation = new Reserver(client, chambre, dateDebut, dateFin);
            reservations.add(reservation);
            System.out.println("Réservation effectuée pour " + client.getNom() + "dans la chambre" + chambre.getNumero());
        }else{
            System.out.println("La chambre"+chambre.getNumero()+" est deja reservé");
        }
    }

    public void afficherReservations() {
        System.out.println ("Réservations dans " + nom + ":");
        for (Reserver reservation : reservations) {
            System.out.println("Client: "+ reservation.getClient().getNom() + ",Chambre" + reservation.getChambre().getNumero() + ", Dates: " + reservation.getDateDebut() + " - " + reservation.getDateFin());
        }
    }

    public void changerAffectation(Client client, Chambre chambreAvant, Chambre chambreAprès) {
        for (Reserver reservation : reservations) {
            if (reservation.getClient().equals(client) && reservation.getChambre().equals(chambreAvant)) {
                reservation.setChambre(chambreAprès);
                chambreAvant.liberer();
                chambreAprès.reserver();
                System.out.println("Changement de réservation effectué : " + client.getNom() + " a changé de chambre.");
                return;
            }
        }
        System.out.println("Aucune réservation trouvée pour ce client dans cette chambre.");
    }

    public void supressionReservation(Client client, Chambre chambre) {
        reservations.removeIf(reservation -> reservation.getClient().equals(client) && reservation.getChambre().equals(chambre));
        chambre.liberer();
        System.out.println("Réservation supprimée pour " + client.getNom() + " dans la chambre " + chambre.getNumero());
    }
}
