public interface Arvore<E> {
    Posicao<E> raiz();
    Posicao<E> pai(Posicao<E> posicao);
    Iterable<Posicao<E>> filhos(Posicao<E> posicao);
    Boolean temFilhos(Posicao<E> posicao);
    Boolean ehFolha(Posicao<E> posicao);
    Boolean ehRaiz(Posicao<E> posicao);
    Boolean temPai(Posicao<E> posicao);
    Integer tamanho();
    Boolean estaVazia();
    Integer altura(Posicao<E> posicao);
    Integer profundidade(Posicao<E> posicao);
}
