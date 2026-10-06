import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Avaliador responsável por analisar senhas conforme critérios didáticos.
 * A avaliação é realizada estritamente em memória e interrompida na primeira regra não atendida.
 */
public class AvaliadorSenha {

    private final List<RegraValidacao> regras;

    public AvaliadorSenha() {
        this.regras = new ArrayList<>();
        configurarRegrasPadrao();
    }

    private void configurarRegrasPadrao() {
        // Regra 1: Comprimento Mínimo
        regras.add(new RegraValidacao() {
            @Override
            public String getNome() {
                return "Comprimento Mínimo (8 caracteres)";
            }

            @Override
            public boolean validar(String senha) {
                return senha != null && senha.length() >= 8;
            }

            @Override
            public String getOrientacao(String senha) {
                int tamanhoAtual = (senha == null) ? 0 : senha.length();
                return String.format(
                    "A senha deve conter no mínimo 8 caracteres. O comprimento atual é de %d caractere(s). Adicione mais caracteres.",
                    tamanhoAtual
                );
            }
        });

        // Regra 2: Letra Maiúscula
        regras.add(new RegraValidacao() {
            @Override
            public String getNome() {
                return "Letra Maiúscula";
            }

            @Override
            public boolean validar(String senha) {
                if (senha == null) return false;
                for (char c : senha.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getOrientacao(String senha) {
                return "A senha deve conter ao menos uma letra maiúscula (A-Z). Adicione ao menos uma letra maiúscula.";
            }
        });

        // Regra 3: Letra Minúscula
        regras.add(new RegraValidacao() {
            @Override
            public String getNome() {
                return "Letra Minúscula";
            }

            @Override
            public boolean validar(String senha) {
                if (senha == null) return false;
                for (char c : senha.toCharArray()) {
                    if (Character.isLowerCase(c)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getOrientacao(String senha) {
                return "A senha deve conter ao menos uma letra minúscula (a-z). Adicione ao menos uma letra minúscula.";
            }
        });

        // Regra 4: Número / Dígito
        regras.add(new RegraValidacao() {
            @Override
            public String getNome() {
                return "Número";
            }

            @Override
            public boolean validar(String senha) {
                if (senha == null) return false;
                for (char c : senha.toCharArray()) {
                    if (Character.isDigit(c)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getOrientacao(String senha) {
                return "A senha deve conter ao menos um número (0-9). Adicione ao menos um dígito numérico.";
            }
        });

        // Regra 5: Caractere Especial
        regras.add(new RegraValidacao() {
            @Override
            public String getNome() {
                return "Caractere Especial";
            }

            @Override
            public boolean validar(String senha) {
                if (senha == null) return false;
                for (char c : senha.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getOrientacao(String senha) {
                return "A senha deve conter ao menos um caractere especial (ex: !@#$%&*_-+=<>?). Adicione um símbolo.";
            }
        });
    }

    /**
     * Avalia a senha informada e retorna o resultado.
     * Retorna na primeira regra não atendida, fornecendo a respectiva orientação didática.
     *
     * @param senha Senha fictícia informada pelo usuário.
     * @return ResultadoValidacao contendo o status e a orientação da primeira regra não atendida.
     */
    public ResultadoValidacao avaliar(String senha) {
        if (senha == null || senha.isEmpty()) {
            return ResultadoValidacao.falha(
                "Senha Vazia",
                "A senha informada está em branco. Digite uma senha para avaliação."
            );
        }

        for (RegraValidacao regra : regras) {
            if (!regra.validar(senha)) {
                return ResultadoValidacao.falha(regra.getNome(), regra.getOrientacao(senha));
            }
        }

        return ResultadoValidacao.sucesso();
    }

    /**
     * Retorna a lista de regras didáticas configuradas (somente leitura).
     */
    public List<RegraValidacao> getRegras() {
        return Collections.unmodifiableList(regras);
    }
}

