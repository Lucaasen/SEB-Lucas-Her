import java.util.Scanner;

public class MeerkeuzeVraagStrategie implements OpdrachtStrategie {
    private String vraag;
    private String[] opties;
    private String correctAntwoord;

    public MeerkeuzeVraagStrategie(String vraag, String[] opties, String correctAntwoord) {
        this.vraag = vraag;
        this.opties = opties;
        this.correctAntwoord = correctAntwoord.toLowerCase();
    }

    @Override
    public void toonUitdaging() {
        System.out.println(vraag);
        for (int i = 0; i < opties.length; i++) {
            System.out.println((i + 1) + ". " + opties[i]);
        }
    }

    @Override
    public boolean voerUit() {
        toonUitdaging();
        System.out.print("Jouw keuze (nummer): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        try {
            int keuze = Integer.parseInt(input);
            if (keuze >= 1 && keuze <= opties.length) {
                return opties[keuze - 1].equalsIgnoreCase(correctAntwoord);
            }
        } catch (NumberFormatException e) {
        }

        return false;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equalsIgnoreCase(correctAntwoord);
    }

    @Override
    public void toonResultaat() {
    }

    @Override
    public void geefFeedback() {
    }
}

