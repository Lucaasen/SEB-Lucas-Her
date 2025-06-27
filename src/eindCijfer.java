import java.util.ArrayList;
import java.util.List;

public class eindCijfer{
    // hier komt observer
    private List<ExamObserver> observers = new ArrayList<>();

    public void geefRapport(Speler speler){

        System.out.println("Eindresultaat: ");
        System.out.println("binnenkort beschikbaar.");
    }

    private void addObserver() {

    }
    private void notifyObservers(String ){


    }

}
