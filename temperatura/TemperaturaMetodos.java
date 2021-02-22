package portifolio.temperatura;

import java.util.Scanner;

public class TemperaturaMetodos {
    String pais;
    String estado;
    String cidade;
    private String escala;
    int escolha;
    int dia;
    int tipo;
    String[] D;
    float[] EMax;
    float[] EMin;

    public float[] getEMax() { return EMax; }
    public float[] getEMin() { return EMin; }

    Scanner in = new Scanner(System.in);

    TemperaturaMCelsius celsius = new TemperaturaMCelsius();
    TemperaturaMFahrenheit fahrenheit = new TemperaturaMFahrenheit();
    TemperaturaMKelvin kelvin = new TemperaturaMKelvin();

    public void formularioPrevisaoRegiao() {

        // insere o nome do local de onde se pretende fazer a conversão das temperaturas
        System.out.print("\nInsira o nome do país: ");
        pais = in.nextLine();
        System.out.print("\nInsira o nome estado: ");
        estado = in.nextLine();
        System.out.print("\nInsira o nome da cidade: ");
        cidade = in.nextLine();
        // seleciona a escala de temperatura da região escolhida
        System.out.println("\nSelecione a escala de temperatura da região:");
        do {
            System.out.println("1 - Celsius\n" +
                    "2 - Fahrenheit\n" +
                    "3 - Kelvin");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    escala = celsius.getNomeEscala();
                    break;
                case 2:
                    escala = fahrenheit.getNomeEscala();
                    break;
                case 3:
                    escala = kelvin.getNomeEscala();
                    break;
                default:
                    System.out.println("\nCódigo desconhecido." +
                            "\nTente novamente.\n");
            }

        } while (escolha < 1 || escolha > 3);
    }

            // seleciona o tipo de conversão entre duas temperaturas a ser realizada
    public void formularioPrevisaoTipo() {
        System.out.println("\nSelecione o tipo de conversão que deseja realizar:");
        do {

            switch (escala) {
                case "Celsius":
                    System.out.println("1 - Celsius para Fahrenheit\n" +
                            "2 - Celsius para Kelvin");
                    tipo = in.nextInt();
                    break;
                case "Fahrenheit":
                    System.out.println("1 - Fahrenheit para Celsius\n" +
                            "2 - Fahrenheit para Kelvin");
                    tipo = in.nextInt();
                    break;
                case "Kelvin":
                    System.out.println("1 - Kelvin para Celsius\n" +
                            "2 - Kelvin para Fahrenheit");
                    tipo = in.nextInt();
                    break;
            }

            if (tipo < 1 || tipo > 2) {
                System.out.println("\nCódigo desconhecido." +
                        "\nTente novamente.\n");
            }

        } while (tipo < 1 || tipo > 2);

    }

        // seleciona a quantidade de dias os quais se deseja fazer a conversão das temperaturas
    public void formularioPrevisaoDia() {

        System.out.println("\nDeseja realizar a conversão de temperatura de quantos dias (até 5 dia)?");
        dia = in.nextInt();
        in.nextLine();
    }

    // armazena as datas
    public void formularioPrevisaoData() {
        int d = 5;
        D = new String[d];

        System.out.println("\nInsira as datas.\n");
        for (int n = 0; n < dia; n++) {
            System.out.print("Data do " + (n + 1) + "º dia (XX/XX/XXXX): ");
            D[n] = in.nextLine();
        }
    }

    // armazena as temperaturas máxima e mínima para cada data e faz a conversão
    public void formularioPrevisaoConversao() {
        int e = 5;
        EMax =new float[e];

        int m = 5;
        EMin =new float[m];

        System.out.println("\nInsira as temperaturas máxima e mínima.\n");
        switch (escala) {

            case "Celsius":
                celsius.setQuantidade(dia);
                celsius.getArmazenarEscalaMaxima();
                System.out.println("");
                celsius.getArmazenarEscalaMinima();

                if (tipo == 1) {
                    // armazena temperaturas máxima e mínima e converte para Fahrenheit
                    for (int n = 0; n < dia; n++) {
                        fahrenheit.setC(celsius.getVMax()[n]);
                        fahrenheit.getConversor1();
                        EMax[n] = fahrenheit.getF();
                    }

                    for (int n = 0; n < dia; n++) {
                        fahrenheit.setC(celsius.getVMin()[n]);
                        fahrenheit.getConversor1();
                        EMin[n] = fahrenheit.getF();
                    }
                    //armazena temperaturas mínima e mínima converte para Kelvin
                } else if (tipo == 2) {

                    for (int n = 0; n < dia; n++) {
                        kelvin.setC(celsius.getVMax()[n]);
                        kelvin.getConversor1();
                        EMax[n] = kelvin.getK();
                    }

                    for (int n = 0; n < dia; n++) {
                        kelvin.setC(celsius.getVMin()[n]);
                        kelvin.getConversor1();
                        EMin[n] = kelvin.getK();
                    }
                }
                break;

            case "Fahrenheit":
                fahrenheit.setQuantidade(dia);
                fahrenheit.getArmazenarEscalaMaxima();
                System.out.println("");
                fahrenheit.getArmazenarEscalaMinima();

                if (tipo == 1) {

                    for (int n = 0; n < dia; n++) {
                        celsius.setF(fahrenheit.getVMax()[n]);
                        celsius.getConversor1();
                        EMax[n] = celsius.getC();
                    }

                    for (int n = 0; n < dia; n++) {
                        celsius.setF(fahrenheit.getVMin()[n]);
                        celsius.getConversor1();
                        EMin[n] = celsius.getC();
                    }

                } else if (tipo == 2) {

                    for (int n = 0; n < dia; n++) {
                        kelvin.setF(fahrenheit.getVMax()[n]);
                        kelvin.getConversor2();
                        EMax[n] = kelvin.getK();
                    }

                    for (int n = 0; n < dia; n++) {
                        kelvin.setF(fahrenheit.getVMin()[n]);
                        kelvin.getConversor2();
                        EMin[n] = kelvin.getK();
                    }

                }
                break;

            case "Kelvin":
                kelvin.setQuantidade(dia);
                kelvin.getArmazenarEscalaMaxima();
                System.out.println("");
                kelvin.getArmazenarEscalaMinima();

                if (tipo == 1) {

                    for (int n = 0; n < dia; n++) {
                        celsius.setK(kelvin.getVMax()[n]);
                        celsius.getConversor2();
                        EMax[n] = celsius.getC();
                    }

                    for (int n = 0; n < dia; n++) {
                        celsius.setK(kelvin.getVMin()[n]);
                        celsius.getConversor2();
                        EMin[n] = celsius.getC();
                    }

                } else if (tipo == 2) {

                    for (int n = 0; n < dia; n++) {
                        fahrenheit.setK(kelvin.getVMax()[n]);
                        fahrenheit.getConversor2();
                        EMax[n] = fahrenheit.getF();
                    }

                    for (int n = 0; n < dia; n++) {
                        fahrenheit.setK(kelvin.getVMin()[n]);
                        fahrenheit.getConversor2();
                        EMin[n] = fahrenheit.getF();
                    }

                }
                break;

        }

    }
        // gera um relatório a partir das informações do formulário
    public void relatorioPrevisao() {

        System.out.printf("\n%-8s%-10s\n","", cidade + " - " + estado + " - " + pais);
        System.out.printf("%-15s%-10s\n", "", "Escala " + escala);
        System.out.println("================================================");

        for (int n = 0; n < dia; n++) {

            System.out.printf("%-18s%-17s\n", "", D[n]);
            System.out.println("================================================");

            switch (escala) {
                case "Celsius":
                    if (tipo == 1) {
                        System.out.printf("%-14s%-16s%-16s\n", "", "Celsius(ºC)", "Fahrenheit(ºF)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", celsius.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", celsius.getVMin()[n], EMin[n]);

                    } else if (tipo == 2) {
                        System.out.printf("%-14s%-18s%-16s\n", "", "Celsius (ºC)", "Kelvin (K)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", celsius.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", celsius.getVMin()[n], EMin[n]);
                    }
                    System.out.println("================================================");
                    break;

                case "Fahrenheit":
                    if (tipo == 1) {
                        System.out.printf("%-12s%-20s%-16s\n", "", "Fahrenheit(ºF)", "Celsius(ºC)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", fahrenheit.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", fahrenheit.getVMin()[n], EMin[n]);

                    } else if (tipo == 2) {
                        System.out.printf("%-12s%-21s%-16s\n", "", "Fahrenheit(ºF)", "Kelvin(K)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", fahrenheit.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", fahrenheit.getVMin()[n], EMin[n]);
                    }
                    System.out.println("================================================");
                    break;

                case "Kelvin":
                    if (tipo == 1) {
                        System.out.printf("%-14s%-19s%-16s\n", "", "Kelvin(K)", "Celsius(ºC)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", kelvin.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", kelvin.getVMin()[n], EMin[n]);

                    } else if (tipo == 2) {
                        System.out.printf("%-14s%-17s%-16s\n", "", "Kelvin(K)", "Fahrenheit(ºF)");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmax", kelvin.getVMax()[n], EMax[n]);
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-4s%-12s%-18.2f%-14.2f\n", "", "Tmin", kelvin.getVMin()[n], EMin[n]);
                    }
                    System.out.println("================================================");
                    break;

            }

        }

    }

}