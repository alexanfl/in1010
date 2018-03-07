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


    static void testNavn(String testVerdi, String forventet)
    {
        System.out.println("Sjekker om legemiddel heter '" + forventet + "'");
        assertEquals(forventet, testVerdi);
        System.out.println("\t…Suksess!\n");
    }


    static void testPris(double testVerdi, double forventet, double feilmargin)
    {
        System.out.println("Sjekker om legemiddel har pris=" + forventet);
        assertEquals(forventet, testVerdi, feilmargin);
        System.out.println("\t…Suksess!\n");
    }


    static void testVirkestoff(double testVerdi, double forventet, 
                               double feilmargin)
    {
        System.out.println("Sjekker om legemiddel har mengde virkestoff=" 
                           + forventet);
        assertEquals(forventet, testVerdi, feilmargin);
        System.out.println("\t…Suksess!\n");
    }



    static void testStyrke(int testVerdi, int forventet)
    {
        System.out.println("Sjekker om legemiddel har styrke=" + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t…Suksess!\n");
    }


    static void kjorFellesTester(Legemiddel legemiddel, String navn, 
                                 double pris, double virkestoff, double nyPris)
    {
        double feilmargin = 0.0001;

        testNavn(legemiddel.hentNavn(),  navn);
        testPris(legemiddel.hentPris(), pris, feilmargin);
        testVirkestoff(legemiddel.hentVirkestoff(), virkestoff, feilmargin);

        legemiddel.settNyPris(nyPris);
        testPris(legemiddel.hentPris(), nyPris, feilmargin);

    }


    //Overlasting av assertEquals pga. forskjellige typer av verdier.
    static boolean assertEquals(int forventet, int testVerdi)
    {
        if (forventet == testVerdi) {
           return true;
        }
        else {
            return false;
        }
    }


    static boolean assertEquals(String forventet, String testVerdi)
    {
        if (testVerdi.equals(forventet))  {
            return true;
        }
        else {
            return false;
        }
    }


    static boolean assertEquals(double forventet, double testVerdi, 
                                double feilmargin)
    {
        if (forventet <= testVerdi + feilmargin 
                && forventet >= testVerdi + feilmargin) {
           return true;
        }
        else {
            return false;
        }
    }
}
