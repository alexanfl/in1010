class Main {
    public static void main (String[] args) {
        // Opprett nytt Regneklynge-objekt ved navn abel.
        Regneklynge abel = new Regneklynge(12);

        // Sett inn 650 noder med 64 GB minne og 1 prosessor.
        for (int i = 0; i < 650; i++) {
            abel.settInnNode(new Node(64, 1));
        }

        // Sett inn 16 noder med 1024 GB minne og 2 prosessorer.
        for (int i = 0; i < 16; i++) {
            abel.settInnNode(new Node(1024, 2));
        }

        System.out.println("\nNoder med minst 32 GB: " 
                            + abel.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " 
                            + abel.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " 
                            + abel.noderMedNokMinne(128) 
                            + "\n");

        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall racks: " + abel.antRacks());
    }
}
