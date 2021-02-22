package portifolio.temperatura;

import java.util.Scanner;

public class TemperaturaMain {

    public static void main(String[] args) {
        int relatorio;
        int alteracao = 1;

        Scanner in = new Scanner(System.in);
        TemperaturaMetodos metodo = new TemperaturaMetodos();

        System.out.println("\n================================================================================================");
        System.out.printf("%-36s%-20s", "", "CONVERSOR DE TEMPERATURA");
        System.out.println("\n================================================================================================\n");
        System.out.printf("%-34s%-10s\n", "", "CELSIUS - FAHRENHEIT - KELVIN");

        System.out.println("\nEste conversor exibe as temperaturas máxima e mínima de uma região nas escalas Celsius, Fahrenheit e Kelvin." +
                "\nAo informar a temperatura na escala de uma região num determinado dia, faz-se a conversão para uma outra escala." +
                "\nPara obter um relatótio com as temperaturas de até 5 dias, preencha o formulário abaixo com as informações solicitadas.");

        do {

            switch (alteracao) {
                case 1:
                    metodo.formularioPrevisaoRegiao();
                    metodo.formularioPrevisaoTipo();
                case 2:
                    metodo.formularioPrevisaoDia();
                case 3:
                    metodo.formularioPrevisaoData();
                case 4:
                    if (alteracao == 4) {
                        metodo.formularioPrevisaoTipo();
                        metodo.formularioPrevisaoConversao();
                    } else {
                        metodo.formularioPrevisaoConversao();
                    }

            }

            metodo.relatorioPrevisao();

            do {

                System.out.println("\nDeseja alterar algo no relatório?\n" +
                        "1 - Sim\n" +
                        "2 - Não");
                relatorio = in.nextInt();

                if (relatorio == 1) {
                    System.out.println("\nO que pretende alterar?\n" +
                            "1 - Região\n" +
                            "2 - Quantidade de dias\n" +
                            "3 - Datas da previsão\n" +
                            "4 - Tipo de conversão");
                    alteracao = in.nextInt();

                } else if (relatorio == 2) {
                    System.out.println("\nRelatório Finalizado.");
                    System.exit(0);
                } else {
                    System.out.println("\nCódigo desconhecido." +
                            "\nTente novamente.\n");
                }

            } while (relatorio < 1 || relatorio > 2);

        } while (alteracao > 0 && alteracao < 5);

    }

}
