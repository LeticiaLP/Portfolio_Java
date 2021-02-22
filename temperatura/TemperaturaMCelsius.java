package portifolio.temperatura;

import java.util.Scanner;

public class TemperaturaMCelsius implements TemperaturaInterface{

    Scanner in = new Scanner(System.in);

    private float F;
    private float K;
    private float C;
    private float[] VMax;
    private float[] VMin;
    private int quantidade;

    public float getF() {
        return F;
    }
    public void setF(float F) { this.F = F; }

    public float getK() {
        return K;
    }
    public void setK(float K) {
        this.K = K;
    }

    public float getC() { return C; }
    public void setC(float C) { this.C = C; }

    public float[] getVMax() { return VMax; }

    public float[] getVMin() { return VMin; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String getNomeEscala() {
        return "Celsius";
    }

    @Override
    public float getConversor1() {
        C = ((5 * F) - 160) / 9;
        return C;
    }

    @Override
    public float getConversor2() {
        C = K - 273;
        return C;
    }

    @Override
    public void getArmazenarEscalaMaxima() {
        int v = 5;
        VMax = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura máxima em ºC do " + (n + 1) + "º dia: ");
            VMax[n] = in.nextFloat();
        }
    }

    @Override
    public void getArmazenarEscalaMinima() {
        int v = 5;
        VMin = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura mínima em ºC do " + (n + 1) + "º dia: ");
            VMin[n] = in.nextFloat();
        }
    }
}
