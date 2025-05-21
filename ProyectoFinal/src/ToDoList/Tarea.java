package ToDoList;

import java.util.Date;

public class Tarea 
{
    private final String Nombre;
    private Date FeVencimiento;
    private boolean Completa;

    public Tarea(String Nombre, Date FeVencimiento) 
    {
        this.Nombre = Nombre;
        this.FeVencimiento = FeVencimiento;
        this.Completa = false;
    }

    public String getNombre() 
    {
        return Nombre;
    }

    public boolean EstaCompleta() 
    {
        return Completa;
    }

    public void MarCompleta() 
    {
        this.Completa = true;
    }

    @Override
    public String toString() 
    {
        String fecha = (FeVencimiento != null) ? " Vence el " + FeVencimiento : "";
        return Nombre + fecha + (Completa ? " (completada)" : "");
    }
}
