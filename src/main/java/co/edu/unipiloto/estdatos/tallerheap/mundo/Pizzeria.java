package co.edu.unipiloto.estdatos.tallerheap.mundo;
import co.edu.unipiloto.estdatos.tallerheap.estructuras.Heap;
import java.util.ArrayList;
import java.util.Comparator;


public class Pizzeria 
{	
	// ----------------------------------
    // Constantes
    // ----------------------------------
	
	/**
	 * Constante que define la accion de recibir un pedido
	 */
	public final static String RECIBIR_PEDIDO = "RECIBIR";
	/**
	 * Constante que define la accion de atender un pedido
	 */
	public final static String ATENDER_PEDIDO = "ATENDER";
	/**
	 * Constante que define la accion de despachar un pedido
	 */
	public final static String DESPACHAR_PEDIDO = "DESPACHAR";
	/**
	 * Constante que define la accion de finalizar la secuencia de acciones
	 */
	public final static String FIN = "FIN";
	
	// ----------------------------------
    // Atributos
    // ----------------------------------
	private Heap<Pedido> pedidosRecibidos;
        private Heap<Pedido> pedidosPorDespachar;

        public Pizzeria() {
        pedidosRecibidos = new Heap<>(Comparator.comparingDouble(Pedido::getPrecio));
        pedidosPorDespachar = new Heap<>(Comparator.comparingInt(p -> -p.getCercania())); // menor cercanía = mayor prioridad
    }
	/**
	 * Heap que almacena los pedidos recibidos
	 */
	// TODO 
	/**
	 * Getter de pedidos recibidos
	 */
	// TODO 
 	/** 
	 * Cola de elementos por despachar
	 */
	// TODO 
	/**
	 * Getter de elementos por despachar
	 */
	// TODO 
	
	// ----------------------------------
    // Constructor
    // ----------------------------------

	/**
	 * Constructor de la case Pizzeria
	 */
	
	
	// ----------------------------------
    // Métodos
    // ----------------------------------
	
	/**
	 * Agrega un pedido a la cola de prioridad de pedidos recibidos
	 * @param nombreAutor nombre del autor del pedido
	 * @param precio precio del pedido 
	 * @param cercania cercania del autor del pedido 
	 */
	public void agregarPedido(String nombreAutor, double precio, int cercania) {
           pedidosRecibidos.add(new Pedido(nombreAutor, precio, cercania));
        }
	
	// Atender al pedido más importante de la cola
	
	/**
	 * Retorna el proximo pedido en la cola de prioridad o null si no existe.
	 * @return p El pedido proximo en la cola de prioridad
	 */
	public Pedido atenderPedido(){
            Pedido atendido = pedidosRecibidos.poll();
            if (atendido != null) {
                pedidosPorDespachar.add(atendido);
            }
            return atendido;
	}

	/**
	 * Despacha al pedido proximo a ser despachado. 
	 * @return Pedido proximo pedido a despachar
	 */
	public Pedido despacharPedido(){
            return pedidosPorDespachar.poll();
	}
	
	/**
	 * Retorna la cola de prioridad de pedidos recibidos como una lista. 
	 * @return list lista de pedidos recibidos.
	 */
	 public ArrayList<Pedido> pedidosRecibidosList(){
            return pedidosRecibidos.toList();
	 }
	 
	 /**
	  * Retorna la cola de prioridad de despachos como una lista. 
	  * @return list cola de prioridad de despachos.
	  */
	 public ArrayList<Pedido> colaDespachosList(){
            return pedidosPorDespachar.toList();
	 }
}
