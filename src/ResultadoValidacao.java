/**
 * Encapsula o resultado da avaliação da senha em memória.
 */
public class ResultadoValidacao {
    private final boolean valida;
    private final String nomeRegraNaoAtendida;
    private final String orientacao;

    private ResultadoValidacao(boolean valida, String nomeRegraNaoAtendida, String orientacao) {
        this.valida = valida;
        this.nomeRegraNaoAtendida = nomeRegraNaoAtendida;
        this.orientacao = orientacao;
    }

    public static ResultadoValidacao sucesso() {
        return new ResultadoValidacao(true, null, "A senha atende a todos os critérios didáticos de segurança!");
    }

    public static ResultadoValidacao falha(String nomeRegra, String orientacao) {
        return new ResultadoValidacao(false, nomeRegra, orientacao);
    }

    public boolean isValida() {
        return valida;
    }

    public String getNomeRegraNaoAtendida() {
        return nomeRegraNaoAtendida;
    }

    public String getOrientacao() {
        return orientacao;
    }
}

