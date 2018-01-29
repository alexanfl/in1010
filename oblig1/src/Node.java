public class Node {
    private int antPros;
    private int minne;


    public Node(int minne, int antPros) {
        // Sett nodens minne og antall prosessorer.
        this.minne = minne; 
        this.antPros = antPros;
    }


    public int antProsessorer() {
        // Hent antall prosessorer i noden.
        return this.antPros;
    }


    public int antMinne() {
        // Hent størrelsen på nodens minne.
        return this.minne;
    }


    public boolean nokMinne(int paakrevdMinne) {
        // Sjekk om noden har minne større eller lik enn påkrevd minne.
        if (this.minne >= paakrevdMinne) {
            return true;
        } 

        return false;
    }
}
