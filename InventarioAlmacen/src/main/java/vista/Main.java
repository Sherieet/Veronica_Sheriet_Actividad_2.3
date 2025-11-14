package vista;
import controlador.Controlador;
import modelo.Inventario;
// Punto de entrada de la aplicación
// Crea Modelo, Controlador y Vista
public class Main {
    public static void main(String[] args){
        Inventario inv=new Inventario();
        Controlador ctrl=new Controlador(inv);
        new VistaBotonesTerminal(ctrl);
    }
}

