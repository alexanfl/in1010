/**
 * @author  Alexander Fleischer alexander.fleischer@fys.uio.no
 */

class Main {
    /**
     * Oppretter et Regneklynge-objekt med racks og setter inn noder.
     *
     * Hvis filnavn spesifiseres lages Re
     *
     * @param args
     *
     */
    public static void main (String[] args) {
        // Hvis ett kommandolinje-argument, gjør del 2 av oblig.
        if (args.length == 1) {

        // Regneklynge-objekt ved navn abel.
        Regneklynge abel = new Regneklynge(args[0]);

        System.out.println("Noder med minst 32 GB: " 
                            + abel.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " 
                            + abel.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " 
                            + abel.noderMedNokMinne(128) 
                            + "\n");

        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall racks: " + abel.antRacks());
        }
        // Hvis det ikke finnes kommandolinje-arg, gjør del 1 av oblig.
        else if (args.length == 0) {
            System.out.println("Henter ikke fra fil."
                               + " Bruk eventuelt >java Main $fil\n");

            // Oppretter ny Regneklynge abel med maksimalt 12 noder per rack.
            Regneklynge abel = new Regneklynge(12);

            // Sett inn 650 noder med 64 GB minne og 1 prosessor.
            for (int i = 0; i < 650; i++) {
                abel.settInnNode(new Node(64, 1));
            }

            // Sett inn 16 noder med 1024 GB minne og 2 prosessorer.
            for (int i = 0; i < 16; i++) {
                abel.settInnNode(new Node(1024, 2));
            }

            System.out.println("Noder med minst 32 GB: " 
                                + abel.noderMedNokMinne(32));
            System.out.println("Noder med minst 64 GB: " 
                                + abel.noderMedNokMinne(64));
            System.out.println("Noder med minst 128 GB: " 
                                + abel.noderMedNokMinne(128) 
                                + "\n");

            System.out.println("Antall prosessorer: " + abel.antProsessorer());
            System.out.println("Antall racks: " + abel.antRacks());

        }
        else {
            System.out.println("Maks ett filnavn. Bruk: >java Main $fil\n");
        }
    }
}
