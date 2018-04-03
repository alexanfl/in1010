import java.util.Scanner;
import java.util.InputMismatchException;

class Legesystem {
    private Scanner input; 
    private Liste<Lege> legeliste;

    Legesystem()
    {
        this.input = new Scanner(System.in);
        this.legeliste = new SortertLenkeliste<Lege>();

        legeliste.leggTil(new Lege("Dr. Arne"));
    }




    public void hovedMeny()
    {
        int valg = 0;


        while(true) {
            skrivUtHovedmeny();
            valg = hentValg();

            switch(valg)
            {
                case 0: 
                    return;
                case 1: 
                    skrivUtOversikt();
                    continue;
                case 2: 
                    leggTilNyttElement();
                    continue;
                case 3: 
                    brukResept();
                    continue;
                case 4: 
                    skrivUtStatistikk();
                    continue;
            }
        }
    }


    public void skrivUtHovedmeny()
    {
        System.out.println("Velkommen til Legesystemet.\n");
        System.out.println("Du har følgende valg:");
        System.out.println("1: Skriver ut informasjon.");
        System.out.println("2: Legg til nye instanser.");
        System.out.println("3: Bruk resept.");
        System.out.println("4: Skriv ut statistikk.");
        System.out.println("0: Avslutt Legesystemet.");
    }


    public int hentValg(){
        int valg = 0;

        while(true){
           try {
               valg = input.nextInt();
               input.nextLine();

               return valg;

           } catch(InputMismatchException e) {
               System.out.println("Kun kommandoer 0–4 er gyldige input.");
               input.next();
               continue;
          }
        }
    }


    public void skrivUtOversikt()
    {
        for (Lege lege: legeliste) {
            lege.skrivUtLegeinformasjon();
        } 
    }


    public void leggTilNyttElement()
    {

    }


    public void brukResept()
    {

    }


    public void skrivUtStatistikk()
    {

    }

}
