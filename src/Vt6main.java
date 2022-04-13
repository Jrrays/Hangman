import java.util.NoSuchElementException;
import java.util.Scanner;

public class Vt6main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Character arvaus;

        Hirsipuu hirsipuu = new Hirsipuu();

        hirsipuu.piilotaVastaus();
        System.out.println("*** Peli alkaa ***");
        System.out.println("Arvauksia jäljellä: " + hirsipuu.arvauksiaJaljella());
        do {
            hirsipuu.tulostaPiiloVastaus();
            System.out.print("Arvaa kirjain: ");
            arvaus = syotaMerkki();
            hirsipuu.arvaa(arvaus);
            hirsipuu.paivitaPiilovastaus();

        } while(!hirsipuu.onLoppu());

        if(hirsipuu.arvauksiaJaljella() == 0) {

            System.out.println("Hävisit pelin! :(");
        } else {

            System.out.println("Voitit pelin! :)");
        }
        System.out.println("Arvattava sana oli \"" + hirsipuu.sana() + "\"");
    }

    public static Character syotaMerkki() {

        Character c = null;
        boolean ok = false;

        do {
            try {
                c = input.next(".").charAt(0);
                c = Character.toLowerCase(c);
                ok = true;
            } catch (NoSuchElementException nse) {

                input.nextLine();
                System.out.print("Virheellinen arvaus, yritä uudestaan: ");
            }
        } while(!ok);
        return c;
    }
}
