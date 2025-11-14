package vista;
import controlador.Controlador;
import modelo.Producto;
import tests.ManualTests;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaBotonesTerminal {
    private Controlador controlador;
    public VistaBotonesTerminal(Controlador controlador){
        this.controlador=controlador;
        SwingUtilities.invokeLater(this::createGUI);
    }

    private void createGUI(){
        JFrame frame=new JFrame("Almacén Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setLocationRelativeTo(null);
        JPanel panel=new JPanel(new GridLayout(2,4,5,5));

        JButton b1=new JButton("Agregar producto");
        JButton b2=new JButton("Listar productos");
        JButton b3=new JButton("Registrar entrada");
        JButton b4=new JButton("Registrar salida");
        JButton b5=new JButton("Stock crítico");
        JButton b6=new JButton("Pruebas manuales");
        JButton b7=new JButton("Salir");

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4);
        panel.add(b5); panel.add(b6); panel.add(b7);

        frame.add(panel); frame.setVisible(true);

        b1.addActionListener(e->accionAgregar());
        b2.addActionListener(e->accionListar());
        b3.addActionListener(e->accionEntrada());
        b4.addActionListener(e->accionSalida());
        b5.addActionListener(e->accionCritico());
        b6.addActionListener(e->ManualTests.runAll());
        b7.addActionListener(e->System.exit(0));
    }

    private void accionAgregar(){
        String nombre=JOptionPane.showInputDialog("Nombre del producto:");
        if(nombre==null||nombre.trim().isEmpty()) return;
        String sStock=JOptionPane.showInputDialog("Stock inicial:");
        if(sStock==null) return;
        try{
            int stock=Integer.parseInt(sStock.trim());
            controlador.agregarProductoDirecto(nombre.trim(),stock);
            System.out.println("Producto agregado: "+nombre+" | Stock: "+stock);
        }catch(Exception e){ System.out.println("Número inválido."); }
    }

    private void accionListar(){
        ArrayList<Producto> list=controlador.listarProductos();
        System.out.println("\n📦 LISTA DE PRODUCTOS:");
        if(list.isEmpty()) System.out.println("  (vacío)");
        for(Producto p:list) System.out.println("- "+p);
    }

    private void accionEntrada(){
        String nombre=JOptionPane.showInputDialog("Nombre del producto:");
        if(nombre==null||nombre.trim().isEmpty()) return;
        String sCant=JOptionPane.showInputDialog("Cantidad a agregar:");
        if(sCant==null) return;
        try{
            int cant=Integer.parseInt(sCant.trim());
            boolean ok=controlador.agregarStockPorNombre(nombre.trim(),cant);
            if(ok) System.out.println("Stock agregado al producto "+nombre);
            else System.out.println("Producto no encontrado.");
        }catch(Exception e){ System.out.println("Número inválido."); }
    }

    private void accionSalida(){
        String nombre=JOptionPane.showInputDialog("Nombre del producto:");
        if(nombre==null||nombre.trim().isEmpty()) return;
        String sCant=JOptionPane.showInputDialog("Cantidad a restar:");
        if(sCant==null) return;
        try{
            int cant=Integer.parseInt(sCant.trim());
            boolean ok=controlador.restarStockPorNombre(nombre.trim(),cant);
            if(ok) System.out.println("Stock restado del producto "+nombre);
            else System.out.println("Producto no encontrado o stock insuficiente.");
        }catch(Exception e){ System.out.println("Número inválido."); }
    }

    private void accionCritico(){
        String sLim=JOptionPane.showInputDialog("Límite para stock crítico:");
        if(sLim==null) return;
        try{
            int lim=Integer.parseInt(sLim.trim());
            ArrayList<Producto> criticos=controlador.getStockCritico(lim);
            System.out.println("\n PRODUCTOS CON STOCK CRÍTICO (<= "+lim+"):");
            if(criticos.isEmpty()) System.out.println("  (ninguno)");
            for(Producto p:criticos) System.out.println("- "+p);
        }catch(Exception e){ System.out.println("Número inválido."); }
    }
}
