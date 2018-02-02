import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Regneklynge {
    private int maksNoderPerRack;
    private ArrayList<Rack> racks = new ArrayList<Rack>();


    /**
     * Konstruktør for første del av oppgaven.
     * Oppretter en regneklynge med et antall noder per rack.
     * Kan deretter sette inn noder med settInnNode-metoden.
     */
    public Regneklynge(int maksNoderPerRack) {
        this.maksNoderPerRack = maksNoderPerRack;
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
        int antNoderDenneLinja;
        int antMinneDenneLinja;
        int antProsDenneLinja;

        // Se om fil eksisterer. Exception hvis ikke.
        try (Scanner scanner = new Scanner(new File(filnavn))) {
            // Sett noderPerRack lik første int i fila.
            this.maksNoderPerRack = scanner.nextInt();

            // Hent ut antall noder, minne og prosessorer fra en linje i fila.
            while(scanner.hasNext()) {
                antNoderDenneLinja = scanner.nextInt();
                antMinneDenneLinja = scanner.nextInt();
                antProsDenneLinja  = scanner.nextInt();

                // Sett inn noder i rack.
                for (int i = 0; i < antNoderDenneLinja; i++) {
                    this.settInnNode(new Node(antMinneDenneLinja, antProsDenneLinja));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fila " + filnavn + " finnes ikke.");
        }
    }


    public void opprettRack() {
        this.racks.add(new Rack(this.maksNoderPerRack));
    }


    public void settInnNode(Node nyNode) {

        if (this.racks.size() == 0) {
            opprettRack();
        }
        else if (this.racks.get(this.racks.size() - 1).erFullt()) {
            opprettRack();
        }

        this.racks.get(this.racks.size() - 1).settInn(nyNode);
    }


    public int antProsessorer() {
        int antPros = 0;

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


    public int antRacks() {
        return this.racks.size();
    }
}
