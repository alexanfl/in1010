import java.util.Iterator;

class LenkelisteIterator<T> implements Iterator<T> {
    private Node<T> forrigeNode;
    private Node<T> node;


    LenkelisteIterator(Node<T> startNode)
    {
        this.node = startNode;
    } 


    public void remove()
    {
        
    }

    public T next()
    {
        this.forrigeNode = this.node;
        this.node = node.hentNeste();
        return node.hentNodeData();
    }

    public boolean hasNext()
    {
        if (node.hentNeste() == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
