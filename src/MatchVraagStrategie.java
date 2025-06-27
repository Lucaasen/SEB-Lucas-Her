import java.util.Scanner;

public class MatchVraagStrategie implements OpdrachtStrategie {

    @Override
    public void toonUitdaging() {
        System.out.println("Koppel de juiste Scrum-termen met hun beschrijvingen (Placeholder).");
    }

    @Override
    public boolean voerUit() {
        toonUitdaging();
        System.out.println("Typ 'ja' als je klaar bent: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("ja");
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equalsIgnoreCase("ja");
    }

    @Override
    public void toonResultaat() {
    }

    @Override
    public void geefFeedback() {
    }
}


