package numerosracionales;

import java.text.DecimalFormat;

public class Racional {

    // atributos
    private int numerador;
    private int denominador;

    // constructor
    public Racional() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    //metodos get y set
    public void setnumerador(int num) {
        this.numerador = num;
    }

    public void setdenominador(int den) {
        this.denominador = den;
    }

    public int getnumerador() {
        return numerador;
    }

    public int getdenominador() {
        return denominador;
    }

    public void simplificar() {
        if (((double) numerador % denominador) == 0) {
            numerador = numerador / denominador;
            denominador = 1;
        } else {
            for (int i = 10; i >= 1; i--) {
                if (divisible(numerador, i) && divisible(denominador, i)) {
                    numerador = numerador / i;
                    denominador = denominador / i;
                }
            }

        }

    }

    private boolean divisible(int numero, int divisor) {
        return ((double) numero % divisor) == 0;
    }
// metodo toString

    @Override
    public String toString() {
        return String.format("%d/%d", this.numerador, this.denominador);
    }

    public String toPuntoF(int decimales) {
        double num = (double) numerador / denominador;
        String nroDeci = "#.";
        for (int i = 0; i < decimales; i++) {
            nroDeci += "#";
        }
        DecimalFormat df = new DecimalFormat(nroDeci);
        return df.format(num);
    }
}
