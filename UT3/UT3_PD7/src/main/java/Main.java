public class Main
{
    public static void main(String[] args) {

        IConjunto<TAlumno> cursoAED1 = new Conjunto<>();
        IConjunto<TAlumno> cursoPF = new Conjunto<>();

        TAlumno alumno1 = new TAlumno(1234, "Marcos", "Perez");
        TAlumno alumno2 = new TAlumno(5678, "Sofia", "Lopez");
        TAlumno alumno3 = new TAlumno(9012, "Carlos", "Garcia");
        TAlumno alumno4 = new TAlumno(3456, "Matia", "Martinez");
        TAlumno alumno5 = new TAlumno(7890, "Luis", "Rodriguez");

        cursoAED1.insertar(alumno1.getCedula(), alumno1);
        cursoAED1.insertar(alumno2.getCedula(), alumno2);
        cursoAED1.insertar(alumno3.getCedula(), alumno3);

        cursoPF.insertar(alumno2.getCedula(), alumno2);
        cursoPF.insertar(alumno4.getCedula(), alumno4);
        cursoPF.insertar(alumno5.getCedula(), alumno5);

        IConjunto<TAlumno> alumnosEnAmbosCursos = cursoAED1.union(cursoPF);
        System.out.println("Alumnos totales: ");
        System.out.println(alumnosEnAmbosCursos.imprimir("\n"));

        IConjunto<TAlumno> alumnosEnAmbosCursosSimultaneamente = cursoAED1.interseccion(cursoPF);
        System.out.println("\nListado de alumnos matriculados simultáneamente en ambos cursos:");
        System.out.println(alumnosEnAmbosCursosSimultaneamente.imprimir("\n"));
    }
}
