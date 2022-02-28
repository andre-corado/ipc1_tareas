public class Cuenta {

    // Atributos
    private String propietario;
    private String tipoCuenta;
    private String idCuenta;
    private double saldo;
    private Transferencia[] historialTransferencias;


    // Constructor
    public Cuenta(String propietario, String tipoCuenta, String idCuenta, double saldo){
        this.propietario = propietario;
        this.tipoCuenta = tipoCuenta;
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        historialTransferencias = new Transferencia[50];
    }

    // Métodos

    public void agregarTransferencia(Transferencia transferencia){
        for(int i = 0; i < historialTransferencias.length; i++){
            if(historialTransferencias[i] == null){
                historialTransferencias[i] = transferencia;
                break;
            }
        }
    }

    // Getters y Setters

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoCuenta(){
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta){
        this.tipoCuenta = tipoCuenta;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Transferencia[] getHistorialTransferencias() {
        return historialTransferencias;
    }

    public void setHistorialTransferencias(Transferencia[] historialTransferencias) {
        this.historialTransferencias = historialTransferencias;
    }

    //

}
