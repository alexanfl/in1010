public class BlaaResept extends Resept
{
    private String reseptfarge = "blaa";


    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      Pasient pasient, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasient, reit);

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
