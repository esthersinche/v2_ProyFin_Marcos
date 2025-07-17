package com.utp.demo.DTO.Fragmentos;

import com.utp.demo.model.Cabina;
import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Paquete;

public class PaqueteyCabinaReservaDTO {

    //paquete
    private String idPaquete;
    private String paqueteNombre;
    private String paqueteDescripcion;
    private double subtotalPaquete;

    //cabina
    private String idCabina;
    private String cabinaTipo;
    private double cabinaprecioporPersona;


    public PaqueteyCabinaReservaDTO() {
    }

    public static PaqueteyCabinaReservaDTO convertiraDTOpaq(Paquete pack, Cabina_Inst cabin){

        PaqueteyCabinaReservaDTO paqdto= new PaqueteyCabinaReservaDTO();
        //paquete

        paqdto.setIdPaquete(pack.getIdPaquete());
        paqdto.setPaqueteNombre(pack.getNomPaquete());
        paqdto.setPaqueteDescripcion(pack.getDescPaquete());
        paqdto.setSubtotalPaquete(pack.getPrecPaqueteUni());

        //cabina
        paqdto.setIdCabina(cabin.getCabinaId());
        paqdto.setCabinaTipo(cabin.getCabTipo().getNombreCab());
        paqdto.setCabinaprecioporPersona(cabin.getPreccabinaper());

        return paqdto;

    }
    

    public String getPaqueteNombre() {
        return paqueteNombre;
    }

    public void setPaqueteNombre(String paqueteNombre) {
        this.paqueteNombre = paqueteNombre;
    }

    public String getPaqueteDescripcion() {
        return paqueteDescripcion;
    }

    public void setPaqueteDescripcion(String paqueteDescripcion) {
        this.paqueteDescripcion = paqueteDescripcion;
    }

    public double getSubtotalPaquete() {
        return subtotalPaquete;
    }

    public void setSubtotalPaquete(double subtotalPaquete) {
        this.subtotalPaquete = subtotalPaquete;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    //cabina

    public String getIdCabina() {
        return idCabina;
    }

    public void setIdCabina(String idCabina) {
        this.idCabina = idCabina;
    }

    public String getCabinaTipo() {
        return cabinaTipo;
    }

    public void setCabinaTipo(String cabinaTipo) {
        this.cabinaTipo = cabinaTipo;
    }

    public double getCabinaprecioporPersona() {
        return cabinaprecioporPersona;
    }

    public void setCabinaprecioporPersona(double cabinaprecioporPersona) {
        this.cabinaprecioporPersona = cabinaprecioporPersona;
    }

    

    



    

    


}
