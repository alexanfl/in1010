public class Legemiddel 
{
    private String navn;
    private int id;
    private double pris;
    private double virkestoff;

    static int idTeller;


    public Legemiddel(String navn, double pris, double virkestoff)
    {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff; 

        this.id = idTeller;
        oppdaterIdTeller();
    } 

    
    public String hentNavn()
    {
        return this.navn;
    }

    
    public int hentId()
    {
        return this.id;
    }


    public double hentPris()
    {
        return this.pris;
    }

    
    public double hentVirkestoff()
    {
        return this.virkestoff;
    }

    
    public void settNyPris(double nyPris)
    {
        this.pris = nyPris;
    }


    void oppdaterIdTeller()
    {
        idTeller++;
    }


    public void skrivUtLegemiddelinformasjon()
    {
        System.out.println("Legemiddelinformasjon\n---------------------");
        System.out.println("\tNavn: " + hentNavn());
        System.out.println("\tID: " + hentId());
        System.out.println("\tMengdevirkestoff: " + hentVirkestoff());
        System.out.println();
    }
}
