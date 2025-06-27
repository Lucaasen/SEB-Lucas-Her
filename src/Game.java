import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Speler speler;
    private Scanner scanner = new Scanner(System.in);
    private List<Kamer> kamers = new ArrayList<>();
    private int huidigeIndex = 0;
    private eindCijfer eindCijfer = new eindCijfer();

    public void start() {
        this.speler = new Speler("Startkamer");
        speler.vraagNaamIn();
        notifyObservers(speler.getNaam() + " heeft het spel gestart.");
        System.out.println("Welkom bij het Scrum Avontuur!");

        this.kamers.add(new SprintPlanningKamer());
        this.kamers.add(new DailyScrumKamer());
        this.kamers.add(new ScrumBoardKamer());
        this.kamers.add(new SprintReviewKamer());
        this.kamers.add(new RetrospectiveKamer());
        this.kamers.add(new TIAKamer());

    while (huidigeIndex < kamers.size()) {
        Actie();
        Kamer kamer = kamers.get(huidigeIndex);
        notifyObservers(speler.getNaam() + " betreedt kamer: " + kamer.getNaam());
    }
    }

    public void Actie() {
        System.out.println("\nWelke actie wil je doen?");
        System.out.print("beweeg, interacteer, menu, inventaris: ");
        String actie = scanner.nextLine();

        if (actie.equalsIgnoreCase("exit")) {
            notifyObservers(speler.getNaam() + " heeft de spel afgesloten.");
            System.out.println("Bedankt voor het spelen! Tot de volgende keer.");
            System.out.println("Afsluiten...");
            System.exit(0);
        }

        verwerkActie(actie);
    }

    public void verwerkActie(String actie) {
        Kamer kamer = kamers.get(huidigeIndex);
        switch (actie.toLowerCase()) {
            case "beweeg":

                System.out.println("Je bent in: " + kamer.getClass().getSimpleName());
                System.out.print("Typ 'v' (vorige) of 'n' (volgende): ");
                String keuze = scanner.nextLine();

                if (keuze.equals("v") && huidigeIndex > 0) {
                    huidigeIndex--;
                } else if (keuze.equals("n")) {
                    if (kamer.isOpdrachtVoltooid()) {
                        if (huidigeIndex < kamers.size() - 1) huidigeIndex++;
                        else System.out.println("Laatste kamer bereikt.");
                    } else {
                        System.out.println("Eerst opdracht voltooien!");
                    }
                } else {
                    System.out.println("Ongeldige keuze of al aan het begin.");
                }

                speler.setLocatie(kamers.get(huidigeIndex).getClass().getSimpleName());
                break;
            case "interacteer":
//                Kamer kamer = kamers.get(huidigeIndex);
                kamer.voerOpdrachtUit(speler);


                boolean spelEinde = (huidigeIndex == kamers.size() -1);
                if((kamer.isOpdrachtVoltooid()) && spelEinde){
                    eindCijfer.geefRapport(speler);
                }
//                huidigeIndex++;
                break;
            case "menu":
                System.out.println("Toon menu-opties...");
                break;
            case "inventaris":
                System.out.println("Je hebt nog geen items.");
                break;
            default:
                System.out.println("Ongeldige actie.");
        }
    }

    private List<SpelEventObserver> observers = new ArrayList<>();

    public void addObserver(SpelEventObserver observer) {
    observers.add(observer);
    }

    private void notifyObservers(String event) {
        for (SpelEventObserver obs : observers) {
            obs.onEvent(event);
        }
    }
}

