public class Lege 
{
    private String navn;


    public Lege(String navn)
    {
        this.navn = navn;
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
}
