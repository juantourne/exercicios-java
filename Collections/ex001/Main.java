import java.util.Scanner;

void main() {
    var scanner = new Scanner(System.in);

    while(true) {
        System.out.println("Digite a operação que deseja realizar: ");
        System.out.println("\t 1: Soma");
        System.out.println("\t 2: Subtração");
        System.out.println("\t 3: Multiplicação");
        System.out.println("\t 4: Sair");
        var opcaoSelecionada = scanner.nextInt();

        while (opcaoSelecionada < 1 || opcaoSelecionada > 4) {
            System.out.println("Digite um valor válido conforme o menu informado: ");
            opcaoSelecionada = scanner.nextInt();
        }

        if (opcaoSelecionada == 4) {
            break;
        }

        System.out.println("Digite os valores que deseja que ocorram na operação, separados por vírgula (ex: 1,2,3,4): ");
        String numeros = scanner.next();

        long[] listaNumeros = Arrays.stream(numeros.split(",")).mapToLong(Long::parseLong).toArray();

        long resultado = switch (opcaoSelecionada) {
            case 1 -> Operador.SOMA.calcular(listaNumeros);
            case 2 -> Operador.SUBTRACAO.calcular(listaNumeros);
            case 3 -> Operador.MULTIPLICACAO.calcular(listaNumeros);
            default -> 0;
        };

        String listaFormatada = getListaFormatada(opcaoSelecionada, numeros);

        System.out.printf("%s = %s\n", listaFormatada, resultado);
    }
}

private static String getListaFormatada(int opcaoSelecionada, String numeros) {
    String listaFormatada;

    if(opcaoSelecionada == Operador.SOMA.getValorNumerico()) {
        listaFormatada = numeros.replaceAll(",", " " + Operador.SOMA.getSimbolo() + " ");
    } else if (opcaoSelecionada == Operador.SUBTRACAO.getValorNumerico()) {
        listaFormatada = numeros.replaceAll(",", " " + Operador.SUBTRACAO.getSimbolo() + " ");
    } else {
        listaFormatada = numeros.replaceAll(",", " " + opcaoSelecionada + " " + Operador.MULTIPLICACAO.getSimbolo() + " ");
    }
    return listaFormatada;
}
