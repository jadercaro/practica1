/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;
//FALTA METODO DE SIMPLICACION
//METODO DE MULTIPLICACION 
//SUMA
//METODO MOSTRAR POLINOMIO
//METODO DE EVALUACION DE POLINOMIO 
//IMPLETAR INTERFAZ 

public class PolinomioVectorF2 {

    private Termino[] terminos;

    /**
     * Constructor para el polinomio
     *
     * @param terminos arreglo de terminos del polinomios
     */
    public void PolinomioVectorF2(Termino[] terminos) {
        this.terminos = terminos;
    }

    public void PolinomioVectorF2() {
        terminos = null;
    }

    /**
     * Obtener el grado del polinomio
     *
     * @return grado del polinomio
     */
    public int getGrado() {
        return terminos[0].getE();
    }

    /**
     * Obtiene el coeficiente de un termino dado un exponente
     *
     * @param exponente
     * @return
     */
    public double getCoeficiente(int exponente) {
        double coeficiente = 0;
        for (Termino t : terminos) {
            if (t.getE() == exponente) {
                return t.getC();
            }
        }
        return coeficiente;
    }

    /**
     * Obtener el arreglo de terminos del polinomio
     *
     * @return
     */
    public Termino[] getTerminos() {
        return terminos;
    }

    /**
     * Cantidad de terminos diferentes de coeficiente 0 en el polinomio
     *
     * @return
     */
    public int getDiferentesCero() {
        return this.terminos.length;
    }

    public String signoOut(String pol) {
        if (pol.startsWith("+")) {
            return (pol.replaceFirst("\\+", ""));
        } else {
            return (pol);
        }
    }

    //Metodo que convierte un polinomio vector forma 2 en un String
    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();

        if (terminos == null) {
            return "0";
        }

        for (Termino ti : terminos) {
            double c = ti.getC();
            int e = ti.getE();
            if (c >= 0) {
                polinomio.append("+");
            } else {
                polinomio.append("-");
            }
            polinomio.append(c).append("X^").append(e).append(" ");
        }
        //FALTA QUITARLE EL SIGNO AL PRIMER TÉRMINO CUANDO ES POSITIVO

        return signoOut(polinomio.toString());

    }

    //Metodo que convierte un polinomio que esta en String en un polinomio vector forma 2
    public Termino[] ingresoTerminos() {
        System.out.println("Ingrese la cantidad de terminos que su polinomio posee: ");
        Scanner lectura = new Scanner(System.in);
        int Nterminos = lectura.nextInt(); //
        Termino[] pol1 = new Termino[Nterminos];
        for (int i = 0; i < Nterminos; i++) {
            System.out.println("Ingrese el coeficiente del termino " + (1 + i) + ": ");
            pol1[i].setC(lectura.nextDouble());
            System.out.println("Ingrese el exponente del termino " + (1 + i) + ": ");
            pol1[i].setE(lectura.nextInt());
        }
        return pol1;
    }

    public boolean esVacio(Termino[] polinomio) { //para saber si el polinomio tipo arreglo es vacio.
        if (polinomio == null) {
            return (true);
        }
        for (int i = 0; i <= polinomio.length; i++) {
            if (polinomio[i].getC() != 0) {
                return (false);
            }
        }
        return (true);

    }

    public boolean esVacio(String polinomio) {
        if (polinomio.equals("0")) {
            return (true);
        }
        return (false);
    }

    public Termino[]  multiplicacion(PolinomioVectorF2 pol2) {
        Termino[] aux = new Termino[this.terminos.length * pol2.terminos.length];
        int n = 0;
        for (int i = 0; i < this.terminos.length; i++) {
            for (int j = 0; j < pol2.terminos.length; j++) {
                aux[n].setE(this.terminos[i].getE() + pol2.terminos[j].getE());
                aux[n].setC(this.terminos[i].getC() * pol2.terminos[j].getC());
                n++;

            }
        }
       return(aux);
    }
}
