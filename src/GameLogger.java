import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class GameLogger implements SpelEventObserver {
    private static final String LOG_FILE = "log/game_log.txt";

    @Override
    public void onEvent(String event) {
    String logEntry = "[" + java.time.LocalDateTime.now() + "] " + event;
    System.out.println(logEntry); // Naar de CLI printen

    try {
        // Controleren of de log map bestaat
        java.nio.file.Files.createDirectories(java.nio.file.Paths.get("log"));

        // Het log bestand schrijven
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logEntry);
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Fout bij het schrijven naar het logbestand: " + e.getMessage());
    }   
    }
}