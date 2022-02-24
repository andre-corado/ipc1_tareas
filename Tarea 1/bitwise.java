import java.util.Scanner;


public class bitwise {
    
    
    public static String operar(int operando1, int operando2, int operacion, String lectura1){

        String respuesta = "";
        
    // Switch según la operación ingresada 
        switch (operacion) {     
            

            // Operación AND
                case 1:
                    respuesta = Integer.toString((operando1 & operando2),2);
                    break;
            
            // Operación NOT
                case 2:
                    int not_binario = ~operando1;
                
                // Lo almacenamos en una string
                    String respuesta1 = Integer.toBinaryString(not_binario);                    
                    
                // Le quitamos los bits inecesarios de los 32 bit del int
                    respuesta = respuesta1.substring(32-lectura1.length());
                    
                    break;
    
            // Operación OR
                case 3:
                    respuesta = Integer.toString((operando1 | operando2),2);
                    break;
    
            // Operación XOR       
                case 4:
                    respuesta = Integer.toString((operando1 ^ operando2),2);
                    break;
                
            // Ninguna operación válida en el menú
                default:                  
                    
                    break;
            }

        return respuesta;
    }


    
    public static int menu(){
        
    // Objeto del escáner
        Scanner leer = new Scanner(System.in);       

    //Imprimimos el menú
        System.out.println("\n\n ------------------------------------------------");
        System.out.println("\t CALCULADORA BITWISE \n");
        System.out.println("1. AND");
        System.out.println("2. NOT");
        System.out.println("3. OR");
        System.out.println("4. XOR");
        System.out.println("\n ------------------------------------------------");
        System.out.print("Ingrese la operación que desea ejecutar: ");        
              
    // Leemos la operación ingresada
        int operacion = leer.nextInt();
        

    // Indicamos la operación a ejecutar
        String operaciones[] = {"AND", "NOT", "OR", "XOR"};
        System.out.print("\033[H\033[2J"); // LIMPIA LA CONSOLA   
        System.out.print("La operación a ejecutar es: ");

    // Solo para una opción válida
        if( operacion == 1 || operacion == 3 ||
            operacion == 2 || operacion == 4){
            System.out.print(operaciones[(operacion-1)] + "\n\n");
        } else {
            System.out.println("OPERACION INVALIDA");
        }
        return operacion;
    }
    
    public static void main(String[] args){
        
        while(true){  //Creado para poder abortar la ejecución

        // Objeto del escáner
            Scanner leer = new Scanner(System.in);  

        // Solicitamos la operación que se desea ejecutar
            int operacion = menu();      
            
        // Si ingresamos una opción inválida terminamos la ejecución
            if( operacion != 1 && operacion != 3 &&
                operacion != 2 && operacion != 4)
            {               
                System.out.println("\n---------------------------------------------------");
                System.out.println("\nEl valor ingresado no es una opción valida en el menú.");
                System.out.println("Ejecute e intente de nuevo con otro valor. \n");
                break;
            }
            
        // Solicitamos los operandos y los convertimos a binario
            System.out.print("\nIngresar el primer operando:\t");
            String lectura1 = leer.nextLine();
            int operando1 = Integer.parseInt(lectura1, 2);
                
            int operando2 = 0;
        // Si la operación fuera NOT se omite el segundo operando
            if(operacion != 2){
                System.out.print("\nIngresar el segundo operando:\t");
                String lectura2 = leer.nextLine();
                operando2 = Integer.parseInt(lectura2, 2);        
            
        // Si los operandos no tienen la misma longitud no se operan
                if(lectura1.length() != lectura2.length()){
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("\nERROR: Los operandos no tienen la misma longitud.");
                    System.out.println("Ejecute e intente de nuevo con operandos que tengan la misma longitud. \n");
                    break;
                }
            }   

            // Enviamos a operar los operandos binarios y los guardamos en una String para imprimirlos
            String respuesta = operar(operando1, operando2, operacion, lectura1);
                
            // Verificamos si la función Integer.toString no eliminó
            String ceros_izquierda = "";
            if(respuesta.length() != lectura1.length()){
                int ceros_restantes = lectura1.length() - respuesta.length();            
                for(int i = ceros_restantes; i > 0; i --){
                    ceros_izquierda = ceros_izquierda + "0";                    
                }
            }
            // Imprimimos el resultado
            System.out.println("\n------------------------------------------------\n");
            System.out.print("El resultado final es:\t\t" + ceros_izquierda + respuesta);
        
            break;
        }
    }
}
