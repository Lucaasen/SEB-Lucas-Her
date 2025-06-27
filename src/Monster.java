public class Monster {
    private String naam;
    private String beschrijving;

    public Monster(String naam, String beschrijving) {
        this.naam = naam;
        this.beschrijving = beschrijving;
    }

    public void verschijn() {
        System.out.println("⚠️ Een monster verschijnt: " + naam);
        System.out.println("Beschrijving: " + beschrijving);
    }

    public void losOp() {
        System.out.println("💡 Je moet een extra opdracht uitvoeren om het monster te verslaan...");
        System.out.println("✅ Je hebt het monster verslagen!");
    }

//    // \/dit moet nog in een methode/constructor
//    Monster scopeCreep = new Monster("Scope Creep", "Je hebt te veel werk in de sprint gestopt!");
//    Monster vertraging = new Monster("Vertraging", "Iemand is zijn update vergeten!");
}



