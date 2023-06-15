package Universidadaplicacion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniversidadApp {
    private Map<String, Estudiante> estudiantes;

    public UniversidadApp() {
        estudiantes = new HashMap<>();
    }

    public void agregarEstudiante(String codigo, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(codigo, nombre, edad);
        estudiantes.put(codigo, estudiante);
        System.out.println("Estudiante agregado correctamente.");
    }

    public void consultarEstudiante(String codigo) {
        if (estudiantes.containsKey(codigo)) {
            Estudiante estudiante = estudiantes.get(codigo);
            System.out.println("Código: " + estudiante.getCodigo());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
        } else {
            System.out.println("No se encontró ningún estudiante con el código especificado.");
        }
    }

    public void actualizarEstudiante(String codigo, String nuevoNombre, int nuevaEdad) {
        if (estudiantes.containsKey(codigo)) {
            Estudiante estudiante = estudiantes.get(codigo);
            estudiante.setNombre(nuevoNombre);
            estudiante.setEdad(nuevaEdad);
            System.out.println("Estudiante actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el código especificado.");
        }
    }

    public void eliminarEstudiante(String codigo) {
        if (estudiantes.containsKey(codigo)) {
            estudiantes.remove(codigo);
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el código especificado.");
        }
    }

    public static void main(String[] args) {
        UniversidadApp app = new UniversidadApp();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de la Universidad ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Consultar estudiante");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código del estudiante: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del estudiante: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    app.agregarEstudiante(codigo, nombre, edad);
                    break;
                case 2:
                    System.out.print("Ingrese el código del estudiante a consultar: ");
                    codigo = scanner.nextLine();
                    app.consultarEstudiante(codigo);
                    break;
                case 3:
                    System.out.print("Ingrese el código del estudiante a actualizar: ");
                    codigo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del estudiante: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva edad del estudiante: ");
                   
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    app.actualizarEstudiante(codigo, nuevoNombre, nuevaEdad);
                    break;
                case 4:
                    System.out.print("Ingrese el código del estudiante a eliminar: ");
                    codigo = scanner.nextLine();
                    app.eliminarEstudiante(codigo);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        }
        scanner.close(); // Cerrar el scanner al finalizar
    }
}

class Estudiante {
    private String codigo;
    private String nombre;
    private int edad;

    public Estudiante(String codigo, String nombre, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

