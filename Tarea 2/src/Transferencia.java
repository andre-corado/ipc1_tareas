import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transferencia {



    // Atributos
    private String origen;
    private String destino;
    private double monto;
    String tiempo;

    // Constructor

    public Transferencia(String origen, String destino, double monto){
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        tiempo = setTiempo();

    }


    // Métodos

    // Getters y Setters

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    private String setTiempo(){
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        String tiempo = formatoHora.format(ahora);
        return tiempo;
    }

    public String getTiempo(){        
        return tiempo;
    }

    //


}
