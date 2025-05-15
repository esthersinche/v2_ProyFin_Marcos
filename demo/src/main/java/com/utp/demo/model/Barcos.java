package com.utp.demo.model;

public class Barcos {

    public enum Modelobarco {

        SMODEL("Pequeño", 15, 15, 18, 16, 16),
        MMODEL("Grande", 20, 26, 30, 24, 20),
        LMODEL("Largo", 40, 50, 30, 35, 25);

        private final String modelo;
        private final int cant_cabinas_inf;
        private final int cant_cabinas_ext;
        private final int cant_cabinas_cbal;
        private final int cant_cabinas_suit;
        private final int cant_cabinas_fam;

        private Modelobarco(String modelo, int cant_cabinas_inf, int cant_cabinas_ext, int cant_cabinas_cbal,
                int cant_cabinas_suit, int cant_cabinas_fam) {
            this.modelo = modelo;
            this.cant_cabinas_inf = cant_cabinas_inf;
            this.cant_cabinas_ext = cant_cabinas_ext;
            this.cant_cabinas_cbal = cant_cabinas_cbal;
            this.cant_cabinas_suit = cant_cabinas_suit;
            this.cant_cabinas_fam = cant_cabinas_fam;
        }

        public String getModelo() {
            return modelo;
        }

        public int getCant_cabinas_inf() {
            return cant_cabinas_inf;
        }

        public int getCant_cabinas_ext() {
            return cant_cabinas_ext;
        }

        public int getCant_cabinas_cbal() {
            return cant_cabinas_cbal;
        }

        public int getCant_cabinas_suit() {
            return cant_cabinas_suit;
        }

        public int getCant_cabinas_fam() {
            return cant_cabinas_fam;
        }

    }
//si no funciona borran el enum y el constructor y los getters y setters dsps le quitan
//el comentario a modelo barcvo y lo generan de nuevo con sourceaction
    private String id_barco;
    private String nombre;
    private String capitan;
    private Modelobarco modelobarco;
    private int capacidad;
    private String recreacion;
    private String imagen;

    public Barcos(String id_barco, String nombre, String capitan, Modelobarco modelobarco, int capacidad,
            String recreacion, String imagen) {
        this.id_barco = id_barco;
        this.nombre = nombre;
        this.capitan = capitan;
        this.modelobarco = modelobarco;
        this.capacidad = capacidad;
        this.recreacion = recreacion;
        this.imagen = imagen;
    }

    public String getId_barco() {
        return id_barco;
    }

    public void setId_barco(String id_barco) {
        this.id_barco = id_barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getRecreacion() {
        return recreacion;
    }

    public void setRecreacion(String recreacion) {
        this.recreacion = recreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //total de cabinas
    public int getTotalcabinas() {
        return modelobarco.getCant_cabinas_inf() + modelobarco.getCant_cabinas_ext()
                + modelobarco.getCant_cabinas_cbal() + modelobarco.getCant_cabinas_suit()
                + modelobarco.getCant_cabinas_fam();
    }

    //capacidad
    /*public int getCapacidad(){
        int cap_inf= modelobarco.getCant_cabinas_inf() * Cabina.Cabina_tipo.inf.cant_max_per;
        int cap_ext= modelobarco.getCant_cabinas_ext() * Cabina.Cabina_tipo.ext.cant_max_per;
        int cap_cbal= modelobarco.getCant_cabinas_cbal() * Cabina.Cabina_tipo.cbal.cant_max_per;
        int cap_suit= modelobarco.getCant_cabinas_suit() * Cabina.Cabina_tipo.suit.cant_max_per;
        int cap_fam= modelobarco.getCant_cabinas_fam() * Cabina.Cabina_tipo.fam.cant_max_per;

        return cap_inf + cap_ext + cap_cbal + cap_suit + cap_fam;
    }
     */
}
