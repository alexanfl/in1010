public class Militaerresept extends HvitResept 
{
    public Militaerresept(Legemiddel legemiddel, Lege utskrivendeLege, 
                      int pasientId, int reit)    
    {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    
    public double prisAaBetale()
    {
        return 0.;
    }
}
