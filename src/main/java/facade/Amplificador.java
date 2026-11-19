package facade;

public class Amplificador {
    public void ligar() { System.out.println("Amplificador: ligado"); }
    public void volume(int v) { System.out.println("Amplificador: volume " + v); }
    public void surround() { System.out.println("Amplificador: som surround"); }
    public void desligar() { System.out.println("Amplificador: desligado"); }
}
