public class Rack {
    private int antNoder = 0;
    private int maksAntNoder;

    private boolean full = false;

    // Velger å bruke en vanlig array fordi antall noder er kjent.
    private Node[] noder;


    public Rack(int maksAntNoder) {
        this.maksAntNoder = maksAntNoder;
        this.noder = new Node[maksAntNoder];
    }


    public int getAntNoder() {
        /*
        * Returnerer antallet noder i racket.
        */

        return antNoder;
    }


    public void settInn(Node nyNode) {
        /*
         * Setter inn en ny node i racket, øker antall noder i racks
         * og sjekker om racket nå er fullt.
        */

        this.antNoder++; 
        this.noder[antNoder - 1] = nyNode;
        oppdaterFull();
    }


    public int antProsessorer() {
        /*
         * Henter ut antall prosessorer ved å iterere over alle noder i racket.
        */

        int antPros = 0;

        // Itererer over nodene i racket og legger sammen antallet prosessorer.
        for (int i = 0; i < antNoder; i++) {
            antPros += this.noder[i].antProsessorer();
        }

        return antPros;
    }


    public int noderMedNokMinne(int paakrevdMinne) {
        /*
         * Sjekker hvilke noder i racket som har nok påkrevd minne
         * og returnerer antallet.
        */

        int antNoderMedNokMinne = 0;
        
        // Itererer over nodene i racket og sjekker hvilke som har nok minne.
        for (int i = 0; i < antNoder; i++) {
            if (this.noder[i].nokMinne(paakrevdMinne)) {
                antNoderMedNokMinne++;
            }
        }

        return antNoderMedNokMinne;
    }


    public void oppdaterFull() {
        /*
        * Sjekker om racket er fullt.
        */

        if (this.antNoder >= this.maksAntNoder) {
            this.full = true;
        }
    }


    public boolean erFull() {
        /*
        * Returnerer true hvis racket er fullt.
        */

        return this.full;
    }
}

