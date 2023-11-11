import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Medico {
    int numeroColegiatura;
    String nombre;
    String especialidad;

    public Medico(int numeroColegiatura, String nombre, String especialidad) {
        this.numeroColegiatura = numeroColegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
}

class Paciente {
    String dni;
    String nombre;
    String direccion;
    double peso;
    double temperatura;
    Medico medicoAsignado;

    public Paciente(String dni, String nombre, String direccion, double peso, double temperatura, Medico medicoAsignado) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
        this.medicoAsignado = medicoAsignado;
    }
}

class Hospital {

    ArrayList<Medico> medicos;
    ArrayList<Paciente> pacientes;

    public Hospital() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        int posicion = pacientes.indexOf(paciente); // Obtener la posición actual del paciente
        System.out.println("Paciente registrado con éxito. El paciente está en la posición: " + posicion);
    }

    public void eliminarPaciente(int posicion) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            pacientes.remove(posicion);
        } else {
            System.out.println("Posición inválida. No se pudo eliminar el paciente.");
        }
    }

    public void modificarDatosPaciente(int posicion, Paciente nuevosDatos) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            pacientes.set(posicion, nuevosDatos);
        } else {
            System.out.println("Posición inválida. No se pudo modificar los datos del paciente.");
        }
    }

    public void mostrarPesoQueMasSeRepite() {
        Map<Double, Integer> pesoFrecuencia = new HashMap<>();

        for (Paciente paciente : pacientes) {
            pesoFrecuencia.put(paciente.peso, pesoFrecuencia.getOrDefault(paciente.peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int frecuenciaMaxima = 0;

        for (Map.Entry<Double, Integer> entry : pesoFrecuencia.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                pesoMasRepetido = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        System.out.println("Peso que más se repite: " + pesoMasRepetido);
    }

    public void mostrarCantidadPacientesConPesoRepetido() {
        Map<Double, Integer> pesoFrecuencia = new HashMap<>();

        for (Paciente paciente : pacientes) {
            pesoFrecuencia.put(paciente.peso, pesoFrecuencia.getOrDefault(paciente.peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int frecuenciaMaxima = 0;

        for (Map.Entry<Double, Integer> entry : pesoFrecuencia.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                pesoMasRepetido = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        int cantidadPacientesConPesoRepetido = frecuenciaMaxima;

        System.out.println("Cantidad de pacientes con el peso que más se repite: " + cantidadPacientesConPesoRepetido);
    }

    public void mostrarPesoMayorYMenor() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        double pesoMayor = pacientes.get(0).peso;
        double pesoMenor = pacientes.get(0).peso;

        for (Paciente paciente : pacientes) {
            if (paciente.peso > pesoMayor) {
                pesoMayor = paciente.peso;
            }
            if (paciente.peso < pesoMenor) {
                pesoMenor = paciente.peso;
            }
        }

        System.out.println("Peso mayor: " + pesoMayor);
        System.out.println("Peso menor: " + pesoMenor);
    }

    public void dividirRangoPesos() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.peso >= 40 && paciente.peso < 60) {
                rango1++;
            } else if (paciente.peso >= 60 && paciente.peso < 80) {
                rango2++;
            } else if (paciente.peso >= 80 && paciente.peso < 100) {
                rango3++;
            } else if (paciente.peso >= 100 && paciente.peso <= 120) {
                rango4++;
            }
        }

        System.out.println("Rango de 40 a 60: " + rango1 + " personas");
        System.out.println("Rango de 60 a 80: " + rango2 + " personas");
        System.out.println("Rango de 80 a 100: " + rango3 + " personas");
        System.out.println("Rango de 100 a 120: " + rango4 + " personas");
    }

    public void mostrarListaPacientesOrdenados() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Collections.sort(pacientes, Comparator.comparing(p -> p.nombre.split(" ")[1]));

        System.out.println("Lista de pacientes ordenados por apellidos:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.nombre);
        }
    }

    public void mostrarDoctoresYEspecialidades() {
        if (medicos.isEmpty()) {
            System.out.println("No hay doctores registrados.");
            return;
        }

        System.out.println("Lista de doctores y especialidades:");
        for (Medico medico : medicos) {
            System.out.println("Doctor: " + medico.nombre + ", Especialidad: " + medico.especialidad);
        }
    }
    public void modificarDatosPaciente(int posicion, Scanner scanner) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente pacienteAModificar = pacientes.get(posicion);
            System.out.println("Ingrese el nuevo nombre del paciente:");
            String nuevoNombre = scanner.nextLine();
            pacienteAModificar.nombre = nuevoNombre;

            System.out.println("Ingrese la nueva dirección del paciente:");
            String nuevaDireccion = scanner.nextLine();
            pacienteAModificar.direccion = nuevaDireccion;

            System.out.println("Ingrese el nuevo peso del paciente:");
            double nuevoPeso = scanner.nextDouble();
            pacienteAModificar.peso = nuevoPeso;

            System.out.println("Ingrese la nueva temperatura del paciente:");
            double nuevaTemperatura = scanner.nextDouble();
            pacienteAModificar.temperatura = nuevaTemperatura;
            System.out.println("Datos del paciente modificados con éxito.");

        } else {
            System.out.println("Posición inválida. No se pudo modificar los datos del paciente.");
        }
    }
    public void registrarMedico(Medico medico) {
        medicos.add(medico);
        System.out.println("Doctor registrado con éxito.");
    }
    public Medico obtenerMedicoDePaciente(String dniPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.dni.equals(dniPaciente)) {
                return paciente.medicoAsignado;
            }
        }
        return null;
    }

    public ArrayList<Medico> buscarDoctoresPorEspecialidad(String especialidad) {
        ArrayList<Medico> doctoresPorEspecialidad = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.especialidad.equals(especialidad)) {
                doctoresPorEspecialidad.add(medico);
            }
        }
        return doctoresPorEspecialidad;
    }
}
