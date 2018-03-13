class Stabel<T> extends Lenkeliste<T>
{
    public Stabel()
    {
        super();
    }


    public void leggPaa(T x)
    {
        super.leggTil(x);
    }


    public T taAv()
    {
        T nodeData = super.fjern(super.stoerrelse() - 1);

        return nodeData;
    }
}
