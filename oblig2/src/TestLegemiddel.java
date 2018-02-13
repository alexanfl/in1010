import org.junit.Test;
import static org.junit.Assert.assertEquals;

class TestLegemiddel {
    public static void main (String [] args)
    {
        // Tester for klasse LegemiddelA
        LegemiddelA testerA = new LegemiddelA("Testlegemiddel A", 300., 6., 9);
        testNavn(testerA.hentNavn(), "Testlegemiddel A");
        testPris(testerA.hentPris(), 300., 0.0001);
        testVirkestoff(testerA.hentVirkestoff(), 6., 0.0001);
        testStyrke(testerA.hentNarkotiskStyrke(), 9);

        testerA.settNyPris(350.);
        testPris(testerA.hentPris(), 350., 0.0001);


        // Tester for klasse LegemiddelB
        LegemiddelB testerB = new LegemiddelB("Testlegemiddel B", 500., 5., 1);
        testNavn(testerB.hentNavn(), "Testlegemiddel B");
        testPris(testerB.hentPris(), 500., 0.0001);
        testVirkestoff(testerB.hentVirkestoff(), 5., 0.0001);
        testStyrke(testerB.hentVanedannendeStyrke(), 1);

        testerB.settNyPris(550.);
        testPris(testerB.hentPris(), 550., 0.0001);


        // Tester for klasse LegemiddelC
        LegemiddelC testerC = new LegemiddelC("Testlegemiddel C", 750., 100.);
        testNavn(testerC.hentNavn(), "Testlegemiddel C");
        testPris(testerC.hentPris(), 750., 0.0001);
        testVirkestoff(testerC.hentVirkestoff(), 100., 0.0001);

        testerC.settNyPris(840.);
        testPris(testerC.hentPris(), 840., 0.0001);

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

}
