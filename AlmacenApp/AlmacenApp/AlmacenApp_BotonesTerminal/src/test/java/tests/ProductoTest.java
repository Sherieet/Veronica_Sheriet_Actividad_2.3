package tests;
import modelo.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductoTest {
    @Test public void testAgregarStock(){ Producto p=new Producto("Arroz",7); p.agregarStock(5); assertEquals(12,p.getStock()); }
    @Test public void testRestarStock(){ Producto p=new Producto("Azucar",10); boolean ok=p.restarStock(3); assertTrue(ok); assertEquals(7,p.getStock()); }
    @Test public void testRestarStockNoNegativo(){ Producto p=new Producto("Aceite",10); boolean ok=p.restarStock(11); assertFalse(ok); assertEquals(10,p.getStock()); }
}
