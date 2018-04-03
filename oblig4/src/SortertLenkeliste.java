class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> 
{

    public SortertLenkeliste()
    {
        super();
    } 

    @Override
    public void leggTil(T x) 
    {
        Node<T> node = this.initNode;

        Node<T> nyNode = new Node<T>(x);

        if (stoerrelse() == 0) {
            node.settNeste(nyNode);
        }
        else {
            finnNyNodePlass(node, nyNode, x);
        }
        
        oekAntNoder();
    }

    public void finnNyNodePlass(Node<T> node, Node<T> nyNode, T x)
    {
        for (int i = 0; i < stoerrelse(); i++) {
            if (x.compareTo(node.hentNeste().hentNodeData()) < 0) {
                nyNode.settNeste(node.hentNeste());

                node.settNeste(nyNode);

                break;
            }
            else {
                node = node.hentNeste();
            }
            
        }
        
        node.settNeste(nyNode);
    }


    @Override
    public T fjern()
    {
        if (hentAntNoder() == 0) {
            throw new UgyldigListeIndeks(-1);
        }

        Node<T> node = this.initNode.hentNeste();

        for (int i = 0; i < stoerrelse() - 1; i++) {
            node = node.hentNeste();
        }

        reduserAntNoder();

        return node.hentNodeData();
    }


    /*
     * Ikke lov å sette inn element hvor som helst.
     */
    @Override
    public void sett(int pos, T x)
    {
        throw new UnsupportedOperationException();
    }
}
