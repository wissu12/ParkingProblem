public class Voiture implements Runnable {
    String nom;
    Parking park;

    public Voiture(String name, Parking park) {
        this.nom = name;
        this.park = park;
    }

    public void run() {
        while (true) {
            seDeplacerExterieur();
            if (park.accept(this)) {
                rentrerParking();
                seGarer();
                sortirParking();
                park.leave(this);
            } else {
                System.out.println(nom + " ne peut pas rentrer dans le parking. Pas de place disponible.");
            }
        }
    }

    private void seDeplacerExterieur() {
        System.out.println(nom + " se déplace à l'extérieur.");
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void rentrerParking() {
        System.out.println(nom + " demande l'accès au parking.");
    }

    private void seGarer() {
        System.out.println(nom + " rentre dans le parking et se gare.");
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sortirParking() {
        System.out.println(nom + " sort du parking.");
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}