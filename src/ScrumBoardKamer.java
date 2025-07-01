import java.util.Scanner;

public class ScrumBoardKamer extends Kamer {
      public ScrumBoardKamer() {
          super("Scrum Board", "Je staat voor een digitaal Scrum board.",
                  new MeerkeuzeVraagStrategie(
                          "Wat hoort NIET thuis op een Scrum Board?",
                          new String[]{"To do", "In progress", "Done", "Gebruikerstevredenheid"},
                          "Gebruikerstevredenheid"
                  ));
      }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Het Scrum Board geeft je overzicht over je werk.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Welke term hoort hier niet thuis?");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) {
            KamerObserver.registreerFout();
            new Monster("Chaos", "Je bord is onoverzichtelijk geworden!").verschijn();

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
        System.out.println("Correct! Dat hoort niet op het Scrum Board.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Gebruik duidelijke categorieën zoals To Do, In Progress, en Done.");
    }
}
