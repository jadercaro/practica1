/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;
//FALTA METODO DE SIMPLICACION
//METODO DE MULTIPLICACION (ya hecho) 
//SUMA (ya hecho) 
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
    public PolinomioVectorF2(Termino[] terminos) {
        this.terminos = terminos;
    }

    public PolinomioVectorF2() {
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
    public Termino[] ingresoTerminos() { //aun no funciona :( 
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

    public PolinomioVectorF2 multiplicacion(PolinomioVectorF2 pol2) { //funciona :) 
        Termino[] terminosPol1 = this.getTerminos(); //creamos una referencia del arreglo de termino que ya tenemos 
        Termino[] terminosPol2 = pol2.getTerminos(); //creamos una referencia del arreglo de termino que ya tenemos 
        int cantidadTerminosPol1 = terminosPol1.length; //tomamos la cantidad de terminos que posee el polinomio1
        int cantidadTerminosPol2 = terminosPol2.length;//tomamos la cantidad de terminos que posee el polinomio2
        int indice3 = 0;//inicializamos el indice para el nuevo polinomio que crearemos 
        Termino[] terminosPol3 = new Termino[cantidadTerminosPol1 * cantidadTerminosPol2]; //creamos el arreglo de terminos con el tamaño indicado
        for (int i = 0; i < cantidadTerminosPol1; i++) { //ciclos para rellenar el nuevo arreglo
            for (int j = 0; j < cantidadTerminosPol2; j++) {
                terminosPol3[indice3] = new Termino(terminosPol1[i].getE() + terminosPol2[j].getE(), terminosPol1[i].getC() * terminosPol2[j].getC()); //vamos multiplicando el j-esimo coeficiente con el i-esimo coeficiente y del mismo modo con los exponentes pero sumandolos 
                indice3++; //aumentamos el indice que se mueve dentro del nuevo polinomio
            }
        }
        PolinomioVectorF2 pol3 = new PolinomioVectorF2(terminosPol3);
        return (pol3); //retornamos el polinomio ya terminado 

    }
    
    
}

