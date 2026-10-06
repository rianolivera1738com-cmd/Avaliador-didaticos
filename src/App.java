import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        AvaliadorSenha avaliador = new AvaliadorSenha();
        Scanner scanner = new Scanner(System.in);

        exibirBoasVindas();

        boolean executando = true;

        while (executando) {
            System.out.println("--------------------------------------------------------------");
            System.out.print("Informe uma senha fictícia (ou 'sair' para encerrar): ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String entrada = scanner.nextLine();

            if (entrada.trim().equalsIgnoreCase("sair")) {
                executando = false;
                System.out.println("\nPrograma encerrado pelo usuário. Bons estudos!");
                break;
            }

            ResultadoValidacao resultado = avaliador.avaliar(entrada);

            if (resultado.isValida()) {
                System.out.println("\n>>> [SUCESSO] Senha válida e segura!");
                System.out.println("A senha informada atende a todos os critérios didáticos estabelecidos:");
                System.out.println("  ✓ Comprimento mínimo de 8 caracteres");
                System.out.println("  ✓ Pelo menos uma letra maiúscula (A-Z)");
                System.out.println("  ✓ Pelo menos uma letra minúscula (a-z)");
                System.out.println("  ✓ Pelo menos um dígito numérico (0-9)");
                System.out.println("  ✓ Pelo menos um caractere especial (!@#$% etc.)\n");

                System.out.print("Deseja avaliar outra senha fictícia? (s/n): ");
                String resposta = scanner.hasNextLine() ? scanner.nextLine().trim() : "n";
                if (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("sim")) {
                    executando = false;
                    System.out.println("\nObrigado por utilizar o ValidaSenhaForte. Até a próxima!");
                }
            } else {
                System.out.println("\n>>> [ATENÇÃO] Regra não atendida: " + resultado.getNomeRegraNaoAtendida());
                System.out.println("Orientaçao: " + resultado.getOrientacao());
                System.out.println("Tente novamente corrigindo o ponto indicado acima.\n");
            }
        }

        scanner.close();
    }

    private static void exibirBoasVindas() {
        System.out.println("==============================================================");
        System.out.println("        VALIDASENHAFORTE - AVALIADOR DIDÁTICO DE SENHAS       ");
        System.out.println("==============================================================");
        System.out.println("Escopo: Avaliação didática em memória com repetição de tentativas.");
        System.out.println("Informe senhas fictícias para aprender os critérios de segurança.");
        System.out.println("Digite 'sair' a qualquer momento para encerrar.");
        System.out.println("==============================================================\n");
    }
}
