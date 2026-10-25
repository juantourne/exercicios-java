import java.util.Arrays;

public enum Operador {
    SOMA(1, "+", nums -> Arrays.stream(nums)
                    .reduce(0L, Long::sum)),
    SUBTRACAO(2,"-", nums -> Arrays.stream(nums)
                        .reduce(nums[0], (n1,n2) -> n1-n2)),
    MULTIPLICACAO(3, "X", nums -> Arrays.stream(nums)
                    .reduce(1L, (n1,n2) -> n1 * n2));

    private final int valorNumerico;

    private final String simbolo;

    private final Operacao operacao;

    Operador(int valorNumerico, String simbolo, Operacao operacao) {
        this.valorNumerico = valorNumerico;
        this.simbolo = simbolo;
        this.operacao = operacao;
    }

    public long calcular(long... nums) {
        return operacao.calcular(nums);
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }
}
