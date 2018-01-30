/**
 * @author  Alexander Fleischer alexander.fleischer@fys.uio.no
 */

public class Node {
    private int antPros;
    private int minne;

    /**
     * Setter nodens minne og antall prosessorer.
     *
     * @param minne     Størrelsen på minnet til hver prosessor.
     * @param antPros   Antall prosessorer i node.
     */
    public Node(int minne, int antPros) {
        this.minne = minne; 
        this.antPros = antPros;
    }


    /**
     * @return Antallet prosessorer i noden.
     */
    public int antProsessorer() {
        // Hent antall prosessorer i noden.
        return this.antPros;
    }


    /**
     * @return Størrelsen på minnet til hver prosessor i noden.
     */
    public int antMinne() {
        // Hent størrelsen på nodens minne.
        return this.minne;
    }


    /**
     * Sjekker om noden har minne større eller lik påkrevd minne.
     *
     * @param paakrevdMinne Kravet til minnestørrelse.
     * @return              true hvis minnet er stort nok, ellers false.
     */
    public boolean nokMinne(int paakrevdMinne) {
        if (this.minne >= paakrevdMinne) {
            return true;
        } 
        return false;
    }
}
