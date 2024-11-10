public class Main {

    public static void ordenarPorNombre(String[] nombres, int[] DUI){
        int n = nombres.length;
        for (int i=0;i<n-1;i++){
            for (int j= 0; j < n-1-i; j++){
                //conparacion de alfabetica de nombres
                if (nombres[j].compareTo(nombres[j+1])>0){
                    //intercambio de nombres
                    String tempNombre = nombres[j];
                    nombres[j] = nombres [j + 1];
                    nombres[ j+1 ]=tempNombre;

                    //intercambio de documento corresponiendo el nombre
                    int temDUI = DUI[j];
                    DUI[j]=DUI[j+1];
                    DUI[j+1]=temDUI;
                }

            }
        }
    }
    public static void main(String[] args) {
//arreglos con nombre y apellido
        String[] nombresHombres = {
                "José Hernández", "Ernesto Martínez", "Julio César López", "Jorge Alberto Rodríguez",
                "José Luis Pérez", "Carlos Vásquez", "Luis García", "Antonio Ramírez",
                "Roberto Gómez", "Francisco Reyes"
        };
        //arreglos de DUI
        int[] DUIHombres = {
                7535841, 8273612, 9461523, 1357984,
                2684135, 3745162, 4912738, 6172849,
                7521493, 8394615
        };
        //arreglos de nombes y apellidos

        String[] nombresMujeres = {
                "María Hernández", "María Teresa Martínez", "María Elena López", "Florinda Rodríguez",
                "Orfilia Pérez", "Laura Vásquez", "Elizabeth García", "Carmen Ramírez",
                "Ana Gómez", "Sofía Reyes",
        };
        //los DUI de mujeres
        int[] DUiMujeres = {
                7548321, 8937162, 6382451, 5173294,
                2468153, 7895423, 6352174, 9823415,
                4719238, 3564827,
        };
        //ordenara los arrglos de nommbres , y DUI

            ordenarPorNombre(nombresHombres,DUIHombres);

            ordenarPorNombre(nombresMujeres,DUiMujeres);

            //imprimir los resultados
        System.out.println("\nLista ordenada por nombre alfabéticamente (Hombres):");
        for (int i = 0; i < nombresMujeres.length; i++) {
            System.out.println(nombresHombres[i] + " - DUI: " +DUIHombres[i]);
        }
        System.out.println("\nLista ordenada por nombre alfabéticamente (Mujeres):");
        for (int i = 0; i < nombresHombres.length; i++) {
            System.out.println(nombresMujeres[i] + " - DUI: " + DUiMujeres[i]);
        }
        System.out.println("algoritmo de burbuja");


    }
}