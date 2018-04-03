public class LegemiddelA extends Legemiddel
{
    private int styrke;


    public LegemiddelA(String navn, double pris, double virkestoff, int styrke)
    {
        super(navn, pris, virkestoff);

        this.styrke = styrke;
    }


    public int hentNarkotiskStyrke()
    {
        return this.styrke;
    }


    @Override
    public void skrivUtLegemiddelinformasjon()
    {
        System.out.println("Legemiddelinformasjon\n---------------------");
        System.out.println("\tNavn: " + hentNavn());
        System.out.println("\tID: " + hentId());
        System.out.println("\tMengdevirkestoff: " + hentVirkestoff());
        System.out.println("\tNarkotisk styrke: " + this.styrke);
        System.out.println();
    }
}
