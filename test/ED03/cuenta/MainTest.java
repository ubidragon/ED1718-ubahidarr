/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED03.cuenta;

import junit.framework.TestCase;

/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class MainTest extends TestCase {

    public MainTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     *
     * Test normal sin excepciones
     */
    public void testIngresar1() throws Exception {
        System.out.println("Test de prueba para ingresar dinero positivo y mayor que 0");
        int cantidad = 5;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        miCuenta.ingresar(cantidad);
        assertTrue(miCuenta.estado() == 4505);
    }

     /**
     *
     * Test no valido con valor negativo
     */
    public void testIngresar2() throws Exception {
        System.out.println("Test de prueba para ingresar dinero negativo");
        int cantidad = -5;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        try {

            miCuenta.ingresar(cantidad);
            fail("Se ha producido un error");

        } catch (Exception e) {
            System.out.println(e);
            assertTrue(miCuenta.estado() == 4500);
        }

    }

     /**
     *
     * Test no valido con valor nulo
     */
    public void testIngresar3() throws Exception {
        System.out.println("Test de prueba para ingresar dinero nulo");
        int cantidad = 0;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        try {

            miCuenta.ingresar(cantidad);
            fail("Se ha producido un error");

        } catch (Exception e) {
            System.out.println(e);
            assertTrue(miCuenta.estado() == 4500);
        }

    }

     /**
     *
     * Test normal sin excepciones
     */
    public void testRetirar1() throws Exception {
        System.out.println("Test de prueba para retirar dinero positivo y mayor que 0");
        int cantidad = 1000;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        miCuenta.retirar(cantidad);
        assertTrue(miCuenta.estado() == 3500);
    }

    /**
     *
     * Test no valido con valor negativo
     */
    public void testRetirar2() throws Exception {
        System.out.println("Test de prueba para retirar dinero negativo");
        int cantidad = -5;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        try {

            miCuenta.retirar(cantidad);
            fail("Se ha producido un error");

        } catch (Exception e) {
            System.out.println(e);
            assertTrue(miCuenta.estado() == 4500);
        }

    }

    /**
     *
     * Test no valido con saldo negativo
     */
    public void testRetirar3() throws Exception {
     
        System.out.println("Test de prueba para retirar mas dinero del permitido");
        int cantidad = 5500;
        Cuenta miCuenta = new Cuenta("Antonio Sánchez", "1000-2365-85-123456799", 4500, 0);
        try {

            miCuenta.retirar(cantidad);
            fail("Se ha producido un error");

        } catch (Exception e) {
            System.out.println(e);
            assertTrue(miCuenta.estado() < 0);
        }

    }

}
