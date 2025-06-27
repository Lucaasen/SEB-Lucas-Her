import java.util.Random;

public class FunnyHintProvider implements HintProvider {
    private static final String[] hints = {
            "Misschien moet je minder koffie drinken voor je deze vragen doet!",
            "Het juiste antwoord is niet '42'.",
            "Vraag je teamgenoot, of je hond.",
            "Je bent dichtbij... of niet.",
            "Scrum is geen gebak!"
    };

    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}
