package com.utp.demo.model;

public class Cabina {

    public enum Cabina_tipo {
        inf("Cabina interior", 4, 40),
        ext("Cabina exterior, con vista al mar", 4, 80.45),
        cbal("Cabina con balcón", 4, 102.30),
        suit("Suite", 6, 216.10),
        fam("Familiar/Conectada", 8, 298.60);

        public final String nombre_cabina;
        public final int cant_max_per;
        public final double prec_cabina_per;

        private Cabina_tipo(String nombre_cabina, int cant_max_per, double prec_cabina_per) {
            this.nombre_cabina = nombre_cabina;
            this.cant_max_per = cant_max_per;
            this.prec_cabina_per = prec_cabina_per;
            //precio de la cabina, se multiplicara por persona
        }

        public String getNombre_cabina() {
            return nombre_cabina;
        }

        public int getCant_max_per() {
            return cant_max_per;
        }

        public double getPrec_cabina_per() {
            return prec_cabina_per;
        }
    }

    private Cabina_tipo cabinatipo;
    //private String nombre_cab;
    //private double precio;
    //private int numpasajerosmax;
    private int numadultos;
    private int numninos;

    public Cabina(Cabina_tipo cabinatipo, int numadultos, int numninos) {
        this.cabinatipo = cabinatipo;
        this.numadultos = numadultos;
        this.numninos = numninos;
    }

    public Cabina_tipo getCabinatipo() {
        return cabinatipo;
    }

    public void setCabinatipo(Cabina_tipo cabinatipo) {
        this.cabinatipo = cabinatipo;
    }

    public int getNumadultos() {
        return numadultos;
    }

    public void setNumadultos(int numadultos) {
        this.numadultos = numadultos;
    }

    public int getNumninos() {
        return numninos;
    }

    public void setNumninos(int numninos) {
        this.numninos = numninos;
    }

    //obtener las personas totales ingresadas
    public int getNumtotalper() {
        return this.numadultos + this.numninos;
    }

    public boolean capacidadvalida() {
        int totalper = getNumtotalper();

        return totalper <= cabinatipo.getCant_max_per();
        //retorna true(si totalper es menor o igual) o false(mayor)
        //el enum agarra el tipo de enum de acuerdo a la cabina del paquete escogido
    }

}
