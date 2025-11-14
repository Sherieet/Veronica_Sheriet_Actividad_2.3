package controlador;
import modelo.*;
import java.util.ArrayList;

// Puente entre Vista y Modelo
// Métodos: agregarProductoDirecto(), agregarStockPorNombre(), etc.
public class Controlador {
    private Inventario inventario;
    public Controlador(Inventario inventario){ this.inventario = inventario; }

    public void agregarProductoDirecto(String nombre,int stock){ inventario.agregarProducto(new Producto(nombre,stock)); }
    public ArrayList<Producto> listarProductos(){ return inventario.getProductos(); }
    public boolean agregarStockPorNombre(String nombre,int cantidad){
        Producto p=inventario.buscarProducto(nombre);
        if(p!=null){ p.agregarStock(cantidad); return true; } return false;
    }
    public boolean restarStockPorNombre(String nombre,int cantidad){
        Producto p=inventario.buscarProducto(nombre);
        if(p!=null) return p.restarStock(cantidad); return false;
    }
    public ArrayList<Producto> getStockCritico(int limite){ return inventario.getProductosCriticos(limite); }
}
