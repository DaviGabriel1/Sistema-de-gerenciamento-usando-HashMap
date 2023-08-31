import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaDeGerenciamento {
    private Map<String,Integer> lista = new HashMap<>();
    private Scanner scan = new Scanner(System.in);


    public SistemaDeGerenciamento(){
        menu();
    }

    private void menu() {
        System.out.println("____SISTEMA DE GERENCIAMENTO____ \n [1]Consultar quantidade em estoque. \n " +
                "[2]Adicionar produtos ao estoque. \n [3]Retirar produtos do estoque. \n [4]alterar o nome do produto \n [5]consultar situação \n [6]sair");
        int opcao = scan.nextInt();
        scan.nextLine();
            switch (opcao){
                case 1:
                    if (lista.isEmpty()){
                        System.out.println("não há nenhum item cadastrado");
                        menu();
                    } else {
                        System.out.println("Digite o nome do produto que deseja consultar: ");
                        String nome = scan.nextLine();
                        consultarQuantidade(nome);
                    }
                    break;
                case 2:
                    System.out.println("digite o nome do produto que deseja adicionar: ");
                    String nomeCriar = scan.nextLine();
                    System.out.println("digite a quantidade: ");
                    int quant = scan.nextInt();
                    adicionarProduto(nomeCriar,quant);
                    break;
                case 3:
                    System.out.println("Digite o nome do produto que deseja remover: ");
                    String nomeRemover = scan.nextLine();
                    removerItem(nomeRemover);
                    break;
                case 4:
                    System.out.println("Digite o nome do item que deseja alterar: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o novo nome: ");
                    String nomeNovo = scan.nextLine();
                    alterarNome(nome,nomeNovo);
                    break;
                case 5:
                    consultarSituacao();
                case 6:
                    System.exit(0);
                    break;
        }
    }

    private void consultarSituacao() {
        if(lista.size() < 10){
            System.out.println("AVISO: estoque abaixo de 10 itens");
        } else{
            System.out.println("estoque sem alertas");
        }
        menu();
    }

    private void alterarNome(String nome, String nomeNovo) {
        int quantidade = lista.get(nome).intValue();
        lista.remove(nome);
        lista.put(nomeNovo,quantidade);
        System.out.println("nome do produto alterado com sucesso para "+nomeNovo);
        menu();
    }

    private void removerItem(String nomeRemover) {
        lista.remove(nomeRemover);
        System.out.println("item "+nomeRemover+" removido com sucesso");
        menu();
    }

    private void adicionarProduto(String nomeCriar, int quant) {
        lista.put(nomeCriar,quant);
        System.out.println("produto "+nomeCriar+",quantidade: "+quant+" adicionado com sucesso");
        menu();
    }

    private void consultarQuantidade(String nome) {
        System.out.println("o item " + nome + " está na lista com a quantidade " + lista.get(nome));
        menu();

    }
}
