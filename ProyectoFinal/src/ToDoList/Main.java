package ToDoList;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        // Título de la aplicación
        System.out.println("To Do list");

        int op; // opción del menú

        // Crear estructuras para diferentes tipos de tareas
        Cola cola = new Cola();//Tareas con fecha de vencimiento
        Pila pila = new Pila();//Tareas con prioridad
        Lista lista = new Lista();//Tareas ordinarias
        Hash hash = new Hash();//Buscar las tareas

        Scanner Tecla = new Scanner(System.in); // para leer entradas del usuario

        // Menú principal
        do {
            System.out.println("Ingresa una opcion");
            System.out.println("1. Agregar una tarea"); 
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Mostar todas las tareas");
            System.out.println("4. Mostar tareas pendientes");
            System.out.println("5. Buscar tareas");
            System.out.println("6. Salir");

            op = Tecla.nextInt(); // leer opción del usuario

            switch (op) 
            {
                case 1 -> {
                    // Submenú para agregar tareas
                    int Op1;
                    System.out.println("1. Agregar tarea con fecha de vencimiento");
                    System.out.println("2. Agregar una tarea con prioridad");
                    System.out.println("3. Agregar tarea ordinaria");
                    Op1 = Tecla.nextInt();

                    switch (Op1) 
                    {
                        case 1 -> {
                            System.out.println("Agregar tarea con fecha de vencimiento");
                            cola.AgreTarea(); // llama método para agregar tarea con fecha
                            
                        }
                        case 2 -> {
                            System.out.println("Agregar tarea con prioridad");
                            Tecla.nextLine(); // limpiar buffer
                            String tarea = Tecla.nextLine(); // leer descripción
                            pila.AgrTareas(tarea); // agregar a la pila
                        }
                        case 3 -> {
                            System.out.println("Agregar una tarea ordinaria");
                            Tecla.nextLine(); // limpiar buffer
                            String tarea = Tecla.nextLine();
                            lista.AgreTareas(tarea); // agregar a lista
                        }
                        default -> System.out.println("Opcion no valida");
                    }
                }
                case 2 -> {
                    // Submenú para marcar como completada
                    System.out.println("Marcar como completada");
                    int Op1;
                    System.out.println("1. Completar tarea con fecha de vencimiento");
                    System.out.println("2. Completar una tarea con prioridad");
                    System.out.println("3. Completar tarea ordinaria");
                    Op1 = Tecla.nextInt();

                    switch (Op1) 
                    {
                        case 1 -> cola.MarCompletada(); // marcar en cola
                        case 2 -> {
                            Tecla.nextLine();
                            System.out.println("Ingrese nombre:");
                            String tarea = Tecla.nextLine();
                            pila.MarCompletada(tarea); // marcar en pila
                        }
                        case 3 -> {
                            Tecla.nextLine();
                            System.out.println("Escriba el nombre de la tarea");
                            String descripcion = Tecla.nextLine();
                            lista.MarCompletada(descripcion); // marcar en lista
                        }
                        default -> System.out.println("Opcion no valida");
                    }
                }
                case 3 -> {
                    // Mostrar todas las tareas
                    if (!pila.isEmpty()) {
                        System.out.println("Las tareas prioritarias son:");
                        pila.MosTareas();
                    }
                    if (!cola.Cola_Tareas.isEmpty()) {
                        System.out.println("Las tareas con limite de tiempo son:");
                        cola.MosTareas();
                    }
                    if (!lista.isEmpty()) {
                        System.out.println("Las tareas ordinarias son:");
                        lista.Mostrar();
                    }
                }
                case 4 -> {
                    // Mostrar solo tareas pendientes
                    System.out.println("Mostrar tareas pendientes");

                    if (!pila.isEmpty()) {
                        System.out.println("Tareas prioritarias pendientes:");
                        pila.mostrarIncompletas();
                    }
                    if (!cola.Cola_Tareas.isEmpty()) {
                        System.out.println("Tareas con limite de tiempo pendientes:");
                        cola.MosIncompletas();
                    }
                    if (!lista.isEmpty()) {
                        System.out.println("Tareas ordinarias pendientes:");
                        lista.mostrarIncompletas();
                    }
                }
                case 5 -> {
                    System.out.println("Buscar una tarea");
                    int Op1;
                    System.out.println("1. Buscar tarea con fecha de vencimiento");
                    System.out.println("2. Buscar una tarea con prioridad");
                    System.out.println("3. Buscar tarea ordinaria");
                    Op1 = Tecla.nextInt();

                    switch (Op1) 
                    {
                        case 1 -> cola.BusTarea(); 
                        case 2 -> {
                            Tecla.nextLine();
                            pila.BusTarea();
                             
                        }
                        case 3 -> {
                            Tecla.nextLine();
                            System.out.println("Escriba el nombre de la tarea");
                            lista.BusTarea();
                        }
                        default -> System.out.println("Opcion no valida");
                    }
                        
                }
                case 6 ->
                {
                    
                    // Salir del programa
                    System.out.println("Bye Bye...");
                    Tecla.close();
                    System.exit(0);
                    
                }
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 6); // repetir hasta que el usuario elija salir
    }
}
