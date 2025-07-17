package com.utp.demo.DTO.Fragmentos;

import com.utp.demo.model.Ruta;

public class RutaReservaDTO {
    private String idRuta;
    private String nombreRuta;
    private String puertoSalida;
    private String puertoDestino;
    private String rutaDuracion;
    private double subtotalRuta;

    public RutaReservaDTO() {
    }

    public static RutaReservaDTO convertiraDTOroute(Ruta route){

        RutaReservaDTO routedto= new RutaReservaDTO();

        routedto.setIdRuta(route.getIdruta());
        routedto.setNombreRuta(route.getNombreruta());
        routedto.setPuertoSalida(route.getSalida());
        routedto.setPuertoDestino(route.getNombreruta());
        routedto.setRutaDuracion(route.getDiasruta());
        routedto.setSubtotalRuta(route.getPrecioruta());

        return routedto;


    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getPuertoSalida() {
        return puertoSalida;
    }

    public void setPuertoSalida(String puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    public String getPuertoDestino() {
        return puertoDestino;
    }

    public void setPuertoDestino(String puertoDestino) {
        this.puertoDestino = puertoDestino;
    }

    public String getRutaDuracion() {
        return rutaDuracion;
    }

    public void setRutaDuracion(String rutaDuracion) {
        this.rutaDuracion = rutaDuracion;
    }

    public double getSubtotalRuta() {
        return subtotalRuta;
    }

    public void setSubtotalRuta(double subtotalRuta) {
        this.subtotalRuta = subtotalRuta;
    }

    

    
    
}
