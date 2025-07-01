import java.util.Scanner;

public class DailyScrumKamer extends Kamer {
    public DailyScrumKamer() {
        super("Daily Scrum", "Iedere ochtend komt je team bijeen.",
                new InvulVraagStrategie("Wat is het hoofddoel van de Daily Scrum?", "afstemming"));
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Dagelijkste stand-up tijd!");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Beantwoord de vraag over het doel van de Daily Scrum.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) {
            KamerObserver.registreerFout();
            new Monster("Verwarring", "Zonder duidelijk doel raken teamleden de weg kwijt.").verschijn();

            System.out.println("Wil je een hint? (ja/nee): ");
            Scanner scanner = new Scanner(System.in);
            String vraag = scanner.nextLine();
            if(vraag.equalsIgnoreCase("ja")){
                HintProvider hint = RandomHintSelector.kiesHintProvider();
                System.out.println(hint.getHint());
                HintObserver.registreerHintGebruik();
            } else {
                System.out.println("(nog) niet nodig dus.");
            }
        } else {
            KamerObserver.registreerCorrect();
        }
        return juist;
    }

        @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Precies! Dagelijkse afstemming is essentieel.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("De Daily Scrum helpt om iedereen op dezelfde lijn te houden.");
    }

}
