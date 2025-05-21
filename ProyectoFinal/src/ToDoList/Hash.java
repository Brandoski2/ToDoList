package ToDoList;

import java.util.HashMap;


public class Hash 
{
    private final HashMap<String, Tarea> mapaTareas;

    public Hash() 
    {
        this.mapaTareas = new HashMap<>();
    }

    // Método para registrar tareas en la tabla hash
    public void ReTarea(Tarea tarea) 
    {
        if (tarea != null && tarea.getNombre() != null) 
        {
            mapaTareas.put(tarea.getNombre().toLowerCase(), tarea);
        }
    }

    // Método para buscar tarea por descripción (no distingue mayúsculas/minúsculas)
    public Tarea BusTarea(String descripcion) 
    {
        if (descripcion == null) return null;
        return mapaTareas.get(descripcion.toLowerCase());
    }
    public void MosTarea(String descripcion)
    {
        Tarea resultado = BusTarea(descripcion);
        if (resultado != null) 
        {
            System.out.println("Tarea encontrada: " + resultado);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}
