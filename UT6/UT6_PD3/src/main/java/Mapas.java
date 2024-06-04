import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mapas {
    //Ejercicio 2
    public static Map<String, String> invertirMapa(Map<String, String> original) throws IllegalArgumentException {
        Map<String, String> invertido = new HashMap<>();
        for (Map.Entry<String, String> entrada : original.entrySet()) {
            if (invertido.containsKey(entrada.getValue())) {
                throw new IllegalArgumentException("Se encontró un valor duplicado: " + entrada.getValue());
            }
            invertido.put(entrada.getValue(), entrada.getKey());
        }
        return invertido;
    }

    public static void main(String[] args) {
        // Crear un mapa
        Map<String, Integer> mapa = new HashMap<>();

        // Agregar elementos al mapa
        mapa.put("John", 25);
        mapa.put("Jane", 30);
        mapa.put("Doe", 35);
        mapa.put("Smith", null);

        // Imprimir el mapa
        System.out.println(mapa);

        // Obtener el valor de una clave
        System.out.println(mapa.get("John"));

        // Verificar si existe una clave
        System.out.println(mapa.containsKey("Jane"));

        // Verificar si existe un valor
        System.out.println(mapa.containsValue(30));

        // Eliminar una clave
        mapa.remove("Doe");
        System.out.println(mapa);
        // Ejercicio 1
        mapa.values().removeIf(Objects::isNull);
        System.out.println(mapa);
        // Iterar sobre el mapa
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

}
