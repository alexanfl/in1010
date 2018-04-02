class Pasient {
    private String navn;
    private String fnr;
    private int id;

    static int idTeller = 0;

    Stabel<Resept> reseptliste;


    public Pasient(String navn, String fnr)
    {
        this.navn = navn;
        this.fnr = fnr;

        this.id = idTeller;
        oppdaterIdTeller();
    }


    void oppdaterIdTeller()
    {
        idTeller++;
    }


    Stabel<Resept> hentReseptliste()
    {
        return this.reseptliste;
    }


    void leggTilResept(Resept nyResept)
    {
        this.reseptliste.leggPaa(nyResept);
    }
}
