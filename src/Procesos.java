import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Procesos {

    static ArrayList<String> ArraylistNombres = new ArrayList<String>();
    static ArrayList<Double> ArraylistPesos = new ArrayList<Double>();
    static ArrayList<Double> ArraylistAlturas = new ArrayList<Double>();
    static ArrayList<Double> ArraylistIMCs = new ArrayList<Double>();
    static ArrayList<Integer> ArraylistTelefonos = new ArrayList<Integer>();

    public static void iniciar() {
        System.out.println("¡Hola!");
        obtenerDatos();
        calcularIMC();
        imprimirDatos();
    }

    public static void obtenerDatos() {
        String nombre;
        double peso, altura;
        int confirmar, telefono;
        do {
            nombre = JOptionPane.showInputDialog(null, "Ingrese un nombre: ");
            ArraylistNombres.add(nombre);
            peso = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese un peso en kg: "));
            ArraylistPesos.add(peso);
            altura = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese un altura en metros: "));
            ArraylistAlturas.add(altura);
            telefono = Integer.parseInt(JOptionPane.showInputDialog(null, nombre + " ingrese un número de teléfono: "));
            ArraylistTelefonos.add(telefono);
            confirmar = JOptionPane.showConfirmDialog(null, "¿Quiere ingresar otro usuario?");
        } while (confirmar == 0);
    }

    public static void calcularIMC() {
        for (int i = 0; i < ArraylistPesos.size(); i++) {
            double imc = ArraylistPesos.get(i) / (ArraylistAlturas.get(i) * ArraylistAlturas.get(i));
            ArraylistIMCs.add(imc);
        }
    }

    public static void imprimirDatos() {
        for (int i = 0; i < ArraylistIMCs.size(); i++) {
            double imc = ArraylistIMCs.get(i);
            String estado = "";
            if (imc < 18.0) {
                estado = "Anorexia";
            } else if (imc >= 18.0 && imc < 20.0) {
                estado = "Delgadez";
            } else if (imc >= 20.0 && imc < 27.0) {
                estado = "Normalidad";
            } else if (imc >= 27.0 && imc < 30.0) {
                estado = "Obesidad (grado 1)";
            } else if (imc >= 30.0 && imc < 35.0) {
                estado = "Obesidad (grado 2)";
            } else if (imc >= 35.0 && imc < 40.0) {
                estado = "Obesidad (grado 3)";
            } else if (imc >= 40.0) {
                estado = "Obesidad mórbida";
            }
            System.out.println("\nUsuario: " + (i + 1) + "\nNombre: " + ArraylistNombres.get(i) + "\nTeléfono: " + ArraylistTelefonos.get(i) + "\nEstado: " + estado);
        }
    }
}


