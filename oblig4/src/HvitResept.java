public class HvitResept extends Resept
{
    private String reseptfarge = "hvit";


    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      int pasientId, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasientId, reit);

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
