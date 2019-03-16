
public class Cuentas {
    private double idCuenta,idCliente,idUsuario,saldo_actual,movimientos;
    private int dia,mes,anio,contrato;
    private String fecha_apertura,fecha_movimiento, tipo_cuenta;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public double getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(double idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(double idCliente) {
        this.idCliente = idCliente;
    }

    public double getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(double idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public double getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(double movimientos) {
        this.movimientos = movimientos;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }
    
}
