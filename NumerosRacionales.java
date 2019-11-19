package numerosracionales;

import java.util.Scanner;

public class NumerosRacionales {

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);

        System.out.println("==== Radical 1 =====");
        System.out.print("Ingrese el numerador: ");
        int num1 = datos.nextInt();
        System.out.print("Ingrese el denominador: ");
        int den1 = datos.nextInt();

        System.out.println("\n==== Radical 2 =====");
        System.out.print("Ingrese el numerador: ");
        int num2 = datos.nextInt();
        System.out.print("Ingrese el denominador: ");
        int den2 = datos.nextInt();

        Racional r1 = new Racional(num1, den1);
        Racional r2 = new Racional(num2, den2);

        System.out.println("\nIngrese el numero de decimales que desee:");
        int deci = datos.nextInt();

        System.out.printf("Radical 1: %s | %s\nRadical 2: %s | %s\n ", r1, r1.toPuntoF(deci), r2, r2.toPuntoF(deci));

        Racional rOp = new Racional();
        rOp = sumaRac(r1, r2);
        System.out.printf("Suma: %s | %s\n ", rOp, rOp.toPuntoF(deci));
        rOp = restaRac(r1, r2);
        System.out.printf("Resta: %s | %s\n ", rOp, rOp.toPuntoF(deci));
        rOp = multiplicarRac(r1, r2);
        System.out.printf("Multiplicacion: %s | %s\n ", rOp, rOp.toPuntoF(deci));
        rOp = dividirRac(r1, r2);
        System.out.printf("Divisor: %s | %s\n ", rOp, rOp.toPuntoF(deci));

    }

    static Racional sumaRac(Racional rac1, Racional rac2) {
        Racional rac = new Racional();
        if (rac1.getdenominador() == rac2.getdenominador()) {
            rac.setdenominador(rac1.getdenominador());
            rac.setnumerador(rac1.getnumerador() + rac2.getnumerador());
        } else {
            rac.setdenominador(rac1.getdenominador() * rac2.getdenominador());
            rac.setnumerador((rac1.getnumerador() * rac2.getdenominador()) + (rac2.getnumerador() * rac1.getdenominador()));
        }
        rac.simplificar();
        return rac;
    }

    static Racional restaRac(Racional rac1, Racional rac2) {
        Racional rac = new Racional();
        if (rac1.getdenominador() == rac2.getdenominador()) {
            rac.setdenominador(rac1.getdenominador());
            rac.setnumerador(rac1.getnumerador() - rac2.getnumerador());
        } else {
            rac.setdenominador(rac1.getdenominador() * rac2.getdenominador());
            rac.setnumerador((rac1.getnumerador() * rac2.getdenominador()) - (rac2.getnumerador() * rac1.getdenominador()));
        }
        rac.simplificar();
        return rac;
    }

    static Racional multiplicarRac(Racional rac1, Racional rac2) {
        Racional rac = new Racional();
        rac.setnumerador(rac1.getnumerador() * rac2.getnumerador());
        rac.setdenominador(rac1.getdenominador() * rac2.getdenominador());
        rac.simplificar();
        return rac;
    }

    static Racional dividirRac(Racional rac1, Racional rac2) {
        Racional rac = new Racional();
        rac.setnumerador(rac1.getnumerador() * rac2.getdenominador());
        rac.setdenominador(rac1.getdenominador() * rac2.getnumerador());
        rac.simplificar();
        return rac;
    }

}
