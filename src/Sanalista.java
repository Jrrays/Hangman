import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sanalista {

    private List<String> sanat;

    public Sanalista() {

        sanat = new ArrayList<>();

        try(BufferedReader sanoja = new BufferedReader(new FileReader("sanalista.txt"))) {

            String yksisana;
            while((yksisana = sanoja.readLine()) != null) {
                sanat.add(yksisana);
            }
        } catch(IOException e) {

            System.out.println("Virhe avattaessa sanatiedostoa");
        }
    }

    public List<String> annaSanat() {

        return sanat;
    }

    public String arvoVastaus(List<String> sanat) {

        Random rand = new Random();
        return sanat.get(rand.nextInt(sanat.size()));
    }
}
