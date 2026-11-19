package facade;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class   HomeTheaterFacadeTest {
    private final PrintStream original = System.out;
    private ByteArrayOutputStream buffer;
    private HomeTheaterFacade ht;

    @BeforeEach
    void setUp() {
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        ht = new HomeTheaterFacade();
    }

    @AfterEach
    void tearDown() { System.setOut(original); }

    private List<String> linhas() {
        return buffer.toString().lines().toList();
    }

    @Test
    void assistirFilmeConfiguraSubsistemasNaOrdem() {
        ht.assistirFilme("Matrix");
        assertEquals(List.of(
            "Preparando para assistir: Matrix",
            "Luzes: 10%",
            "Projetor: ligado",
            "Projetor: entrada HDMI",
            "Amplificador: ligado",
            "Amplificador: som surround",
            "Amplificador: volume 8"), linhas());
    }

    @Test
    void terminarFilmeDesligaTudoEAcendeLuzes() {
        ht.terminarFilme();
        assertEquals(List.of(
            "Desligando home theater...",
            "Amplificador: desligado",
            "Projetor: desligado",
            "Luzes: 100%"), linhas());
    }

    @Test
    void assistirFilmeUsaONomeInformado() {
        ht.assistirFilme("Interestelar");
        assertEquals("Preparando para assistir: Interestelar", linhas().get(0));
    }

    @Test
    void fluxoCompletoPodeSerRepetido() {
        ht.assistirFilme("A");
        ht.terminarFilme();
        ht.assistirFilme("B");
        assertTrue(buffer.toString().contains("Preparando para assistir: B"));
        assertEquals(7 + 4 + 7, linhas().size());
    }
}
