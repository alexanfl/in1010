import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T>
{
    //Første element i listen. Protected så subklasse når den.
    protected Node<T> initNode;
    private int antNoder = 0;

    public Lenkeliste()
    {
        this.initNode = new Node<T>(null);
    }


    public void oekAntNoder()
    {
        this.antNoder++;
    }


    public void reduserAntNoder()
    {
        this.antNoder--;
    }


    public int hentAntNoder()
    {
        return this.antNoder;
    }


    public T fjern(int pos)
    {
        if (antNoder == 0) {
            throw new UgyldigListeIndeks(-1);
        }

        if (pos > antNoder - 1 || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }

        Node<T> node = this.initNode;

        for (int i = 0; i < pos; i++) {
            node = node.hentNeste();
        }

        Node<T> nesteNode = node.hentNeste();

        T nodeData = nesteNode.hentNodeData();

        node.settNeste(node.hentNeste().hentNeste());

        reduserAntNoder();     

        return nodeData;

    }


    public T fjern()
    {
        if (antNoder == 0) {
            throw new UgyldigListeIndeks(-1);
        }

        Node<T> node = this.initNode.hentNeste();

        this.initNode.settNeste(node.hentNeste());

        reduserAntNoder();

        return node.hentNodeData();
    }

    


    public int stoerrelse()
    {
        return this.antNoder;
    }


    /*
     * Legger til node på spesfikk plass.
     */
    public void leggTil(int pos, T x)
    {
        if (pos > this.antNoder || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }

        Node<T> node = this.initNode;

        for (int i = 0; i < pos; i++) {
            node = node.hentNeste();
        }

        Node<T> nyNode = new Node<T>(x);

        nyNode.settNeste(node.hentNeste());

        node.settNeste(nyNode);

        oekAntNoder();
    }


    /*
     * Legger til node sist.
     */
    public void leggTil(T x)
    {
        Node<T> node = initNode;

        while (node.hentNeste() != null) {
            node = node.hentNeste();
        }

        node.settNeste(new Node<T>(x));

        oekAntNoder();
    }


    public void sett(int pos, T x)
    {
        if (pos > antNoder - 1 || pos < 0 || antNoder == 0) {
            throw new UgyldigListeIndeks(pos);
        }

        Node<T> node = initNode.hentNeste();

        for (int i = 0; i < pos; i++) {
            node = node.hentNeste();
        }

        node.settNodeData(x);
    }


    public T hent(int pos)
    {
        if (antNoder == 0) {
            throw new UgyldigListeIndeks(-1);
        } 

        if (pos > antNoder - 1 || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }

        Node<T> node = this.initNode.hentNeste();

        for (int i = 0; i < pos; i++) {
            node = node.hentNeste();
        } 

        return node.hentNodeData();
    }


    public Iterator<T> iterator()
    {
        LenkelisteIterator<T> iterator = new LenkelisteIterator<T>(this.initNode);

        return iterator;
    }
}
