package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {


    public static void guardarArchivoTexto(String contenidoLinea, String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        File parent = archivo.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(contenidoLinea);
            writer.newLine();
        }
    }

    // Metodos usados por los DAO
    public static void guardarArchivoLibro(String informacionLibro, String nombreArchivo) throws IOException {
        guardarArchivoTexto(informacionLibro, nombreArchivo);
    }

    public static void guardarArchivoRevista(String informacionRevista, String nombreArchivo) throws IOException {
        guardarArchivoTexto(informacionRevista, nombreArchivo);
    }

    public static void guardarArchivoArticuloInvestigacion(String informacionArticulo, String nombreArchivo) throws IOException {
        guardarArchivoTexto(informacionArticulo, nombreArchivo);
    }

    //Lee todas las líneas de un archivo de texto y las devuelve como ArrayList<String>.
    //Si el archivo no existe devuelve lista vacía.
     
    public static ArrayList<String> leerArchivoTextoLines(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        ArrayList<String> lineas = new ArrayList<>();
        if (!archivo.exists()) {
            return lineas;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    // Binario (colecciones completas) 

    //Guarda una lista completa en un archivo binario (sobrescribe).
     
    public static <T> void guardarListaBinario(List<T> lista, String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        File parent = archivo.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            ArrayList<T> copia = new ArrayList<>(lista);
            oos.writeObject(copia);
            oos.flush();
        }
    }

    //Lee una lista desde un archivo binario y la retorna. Si el archivo no existe retorna lista vacía.
    //Lanza ClassNotFoundException si el contenido no es deserializable correctamente.
     
    public static <T> ArrayList<T> leerListaBinario(String nombreArchivo) throws IOException, ClassNotFoundException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<T>) obj;
            } else {
                return new ArrayList<>();
            }
        }
    }
}
