
import java.security.cert.TrustAnchor;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BancaEnLinea {

    // Atributos
    static Cliente[] clientes = new Cliente[50];
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();


    //Métodos

    public static Cuenta buscarCuenta(String idCuenta){
        boolean cuentaEncontrada = false;
        Cuenta cuenta = null;

        for (int j = 0; j < clientes.length; j ++) {

            if(clientes[j] == null){
                continue;
            }

            Cuenta[] cuentas = clientes[j].getCuentas();

            if(cuentas[0] == null){
                continue;
            }

            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i] == null) {
                    continue;
                }

                if(idCuenta.equals(cuentas[i].getIdCuenta())){
                    cuenta = cuentas[i];
                    cuentaEncontrada = true;
                    break;
                }

            }

            if(cuentaEncontrada){
                break;
            }

        }

        return  cuenta;
    }

    public static boolean verificarFondos(String origen, double monto){
        boolean fondosSuficientes = false;
        Cuenta debitar = buscarCuenta(origen);
        double saldo = debitar.getSaldo();

        double liquidacion = saldo - monto;

        if (liquidacion >= 0){
            fondosSuficientes = true;
        }

        return fondosSuficientes;
    }

    public static boolean verificarCuenta(String idCuenta){
        boolean cuentaExiste = false;

        for (int j = 0; j < clientes.length; j ++) {

            if(clientes[j] == null){
                continue;
            }

            Cuenta[] cuentas = clientes[j].getCuentas();

            if(cuentas[0] == null){
                continue;
            }

            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i] == null) {
                    continue;
                }

                if(idCuenta.equals(cuentas[i].getIdCuenta())){
                    cuentaExiste = true;
                    break;
                }

            }

            if(cuentaExiste){
                break;
            }

        }

        return cuentaExiste;
    }

    public static int buscarCliente(String cui){
        int numeroCliente = -1;
        for(int i = 0; i < clientes.length; i++){
            if (clientes[i] == null){
                continue;
            }
            if (cui.equals(clientes[i].getCui())){
                numeroCliente = i;
                break;
            }
        }

        return numeroCliente;
    }

    public static void agregarCliente(Cliente cliente){
        for(int i = 0; i < clientes.length; i++){
            if(clientes[i] == null){
                clientes[i] = cliente;
                break;
            }
        }
    }

    public static void imprimirHistorial(Cuenta cuenta){

        System.out.println("\t\t\t\t\t\tCLIENTE: " + cuenta.getPropietario());
        System.out.println("No. de Cuenta: " + cuenta.getIdCuenta() + "\n" );
        System.out.println("\n Transferencias: ");
        Transferencia[] transferencias = cuenta.getHistorialTransferencias();

        if(transferencias[0] != null){     // Si el cliente tiene transferencias

            System.out.println("___________________________________________________________________________________");
            System.out.println("Cuenta Origen  |  Cuenta Destino  |  Monto Transferido  | Fecha y Hora   ");

            for (Transferencia transferencia : transferencias) {

                if (transferencia == null) {
                    continue;
                }
                System.out.println("___________________________________________________________________________________");
                System.out.println("\t" + transferencia.getOrigen() + "\t\t" + transferencia.getDestino() + "\t\t\t" + "Q\t" + transferencia.getMonto() + "\t\t " + transferencia.getTiempo());




            }


        } else {
            System.out.println("NO POSEE TRANSFERENCIAS AÚN.");
        }

        System.out.println("\n\n Presione ENTER para regresar al menú principal.");
        leer.nextLine();
    }

    public static void imprimirDatos(Cliente cliente){

        System.out.println("\t\t\t\t\t\tCLIENTE: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("CUI: " + cliente.getCui() + "\n" );
        System.out.println("\n Cuentas: ");
        Cuenta[] cuentas = cliente.getCuentas();

        if(cuentas[0] != null){     // Si el cliente tiene cuentas

            System.out.println("__________________________________________________________________");
            System.out.println("\tTipo de Cuenta     |    No. de Cuenta    |   Saldo Disponible ");

            for (Cuenta cuenta : cuentas) {

                if (cuenta == null) {
                    continue;
                }
                System.out.println("__________________________________________________________________");
                System.out.print("\t\t" + cuenta.getTipoCuenta());

                if (cuenta.getTipoCuenta().equals("Monetaria")) {
                    System.out.println("\t\t\t\t" + cuenta.getIdCuenta() + "\t\t\t" + "Q\t" + cuenta.getSaldo());
                } else {
                    System.out.println("\t\t\t\t\t" + cuenta.getIdCuenta() + "\t\t\t" + "Q\t" + cuenta.getSaldo());
                }


            }


        } else {
            System.out.println("NO POSEE CUENTAS AÚN.");
        }

        System.out.println("\n\n Presione ENTER para regresar al menú principal.");
        leer.nextLine();
    }


    public static int menuPrincipal(){

        while(true) {
            System.out.println("\t\tMENU PRINCIPAL");
            System.out.println("________________________________________________");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("2. Crear nueva cuenta");
            System.out.println("3. Visualizar datos de un cliente");
            System.out.println("4. Realizar una transferencia");
            System.out.println("5. Ver historial de transferencias");

            System.out.println("\nIngrese una opción válida: ");

            int lectura = leer.nextInt();

            if (lectura >= 1 && lectura <= 5) {
                return lectura;
            } else {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }

        }

    }




    public static void main(String[] args){


        // Menú Principal

        while (true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            int opcion = menuPrincipal();
            switch (opcion){
                // Crear nuevo cliente
                case 1:

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Ingrese el CUI del cliente: ");
                    leer.nextLine(); // Evitar salto de lectura
                    String cui = leer.nextLine().trim().toUpperCase();

                    if(buscarCliente(cui) != -1 ){

                        System.out.println("\nYa existe un cliente con este CUI. \nPresione ENTER para volver a intentar.");
                        leer.nextLine();
                        break;

                    }

                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombre = leer.nextLine().trim().toUpperCase();
                    System.out.println("Ingrese el apellido del cliente: ");
                    String apellido = leer.nextLine().trim().toUpperCase();
                    Cliente cliente = new Cliente(cui, nombre, apellido);
                    agregarCliente(cliente);
                    break;

                // Crear nueva cuenta
                case 2:

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Ingrese el CUI del cliente: ");
                    leer.nextLine();
                    cui = leer.nextLine().trim();
                    int numeroCliente = buscarCliente(cui);

                    // Si existe el cliente
                    if(numeroCliente != -1){
                        cliente = clientes[numeroCliente];

                        // Solicitamos el tipo de cuenta a iniciar
                        System.out.println("\nIngrese el tipo de cuenta: \n M - Monetaria \t A- Ahorro");
                        String tipoCuenta = leer.nextLine().trim().toUpperCase();
                        if(!(tipoCuenta.equals("M") || tipoCuenta.equals("A"))){ // Si no existe el tipo de cuenta
                            System.out.println("\nNo existe ningún tipo de cuenta como la que ingresó. \nPresione ENTER para volver a intentar.");
                            leer.nextLine();
                            break;
                        }

                        // Generamos un identificador para la cuenta

                        String numeroRandom = String.valueOf(random.nextInt(8999999) + 1000000); // 1000000 - 9999999
                        String idCuenta = tipoCuenta + numeroRandom + numeroCliente;

                        // Chequeamos que no exista un identificador igual

                        Cuenta[] cuentas = cliente.getCuentas();
                        if(cuentas[0] != null){
                            for(int i = 0; i < cuentas.length; i++){
                                if(cuentas[i] == null){
                                    continue;
                                }
                                if(idCuenta.equals( cuentas[i].getIdCuenta() ) ){
                                    do{
                                        numeroRandom = String.valueOf(random.nextInt(8999) + 1000); // 1000 - 9999
                                        idCuenta = tipoCuenta + numeroRandom + numeroCliente;
                                    } while(idCuenta.equals( cuentas[i].getIdCuenta() ) );
                                }
                            }
                        }


                        // Solicitamos el monto de apertura de la cuenta
                        double monto;
                        do{
                            System.out.println("\n El monto debe de ser al menos Q100.00. Ingrese de nuevo un monto válido: ");
                             monto = leer.nextDouble();
                        } while (monto < 100.00);

                        // Creamos la cuenta
                        if(tipoCuenta.equals("M")){
                            tipoCuenta = "Monetaria";
                        } else {
                            tipoCuenta = "Ahorro";
                        }

                        String propietario = cliente.getNombre() + " " + cliente.getApellido();

                        Cuenta cuenta = new Cuenta(propietario, tipoCuenta, idCuenta, monto);

                        // Agregamos la cuenta al cliente

                        cliente.agregarCuenta(cuenta);

                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("\t\tCUENTA CREADA EXITOSAMENTE.\n Anote su número de cuenta: ");
                        System.out.println("\t" + idCuenta);
                        System.out.println("\n\n\t\t\t Presione ENTER para continuar.");
                        leer.nextLine();
                        leer.nextLine();

                    }
                    // Si no existe el cliente
                    else {
                        System.out.println("\nNo existe ningún cliente con el CUI que ingresó. \nPresione ENTER para volver a intentar.");
                        leer.nextLine();
                        break;
                    }

                    break;

                // Visualizar Datos
                case 3:

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Ingrese el CUI del cliente: ");
                    leer.nextLine();
                    cui = leer.nextLine().trim();
                    numeroCliente = buscarCliente(cui);

                    if(numeroCliente != -1) {
                        cliente = clientes[numeroCliente];
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        imprimirDatos(cliente);
                    } else {
                        System.out.println("\nNo existe ningún cliente con el CUI que ingresó. \nPresione ENTER para volver a intentar.");
                        leer.nextLine();
                        break;
                    }
                    break;

                // Realizar una transferencia
                case 4:

                    // Solicitar CUI del Cliente
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Ingrese el monto a transferir en Q. Ejemplo: 75.00");
                    leer.nextLine();
                    double monto = leer.nextDouble();
                    System.out.println("Ingrese la cuenta de origen: (Cuenta a la que se le debitará)");
                    leer.nextLine();
                    String idCuenta = leer.nextLine().trim().toUpperCase();

                    boolean cuentaExiste = verificarCuenta(idCuenta);

                    if(cuentaExiste) {

                        String origen = idCuenta;

                        System.out.println("\nIngrese la cuenta de destino: (Cuenta a la que se le acreditará)");
                        idCuenta = leer.nextLine().trim().toUpperCase();

                        if(idCuenta.equals(origen)){
                            System.out.println("\nNo puede realizar transferencias a la misma cuenta. \nPresione ENTER para volver a intentar.");
                            leer.nextLine();
                            break;
                        }

                        cuentaExiste = verificarCuenta(idCuenta);

                        if(cuentaExiste) {

                            String destino = idCuenta;

                            // Verificar fondos
                            boolean fondosSuficientes = verificarFondos(origen, monto);

                            if(fondosSuficientes){
                                // Realizar transferencia


                                Cuenta debitar = buscarCuenta(origen);
                                double saldo = debitar.getSaldo();
                                debitar.setSaldo(saldo - monto);
                                Transferencia transferencia1 = new Transferencia(origen, destino, (monto*-1));
                                debitar.agregarTransferencia(transferencia1);

                                Cuenta acreditar = buscarCuenta(destino);
                                saldo = acreditar.getSaldo();
                                acreditar.setSaldo(saldo + monto);
                                Transferencia transferencia2 = new Transferencia(origen, destino, monto);
                                acreditar.agregarTransferencia(transferencia2);

                                System.out.println("\n_______________________________________");
                                System.out.println("La transferencia fue realizada con éxito. \nPresione ENTER para regresar al menú principal.");
                                leer.nextLine();

                            }
                            else{
                                System.out.println("\nNo hay fondos suficientes. \nPresione ENTER para volver a intentar.");
                                leer.nextLine();
                                break;
                            }

                        } else {
                            System.out.println("\nNo existe la cuenta que ingresó. \nPresione ENTER para volver a intentar.");
                            leer.nextLine();
                            break;
                        }


                    } else {
                        System.out.println("\nNo existe la cuenta que ingresó. \nPresione ENTER para volver a intentar.");
                        leer.nextLine();
                        break;
                    }

                    break;


                case 5:

                    System.out.println("Ingrese el número de cuenta a revisar su historial de transferencias: ");
                    leer.nextLine();
                    idCuenta = leer.nextLine().trim().toUpperCase();

                    cuentaExiste = verificarCuenta(idCuenta);

                    if(cuentaExiste) {

                        Cuenta cuenta = buscarCuenta(idCuenta);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        imprimirHistorial(cuenta);

                    }
                    else{
                        System.out.println("\nNo existe la cuenta que ingresó. \nPresione ENTER para volver a intentar.");
                        leer.nextLine();
                        break;
                    }

                    break;



                default:

                    break;


            }

        }

    }


}
