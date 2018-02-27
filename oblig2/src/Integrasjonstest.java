class Integrasjonstest 
{
    public static void main (String [] args)
    {
        int pasientId1 = 42;
        int pasientId2 = 43;
        int pasientId3 = 44;

        Fastlege fastlege           = new Fastlege("Ola Fastlege", 1); 
        Lege lege                   = new Lege("Kari Sykehuslege"); 

        LegemiddelA smertestillende = new LegemiddelA("Morfin", 1000., 10., 5);
        LegemiddelB angstdempende   = new LegemiddelB("Sobril", 500., 15., 7);
        Legemiddel ppiller          = new LegemiddelC("Microgynon", 150., 150.);

        BlaaResept blaa = new BlaaResept(angstdempende, fastlege, pasientId1, 5);
        Militaerresept militaer = new Militaerresept(smertestillende, lege, 
                                                     pasientId2, 10);
        PResept pResept = new PResept(ppiller, fastlege, pasientId3, 5);

        testResept(blaa);
        testResept(militaer);
        testResept(pResept);

        

    }    


    static void testLegemiddel(Legemiddel legemiddel)
    {
        legemiddel.skrivUtLegemiddelinformasjon();
    }


    static void testLege(Lege lege)
    {
        lege.skrivUtLegeinformasjon();
    }


    static void testResept(Resept resept)
    {
        System.out.println();
        System.out.println("--------- Resepttest ---------");
        System.out.println();
        resept.skrivUtReseptinformasjon();
        testLege(resept.hentLege());
        testLegemiddel(resept.hentLegemiddel());
        System.out.println("------------------------------");
        System.out.println();
    }

}
