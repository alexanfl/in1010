public class Node {
    private int antPros;
    private int minne;

    public Node(int minne, int antPros) {
        this.minne = minne; 
        this.antPros = antPros;
    }


    public int antProsessorer() {
        return this.antPros;
    }


    /**
     * @return Størrelsen på minnet til hver prosessor i noden.
     */
    public int antMinne() {
        return this.minne;
    }


    /**
     * Sjekker om noden har minne større eller lik påkrevd minne.
     */
    public boolean nokMinne(int paakrevdMinne) {
        if (this.minne >= paakrevdMinne) {
            return true;
        } 
        return false;
    }
}
