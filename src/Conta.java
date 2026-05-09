public class Conta {
    private Integer numero;
    private String titular;
    private double saldo;
    private double saqueLimite;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaqueLimite() {
        return saqueLimite;
    }

    public void setSaqueLimite(double saqueLimite) {
        this.saqueLimite = saqueLimite;
    }

    public Conta(){

    }

    public Conta(Integer numero, String titular, double saldo, double saqueLimite) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.saqueLimite = saqueLimite;
    }

    public void depositar(double valor){
        validarDeposito(valor);
        saldo += valor;
    }

    public void sacar(double valor){
        validarSaque(valor);
        saldo -= valor;
    }

    private void validarSaque(double valor){
        if(valor > getSaqueLimite()){
            throw new BusinessException("Valor maior que o saque limite!");
        }
        if(valor > getSaldo()){
            throw new BusinessException("Saldo insuficiente!");
        }
    }

    private void validarDeposito(double valor){
        if (valor <= 0){
            throw new BusinessException("Valor de depósito inválido!");
        }
    }

    @Override
    public String toString() {
        return "\nNúmero: " + numero +
                "\nTitular: " + titular +
                String.format("\nSaldo: %.2f", saldo) +
                String.format("\nLimite de saque: %.2f", saqueLimite);
    }
}
