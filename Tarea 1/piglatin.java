import java.util.Scanner;

public class piglatin {
    
    
    public static void imprimir(String[] oracion_traducida) {

    // Para cada palabra del arreglo
        for (int x = 0 ; x < oracion_traducida.length ; x++ ) {
        
        // Se imprime la palabra
            System.out.print(oracion_traducida[x]);

        }           
        
    } 
    
    
    public static void traducir(String lectura){

    // Separamos la oración por palabras
        String[] oracion = lectura.split(" ");
        String[] oracion_traducida = new String[oracion.length];
        String primer_letra = "";
        char vocales[] = "aeiou".toCharArray();

    //  Para cada una de las palabras
        for(int i = 0 ; i < oracion.length ; i++ ){
            String palabra = oracion[i];
            String palabra_traducida; 


        // Identificamos su primer caracter
            primer_letra = palabra.substring(0,1);

        // Si comienza con una vocal            
            if( primer_letra.equals("a") ||
                primer_letra.equals("e") ||
                primer_letra.equals("i") ||
                primer_letra.equals("o") ||
                primer_letra.equals("u") ) {
                
                // Le agregamos la sílaba 'ay' al final
                    palabra_traducida = oracion[i] + "ay ";

                // Lo almacenamos en la oracion traducida
                    oracion_traducida[i] = palabra_traducida;                   
                 

        //Si comienza con una consonante               
            } else {

        // Buscamos la posición de la vocal
                int posicion_vocal = 0;

            // Separamos la palabra por letras
                char letras[] = oracion[i].toCharArray();

            // Para cada letra de la palabra
                for(int b = 0 ; b < letras.length ; b++){

                    boolean vocal_encontrada = false; // boolean para lograr salir del doble bucle

                // Para cada vocal  
                    for(int c = 0 ; c < vocales.length ; c++){
                    // Comparamos si es una vocal
                        if( letras[b] == vocales[c] ){
                            posicion_vocal = b;
                            vocal_encontrada = true; 
                            break;
                        }
                    }

                    if (vocal_encontrada) {  // Condición para salir del bucle al encontrar la vocal
                        break;
                    }

                }

            // Armamos la nueva palabra                     
            palabra_traducida = oracion[i].substring(posicion_vocal) + oracion[i].substring(0,posicion_vocal)+"ay ";
                
            // Lo almacenamos en la oracion traducida
            oracion_traducida[i] = palabra_traducida;


            }        
        }

        // Mandamos a imprimir la oración traducida
            imprimir(oracion_traducida);

        
    }




    public static void main(String[] args){
        
        Scanner leer = new Scanner(System.in);

    // Espacios en blanco
        System.out.println("\n\n");

    // Se solicita la oración
        System.out.println("Ingresa una oracion en ingles para poder traducirla a Pig Latin:  :D");
        String lectura = leer.nextLine();
        
        
    // Espacios en blanco
        System.out.println("\n--------------------------------------\n");
        
    
    // Imprimimos la oración traducida
        System.out.println("La oracion traducida a Pig Latin es:");
        traducir(lectura);
        System.out.println("\n\n");




    }
}
