import java.util.HashSet;

public class Parking {
    int placesOccupees;
    int capacite;
    public HashSet<Voiture> infoVoitures = new HashSet<Voiture>();

     Parking(int size) {
        this.capacite = size;
    }

     int places() {
        return (this.capacite - this.placesOccupees);
    }

    public synchronized boolean accept(Voiture myVoit) {
        if (placesOccupees < capacite) {
            placesOccupees++;
            infoVoitures.add(myVoit);
            return true;
        }
        return false;
    }

    public synchronized void leave(Voiture myVoit) {
        if (placesOccupees > 0) {
            placesOccupees--;
            infoVoitures.remove(myVoit);
        }
    }
}