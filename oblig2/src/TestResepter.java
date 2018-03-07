class TestResepter 
{
    public static void main (String [] args)
    {
        double testPris =  300.;
        double testNyPris = 100.;
        double testVirkestoff = 5.;
        double feilmargin = 0.0001;
        int testReit = 5;
        int testPasientId = 42;
        int testStyrke = 1;

        Lege testLege = new Lege("Lege Legesen");
        Legemiddel testLegemiddel = new LegemiddelA("testmiddel A", 
                                                    testPris, testVirkestoff, 
                                                    testStyrke);


        /*
        * Tester klasse BlaaResept.
        */
        Resept testBlaaResept = new BlaaResept(testLegemiddel, testLege, 
                                               testPasientId, testReit);

        // Tester om bruk-metoden senker reit.
        testBruk(testBlaaResept.bruk(), true);
        for (int i = 0; i < testReit; i++) {
            testReit(testBlaaResept.hentReit(), testReit - i - 1); 
            testBlaaResept.bruk();
        }
        testBruk(testBlaaResept.bruk(), false);



        // Tester at BlaaResept har 75 % rabatt.
        testPris(testBlaaResept.prisAaBetale(), 0.25*testPris, feilmargin);
        
        testFarge(testBlaaResept.farge(), "blaa");
        testPasientId(testBlaaResept.hentPasientId(), testPasientId);
        testId(testBlaaResept.hentId(), 0);



        /*
        * Tester klasse Militaerresept.
        */
        Resept testMilitaerResept = new Militaerresept(testLegemiddel, 
                                                       testLege, testPasientId,
                                                       testReit);

        testReit(testMilitaerResept.hentReit(), testReit); 

        // Tester at Militaerresept gir 100 % rabatt.
        testPris(testMilitaerResept.prisAaBetale(), 0., feilmargin);

        testFarge(testMilitaerResept.farge(), "hvit");
        testPasientId(testMilitaerResept.hentPasientId(), testPasientId);
        testId(testMilitaerResept.hentId(), 1);


        /*
        * Tester klasse PResept.
        */
        Resept testPResept = new PResept(testLegemiddel, testLege, 
                                         testPasientId, testReit);

        // Tester at PResept alltid har reit=3.
        testReit(testPResept.hentReit(), 3); 

        // Tester at PResept gir 116 kr rabatt.
        testPris(testPResept.prisAaBetale(), testPris - 116, feilmargin);
    
        // Tester om 116 kr rabatt på pris=100 kr blir 0 kr.
        testPResept.hentLegemiddel().settNyPris(testNyPris);
        testPris(testPResept.prisAaBetale(), 0., feilmargin);

        testFarge(testPResept.farge(), "hvit");
        testPasientId(testPResept.hentPasientId(), testPasientId);
        testId(testPResept.hentId(), 2);

    }    


    static void testReit(int testVerdi, int forventet)
    {
        System.out.println("Tester om resept har reit=" + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t… Suksess!\n");
    }


    static void testPris(double testVerdi, double forventet, 
                         double feilmargin)
    {
        System.out.println("Tester om resept har pris=" + forventet);
        assertEquals(forventet, testVerdi, feilmargin);
        System.out.println("\t… Suksess!\n");
    }


    static void testFarge(String testVerdi, String forventet)
    {
        System.out.println("Tester om reseptfargen er " + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t… Suksess!\n");
    }


    static void testId(int testVerdi, int forventet)
    {
        System.out.println("Tester om resept har id=" + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t… Suksess!\n");
    }


    static void testPasientId(int testVerdi, int forventet)
    {
        System.out.println("Tester om pasientens id=" + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t… Suksess!\n");
    }


    static void testBruk(boolean testVerdi, boolean forventet)
    {
        System.out.println("Tester om resepten kan brukes, forventet=" + forventet);
        assertEquals(forventet, testVerdi);
        System.out.println("\t… Suksess!\n");
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

    static boolean assertEquals(boolean forventet, boolean testVerdi)
    {
        if (forventet == testVerdi)  {
            return true;
        }
        else {
            return false;
        }
    }

}
