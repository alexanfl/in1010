public class BlaaResept extends Resept
{
    private String reseptfarge = "blaa";


    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      int pasientId, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasientId, reit);

    }


    public double prisAaBetale()
    {
        return 0.25*(hentLegemiddel().hentPris());
    }


    public String farge()
    {
        return this.reseptfarge;    
    }
}
