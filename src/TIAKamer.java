import java.util.Scanner;

public class TIAKamer extends Kamer {
    public TIAKamer() {
        super("Scrum Pilaren", "Test je kennis over de 3 Scrum-pilaren.",
                new InvulVraagStrategie("Wat zijn de drie kernpilaren van Scrum?", "transparantie, inspectie, aanpassing"));
    }


    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("De basis van Scrum rust op 3 pijlers...");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Noem de drie Scrum-pilaren.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) {
            KamerObserver.registreerFout();
            new Monster("Instabiliteit", "Zonder de juiste basis valt alles uit elkaar.").verschijn();

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
        System.out.println("Perfect! Je kent de fundamenten.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Transparantie, Inspectie en Aanpassing houden je team wendbaar.");
    }
}
