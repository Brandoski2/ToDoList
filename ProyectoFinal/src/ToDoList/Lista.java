package ToDoList;

import java.util.LinkedList;
import java.util.Scanner;

public class Lista<T extends Comparable<T>> 
{
    private final LinkedList<T> elementos = new LinkedList<>();
    Hash hash = new Hash();
    Scanner Tecla = new Scanner(System.in);
    public void AgreTareas(T nuevo) 
    {
        int i = 0;
        while (i < elementos.size() && nuevo.compareTo(elementos.get(i)) > 0) 
        {
            i++;
        }
        elementos.add(i, nuevo); // insertando ordenadamente
        hash.ReTarea((Tarea) nuevo);
    }

    public boolean Eliminar(T valor) 
    {
        return elementos.remove(valor);
    }
    public void Mostrar() 
    {
        for (T e : elementos) 
        {
            System.out.println(e);
        }
    }

    public boolean isEmpty() 
    {
        return elementos.isEmpty();
    }

    public void MarCompletada(T valor) 
    {
        for (int i = 0; i < elementos.size(); i++) 
        {
            T actual = elementos.get(i);
            if (actual.equals(valor) && actual instanceof String) //Pinstanceof = para verificarel onjeto es de un tipo especifico
            {
                String marcado = "Completada: " + actual;
                elementos.set(i, (T) marcado);//Convierte a T en un tipo generico como la lista y remplaza la tarea por la que dice completada
            }
        }
    }

    public void mostrarIncompletas() 
    {
        for (T e : elementos) 
        {
            if (e instanceof String s && !s.startsWith("Completada:")) 
            {
                System.out.println(s);
            }
        }
    }
    public void BusTarea() {
        System.out.println("Ingresa la descripcion de la tarea a buscar:");
        String descripcion = Tecla.nextLine();

        Tarea resultado = hash.BusTarea(descripcion);

        if (resultado != null) {
            System.out.println("Tarea encontrada: " + resultado);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}
