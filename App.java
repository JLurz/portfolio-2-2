import java.util.Scanner;


public class App {
    public static void main(String[] args) {

        //Erzeugen eines Objekts von PM, um auf die Funktionen zuzugreifen
        Pm Projektmanagement = new Pm();


        //Startseite eingeben
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eine Url eingeben, um das Programm zu starten: ");
        String StartSeite = scanner.nextLine();


        //Aufrufen der Funktion getSeiten() aus der Klasse Pm
        Projektmanagement.getSeiten(StartSeite);


        //Aufrufen der Funktion getAufgaben() aus der Klasse Pm
        //Aber nur, wenn keine Seiten verlinkt sind --> SeitenListe hat die Größe 0, da sonst die Funktion getText() nicht aufgerufen wird
        if (Projektmanagement.SeitenListe.size() == 0) {
            Projektmanagement.getText(StartSeite);
        }


        //Liste mit gefundenen Seiten ausgeben
        System.out.println("Alle verlinkten Seiten: ");
        if (Projektmanagement.SeitenListe.size() == 0) {
            System.out.println("Keine Seiten verlinkt.");
        } else {
            System.out.println(Projektmanagement.getSeitenListe());
        }

        //Leerzeile
        System.out.println();


        //Liste mit gefundenen Aufgaben ausgeben
        System.out.println("Alle gefundenen Aufgaben: ");
        System.out.println(Projektmanagement.getAufgabenListe());
        System.out.println();


        //Interaktive Abfrage nach Funktionen
        while (true) {
            System.out.println("Folgende Optionen sind möglich:");
           // System.out.println("(1) Neue Startseite eingeben");
            System.out.println("(2) unfertige Aufgaben ausgeben");
            System.out.println("(e) Programm beenden");

            //Auf Benutzereingabe warten
            String userInput = scanner.nextLine();
            System.out.println();
            System.out.println("Der Benutzer möchte folgende Aktion durchführen: " + userInput);

            //switch case mit den entsprechenden Auswahlmöglichkeiten
            switch (userInput) {

                //Eingabe 1: Neue Startseite eingeben und alle Aufgaben und Seiten auflisten
                /*case "1":
                    System.out.println("Eine Url eingeben, um das Programm zu starten: ");
                    String NeueStartSeite = scanner.nextLine();

                    //Aufrufen der Funktion getSeiten() aus der Klasse Pm
                    Projektmanagement.getSeiten(NeueStartSeite);

                    System.out.println("Alle verlinkten Seiten: ");
                    System.out.println(Projektmanagement.getSeitenListe());
                    System.out.println();

                    //Aufrufen der Funktion getAufgaben() aus der Klasse Pm
                    Projektmanagement.getText(NeueStartSeite);
                    System.out.println(Projektmanagement.getAufgabenListe());
                    break;*/

                //case "2" : System.out.println("Nicht erledigte Aufgaben:");
                // Projektmanagement.getUnfertigeAufgaben();
                //break;

                //Eingabe e: Beenden des Programms
                case "e":
                    return;

                //Alle anderen Eingaben sind ungültig --> Fehlermeldung
                default:
                    System.err.println("Die Eingabe ist kein gültiger Befehl, bitte versuche es nochmal!");
            }
        }
    }
}
