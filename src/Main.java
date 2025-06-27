//het programma starten

public class Main {
    public static void main(String[] args) {

        //maak een nieuw Game-object
        Game game = new Game();
        game.addObserver(new GameLogger());
        //start het spel
        game.start();
        // Log het moment dat de speler het spel start
    }
}
