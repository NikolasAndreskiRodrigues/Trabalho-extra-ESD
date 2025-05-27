import java.util.ArrayList;
import java.util.List;

public class No<E> implements Posicao<E> {

    private E elemento;
    private No<E> pai;
    private List<No<E>> filhos = new ArrayList<>();

    public No(E elemento, No<E> pai) {
        this.elemento = elemento;
        this.pai = pai;
    }

    public E getElemento() {
        return elemento;
    }

    public No<E> getPai() {
        return pai;
    }

    public List<No<E>> getFilhos() {
        return filhos;
    }

    public void adicionarFilho(No<E> filho) {
        filhos.add(filho);
    }
}

