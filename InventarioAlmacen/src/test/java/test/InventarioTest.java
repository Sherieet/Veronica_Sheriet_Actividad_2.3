package test;

import modelo.Inventario;
import modelo.Producto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {

    private Inventario inventario;

    @Before
    public void setUp() {
        inventario = new Inventario(); 
    }

    @Test
    public void testAgregarProducto() {
        Producto p = new Producto("Manzanas", 7);
        inventario.agregarProducto(p);

        assertEquals(1, inventario.getProductos().size());
        assertEquals("Manzanas", inventario.getProductos().get(0).getNombre());
        assertEquals(7, inventario.getProductos().get(0).getStock());
    }

    @Test
    public void testAgregarStock() {
        Producto p = new Producto("Peras", 10);
        inventario.agregarProducto(p);

        p.agregarStock(5);

        assertEquals(15, p.getStock());
    }

    @Test
    public void testRestarStockExitoso() {
        Producto p = new Producto("Naranjas", 10);
        inventario.agregarProducto(p);

        boolean exito = p.restarStock(3); 

        assertTrue(exito);
        assertEquals(7, p.getStock());
    }

    @Test
    public void testRestarStockFallido() {
        Producto p = new Producto("Kiwis", 10);
        inventario.agregarProducto(p);

        boolean exito = p.restarStock(11); 

        assertFalse(exito);
        assertEquals(10, p.getStock()); 
    }

    @Test
    public void testBuscarProducto() {
        inventario.agregarProducto(new Producto("Mango", 5));

        Producto encontrado = inventario.buscarProducto("Mango");

        assertNotNull(encontrado);
        assertEquals("Mango", encontrado.getNombre());
    }

    @Test
    public void testProductosCriticos() {
        inventario.agregarProducto(new Producto("Tomate", 2));
        inventario.agregarProducto(new Producto("Ajo", 10));

 
        assertEquals(1, inventario.getProductosCriticos(3).size());
        assertEquals("Tomate", inventario.getProductosCriticos(3).get(0).getNombre());
    }
}
