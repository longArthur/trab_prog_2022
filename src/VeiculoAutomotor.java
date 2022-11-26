import java.time.LocalDate;
import java.util.Objects;

public abstract class VeiculoAutomotor implements Comparable<VeiculoAutomotor> {
    private final String marca;
    private final String modelo;
    private final LocalDate fabricacao;
    private double velocidade;

    public VeiculoAutomotor(String marca, String modelo, LocalDate fabricacao){
        Objects.requireNonNull(marca,"Marca nao pode ser nula");
        Objects.requireNonNull(modelo,"Modelo nao pode ser nulo");
        Objects.requireNonNull(fabricacao, "Fabricacao nao pode ser nulo");

        this.marca = marca;
        this.modelo = modelo;
        this.fabricacao = fabricacao;
        this.velocidade = 0;
    }

    //getters

    public double getVelocidade() {
        return velocidade;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getFabricacao() {
        return fabricacao;
    }

    public boolean aumentaVelocidade(double aAdicionar){
        this.velocidade += aAdicionar;
        return true;
    }

    public double diminuiVelocidade(double aDiminuir){
        this.velocidade -= aDiminuir;
        return this.velocidade;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(VeiculoAutomotor obj){

    }
}
