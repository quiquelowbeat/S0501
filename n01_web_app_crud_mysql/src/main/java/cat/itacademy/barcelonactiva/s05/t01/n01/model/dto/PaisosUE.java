package cat.itacademy.barcelonactiva.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class PaisosUE {

    public static final List<String> paisosUE = Arrays.asList("Alemania","Austria", "Bélgica", "Bulgaria",
            "Chipre", "República Checa", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia",
            "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
            "Malta", "Países Bajos", "Polonia", "Portugal", "Rumanía", "Suecia");

    public static String setTipusPais(String paisSucursal){
        String paisSucursalFinal = "";
        boolean exist = false;
        int i = 0;
        int loopLength = paisosUE.size();
        if(paisSucursal != null){
            while(!exist && i < loopLength){
                if(paisSucursal.equalsIgnoreCase(paisosUE.get(i))){
                    exist = true;
                }
                i++;
            }
            paisSucursalFinal = (exist) ? "UE" : "Fora UE";
        } else {
            paisSucursalFinal = "Pais desconegut";
        }
        return paisSucursalFinal;
    }
}
