import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Modificar datos de paciente");
            System.out.println("4. Mostrar peso que más se repite");
            System.out.println("5. Mostrar cantidad de pacientes con el peso que más se repite");
            System.out.println("6. Mostrar peso mayor y menor");
            System.out.println("7. Dividir rango de pesos y mostrar cantidad de personas en cada rango");
            System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9. Indicar qué doctor atendió a un paciente");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del paciente:");
                    System.out.println("DNI:");
                    String dni = scanner.next();
                    System.out.println("Apellido y Nombre:");
                    String nombrePaciente = scanner.next();
                    System.out.println("Dirección:");
                    String direccion = scanner.next();
                    System.out.println("Peso:");
                    double peso = scanner.nextDouble();
                    System.out.println("Temperatura:");
                    double temperatura = scanner.nextDouble();
                    Medico medicoAsignado = new Medico(1, "Dr. Ejemplo", "Especialidad Ejemplo");

                    Paciente nuevoPaciente = new Paciente(dni, nombrePaciente, direccion, peso, temperatura, medicoAsignado);
                    hospital.registrarPaciente(nuevoPaciente);
                    break;

                case 2:
                    System.out.println("Ingrese la posición del paciente que desea eliminar:");
                    int posicionEliminar = scanner.nextInt();
                    hospital.eliminarPaciente(posicionEliminar);
                    break;

                case 3:

                    System.out.println("Ingrese la posición del paciente que desea modificar:");
                    int posicionModificar = scanner.nextInt();
    scanner.nextLine();
                    hospital.modificarDatosPaciente(posicionModificar, scanner);
                    break;
            case 4:

                    hospital.mostrarPesoQueMasSeRepite();
                    break;

                case 5:

                    hospital.mostrarCantidadPacientesConPesoRepetido();
                    break;

                case 6:
                    hospital.mostrarPesoMayorYMenor();
                    break;

               case 7:
                   hospital.dividirRangoPesos();


                   break;

                case 8:
                    hospital.mostrarListaPacientesOrdenados();
                    break;

                case 9:

                    System.out.println("Ingrese el DNI del paciente:");
                    String dniPaciente = scanner.next();
                     Medico medicoQueAtendio = hospital.obtenerMedicoDePaciente(dniPaciente);
                     if (medicoQueAtendio != null) {
                         System.out.println("El paciente fue atendido por el doctor:");
                         System.out.println("Número de colegiatura: " + medicoQueAtendio.numeroColegiatura);
                         System.out.println("Nombre: " + medicoQueAtendio.nombre);
                         System.out.println("Especialidad: " + medicoQueAtendio.especialidad);
                     } else {
                         System.out.println("No se encontró al paciente con DNI: " + dniPaciente);
                     }
                    break;

                    



                case 10:
                    System.out.println("Ingrese la especialidad a buscar:");
                    String especialidadBuscar = scanner.next();
                    ArrayList<Medico> doctoresEncontrados = hospital.buscarDoctoresPorEspecialidad(especialidadBuscar);
                    break;
              case 11:
                  System.out.println("Ingrese el número de colegiatura del médico:");
                  int numeroColegiaturaMedico = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("Ingrese el nombre del médico:");
                  String nombreMedico = scanner.nextLine();
                  System.out.println("Ingrese la especialidad del médico:");
                  String especialidadMedico = scanner.nextLine();
                  Medico nuevoMedico = new Medico(numeroColegiaturaMedico, nombreMedico, especialidadMedico);
                  hospital.registrarMedico(nuevoMedico);
                  break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                    break;
            }
        }
    }
}
