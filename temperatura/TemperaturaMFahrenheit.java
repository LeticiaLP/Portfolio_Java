package portifolio.temperatura;

import java.util.Scanner;

public class TemperaturaMFahrenheit implements TemperaturaInterface{

    private float C;
    private float K;
    private float F;
    private float[] VMax;
    private float[] VMin;
    private int quantidade;

    Scanner in = new Scanner(System.in);

    public float getC() {
        return C;
    }
    public void setC(float c) {
        C = c;
    }

    public float getK() {
        return K;
    }
    public void setK(float K) {
        this.K = K;
    }

    public float getF() { return F; }
    public void setF(float f) { F = f; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public float[] getVMax() { return VMax; }

    public float[] getVMin() { return VMin; }

    @Override
    public String getNomeEscala() { return "Fahrenheit"; }

    @Override
    public float getConversor1() {
        F = ((9 * C) + 160) / 5;
        return F;
    }

    @Override
    public float getConversor2() {
        F = (((9 * K) - 2457) / 5) + 32;
        return F;
    }

    @Override
    public void getArmazenarEscalaMaxima() {
        int v = 5;
        VMax = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura máxima em °F do " + (n + 1) + "° dia: ");
            VMax[n] = in.nextFloat();
        }
    }

    @Override
    public void getArmazenarEscalaMinima() {
        int v = 5;
        VMin = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura mínima em °F do " + (n + 1) + "° dia: ");
            VMin[n] = in.nextFloat();
        }
    }
}
