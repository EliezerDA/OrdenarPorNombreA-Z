import java.util.Scanner;

public class quickSortBusqueda {
    public class quickSortPersona {
        static class Persona{
            String nombre;
            int DUI;

            public Persona(String nombre, int DUI) {
                this.nombre = nombre;
                this.DUI = DUI;
            }
            //metodo QuickSort que ordena el arreglo de dividir los arreglos
            public static void quickSort(Persona[] personas , int inicio, int fin ){
                //si el indice de inicio es menor que el indice de fin sigue el procedimiento de ordenamiento
                if (inicio < fin){
                    //llamamos a la funcion de particion para obtener la pocion de pivote
                    int pivon = partition(personas,inicio,fin);
                    //ordenamos recursivamente los dos sublistas  antes y des pues del pivote

                    quickSort(personas,inicio,pivon-1);
                    quickSort(personas,pivon+1,fin);

                }
            }

            private static int partition(Persona[] personas, int inicio, int fin){
                //se inicializa el ultimo elemnto como pivote
                Persona pivote = personas[fin];

                //inicializamos el indice de intercambio
                int i = (inicio -1);

                // recorremos el arreglo y colocamos los elementos menores o iguales al pivote a la izquierda
                // y los mayores a la derecha del pivote

                for (int j= inicio; j < fin; j++){
                    if (personas[j].nombre.compareTo(pivote.nombre)<=0){
                        i++;
                        //intercambiamos los elementos para organizar los elemtos pequeños que el pivote a la izquierda
                        Persona temp= personas[i];
                        personas[i]=personas[j];
                        personas[j]= temp;
                    }
                }

                //intercambiamos el pivote con el primer elemento que sea mayor que el
                Persona temp = personas[i+1];
                personas[i+1] = personas[fin];
                personas[fin]= temp;

                //// se devueleve la posición final del pivote, que ahora está en su lugar ordenado

                return i+1;
            }

        }

        // Método para buscar un individuo por nombre
        public static void buscarPorNombre(Persona[] individuos, String nombreBuscado) {
            boolean encontrado = false;
            for (Persona individuo : individuos) {
                if (individuo.nombre.equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("Encontrado: " + individuo.nombre + " - DUI: " + individuo.DUI);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Persona no encontrada.");
            }
        }

        public static void buscarPorDui(Persona[] individuos, int duiBuscado) {
            boolean encontrado = false;
            for (Persona individuo : individuos) {
                if (individuo.DUI == duiBuscado) {
                    System.out.println("Encontrado: " + individuo.nombre + " - DUI: " + individuo.DUI);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("DUI no encontrado.");
            }
        }


        public static void main(String[] args) {
            // Arreglos de ejemplos de nombres de hombres y mujeres con sus respectivos DUIs
            Persona[] hombres = new Persona[]{
                    new Persona("Carlos", 7535841),
                    new Persona("José", 9234567),
                    new Persona("Luis", 5632871),
                    new Persona("Antonio", 4123567),
                    new Persona("David",0627550),
                    new Persona("Oscar lemus",4587412)
            };

            Persona[] mujeres =new Persona[]{
                    new Persona("Ana", 1234567),
                    new Persona("María", 7654321),
                    new Persona("Laura", 8765432),
                    new Persona("Elizabeth", 2345678),
                    new Persona("Roxana",0617125),
                    new Persona("Modesta",2587456)
            };

            //ordenamos los arreglos utilizando el Quicksort
            Persona.quickSort(hombres,0,hombres.length-1);
            Persona.quickSort(mujeres,0,mujeres.length-1);

            //scanner
            Scanner scanner = new Scanner(System.in);

            //menu para buscar por nombre o DUI
            System.out.println("Que deseas buscar? (1-nombre ,2-DUI) ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Ingresa el nombre a buscar: ");
                String nombreBuscado = scanner.nextLine();
                buscarPorNombre(hombres, nombreBuscado);
                buscarPorNombre(mujeres, nombreBuscado);
            } else if (opcion == 2) {
                System.out.print("Ingresa el DUI a buscar: ");
                int duiBuscado = scanner.nextInt();
                buscarPorDui(hombres, duiBuscado);
                buscarPorDui(mujeres, duiBuscado);
            } else {
                System.out.println("Opción no válida.");
            }

            scanner.close();  // Cerrar el scanner al final

            //se impreme los arreglos
            System.out.println("Hombres ordenados por el nombre: ");
            for(Persona hombre : hombres){
                System.out.println(hombre.nombre+" - DUI: "+hombre.DUI);
            }

            System.out.println("\nMujeres ordenadas por nombre:");
            for (Persona mujer : mujeres) {
                System.out.println(mujer.nombre + " - DUI: " + mujer.DUI);
            }

        }
    }


}
