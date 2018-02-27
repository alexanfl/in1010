public class LegemiddelB extends Legemiddel
{
    private int styrke;


    public LegemiddelB(String navn, double pris, double virkestoff, int styrke)
    {
        super(navn, pris, virkestoff);

        this.styrke = styrke;
    }


    public int hentVanedannendeStyrke()
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
        System.out.println("\tVanedannende styrke: " + this.styrke);
        System.out.println();
    }
}
