public class Cliente {

    //Atributos
    private String cui;
    private String nombre;
    private String apellido;
    private Cuenta[] cuentas;

    //Constructor
    public Cliente(String cui, String nombre, String apellido){
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        cuentas = new Cuenta[20];
    }


    // Métodos

    public void agregarCuenta(Cuenta cuenta){
        for(int i = 0; i < cuentas.length; i++){
            if(cuentas[i] == null){
                cuentas[i] = cuenta;
                break;
            }
        }
    }



    // Getters y Setters

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    //




}
