package facade;

public class    Main {
    public static void main(String[] args) {
        HomeTheaterFacade ht = new HomeTheaterFacade();
        ht.assistirFilme("Matrix");
        System.out.println();
        ht.terminarFilme();
    }
}
