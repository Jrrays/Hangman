import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hirsipuu {

    private int arvauslkm;
    private String vastaus;

    private Sanalista sanat;
    private final List<Character> arvaukset;
    private final List<Character> vastausPiilotettuna;

    public Hirsipuu() {

        sanat = new Sanalista();
        arvaukset = new ArrayList<>();
        arvauslkm = 5;
        vastaus = sanat.arvoVastaus(sanat.annaSanat());
        vastausPiilotettuna = new ArrayList<>(vastaus.length());
    }

    public void setArvauslkm(int arvauslkm) {
        this.arvauslkm = arvauslkm;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }


    public boolean arvaa(Character merkki) {

        boolean oikein = false;
        String arvaus;
        arvaus = Character.toString(merkki);

        if(arvaukset.contains(merkki)) {

            System.out.println("'" + merkki + "' on jo arvattu");
            System.out.print("\n");
            return oikein;
        } else {

            arvaukset.add(merkki);
            oikein = vastaus.contains(arvaus);
        }

        if(oikein) {

            System.out.println("Arvaus oli oikein");
            System.out.print("\n");
        } else {

            System.out.println("Arvaus oli väärin");
            arvauslkm -= 1;
            System.out.println("Arvauksia jäljellä: " + arvauslkm);
            System.out.print("\n");
        }

        return oikein;
    }

    public List<Character> arvaukset() {

        return arvaukset;
    }

    public int arvauksiaJaljella() {

        return arvauslkm;
    }

    public String sana() {

        return vastaus;
    }

    public boolean onLoppu() {

        boolean stop = false;
        int oikeatmerkit = 0;

        for(int i = 0; i < vastaus.length(); i++) {

            if(arvaukset.contains(vastaus.charAt(i))) {

                oikeatmerkit++;
            }

            if(oikeatmerkit == vastaus.length()) {

                stop = true;
            }

            if(arvauslkm == 0) {

                stop = true;
            }
        }
        return stop;
    }

    public void piilotaVastaus() {

        for(int i = 0; i < vastaus.length(); i++) {

            vastausPiilotettuna.add('*');
        }
    }

    public void tulostaPiiloVastaus() {

        Iterator<Character> ite = vastausPiilotettuna.iterator();

        while (ite.hasNext()) {
            System.out.print(ite.next());
        }
        System.out.print("\n");
    }

    public void paivitaPiilovastaus() {

        for(int i = 0; i < vastaus.length(); i++) {

            if(arvaukset.contains(vastaus.charAt(i))) {

                vastausPiilotettuna.set(i, vastaus.charAt(i));
            }
        }
    }
}
