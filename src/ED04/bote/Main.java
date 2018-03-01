package ED04.bote;

/**
 * 
 * @author Ubaldo Hidalgo Arriaga
 */
public class Main {

    /**
     * Metodo que muestra por consola como se van realizando las operaciones
     * @param args 
     */
    public static void main(String[] args) {
        Bote bruguer;
        int centilitros=300;
        int centimos=200;
        int metros=2;
        
        bruguer=new Bote(300,10,"verde",2,500);
       
        opera_Pinta(bruguer, metros);
        opera_Rellena(bruguer, centilitros, centimos);
    }

    /**
     * Metodo que realiza la comprobacion de la operacion de rellenar un bote
     * @param bruguer el nombre que recibe el objeto Bote que vamos a modificar
     * @param centilitros la cantidad en centilitros que vamos a rellenas
     * @param centimos el dinero que vamos a invertir en rellenar el bote
     */
    public static void opera_Rellena(Bote bruguer, int centilitros, int centimos) {
        /*Vamos a intentar añadir 300 centilitros al bote, como se supera la capacidad saltará
        una excepción y no se modificará el contenido del depósito que seguirá siendo 280cl*/
        try {
            System.out.println("Vamos a rellenar el bote");
            bruguer.rellenar(centilitros, centimos, "verde");
            System.out.println("Recarga realizada, ahora tiene "+bruguer.getContenido()+" centilitros en el bote");
        } catch (Exception e) {
            System.out.println("Error al rellenar el bote, el contenido sigue siendo: "+bruguer.getContenido());
            
        }
    }

    /**
     * Metodo que realiza la comprobacion de la operacion de pintar con un bote
     * @param bruguer el bote con el que vamos a pintar
     * @param metros los metros cuadrados que vamos a pintar
     */
    public static void opera_Pinta(Bote bruguer, int metros) {
        /*Vamos a pintar 2 metros, como hay sufuiciente pintura la operación tendrá éxito y se
        descontarán 20 centilitros del contenido del bote, quedan 280cl*/
        try {
            System.out.println("Vamos a pintar");
            bruguer.pintar(metros);
            System.out.println("En el bote quedan "+bruguer.getContenido()+" centilitros");
        } catch (Exception e) {
            System.out.println("Error al pintar");
        }
    }
    
}
