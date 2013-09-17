
package domapli;
import bibliotek.*;
public class Algoritmo_burbuja {
  
   public static boolean noOrdenado(int[] matriz,int ind1,int ind2,boolean orden){//hace comparaciones segun el orden(ascendente o descendente)
        /*
         * int[] matriz: es la matriz a tratar
         * int ind1: es el indice anterior
         * int ind2: es el indice posterior
         * *NOTA: El orden con que se pasan los indices con relevantes;
         */
            boolean condicion;
            //se asume q el orden es ascendente(de menor a mayor)
            condicion = matriz[ind1]>matriz[ind2];//si el anterior es mayor al posterior ocurre se debe reordenar la matriz 
            if(!orden){//si orden descendente(de mayor a menor)
                condicion = matriz[ind1]<matriz[ind2];//si el anterior es menor al posterior ocurre se debe reordenar la matriz 
            }
            /*
             SI condicion = true , los elementos evaluados de la matriz NO tiene  el orden(ASC o DES) deseado;
               condicion = false , los elementos evaluados de la matriz SI tienen el orden(ASC o DES) deseado;
             */
        return condicion;
    }

    public static void reordenar(int[]matriz,int ind1,int ind2){//para reordenar los valores de la matrices de tipo entero
        int aux;
        aux = matriz[ind1];//valor auxiliar;
        matriz[ind1] = matriz[ind2];//el anterior valdra igual al posterior
        matriz[ind2] = aux;//el posterior valdra igual al anterior
        /*
         * Si hacemos : matriz[ind2] = matriz[ind1]; seria un error, pues matriz[ind1] ya fue sobreescrito;
         * y estariamos realmente haciendo :  matriz[ind2] = matriz[ind2]; y esto no tendria sentido, si lo q buscamos es intercambiar de valores;
         */
    }
    public static void reordenar(String[]matriz,int ind1,int ind2){//para reordenar los valores de la matrices del tipo cadena
        String temp;
        temp = matriz[ind1];
        matriz[ind1] = matriz[ind2];
        matriz[ind2] = temp;
    }
    //Aqui el algoritmo mejorado
     public static void ordenarV31(int[] matriz,String[] matriz2,boolean orden){//VERSION MEJORADA DEL V3
        int pasadas = 0;
        int comparaciones = 0;
        for(int i = 0,j,longi = matriz.length-1;i<longi;i++){//bucle hacia adelante
        /*
            Este bucle controlara los movimientos hacia adelante de la matriz
        */
            ++pasadas;
            j = i+1;
               if(noOrdenado(matriz,i,j,orden) && i>=1){
                   //solo si el orden de los valores evaluados no estan como se desean Y
                   //ya va mas de una iteracion el bucle superior 
                   ++comparaciones;
                   reordenar(matriz,i,j);
                   reordenar(matriz2,i,j);
                    for (int k = i,j_; k > 0; k--) {//bucle hacia atras
                        /*
                         Este bucle controlara los movimientos hacia atras de la matriz;
                         * a partir del ultimo elemento evaluado por el bucle que evalua hacia adelante(el superior)
                         */
                        j_ = k - 1;
                        if(noOrdenado(matriz,j_,k,orden)){
                            reordenar(matriz,j_,k);
                            reordenar(matriz2,j_,k);
                        }
                    }//end for
                }//end  if(verificarOrden(matriz,i,j,orden)&&i>=1)
        }//end for    
        estadisticas(pasadas, comparaciones);
    }//end ordenarv31

    private static void mostrarArray(int[] matriz){//solo muestra  una matriz especifica
        System.out.print("\n");
        for (int i = 0,longi=matriz.length; i < longi; i++) {
            System.out.print(matriz[i]+" - ");
        }
        System.out.print("\n");
    }
    private static void mostrarArray(String[] matriz){//solo muestra  una matriz especifica
        System.out.print("\n");
        for (int i = 0,longi=matriz.length; i < longi; i++) {
            System.out.print(matriz[i]+" - ");
        }
        System.out.print("\n");
    }

    private static void estadisticas( int pasadas, int comparaciones) {
        System.out.println( "Pasadas: " + pasadas );
        System.out.println( "Comparaciones: " + comparaciones );
    }


    public static void main(String[] args) {
        String nombres[]={"carlos","erick","omar","sara","gloria","tavo","silene","carolina","hellens"};
        int notas5[]={29,64,110,17,111,102,13,14,0};

        ordenarV31(notas5,nombres,true);
        mostrarArray(notas5);
        mostrarArray(nombres);

        
    }
}
