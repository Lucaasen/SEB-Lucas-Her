import java.util.Scanner;

public class InvulVraagStrategie implements OpdrachtStrategie {
    private String vraag;
    private String juistAntwoord;
    private final Scanner scanner = new Scanner(System.in);

    public InvulVraagStrategie(String vraag, String juistAntwoord) {
        this.vraag = vraag;
        this.juistAntwoord = juistAntwoord.toLowerCase();
    }

    @Override
    public boolean voerUit() {
//        System.out.println(vraag);
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        return antwoord.equals(juistAntwoord);
    }

    @Override
    public void toonUitdaging() {
        System.out.println(vraag);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        if (antwoord.toLowerCase().equals(juistAntwoord)) {
            return true;
        } else {
            new Monster("Fout antwoord", "Dat klopt niet helemaal.").verschijn();
            return false;
        }
    }

    @Override
    public void toonResultaat() {
        System.out.println("Correct antwoord!");
    }

    @Override
    public void geefFeedback() {
        System.out.println("Zorg ervoor dat je de termen goed begrijpt.");
    }
}