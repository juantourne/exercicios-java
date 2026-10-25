Scanner scanner = new Scanner(System.in);

void main() {
    //Input dos números
    System.out.println("Digite o número de telefone fixo (8 dígitos): ");
    long telefoneFixo = scanner.nextLong();

    //Validação do telefone fixo
    while(String.valueOf(telefoneFixo).length() != 8) {
        System.out.println("Digite um número de telefone fixo válido (8 dígitos): ");
        telefoneFixo = scanner.nextLong();
    }

    System.out.println("Digite o número de telefone de celular (11 dígitos): ");
    long telefoneCelular = scanner.nextLong();

    //Validação do telefone celular
    while(String.valueOf(telefoneCelular).length() != 11) {
        System.out.println("Digite um número de telefone celular válido (11 dígitos): ");
        telefoneCelular = scanner.nextLong();
    }

    //Conversão para String
    String formatoTelefoneFixo = String.valueOf(telefoneFixo);
    String formatoTelefoneCelular = String.valueOf(telefoneCelular);

    //Divisão da string do telefone fixo
    var inicioTelefoneFixo = formatoTelefoneFixo.substring(0,4);
    var finalTelefoneFixo = formatoTelefoneFixo.substring(4,8);

    //Divisão da string do telefone celular
    var ddd = formatoTelefoneCelular.substring(0,2);
    var inicioTelefoneCelular = formatoTelefoneCelular.substring(2,7);
    var finalTelefoneCelular = formatoTelefoneCelular.substring(7, 11);

    //Junção com máscara
    var telefoneFixoMascarado = inicioTelefoneFixo + "-" + finalTelefoneFixo;
    var telefoneCelularMascarado = "(" + ddd + ")" + " " + inicioTelefoneCelular + "-" + finalTelefoneCelular;

    System.out.println("=======");
    System.out.printf("Telefone fixo mascarado: %s\nTelefone celular mascarado: %s\n", telefoneFixoMascarado, telefoneCelularMascarado);
    System.out.println("=======");
}

