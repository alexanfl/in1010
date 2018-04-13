public class Lege implements Comparable<Lege>
{
    private String navn;
    private Lenkeliste<Resept> reseptliste;


    public Lege(String navn)
    {
        this.navn = navn;
        this.reseptliste = new Lenkeliste<Resept>();
    }   


    public String hentNavn()
    {
        return this.navn;
    }


    public void skrivUtLegeinformasjon()
    {
        System.out.println("Legeinformasjon\n---------------------");
        System.out.println("\tLegens navn: " + hentNavn());
        System.out.println();
    }


    public int compareTo(Lege l)
    {
        int resultatAvCompareTo = hentNavn().compareTo(l.hentNavn());
        return resultatAvCompareTo;
    }


    public Lenkeliste<Resept> hentReseptliste()
    {
        return this.reseptliste;
    }


    public void leggTilResept(Resept nyResept)
    {
        this.reseptliste.leggTil(nyResept);
    }
}
