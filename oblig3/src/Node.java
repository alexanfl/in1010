class Node<T> 
{
    private T nodeData;    
    private Node<T> neste;


    public Node(T nodeData)
    {
        this.neste = null;
        this.nodeData  = nodeData;
    }


    public T hentNodeData()
    {
        return this.nodeData;
    }

    
    public Node<T> hentNeste()
    {
        return this.neste;
    }


    public void settNodeData(T nyData)
    {
        this.nodeData = nyData;
    }


    public void settNeste(Node<T> nyNeste)
    {
        this.neste = nyNeste;
    }
}
