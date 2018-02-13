import org.junit.Test;
import static org.junit.Assert.assertEquals;

class TestLegemiddel 
{
    public static void main (String [] args)
    {
        String navn;
        double pris;
        double nyPris;
        double virkestoff;
        int styrke;

        // Tester for klasse LegemiddelA
        navn = "Testlegemiddel A";
        pris = 300.;
        nyPris = 350.;
        virkestoff = 6.;
        styrke = 9;

        LegemiddelA testerA = new LegemiddelA("Testlegemiddel A", 
                                              pris, virkestoff, styrke);
        kjorFellesTester(testerA,  navn, pris, virkestoff, nyPris);

        testStyrke(testerA.hentNarkotiskStyrke(), styrke);


        // Tester for klasse LegemiddelB
        navn = "Testlegemiddel B";
        pris = 500.;
        nyPris = 490.;
        virkestoff = 5.;
        styrke = 1;

        LegemiddelB testerB = new LegemiddelB("Testlegemiddel B", 
                                              pris, virkestoff, styrke);
        kjorFellesTester(testerB,  navn, pris, virkestoff, nyPris);

        testStyrke(testerB.hentVanedannendeStyrke(), styrke);


        // Tester for klasse LegemiddelC
        navn = "Testlegemiddel C";
        pris = 750.;
        nyPris = 999.;
        virkestoff = 100.;

        LegemiddelC testerC = new LegemiddelC("Testlegemiddel C", 
                                              pris, virkestoff);
        kjorFellesTester(testerC,  navn, pris, virkestoff, nyPris);
    }


    @Test
    static void testNavn(String testVerdi, String resultat)
    {
        System.out.println("Sjekker om legemiddel heter '" + resultat + "'");
        assertEquals(testVerdi, resultat);
        System.out.println("\t…Suksess!\n");
    }


    @Test
    static void testPris(double testVerdi, double resultat, double feilmargin)
    {
        System.out.println("Sjekker om legemiddel har pris=" + resultat);
        assertEquals(testVerdi, resultat, feilmargin);
        System.out.println("\t…Suksess!\n");
    }


    @Test
    static void testVirkestoff(double testVerdi, double resultat, 
                               double feilmargin)
    {
        System.out.println("Sjekker om legemiddel har mengde virkestoff=" 
                           + resultat);
        assertEquals(testVerdi, resultat, feilmargin);
        System.out.println("\t…Suksess!\n");
    }



    @Test
    static void testStyrke(int testVerdi, int resultat)
    {
        System.out.println("Sjekker om legemiddel har styrke=" + resultat);
        assertEquals(testVerdi, resultat);
        System.out.println("\t…Suksess!\n");
    }


    static void kjorFellesTester(Legemiddel legemiddel, String navn, 
                                 double pris, double virkestoff, double nyPris)
    {
        testNavn(legemiddel.hentNavn(),  navn);
        testPris(legemiddel.hentPris(), pris, 0.0001);
        testVirkestoff(legemiddel.hentVirkestoff(), virkestoff, 0.0001);

        legemiddel.settNyPris(nyPris);
        testPris(legemiddel.hentPris(), nyPris, 0.0001);

    }
}
