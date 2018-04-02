class Pasient {
    private String navn;
    private String fnr;
    private int id;

    static int idTeller = 0;


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
}
