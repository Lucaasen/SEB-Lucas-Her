import java.util.Scanner;

public class Opdracht {
    public void start(Speler speler) {
        System.out.println("SCRUM Vraag: Wat is de rol van een Scrum Master?");
        System.out.print("Jouw antwoord: ");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();

        if (!antwoord.equalsIgnoreCase("begeleider van het team")) {
            System.out.println("Fout antwoord!");
            Monster monster = new Monster("ScopeCreep", "Verwarring");
            monster.verschijn();
        } else {
            System.out.println("Correct!");
        }
    }
}
