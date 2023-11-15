public class Main {
    public static void main(String[] args) {
        int tailleParking = 8;
        int nbVoitures = 15;
        Parking leParking = new Parking(tailleParking);
        Thread[] mesVoitures = new Thread[nbVoitures];

        for (int i = 0; i < nbVoitures; i++) {
            mesVoitures[i] = new Thread(new Voiture(String.format("Voiture %d ", i), leParking));
            mesVoitures[i].start();
        }
    }
}