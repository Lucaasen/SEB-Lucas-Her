import java.util.Random;

public class RandomHintSelector {
    public static HintProvider kiesHintProvider() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return new FunnyHintProvider();
        } else {
            return new HelpHintProvider();
        }
    }
}
