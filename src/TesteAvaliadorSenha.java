/**
 * Suíte de testes automatizados em console para validar a lógica didática do AvaliadorSenha.
 */
public class TesteAvaliadorSenha {

    public static void main(String[] args) {
        AvaliadorSenha avaliador = new AvaliadorSenha();
        int totalTestes = 0;
        int sucessos = 0;

        System.out.println("Iniciando bateria de testes do AvaliadorSenha...");

        // Teste 1: Senha vazia
        totalTestes++;
        ResultadoValidacao r1 = avaliador.avaliar("");
        if (!r1.isValida() && r1.getNomeRegraNaoAtendida().equals("Senha Vazia")) {
            sucessos++;
            System.out.println("✓ Teste 1 passou: Senha vazia identificada.");
        } else {
            System.err.println("✗ Teste 1 falhou: " + r1.getOrientacao());
        }

        // Teste 2: Senha curta (< 8 caracteres)
        totalTestes++;
        ResultadoValidacao r2 = avaliador.avaliar("Ab1!");
        if (!r2.isValida() && r2.getNomeRegraNaoAtendida().contains("Comprimento Mínimo")) {
            sucessos++;
            System.out.println("✓ Teste 2 passou: Comprimento insuficiente identificado.");
        } else {
            System.err.println("✗ Teste 2 falhou: " + r2.getOrientacao());
        }

        // Teste 3: Sem letra maiúscula
        totalTestes++;
        ResultadoValidacao r3 = avaliador.avaliar("abcdef1!");
        if (!r3.isValida() && r3.getNomeRegraNaoAtendida().equals("Letra Maiúscula")) {
            sucessos++;
            System.out.println("✓ Teste 3 passou: Falta de letra maiúscula identificada.");
        } else {
            System.err.println("✗ Teste 3 falhou: " + r3.getOrientacao());
        }

        // Teste 4: Sem letra minúscula
        totalTestes++;
        ResultadoValidacao r4 = avaliador.avaliar("ABCDEF1!");
        if (!r4.isValida() && r4.getNomeRegraNaoAtendida().equals("Letra Minúscula")) {
            sucessos++;
            System.out.println("✓ Teste 4 passou: Falta de letra minúscula identificada.");
        } else {
            System.err.println("✗ Teste 4 falhou: " + r4.getOrientacao());
        }

        // Teste 5: Sem número
        totalTestes++;
        ResultadoValidacao r5 = avaliador.avaliar("Abcdefgh!");
        if (!r5.isValida() && r5.getNomeRegraNaoAtendida().equals("Número")) {
            sucessos++;
            System.out.println("✓ Teste 5 passou: Falta de número identificada.");
        } else {
            System.err.println("✗ Teste 5 falhou: " + r5.getOrientacao());
        }

        // Teste 6: Sem caractere especial
        totalTestes++;
        ResultadoValidacao r6 = avaliador.avaliar("Abcdefg1");
        if (!r6.isValida() && r6.getNomeRegraNaoAtendida().equals("Caractere Especial")) {
            sucessos++;
            System.out.println("✓ Teste 6 passou: Falta de caractere especial identificada.");
        } else {
            System.err.println("✗ Teste 6 falhou: " + r6.getOrientacao());
        }

        // Teste 7: Senha válida completa
        totalTestes++;
        ResultadoValidacao r7 = avaliador.avaliar("Senha@123");
        if (r7.isValida()) {
            sucessos++;
            System.out.println("✓ Teste 7 passou: Senha completa validada com sucesso.");
        } else {
            System.err.println("✗ Teste 7 falhou: " + r7.getOrientacao());
        }

        // Teste 8: Outra senha válida com diferentes símbolos
        totalTestes++;
        ResultadoValidacao r8 = avaliador.avaliar("Xpto#9876");
        if (r8.isValida()) {
            sucessos++;
            System.out.println("✓ Teste 8 passou: Senha alternativa validada com sucesso.");
        } else {
            System.err.println("✗ Teste 8 falhou: " + r8.getOrientacao());
        }

        System.out.println("\nResumo dos testes: " + sucessos + "/" + totalTestes + " testes aprovados.");
        if (sucessos != totalTestes) {
            System.exit(1);
        }
    }
}

