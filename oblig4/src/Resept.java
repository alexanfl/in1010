public abstract class Resept {
    private Legemiddel legemiddel;
    private Lege utskrivendeLege;
    private int id;
    private int pasientId;
    private int reit;
    private Pasient p;

    static int idTeller = 0;

    
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient p, 
                  int reit)
    {
        this.legemiddel = legemiddel;

        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        this.p = p;

        this.id = idTeller;
        oppdaterIdTeller();

        this.p.leggTilResept(this);
        this.utskrivendeLege.leggTilResept(this);
    }


    abstract public String farge();
    abstract public double prisAaBetale();


    public int hentId()
    {
        return this.id;
    }


    public int hentReit()
    {
        return this.reit;
    }

    public int hentPasientId()
    {
        return this.pasientId;
    }


    public Lege hentLege()
    {
        return this.utskrivendeLege;
    }


    public Legemiddel hentLegemiddel()
    {
        return this.legemiddel;
    }


    public void oppdaterReit(int nyVerdi)
    {
        this.reit = nyVerdi;
    }


    public boolean bruk()
    {
        if (hentReit() > 0) {
            oppdaterReit(this.reit - 1);
            return true;
        }
        else {
            return false;
        }
    }


    void oppdaterIdTeller()
    {
        idTeller++;
    }


    void skrivUtReseptinformasjon()
    {
        System.out.println("Reseptinformasjon\n---------------------");
        System.out.println("\tID: " + hentId());
        System.out.println("\tFarge: " + farge());
        System.out.println("\tReit: " + hentReit());
        System.out.println("\tPasientID: " + hentPasientId());
        System.out.println();
    }
}
