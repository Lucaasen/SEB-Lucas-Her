import java.util.Scanner;

public class Speler {
    private String locatie;
    private String status;
    private String naam;
    private static Scanner scanner = new Scanner(System.in);

    public Speler(String startLocatie) {
        this.locatie = startLocatie;
        this.status = "Beginnend";
    }

    public void vraagNaamIn() {
        vraagNaam();
    }

    public void vraagNaam(){
        System.out.print("Vul je naam in: ");
        this.naam = scanner.nextLine();
        System.out.println("Je speelt als: "+ this.naam);
    }

    public void beweeg() {
        System.out.println("" + locatie);
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNaam() {
        return naam;
    }
}
