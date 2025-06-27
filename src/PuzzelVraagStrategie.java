import java.util.Scanner;

public class PuzzelVraagStrategie implements OpdrachtStrategie {

    @Override
    public void toonUitdaging() {
        System.out.println("Los de volgende puzzel op (Placeholder): Wat is de overkoepelende waarde van Scrum?");
    }

    @Override
    public boolean voerUit() {
        toonUitdaging();
        System.out.print("Jouw antwoord: ");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        return controleerAntwoord(antwoord);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.contains("samenwerking") || antwoord.contains("waarde");
    }

    @Override
    public void toonResultaat() {
    }

    @Override
    public void geefFeedback() {
    }
}
