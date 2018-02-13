public class PResept extends HvitResept 
{
    private int reit = 3;


    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      int pasientId, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasientId, reit);

        oppdaterReit(3);

    }

    
    public double prisAaBetale()
    {
        return Math.max(hentLegemiddel().hentPris() - 116, 0);
    }
}
