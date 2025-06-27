import java.util.Random;

public class HelpHintProvider implements HintProvider {
    private static final String[] hints = {
            "Denk aan de kernwaarden van Scrum.",
            "Focus op wat het team elke dag bespreekt.",
            "Herlees de theorie over deze Scrum-activiteit.",
            "De drie pilaren zijn fundamenteel voor inspectie en aanpassing.",
            "De juiste termen staan in het Scrum Guide document."
    };

    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}
