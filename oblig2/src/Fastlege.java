public class Fastlege extends Lege implements Kommuneavtale
{
    private int avtalenummer;


    public Fastlege(String navn, int avtalenummer)
    {
        super(navn);
        this.avtalenummer = avtalenummer;
    }


    public int hentAvtalenummer()
    {
        return this.avtalenummer;
    }

    
    @Override
    public void skrivUtLegeinformasjon()
    {
        System.out.println("Fastlegeinformasjon\n---------------------");
        System.out.println("\tLegens navn: " + hentNavn());
        System.out.println("\tLegens avtalenummer: " + hentAvtalenummer());
        System.out.println();
    }
}
