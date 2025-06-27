import java.util.Scanner;

public class SprintPlanningKamer extends Kamer {
    public SprintPlanningKamer() {
        super("Sprint Planning", "Welke taken passen in de komende sprint?", new InvulVraagStrategie("Welke taak is geschikt voor de sprint?", "user login implementeren"));
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("In deze kamer plan je het werk voor de sprint.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Opdracht: Welke taken passen in de sprint.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) {
            new Monster("Scope Creep", "Je hebt te veel werk of onrealistische taken gekozen.").verschijn();

            System.out.println("Wil je een hint? (ja/nee): ");
            Scanner scanner = new Scanner(System.in);
            String vraag = scanner.nextLine();
            if(vraag.equalsIgnoreCase("ja")){
                HintProvider hint = RandomHintSelector.kiesHintProvider();
                System.out.println(hint.getHint());
            } else {
                System.out.println("(nog) niet nodig dus.");
            }
        }
        return juist;
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed gekozen taak! Dit is realistisch voor een sprint.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Probeer altijd klein en haalbaar te plannen.");
    }
}
