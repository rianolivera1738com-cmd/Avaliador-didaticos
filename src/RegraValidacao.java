/**
 * Representa uma regra didática individual para validação de senha.
 */
public interface RegraValidacao {
    /**
     * Nome descritivo da regra.
     */
    String getNome();

    /**
     * Verifica se a senha atende ao critério desta regra.
     *
     * @param senha Senha fictícia informada pelo usuário.
     * @return true se a regra for atendida, false caso contrário.
     */
    boolean validar(String senha);

    /**
     * Retorna a mensagem de orientação com instrução de como corrigir a senha
     * para atender a esta regra específica.
     *
     * @param senha Senha fictícia informada.
     * @return Texto de orientação didática para o usuário.
     */
    String getOrientacao(String senha);
}

