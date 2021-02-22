package portifolio.temperatura;

import java.util.Scanner;

public class TemperaturaMKelvin implements TemperaturaInterface {

    private float C;
    private float F;
    private float K;
    private float VMax[];
    private float VMin[];
    private int quantidade;

    Scanner in = new Scanner(System.in);

    public float getC() { return C; }
    public void setC(float C) { this.C = C; }

    public float getF() { return F; }
    public void setF(float F) {
        this.F = F;
    }

    public float getK() { return K; }
    public void setK(float K) { this.K = K; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public float[] getVMax() { return VMax; }

    public float[] getVMin() { return VMin; }

    @Override
    public String getNomeEscala() {
        return "Kelvin";
    }

    @Override
    public float getConversor1() {
        K = C + 273;
        return K;
    }

    @Override
    public float getConversor2() {
        K = (((5 * F) - 160) / 9) + 273;
        return K;
    }

    @Override
    public void getArmazenarEscalaMaxima() {
        int v = 5;
        VMax = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura máxima em K do " + (n + 1) + "° dia: ");
            VMax[n] = in.nextFloat();
        }
    }

    @Override
    public void getArmazenarEscalaMinima() {
        int v = 5;
        VMin = new float[v];

        for (int n = 0; n < quantidade; n++) {
            System.out.print("Temperatura mínima em K do " + (n + 1) + "° dia: ");
            VMin[n] = in.nextFloat();
        }
    }

}