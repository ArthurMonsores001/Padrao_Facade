package facade;

/** Facade: interface simples sobre os subsistemas. */
public class HomeTheaterFacade {
    private final Luzes luzes = new Luzes();
    private final Projetor projetor = new Projetor();
    private final Amplificador amp = new Amplificador();

    public void assistirFilme(String filme) {
        System.out.println("Preparando para assistir: " + filme);
        luzes.escurecer(10);
        projetor.ligar();
        projetor.entrada("HDMI");
        amp.ligar();
        amp.surround();
        amp.volume(8);
    }

    public void terminarFilme() {
        System.out.println("Desligando home theater...");
        amp.desligar();
        projetor.desligar();
        luzes.acender();
    }
}
