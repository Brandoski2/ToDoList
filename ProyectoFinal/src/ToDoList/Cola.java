package ToDoList;

import java.util.Calendar;// Para manipular fechas fácilmente
import java.util.Date;// Para representar fechas (tipo Date)
import java.util.LinkedList;// Para implementar la cola (estructura FIFO)
import java.util.Queue;// Interfaz de cola
import java.util.Scanner;// Para leer entrada del usuario

public class Cola
{
    Queue<Tarea> Cola_Tareas = new LinkedList<>();//La pila donde se almacenan los datos
    Scanner Tecla = new Scanner(System.in);
    Hash hash = new Hash();
    // Agregar una nueva tarea con fecha
    public void AgreTarea() 
    {
        System.out.println("Agrega la descripcion de la tarea:");
        String descripcion = Tecla.nextLine();

        System.out.println("Establece la fecha de vencimiento:");
        System.out.print("Dia: ");
        int dia = Tecla.nextInt();
        System.out.print("Mes: ");
        int mes = Tecla.nextInt();
        System.out.print("Año: ");
        int año = Tecla.nextInt();
        Tecla.nextLine();

        Calendar calendar = Calendar.getInstance();//Para saber la fecha y hora actuales
        calendar.set(año, mes - 1, dia); // configurar fecha
        //Comienzan en 0 por lo que hay que restarle uno al mes para que se escriba normal
        Date fechaVencimiento = calendar.getTime();//Convierte el calendar a date

        Cola_Tareas.add(new Tarea(descripcion, fechaVencimiento));//Se añade la tarea
        System.out.println("Tarea agregada con exito.");
    }

    // Eliminar primera tarea
    public void EliTarea() 
    {
        if (!Cola_Tareas.isEmpty()) {//Si la cola no esta vacia
            Tarea tareaEliminada = Cola_Tareas.remove();
            System.out.println("Tarea eliminada: " + tareaEliminada.getNombre());
        } else 
        {
            System.out.println("No hay tareas para eliminar.");
        }
    }

    // Mostrar todas las tareas
    public void MosTareas()
    {
        if (Cola_Tareas.isEmpty()) 
        {
            System.out.println("No hay tareas en la lista.");
            return;
        }

        for (Tarea tarea : Cola_Tareas) 
        {
            System.out.println(tarea);
        }
    }

    // Marcar como completada una tarea
    public void MarCompletada() 
    {
        if (Cola_Tareas.isEmpty()) 
        {
            System.out.println("No hay tareas para marcar como completadas.");
            return;
        }

        System.out.println("Ingresa la descripcion de la tarea a marcar como completada:");
        String descripcion = Tecla.nextLine();

        for (Tarea tarea : Cola_Tareas) 
        {
            if (tarea.getNombre().equalsIgnoreCase(descripcion)) 
                //equalsIgnoreCase: Compara las variables sin importar las mayusculas o minusculas
            {
                tarea.MarCompleta();
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }

        System.out.println("Tarea no encontrada.");
    }

    // Mostrar solo las tareas incompletas
    public void MosIncompletas() 
    {
        for (Tarea t : Cola_Tareas) 
        {
            if (!t.EstaCompleta()) 
            {
                System.out.println(t);
            }
        }
    }
    public void BusTarea()
    {
        System.out.println("Ingresa la descripcion de la tarea a buscar:");
        String descripcion = Tecla.nextLine();

        Tarea resultado = hash.BusTarea(descripcion);

        if (resultado != null) 
        {
            System.out.println("Tarea encontrada: " + resultado);
        } 
        else 
        {
            System.out.println("Tarea no encontrada.");
        }
    }
}
