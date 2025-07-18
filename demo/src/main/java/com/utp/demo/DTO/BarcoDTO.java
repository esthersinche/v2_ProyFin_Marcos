package com.utp.demo.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.utp.demo.model.Barcos;

public class BarcoDTO {

    private String idBarco;
    private String nombreBarco;
    private String capitanBarco;
    private String modeloBarco;
    private String descripcionBarco;
    private String imgURLbarco;

    // Aquí: la lista de IDs de rutas asociadas
    private List<String> idsrutasbarco;

    // (Opcional) si realmente necesitas estos cálculos:
    private int totalCabinas;
    private int capacidadTotal;

    public BarcoDTO() {
    }

    // Método de fábrica para convertir entidad ➞ DTO
    public static BarcoDTO fromEntity(Barcos barco) {
        BarcoDTO dto = new BarcoDTO();
        dto.setIdBarco(barco.getIDbarco());
        dto.setNombreBarco(barco.getNombrebarco());
        dto.setCapitanBarco(barco.getCapitanbarco());
        dto.setModeloBarco(barco.getBarmodel().getModeloBarco());
        dto.setDescripcionBarco(barco.getDescripcionbarco()); // ajusta si cambia el campo
        dto.setImgURLbarco(barco.getImagenbarco()); // idem

        // Convertimos el Set<RutaBarco> a lista de Strings (ids de ruta)
        List<String> rutas = barco.getRutas()
                .stream()
                .map(rb -> rb.getRuta().getIdruta())
                .distinct()
                .collect(Collectors.toList());
        dto.setIdsrutasbarco(rutas);

        // Si necesitas calcular totalCabinas/capacidadTotal:
        // dto.setTotalCabinas(barco.getCabinas().size());
        // dto.setCapacidadTotal(barco.getCabinas().stream()
        // .mapToInt(Cabina::getCapacidad).sum());

        return dto;
    }

    // ——— Getters y Setters ———
    public String getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(String id) {
        this.idBarco = id;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String n) {
        this.nombreBarco = n;
    }

    public String getCapitanBarco() {
        return capitanBarco;
    }

    public void setCapitanBarco(String c) {
        this.capitanBarco = c;
    }

    public String getModeloBarco() {
        return modeloBarco;
    }

    public void setModeloBarco(String m) {
        this.modeloBarco = m;
    }

    public String getDescripcionBarco() {
        return descripcionBarco;
    }

    public void setDescripcionBarco(String d) {
        this.descripcionBarco = d;
    }

    public String getImgURLbarco() {
        return imgURLbarco;
    }

    public void setImgURLbarco(String u) {
        this.imgURLbarco = u;
    }

    public List<String> getIdsrutasbarco() {
        return idsrutasbarco;
    }

    public void setIdsrutasbarco(List<String> list) {
        this.idsrutasbarco = list;
    }

    public int getTotalCabinas() {
        return totalCabinas;
    }

    public void setTotalCabinas(int t) {
        this.totalCabinas = t;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int c) {
        this.capacidadTotal = c;
    }
    /*
     * 
     * private String idBarco;
     * private String nombreBarco;
     * private String modeloBarco;
     * private String capitanBarco;
     * private int totalCabinas;
     * private int capacidadTotal;
     * 
     * private String descripcionBarco;
     * private String imgURLbarco;
     * 
     * public BarcoDTO() {
     * }
     * 
     * public String getIdBarco() {
     * return idBarco;
     * }
     * 
     * public void setIdBarco(String idBarco) {
     * this.idBarco = idBarco;
     * }
     * 
     * public String getNombreBarco() {
     * return nombreBarco;
     * }
     * 
     * public void setNombreBarco(String nombreBarco) {
     * this.nombreBarco = nombreBarco;
     * }
     * 
     * public String getCapitanBarco() {
     * return capitanBarco;
     * }
     * 
     * public void setCapitanBarco(String capitanBarco) {
     * this.capitanBarco = capitanBarco;
     * }
     * 
     * public String getModeloBarco() {
     * return modeloBarco;
     * }
     * 
     * public void setModeloBarco(String modeloBarco) {
     * this.modeloBarco = modeloBarco;
     * }
     * 
     * public String getImgURLbarco() {
     * return imgURLbarco;
     * }
     * 
     * public void setImgURLbarco(String imgURLbarco) {
     * this.imgURLbarco = imgURLbarco;
     * }
     * 
     * public String getDescripcionBarco() {
     * return descripcionBarco;
     * }
     * 
     * public void setDescripcionBarco(String descripcionBarco) {
     * this.descripcionBarco = descripcionBarco;
     * }
     * 
     * public int getTotalCabinas() {
     * return totalCabinas;
     * }
     * 
     * public void setTotalCabinas(int totalCabinas) {
     * this.totalCabinas = totalCabinas;
     * }
     * 
     * public int getCapacidadTotal() {
     * return capacidadTotal;
     * }
     * 
     * public void setCapacidadTotal(int capacidadTotal) {
     * this.capacidadTotal = capacidadTotal;
     * }
     */

}
