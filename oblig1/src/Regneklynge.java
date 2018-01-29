import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Regneklynge {
    private int noderPerRack;

    // Velger å bruke en ArrayList fordi antall Racks ikke er kjent.
    private ArrayList<Rack> racks = new ArrayList<Rack>();


    public Regneklynge(int noderPerRack) {
        /*
         * Konstruktør fra første del av oppgaven.
         * Oppretter en regneklynge med et antall noder per rack.
         * Kan deretter sette inn noder med settInnNode-metoden.
        */
        
        this.noderPerRack = noderPerRack;
    }


    public Regneklynge(String filnavn) {
        /*
         * Konstruktør for andre del av oppgaven.
         * Oppretter en regneklynge fra informasjon i input-fil.
        */

        settInnFraFil(filnavn);
    }


    public void settInnFraFil(String filnavn) {
        /*
         * Åpner fil, henter ut noderPerRack fra første linje i fila.
         * Hver linje etter dette brukes til å sette inn et antall noder
         * med git antall prosessorer og minne.
        */

        int antNoderPerLinje, tmpAntMinne, antProsPerLinje;

        // Se om fil eksisterer. Exception hvis ikke.
        try (Scanner scanner = new Scanner(new File(filnavn))) {
            // Sett noderPerRack lik første int i fila.
            this.noderPerRack = scanner.nextInt();

            // Hent ut antall noder, minne og prosessorer fra en linje i fila.
            while(scanner.hasNext()) {
                antNoderPerLinje = scanner.nextInt();
                tmpAntMinne = scanner.nextInt();
                antProsPerLinje  = scanner.nextInt();

                // Sett inn noder.
                for (int i = 0; i < antNoderPerLinje; i++) {
                    this.settInnNode(new Node(tmpAntMinne, antProsPerLinje));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fil " + "\'" + filnavn + "\'" 
                                + " finnes ikke.");
        }
    }


    public void opprettRack() {
        /*
         * Oppretter et nytt Rack-objekt og legger det i ArrayList-en racks.
         * Oppdaterer totalt antall racks.
        */

        this.racks.add(new Rack(this.noderPerRack));
    }


    public void settInnNode(Node nyNode) {
        /*
         * Setter inn nyNode i et rack. Hvis det ikke finnes et rack
         * eller om alle rackene er fulle opprettes et nytt. 
        */

        // Sjekker om det finnes racks og om det nyeste racket er fullt.
        if (this.racks.size() == 0) {
            opprettRack();
        }
        else if (this.racks.get(this.racks.size() - 1).erFull()) {
            opprettRack();
        }

        // Setter inn nyNode i racket.
        this.racks.get(this.racks.size() - 1).settInn(nyNode);
    }


    public int antProsessorer() {
        /*
         * Henter ut antall prosessorer ved å iterere over alle racks
         * i ArrayList-en og kalle Rack-objektets antProsessorer-metode.
        */

        int antPros = 0;

        // Sjekker antall prosessorer i rack.
        for (int i = 0; i < this.racks.size(); i++) {
            antPros += this.racks.get(i).antProsessorer();   
        }

        return antPros;
    }


    public int noderMedNokMinne(int paakrevdMinne) {
        /*
         * Henter ut antall noder i regneklyngen som har nok påkrevd minne
         * ved å iterere over alle rackene i ArrayList-en og kalle
         * Rack-objektets noderMedNokMinne-metode.
        */

        int antNoderMedNokMinne = 0;

        // Sjekker antall noeder med nok minne i hvert rack.
        for (int i = 0; i < this.racks.size(); i++) {
            Rack currentRack = this.racks.get(i);

            antNoderMedNokMinne += currentRack.noderMedNokMinne(paakrevdMinne);
        } 

        return antNoderMedNokMinne;
    }


    public int antRacks() {
        // Henter antall racks regneklynge.
        return this.racks.size();
    }
}
