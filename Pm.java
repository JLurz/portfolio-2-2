import java.util.ArrayList;

public class Pm {

    //Statischen Resolver erzeugen für die gesamte Klasse
    Resolver resolver = new Resolver();

    //Liste mit den gefundenen Aufgaben
    ArrayList<String> AufgabenListe = new ArrayList<>();

    //Liste mit den gefundenen Seiten
    ArrayList<String> SeitenListe = new ArrayList<>();


    public void getSeiten(String StartSeite) {

        //Variable Text definieren, mit dem Inhalt aus der eingegebenen Startseite
        String Text = resolver.getInhalt(StartSeite);

        //While Schleife, die so lange arbeitet bis keine "](" mehr im Text enthalten ist
        // "](" leitet Verlinkungen auf Seiten ein
        while (Text.contains("](")) {

            //Definieren eines BeginIndex zum Schneiden
            // +1 um die Klammer nicht mitzunehmen
            int BeginIndex = Text.indexOf("(") + 1;

            //Definieren eines EndIndex
            int EndIndex = Text.indexOf(")", BeginIndex);

            //Gefundene verlinkte Seite(=gSeite) extrahieren mittels substring
            String gSeite = Text.substring(BeginIndex, EndIndex);

            //Gefundene Seite zur ArrayListe hinzufügen
            SeitenListe.add(gSeite);

            //Restlicher nicht geschnittener Text in Variable Text speichern, um weiter nach Links zu suchen
            Text = Text.substring(EndIndex);

                //Rekursiver Aufruf, der Funktion getText mit dem Übergabeparameter gSeite
                getText(gSeite);
            }
        }


    //Funktion, die den Inhalt aus der StartSeite zieht
    public void getText(String StartSeite) {

        //Variable Text speichert Inhalt der StatSeite
        String Text = resolver.getInhalt(StartSeite);

        //Aufruf der Funktion getAufgaben mit dem Parameter Text
        getAufgaben(Text);
    }

    public void getAufgaben(String Text) {

        //Alles bis zur ersten Aufgabe herausschneiden
        //Aufgaben beginnen immer mit * [
        Text = Text.substring(Text.indexOf("* ["));

        // Variable gaufgabe aufstellen für die gefundene Aufgabe
        //gaufgabe mit geschnittenen Text gleichsetzen
        // +2 entfernt "* " falls vorhanden
        String gaufgabe = Text.substring(Text.indexOf("* [") + 2);

        // schneidet alles bis zur nächsten aufgabe weg, falls es noch eine gibt
        if (gaufgabe.contains("*")) {
            gaufgabe = gaufgabe.substring(0, gaufgabe.indexOf("*"));
        }

        //Aufgabe zur Liste hinzufügen
        AufgabenListe.add(gaufgabe);

        // Aufgabe wird aus dem Text String entfernt
        Text = Text.replace("* " + gaufgabe, "");

        // überprüft, ob noch weitere Aufgaben vorhanden sind
            if (Text.contains("* [")) {

            //Rekursiver Aufruf der Methode getAufgaben mit Text
            getAufgaben(Text);
        }
    }


    //public void getUnfertigenAufgaben()
    //wenn kein X in der Klammer ist ausgeben
    //prüfen ob das String der ArrayListe ein [x] wenn ja dann in neuer Liste speichern und ausgeben


        //Funktion, die die Aufgabenliste ausgibt
        public ArrayList<String> getAufgabenListe() {
        return AufgabenListe;
        }

        //Funktion, die die SeitenListe ausgibt
        public ArrayList<String> getSeitenListe() {
        return SeitenListe;
        }

}
