import java.util.Objects;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;

    // Constructor, getters, setters

    // Método equals de la clase Object
    @Override
    public boolean equals(Object o) {
        // Si el objeto comparado es el mismo, retorna true
        if (this == o) return true;

        // Si el objeto comparado es null o de diferente clase, retorna false
        if (o == null || getClass() != o.getClass()) return false;

        // Convertimos el objeto a un tipo Alumno
        Alumno alumno = (Alumno) o;

        // Comparamos los campos relevantes para determinar la igualdad
        return ID == alumno.ID &&
               // Usamos Objects.equals para manejar posibles nulls en fullName y email
               Objects.equals(fullName, alumno.fullName) &&
               Objects.equals(email, alumno.email);
    }

    // Método hashCode de la clase Object
    @Override
    public int hashCode() {
        // Calculamos el código hash usando Objects.hash que combina los hashes de ID, fullName y email
        return Objects.hash(ID, fullName, email);
    }
}

