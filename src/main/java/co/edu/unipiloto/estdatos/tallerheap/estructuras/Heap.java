package co.edu.unipiloto.estdatos.tallerheap.estructuras;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Heap <T> implements IHeap<T>{
    
    private ArrayList<T> elementos;
    private Comparator<T> comparador;

    public Heap(Comparator<T> comparador) {
        this.comparador = comparador;
        this.elementos = new ArrayList<>();
    }
    private int padre(int i) { return (i - 1) / 2; }
    private int izquierdo(int i) { return 2 * i + 1; }
    private int derecho(int i) { return 2 * i + 2; }

    public void add(T elemento) {
        elementos.add(elemento);
        siftUp();
    }

    public T peek() {
        return elementos.isEmpty() ? null : elementos.get(0);
    }

    public T poll() {
        if (elementos.isEmpty()) return null;
        T raiz = elementos.get(0);
        T ultimo = elementos.remove(elementos.size() - 1);
        if (!elementos.isEmpty()) {
            elementos.set(0, ultimo);
            siftDown();
        }
        return raiz;
    }
    public int size() {
        return elementos.size();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public void siftUp() {
        int i = elementos.size() - 1;
        while (i > 0) {
            int p = padre(i);
            if (comparador.compare(elementos.get(i), elementos.get(p)) > 0) {
                Collections.swap(elementos, i, p);
                i = p;
            } else {
                break;
            }
        }
    }

    public void siftDown() {
        int i = 0;
        int size = elementos.size();
        while (izquierdo(i) < size) {
            int izq = izquierdo(i);
            int der = derecho(i);
            int mejor = izq;

            if (der < size && comparador.compare(elementos.get(der), elementos.get(izq)) > 0) {
                mejor = der;
            }

            if (comparador.compare(elementos.get(mejor), elementos.get(i)) > 0) {
                Collections.swap(elementos, i, mejor);
                i = mejor;
            } else {
                break;
            }
        }
    }

    public ArrayList<T> toList() {
        return new ArrayList<>(elementos);
    }
}
