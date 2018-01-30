/**
 * @author Alexander Fleischer alexander.fleischer@fys.uio.no
 */

public class Rack {
    // Antallet noder i racket for øyeblikket.
    private int antNoder = 0;
    // Det maksimale antallet noder et Rack-objekt kan holde.
    private int maksAntNoder;

    // Holder styr på om racket er fullt.
    private boolean full = false;

    // Velger å bruke en vanlig array fordi antall noder er kjent.
    private Node[] noder;


    /**
     * Setter maksAntNoder fra argument og oppretter en liste av Node-objekter.
     *
     * @param maksAntNoder
     */
    public Rack(int maksAntNoder) {
        this.maksAntNoder = maksAntNoder;
        this.noder = new Node[maksAntNoder];
    }


    /**
    * @return antallet noder i racket.
    */
    public int getAntNoder() {
        return antNoder;
    }


    /**
     * Setter inn en ny node i racket, øker antall noder i racks
     * og sjekker om racket nå er fullt.
     *
     * @param nyNode
     */
    public void settInn(Node nyNode) {
        this.antNoder++; 
        this.noder[antNoder - 1] = nyNode;
        oppdaterFull();
    }


    /**
     * Henter ut antall prosessorer ved å iterere over alle noder i racket.
     *
     * @return Antallet prosessorer i racket.
     */
    public int antProsessorer() {

        int antPros = 0;

        // Itererer over nodene i racket og legger sammen antallet prosessorer.
        for (int i = 0; i < antNoder; i++) {
            antPros += this.noder[i].antProsessorer();
        }

        return antPros;
    }


    /**
     * Sjekker hvilke noder i racket som har nok påkrevd minne.
     *
     * @param paakrevdMinne Kravet til hvor stort minne hver prosessor skal ha.
     * @return              Antallet noder med nok påkrevd minne.
    */
    public int noderMedNokMinne(int paakrevdMinne) {

        // Variabel som økes med én for hver node med nok minne.
        int antNoderMedNokMinne = 0;
        
        // Itererer over nodene i racket og sjekker hvilke som har nok minne.
        for (int i = 0; i < antNoder; i++) {
            if (this.noder[i].nokMinne(paakrevdMinne)) {
                antNoderMedNokMinne++;
            }
        }

        return antNoderMedNokMinne;
    }


    /**
    * Sjekker om racket er fullt og oppdaterer full.
    */
    public void oppdaterFull() {
        if (this.antNoder >= this.maksAntNoder) {
            this.full = true;
        }
    }


    /**
    * @return true hvis racket er fullt.
    */
    public boolean erFull() {
        return this.full;
    }
}
