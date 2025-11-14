package tests;
public class ManualTests {
    public static void runAll(){
        System.out.println("\n--- INICIANDO PRUEBAS MANUALES ---");
        testAgregarStock(); testRestarStock(); testRestarStockNoNegativo();
        System.out.println("--- FIN PRUEBAS MANUALES ---\n");
    }
    private static void assertEquals(String name,int expected,int actual){
        System.out.println((expected==actual?"[OK] ":"[FAIL] ")+name+" esperado="+expected+", real="+actual);
    }
    private static void assertTrue(String name,boolean cond){ System.out.println((cond?"[OK] ":"[FAIL] ")+name); }
    private static void testAgregarStock(){ modelo.Producto p=new modelo.Producto("Arroz",7); p.agregarStock(5); assertEquals("testAgregarStock",12,p.getStock()); }
    private static void testRestarStock(){ modelo.Producto p=new modelo.Producto("Azucar",10); boolean ok=p.restarStock(3); assertTrue("testRestarStock",ok); assertEquals("testRestarStock-stock",7,p.getStock()); }
    private static void testRestarStockNoNegativo(){ modelo.Producto p=new modelo.Producto("Aceite",10); boolean ok=p.restarStock(11); assertTrue("testRestarStockNoNegativo",!ok); assertEquals("testRestarStockNoNegativo-stock",10,p.getStock()); }
}
