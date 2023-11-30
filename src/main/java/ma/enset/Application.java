package ma.enset;

public class Application {
    public static void main(String[] args) {
        Avion avion = new AvionImpl();
        avion.sortirDuGarrage();
        avion.decoller();
        avion.atterir();
        avion.entrerAuGarrage();
        avion.doActivity();
    }
}
