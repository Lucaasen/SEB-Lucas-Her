
public interface OpdrachtStrategie {

    boolean voerUit();
    void toonUitdaging(); // deze moet overal worden geïmplementeerd


    boolean controleerAntwoord(String antwoord);

    void toonResultaat();

    void geefFeedback();
}

