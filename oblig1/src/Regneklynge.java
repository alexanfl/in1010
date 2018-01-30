import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author Alexander Fleischer alexander.fleischer@fys.uio.no
 */
public class Regneklynge {
    // Det maksimale antallet noderi hvert Rack-objekt.
    private int noderPerRack;
    // Velger å bruke en ArrayList fordi antall Racks ikke er kjent.
    private ArrayList<Rack> racks = new ArrayList<Rack>();


    /**
     * Konstruktør for første del av oppgaven.
     * Oppretter en regneklynge med et antall noder per rack.
     * Kan deretter sette inn noder med settInnNode-metoden.
     */
    public Regneklynge(int noderPerRack) {
        this.noderPerRack = noderPerRack;
    }


    /**
     * Konstruktør for andre del av oppgaven.
     * Oppretter en regneklynge fra informasjon i input-fil.
     */
    public Regneklynge(String filnavn) {
        settInnFraFil(filnavn);
    }


    /**
     * Åpner fil, henter ut noderPerRack fra første linje i fila.
     *
     * Hver linje etter dette brukes til å sette inn et antall noder
     * med git antall prosessorer og minne.
     *
     * @param filnavn                   Filen det skal hentes informasjon fra.
     * @exception FileNotFoundException Hvis filen ikke finnes.
    */
    public void settInnFraFil(String filnavn) {
        // Midlertidig variabel for antallet noder (per linje) i input-fila.
        int antNoderPerLinje;
        // Midlertidig variabel for prosessorminnet (per linje) i input-fila.
        int antMinnePerLinje;
        // Midlertidig variabel for antallet prosessorer (per linje) i input-fila.
        int antProsPerLinje;

        // Se om fil eksisterer. Exception hvis ikke.
        try (Scanner scanner = new Scanner(new File(filnavn))) {
            // Sett noderPerRack lik første int i fila.
            this.noderPerRack = scanner.nextInt();

            // Hent ut antall noder, minne og prosessorer fra en linje i fila.
            while(scanner.hasNext()) {
                antNoderPerLinje = scanner.nextInt();
                antMinnePerLinje = scanner.nextInt();
                antProsPerLinje  = scanner.nextInt();

                // Sett inn noder i rack.
                for (int i = 0; i < antNoderPerLinje; i++) {
                    this.settInnNode(new Node(antMinnePerLinje, antProsPerLinje));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fil " + "\'" + filnavn + "\'" 
                                + " finnes ikke.");
        }
    }


    /**
     * Oppretter et nytt Rack-objekt og legger det i ArrayList-en racks.
     * Oppdaterer totalt antall racks.
    */
    public void opprettRack() {
        this.racks.add(new Rack(this.noderPerRack));
    }


    /**
     * Setter inn nyNode i et rack. 
     *
     * Hvis det ikke finnes et rack eller om alle rackene er fulle, opprettes 
     * et nytt. 
    */
    public void settInnNode(Node nyNode) {
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


    /**
     * Henter ut antall prosessorer ved å iterere over alle racks
     * i ArrayList-en og kalle Rack-objektets antProsessorer-metode.
     *
     * @return antallet prosessorer i regneklyngen.
    */
    public int antProsessorer() {
        // Antallet prosessorer i regneklyngen.
        int antPros = 0;

        // Sjekker antall prosessorer i rack.
        for (int i = 0; i < this.racks.size(); i++) {
            antPros += this.racks.get(i).antProsessorer();   
        }

        return antPros;
    }


    /**
     * Henter ut antall noder i regneklyngen som har nok påkrevd minne
     * ved å iterere over alle rackene i ArrayList-en og kalle
     * Rack-objektets noderMedNokMinne-metode.
     *
     * @param paakrevdMinne Minnet som kreves av hver prosessor i klyngen.
     * @return              Antallet noder med nok minne.
     */
    public int noderMedNokMinne(int paakrevdMinne) {
        // Antallet noder med nok minne i regneklyngen.
        int antNoderMedNokMinne = 0;

        // Sjekker antall noeder med nok minne i hvert rack.
        for (int i = 0; i < this.racks.size(); i++) {
            Rack currentRack = this.racks.get(i);
            antNoderMedNokMinne += currentRack.noderMedNokMinne(paakrevdMinne);
        } 

        return antNoderMedNokMinne;
    }


    /**
     * Henter antall racks regneklynge.
     *
     * @return Størrelsen på ArrayList-en racks.
     */
    public int antRacks() {
        return this.racks.size();
    }
}
