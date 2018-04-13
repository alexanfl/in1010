class Pasient {
    private String navn;
    private String fnr;
    private int id;

    static int idTeller = 0;

    Stabel<Resept> reseptliste = new Stabel<>();


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


    public void skrivUtPasientinformasjon()
    {
        System.out.println("Pasientinformasjon\n---------------------");
        System.out.println("\tNavn: " + this.navn);
        System.out.println("\tID: " + this.id);
        System.out.println("\tFødselsnummer: " + this.fnr);
        System.out.println();
    }


    public String hentNavn()
    {
        return this.navn;
    }


    public int hentId()
    {
        return this.id;
    }


    public String hentFnr()
    {
        return this.fnr;
    }

}
