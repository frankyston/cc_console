package org.cejug.cc_console;

import java.util.Scanner;

import org.cejug.cc_console.jdbc.CCConsoleJDBC;
import org.cejug.cc_console.pojo.Personagem;

/**
 * Classe principal para inciar o sistema.
 * 
 * @author helio frota https://www.heliofrota.com
 * 
 */
public class CCConsole {

    // Mensagens que serão mostradas de vez em quando.
    private static final String OPCAO_1 = "1 - Cadastrar personagem";
    private static final String OPCAO_2 = "2 - Listar personagens";
    private static final String OPCAO_3 = "3 - Remover personagem";
    private static final String OPCAO_4 = "4 - Atualizar personagem";
    private static final String OPCAO_0 = "0 - Sair";
    private static final String ESPACO = "-------------------------------\n";

    /**
     * Método main.
     * 
     * @param String... args
     */
    public static void main(String... args) {

        // Instanciando objeto da classe CCConsoleJDBC. 
        CCConsoleJDBC ccConsoleJDBC = new CCConsoleJDBC();

        // Irá guardar a opção escolhida no menu.
        String opcao = "99";
        
        // Fica em loop até opção 0 ser informada.
        do {

            switch (opcao) {
            case "1":

                // Mensagem...
                System.out.println("Qual o nome do seu personagem favorito ?");
                System.out.println(ESPACO);

                // Prepara o sistema para obter entrada de dados pelo teclado.
                Scanner opcao1 = new Scanner(System.in);
                // Guarda a opção informada.
                String nome = opcao1.nextLine();
                // Cria objeto personagem.
                Personagem personagem = new Personagem();
                // Atualiza a propriedade nome.
                personagem.setNome(nome);
                // Salva o objeto no banco de dados.
                ccConsoleJDBC.salvarPersonagem(personagem);

                // Mensagem...
                System.out.println("Personagem salvo com sucesso !");
                System.out.println(ESPACO);

                enchimentoDeLinguica();
                
                // Manda para o default do switch.
                opcao = "99";
                
                break;

            case "2":

                ccConsoleJDBC.listarPersonagens();
                System.out.println(ESPACO);

                enchimentoDeLinguica();
                
                // Manda para o default do switch.
                opcao = "99";

                break;

            case "3":

                // Lista todos os personagens.
                ccConsoleJDBC.listarPersonagens();
                System.out.println(ESPACO);
                
                // Mensagem...
                System.out.println("Informe o ID do personagem que deseja excluir.");
                System.out.println(ESPACO);

                // Prepara o sistema para obter entrada de dados pelo teclado.
                Scanner opcao3 = new Scanner(System.in);
                
                // Guarda a opção informada.
                String id = opcao3.nextLine();
                
                // Remove o personagem pelo id informado.
                ccConsoleJDBC.removerPersonagem(Integer.parseInt(id));
                
                enchimentoDeLinguica();
                
                // Manda para o default do switch.
                opcao = "99";
                
                break;
            case "4":

                // Lista todos os personagens.
                ccConsoleJDBC.listarPersonagens();
                System.out.println(ESPACO);
                
                // Mensagem...
                System.out.println("Informe o ID do personagem que deseja modificar.");
                System.out.println(ESPACO);

                // Prepara o sistema para obter entrada de dados pelo teclado.
                Scanner opcao4 = new Scanner(System.in);
                
                // Guarda a opção informada.
                String idAlterar = opcao4.nextLine();
                
                // Mensagem...
                System.out.println("Informe o novo nome do personagem.");
                System.out.println(ESPACO);
                
                // Prepara o sistema para obter entrada de dados pelo teclado.
                opcao4 = new Scanner(System.in);
                
                // Guarda a opção informada.
                String novoNome = opcao4.nextLine();
                
                // Altera o personagem pelo id informado.
                ccConsoleJDBC.atualizarPersonagem(Integer.parseInt(idAlterar), novoNome);
                
                enchimentoDeLinguica();
                
                // Manda para o default do switch.
                opcao = "99";

                
                break;

            case "0":
                System.exit(0);
                break;

            default:
                // Mostra o menu pela primeira vez.
                mostraMenu();

                // Prepara o sistema para obter entrada de dados pelo teclado.
                Scanner scanner = new Scanner(System.in);

                // Guarda a opção informada.
                opcao = scanner.nextLine();
                break;
            }

        } while (!opcao.equals("0"));

    }

    /**
     * Mostra o menu com as opções.
     */
    private static void mostraMenu() {
        System.out.println("Escolha uma opção e tecle < enter >");
        System.out.println(OPCAO_1);
        System.out.println(OPCAO_2);
        System.out.println(OPCAO_3);
        System.out.println(OPCAO_4);
        System.out.println(OPCAO_0);
        System.out.println(ESPACO);
    }
    
    /**
     * Enchimento de linguiça pra dizer que está processando alguma coisa...
     */
    private static void enchimentoDeLinguica() {
        // Tenta pausar a thread por 2 segundos.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
