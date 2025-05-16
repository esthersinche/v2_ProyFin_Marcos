package com.utp.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.Cabina;
import com.utp.demo.model.Paquete;
import com.utp.demo.model.Ruta;

@Service
public class PaqueteService {

    private final RutaService rutaService;

    PaqueteService(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    public List<Paquete> ObtenertodoPaquetes() {
        List<Paquete> listapaquetes = new ArrayList<>();

        String[] nompaqs = { //nombres paquetes
            "Todo Incluido",
            "Paquete Internet, Restaurante, Bebidas, Piscina",
            "Paquete Internet, Restaurante-Buffet, Bebidas"
        };

        Cabina.Cabina_tipo[] tiposcabina = Cabina.Cabina_tipo.values();//values devuelve array de los enums

        Barcos.Modelobarco[] tiposmodelo = Barcos.Modelobarco.values();//array de modelos de barco

        List<Ruta> rutas = rutaService.obtenerTodoRutas();

        String[] descs = { //descripciones de paquetes
            "Todos los beneficios del crucero",
            "Acceso a Internet Ilimitado, Bebidas ilimitadas, Restaurantes gourmet, Buffet y Piscinas",
            "Acceso basico a Internet Ilimitado, Bebidas Ilimitadas y Buffet."
        };

        for (Ruta ruta : rutas) {//recorre las rutas
            switch (ruta.getNombre_ruta()) {
                case "Caribe Occidental":
                    for (Barcos.Modelobarco tipomodelo : tiposmodelo) {
                        if (tipomodelo.equals(Barcos.Modelobarco.SMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Caribe Occidental")
                                }
                            }
                        } else if (tipomodelo.equals(Barcos.Modelobarco.LMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Caribe Occidental")
                                }
                            }
                        }
                    }
                    break;
                case "Escapada a Bahamas":
                    for (Barcos.Modelobarco tipomodelo : tiposmodelo) {
                        if (tipomodelo.equals(Barcos.Modelobarco.MMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Escapada a Bahamas")
                                }
                            }
                        }
                    }
                    break;
                case "Mediterráneo Clásico":
                    for (Barcos.Modelobarco tipomodelo : tiposmodelo) {
                        if (tipomodelo.equals(Barcos.Modelobarco.SMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Mediterráneo Clásico")
                                }
                            }
                        }
                    }
                    break;

                case "Alaska Inexplorada":
                    for (Barcos.Modelobarco tipomodelo : tiposmodelo) {
                        if (tipomodelo.equals(Barcos.Modelobarco.MMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Alaska Inexplorada")
                                }
                            }
                        } else if (tipomodelo.equals(Barcos.Modelobarco.LMODEL)) {
                            for (Cabina.Cabina_tipo tipocabina : tiposcabina) {
                                for (int i = 0; i < nompaqs.length; i++) {
                                    Paquete paquete = new Paquete(nompaqs[i], tipocabina, descs[i], ruta, tipomodelo);
                                    listapaquetes.add(paquete);
                                    //si ruta en el constructor no funciona usar esto, rutaService.buscarPorNombreRuta("Alaska Inexplorada")
                                }
                            }
                        }
                    }
                    break;
            }

        }

        return listapaquetes;

    }

    // reserva controlador, no tocar
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombres_paquetes) {
        return ObtenertodoPaquetes().stream()
                .filter(n -> nombres_paquetes.contains(n.getNombre_paq()))
                .collect(Collectors.toList());
    }

    //mas que nada para que sean stackeables en los filtros
    public List<Paquete> buscarPorRutaPaquetes(List<Paquete> listafilteroforiginal, List<String> nom_ruta_paquetes) {
        //lista q saca los nombres de la lista ruta_paquetes
        //map transforma los elementos del stream en otros, aqui es en string
        /*List<String> nom_ruta_paquetes= ruta_paquetes.stream()
                .map(Ruta::getNombre_ruta).collect(Collectors.toList());*/

        return listafilteroforiginal.stream()
                .filter(nr -> nom_ruta_paquetes.contains(nr.getRuta_paq().getNombre_ruta()))
                .collect(Collectors.toList());

    }

    public List<Paquete> buscarPorModeloPaquetes(List<Paquete> listafilteroforiginal, List<String> nom_modelo_paquetes) {
        return listafilteroforiginal.stream().filter(nm -> nom_modelo_paquetes
                .contains(nm.getModelobarco_paq().getModelo())).collect(Collectors.toList());

    }

    public List<Paquete> buscarPorCantMaxPerPaquetes(List<Paquete> listafilteroforiginal, List<Integer> num_personas_paquetes) {
        return listafilteroforiginal.stream().filter(np -> num_personas_paquetes
                .contains(np.getCabinatipo_paq().getCant_max_per())).collect(Collectors.toList());

    }

}
