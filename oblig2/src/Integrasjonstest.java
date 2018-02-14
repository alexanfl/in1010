class Integrasjonstest 
{
    public static void main (String [] args)
    {
        int pasientId1 = 42;
        int pasientId2 = 43;
        int pasientId3 = 44;

        Fastlege fastlege           = new Fastlege("Ola Fastlege", 1); 

        LegemiddelA smertestillende = new LegemiddelA("Morfin", 1000., 10., 5);
        LegemiddelB angstdempende   = new LegemiddelB("Sobril", 500., 15., 7);
        Legemiddel ppiller          = new LegemiddelC("Microgynon", 150., 150.);

        BlaaResept blaa = new BlaaResept(angstdempende, fastlege, pasientId1, 5);
        Militaerresept militaer = new Militaerresept(smertestillende, fastlege, 
                                                     pasientId2, 10);
        PResept pResept = new PResept(ppiller, fastlege, pasientId1, 5);


        testLegemiddel(blaa.hentLegemiddel());
        testLegemiddel(militaer.hentLegemiddel());
        testLegemiddel(pResept.hentLegemiddel());

        testLegemiddel(smertestillende);

    }    

    /*
     * Samme metodenavn/metodeoverlasting for å teste subklasser.
     */
    static void testLegemiddel(Legemiddel legemiddel)
    {
        skrivUtLegemiddelInformasjon(legemiddel);
        System.out.println("\n");
    }


    static void testLegemiddel(LegemiddelA legemiddel)
    {
        skrivUtLegemiddelInformasjon(legemiddel);
        System.out.println("\tNarkotisk styrke: " + legemiddel.hentNarkotiskStyrke());
        System.out.println("\n");
    }


    static void testLegemiddel(LegemiddelB legemiddel)
    {
        skrivUtLegemiddelInformasjon(legemiddel);
        System.out.println("\tVanedannende styrke: " + legemiddel.hentVanedannendeStyrke());
        System.out.println("\n");
    }


    static void skrivUtLegemiddelInformasjon(Legemiddel legemiddel)
    {
        System.out.println("Legemiddelinformasjon\n---------------------");
        System.out.println("\tNavn: " + legemiddel.hentNavn());
        System.out.println("\tID: " + legemiddel.hentId());
        System.out.println("\tMengdevirkestoff: " + legemiddel.hentVirkestoff());
    }
}
