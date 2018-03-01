package ED04.bote;

/**
 * Clase que define propiedades y operaciones de un Bote de Pintura.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Bote {

    private int contenido;//Centilitros de pintura disponibles en el bote
    private int centilitros_metro;//Centrilitros necesarios para pintar un metro cuadrado
    private String color;//Color de la pintura
    private int precio;//Precio en céntimos del centilitro de pintura
    private int capacidad;//Número máximo de centilitros que caben en el bote

    /**
     * Constructor por defecto
     */
    public Bote() {
    }

    /**
     * Constructor por parametros
     *
     * @param contenido Centilitros de pintura disponibles en el bote
     * @param centilitros_metro Centrilitros necesarios para pintar un metro
     * cuadrado
     * @param color Color de la pintura
     * @param precio Precio en céntimos del centilitro de pintura
     * @param capacidad Número máximo de centilitros que caben en el bote
     */
    public Bote(int contenido, int centilitros_metro, String color, int precio, int capacidad) {
        this.contenido = contenido;
        this.centilitros_metro = centilitros_metro;
        this.color = color;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    /**
     * Método que devuelve el contenido en centilitros del bote
     *
     * @return el contenido
     */
    public int getContenido() {
        return contenido;
    }

    /**
     * Método que modifica el contenido en centilitros del bote
     *
     * @param contenido el nuevo contenido del bote
     */
    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que devuelve el contenido en centilitros necesario para pintar un
     * metro cuadrado
     *
     * @return el contenido en centilitros por metro cuadrado
     */
    public int getCentilitros_metro() {
        return centilitros_metro;
    }

    /**
     * Metodo que modifica el contenido necesario en centilitros para pinta run
     * emtro cuadrado
     *
     * @param centilitros_metro el nuevo numero de centilitros por metro
     * cuadrado
     */
    public void setCentilitros_metro(int centilitros_metro) {
        this.centilitros_metro = centilitros_metro;
    }

    /**
     * Metodo que devulve el color
     *
     * @return el color
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo que modifica el color
     *
     * @param color el nuevo color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo que devuelve el precio
     *
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Metodo que modifica el precio
     *
     * @param precio el nuevo precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Metodo que devuelve la capacidad
     *
     * @return capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     *
     * Metodo que modifica la capacidad del bote
     *
     * @param capacidad la nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Método que permite pintar una superficie, es necesario que haya
     * suficiente pintura en el bote y que la superficie que se va a pintar sea
     * positiva
     *
     * @param metros metros que se van a pitnar
     * @throws Exception Salta la excepcion al introducir una superficie
     * negativa
     */
    public void pintar(int metros) throws Exception {
        if (metros * this.getCentilitros_metro() > this.getContenido()) {
            throw new Exception("No hay pintura suficiente para pintar esa superficie");
        }
        if (metros <= 0) {
            throw new Exception("No tiene sentido pintar una superficie que no sea positiva");
        }
        this.setContenido(this.getContenido() - (metros * this.getCentilitros_metro()));
    }

    /**
     * Método que permite aumentar el contenido del bote de pintura, es
     * necesario que la cantidad que se quiere añadir y el dinero con que se va
     * a pagar sean positvos, además el dinero debe ser suficiente para pagar la
     * cantidad que se va a añadir
     *
     * @param centilitros cantidad en centilitros, que vamos a rellenar
     * @param centimos dinero con el que se va a pagar
     * @param color color con el que se va a rellenar
     * @throws Exception se produce una excepcion si, se introduce dinero o
     * centilitros negativo, tambien por no tener dinero suficiente o por hacer
     * rebosar el bote
     */
    public void rellenar(int centilitros, int centimos, String color) throws Exception {
        if (centimos <= 0) {
            throw new Exception("Se necesita una cantidad positiva de dinero");
        }
        if (centilitros <= 0) {
            throw new Exception("Los centilitros deben ser positivos");
        }

        if (this.getContenido() + centilitros > getCapacidad()) {
            throw new Exception("No se puede superar la capacidad del bote");
        }
        if (centimos < centilitros * getPrecio()) {
            throw new Exception("No tiene dinero suficiente");
        }
        this.setContenido(this.getContenido() + centilitros);
    }

}
