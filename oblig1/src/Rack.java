public class Rack {
    private int antNoder = 0;
    private int maksAntNoder;

    private boolean racketErFullt = false;

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
        oppdaterRacketErFullt();
    }


    public int antProsessorer() {

        int antPros = 0;

        for (int i = 0; i < antNoder; i++) {
            antPros += this.noder[i].antProsessorer();
        }

        return antPros;
    }


    public int noderMedNokMinne(int paakrevdMinne) {

        int antNoderMedNokMinne = 0;
        
        for (int i = 0; i < antNoder; i++) {
            if (this.noder[i].nokMinne(paakrevdMinne)) {
                antNoderMedNokMinne++;
            }
        }

        return antNoderMedNokMinne;
    }


    public void oppdaterRacketErFullt() {
        if (this.antNoder >= this.maksAntNoder) {
            this.racketErFullt = true;
        }
    }


    public boolean erFullt() {
        return this.racketErFullt;
    }
}
