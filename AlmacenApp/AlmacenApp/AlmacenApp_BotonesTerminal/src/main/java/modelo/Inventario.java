package modelo;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) { productos.add(p); }
    public Producto buscarProducto(String nombre) {
        for(Producto p: productos) if(p.getNombre().equalsIgnoreCase(nombre)) return p;
        return null;
    }
    public ArrayList<Producto> getProductos() { return productos; }
    public ArrayList<Producto> getProductosCriticos(int limite) {
        ArrayList<Producto> criticos = new ArrayList<>();
        for(Producto p: productos) if(p.getStock()<=limite) criticos.add(p);
        return criticos;
    }
}
