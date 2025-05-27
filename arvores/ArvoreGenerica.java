import java.util.ArrayList;

public class ArvoreGenerica<E> implements Arvore<E> {

    private No<E> raiz;
    private Integer tamanho;

    public ArvoreGenerica() {
        raiz = null;
        tamanho = 0;
    }

    public Posicao<E> adicionarRaiz(E elemento) {
    raiz = new No<>(elemento, null);
    tamanho = 1;
    return raiz;
}

    public Posicao<E> adicionarFilho(Posicao<E> posicaoPai, E elemento) {
        No<E> pai = validarNo(posicaoPai);
        No<E> filho = new No<>(elemento, pai);
        pai.adicionarFilho(filho);
        tamanho++;
        return filho;
    }

    private No<E> validarNo(Posicao<E> posicao) {
        if (!(posicao instanceof No)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (No<E>) posicao;
    }

    public void percursoPreOrdem(Posicao<E> posicao) {
        System.out.print(posicao.getElemento() + " ");

        for (Posicao<E> filho : filhos(posicao)) {
            percursoPreOrdem(filho);
        }
    }

    public void percursoPosOrdem(Posicao<E> posicao) {
        for (Posicao<E> filho : filhos(posicao)) {
            percursoPosOrdem(filho);
        }
        
        System.out.print(posicao.getElemento() + " ");
    }

    public void percursoFolha(Posicao<E> posicao) {
    if (!temFilhos(posicao)) {
        System.out.println("Folha: " + posicao.getElemento());
    } else {
        for (Posicao<E> filho : filhos(posicao)) {
            percursoFolha(filho);
        }
    }
}

    @Override
    public Posicao<E> raiz() {
        return raiz;
    }

    @Override
    public Posicao<E> pai(Posicao<E> posicao) {
        return validarNo(posicao).getPai();
    }

    @Override
    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) {
        return new ArrayList<>(validarNo(posicao).getFilhos());
    }

    @Override
    public Boolean ehFolha(Posicao<E> posicao) {
        if (temFilhos(posicao)) {
            System.out.println("Posição não é uma folha: " + posicao.getElemento());
            return false;
        } else {
            System.out.println("Posição é uma folha: " + posicao.getElemento());
            return true;
        }
    }

    @Override
    public Boolean temFilhos(Posicao<E> posicao) {
        No<E> no = validarNo(posicao);
        return !no.getFilhos().isEmpty();
    }

    @Override
    public Boolean temPai(Posicao<E> posicao) {
        // TODO
        return false;
    }

    @Override
    public Boolean ehRaiz(Posicao<E> posicao) {
        return posicao == raiz;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }

    @Override
    public Boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public Integer altura(Posicao<E> posicao) {
        if (ehFolha(posicao)) return 0;
        Integer altura = 0;
        for (Posicao<E> filho : filhos(posicao)) {
            altura = Math.max(altura, altura(filho));
        }
        return 1 + altura;
    }

    @Override
    public Integer profundidade(Posicao<E> posicao) {
        int profundidade;
        if (ehRaiz(posicao)) {
            profundidade = 0;
        } else {
            profundidade = 1 + profundidade(pai(posicao));
        }
        System.out.println("Profundidade de " + posicao.getElemento() + ": " + profundidade);
        return profundidade;
    }
}
