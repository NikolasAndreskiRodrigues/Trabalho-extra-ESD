public class Main {

    public static void main(String[] args) {
        ArvoreGenerica arvore = new ArvoreGenerica<>();

        Posicao empresa = arvore.adicionarRaiz("Empresa");
        Posicao rh = arvore.adicionarFilho(empresa, "RH");
        Posicao ti = arvore.adicionarFilho(empresa, "TI");
        Posicao financeiro = arvore.adicionarFilho(empresa, "Financeiro");
        Posicao recrutamento = arvore.adicionarFilho(rh, "Recrutamento");
        Posicao beneficios = arvore.adicionarFilho(rh, "Benefícios");
        Posicao estagios = arvore.adicionarFilho(recrutamento, "Estágios");
        Posicao convenios = arvore.adicionarFilho(beneficios, "Convênios");
        Posicao desenvolvimento = arvore.adicionarFilho(ti, "Desenvolvimento");
        Posicao suporte = arvore.adicionarFilho(ti, "Suporte");
        Posicao frontend = arvore.adicionarFilho(desenvolvimento, "Front-end");
        Posicao backend = arvore.adicionarFilho(desenvolvimento, "Back-end");
        Posicao angular = arvore.adicionarFilho(frontend, "Angular");
        Posicao contabilidade = arvore.adicionarFilho(financeiro, "Contabilidade");
        Posicao impostos = arvore.adicionarFilho(contabilidade, "Impostos");

        arvore.percursoPreOrdem(empresa);
        arvore.percursoPosOrdem(empresa);
        System.out.println("----------------------------------");
        arvore.ehFolha(angular);
        arvore.ehFolha(frontend);
        System.out.println("----------------------------------");
        arvore.percursoFolha(empresa);
        System.out.println("----------------------------------");
        arvore.profundidade(angular);
    }
}
