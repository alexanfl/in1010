public class HvitResept extends Resept
{
    private String reseptfarge = "hvit";


    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      Pasient pasient, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasient, reit);

    }


    public double prisAaBetale()
    {
        return hentLegemiddel().hentPris();
    }


    public String farge()
    {
        return this.reseptfarge;    
    }
}
