import java.time.LocalDate;
import java.util.Objects;

public abstract class VeiculoAutomotor implements Comparable<VeiculoAutomotor> {
    private final String marca;
    private final String modelo;
    private final LocalDate fabricacao;
    private double velocidade;
    private boolean ligado;

    public VeiculoAutomotor(String marca, String modelo, LocalDate fabricacao){
        Objects.requireNonNull(marca,"Marca nao pode ser nula");
        Objects.requireNonNull(modelo,"Modelo nao pode ser nulo");
        Objects.requireNonNull(fabricacao, "Fabricacao nao pode ser nulo");

        this.marca = marca;
        this.modelo = modelo;
        this.fabricacao = fabricacao;
        this.velocidade = 0;
        this.ligado = false;
    }

    //getters

    public double getVelocidade() {
        return this.velocidade;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public LocalDate getFabricacao() {
        return this.fabricacao;
    }

    public boolean isLigado(){ return this.ligado; }

    public boolean aumentaVelocidade(double aAdicionar){
        if (aAdicionar < 0) return false;
        this.velocidade += aAdicionar;
        return true;
    }

    public boolean diminuiVelocidade(double aDiminuir){
        if (aDiminuir < 0) return false;
        this.velocidade -= aDiminuir;
        return true;
    }

   public boolean liga(){
        this.ligado = true;
        return this.ligado;
   }

   public boolean desliga(){
        this.ligado = false;
        return this.ligado;
   }

    @Override
    public String toString() {
        return String.format("""
                Marca: %s
                Modelo: %s
                Fabricacao: %d/%d/%d
                Velocidade: %f03.1
                Ligado: %b""", this.getMarca(), this.getModelo(),
                this.getFabricacao().getDayOfMonth(), this.getFabricacao().getDayOfMonth(),this.getFabricacao().getYear(),
                this.getVelocidade(), this.ligado);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!this.getClass().isInstance(obj)) return false;

        VeiculoAutomotor in = (VeiculoAutomotor) obj;
        return (this.marca.equals(in.marca)) &&
                (this.modelo.equals(in.modelo)) &&
                (this.fabricacao.equals(in.fabricacao)) &&
                (this.velocidade == in.velocidade) &&
                (this.ligado == in.ligado);
    }

    @Override
    public int compareTo(VeiculoAutomotor obj){
        if (this.equals(obj)) return 0;
        switch (this.marca.compareTo(obj.marca)) {
            case -1:
                return -1;
            case 0:
                switch (this.modelo.compareTo(obj.modelo)) {
                    case -1:
                        return -1;
                    case 0:
                        return this.fabricacao.compareTo(obj.fabricacao);
                    case 1:
                        return 1;
                }
            case 1:
                return 1;
        }
        return -1   ;
    }

}
