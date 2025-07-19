package com.utp.demo.DTO.Fragmentos;

import com.utp.demo.model.Barcos;

public class BarcoReservaDTO {
    private String idBarco;

    public BarcoReservaDTO() {
    }

    public static BarcoReservaDTO convertiraDTOboat(Barcos boat){

        BarcoReservaDTO boatdto= new BarcoReservaDTO();

        boatdto.setIdBarco(boat.getIDbarco());

        return boatdto;

    }

    public String getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(String idBarco) {
        this.idBarco = idBarco;
    }

    
    
}
