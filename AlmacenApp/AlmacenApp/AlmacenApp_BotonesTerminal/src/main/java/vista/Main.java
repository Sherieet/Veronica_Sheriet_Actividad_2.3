package vista;
import controlador.Controlador;
import modelo.Inventario;

public class Main {
    public static void main(String[] args){
        Inventario inv=new Inventario();
        Controlador ctrl=new Controlador(inv);
        new VistaBotonesTerminal(ctrl);
    }
}

