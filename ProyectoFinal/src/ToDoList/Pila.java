package ToDoList;

import java.util.Scanner;
import java.util.Stack;

public class Pila 
{
    private final Stack<Tarea> tareas = new Stack<>();
    Hash hash = new Hash();
    Scanner Tecla = new Scanner(System.in);
    public void AgrTareas(String descripcion) 
    {
        Tarea NuTarea = new Tarea(descripcion, null);//null significa que no tiene fecha fecha
        tareas.push(NuTarea); 
        hash.ReTarea(NuTarea);
    }
    public void MosTareas() 
    {
        for (int i = tareas.size() - 1; i >= 0; i--) 
        {   
            System.out.println(tareas.get(i));
        }
    }

    public void MarCompletada(String descripcion) 
    {
        for (Tarea tarea : tareas) 
        {
            if (tarea.getNombre().equalsIgnoreCase(descripcion)) 
            {
                tarea.MarCompleta();
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    public void mostrarIncompletas() 
    {
        for (Tarea tarea : tareas) 
        {
            if (!tarea.EstaCompleta()) 
            {
                System.out.println(tarea);
            }
        }
    }

    public boolean isEmpty() 
    {
        return tareas.isEmpty();
    }
    public void BusTarea() 
    {
        System.out.println("Ingresa la descripcion de la tarea a buscar:");
        String descripcion = Tecla.nextLine();

        Tarea resultado = hash.BusTarea(descripcion);

        if (resultado != null) {
            System.out.println("Tarea encontrada: " + resultado);
        } else 
        {
            System.out.println("Tarea no encontrada.");
        }
    }  
}
