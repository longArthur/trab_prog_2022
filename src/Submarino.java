import java.time.LocalDate;
import java.util.Objects;

public class Submarino extends VeiculoAutomotor {
    private final double limProfundidade;
    private final double maxVel;
    private final String registro;
    private double profundidade;

    public Submarino (String marca, String modelo, LocalDate fabricacao, String registro, double limProfundidade, double maxVel){
        super(marca,modelo,fabricacao);
        Objects.requireNonNull(registro,"Registro nao pode ser nulo");
        if (limProfundidade <= 0) throw new IllegalArgumentException("Profundidade tem que ser maior que zero!");
        if (maxVel <= 0) throw new IllegalArgumentException("Limite de velocidade tem que ser maior que zero!");

        this.registro = registro;
        this.limProfundidade = limProfundidade;
        this.maxVel = maxVel;
        profundidade = 0;
    }

    //getters

    public double getProfundidade() {
        return this.profundidade;
    }

    public double getLimProfundidade() {
        return this.limProfundidade;
    }

    public double getMaxVel() {
        return this.maxVel;
    }

    public String getRegistro() {
        return this.registro;
    }


    public boolean submerge(double aSubmergir){
        if (aSubmergir < 0) return false;
        else if (this.profundidade + aSubmergir > this.limProfundidade)
            this.profundidade = this.limProfundidade;
        else
            this.profundidade += aSubmergir;
        return true;
    }

    public boolean emerge(double aEmergir){
        if (aEmergir < 0) return false;
        else if (this.profundidade - aEmergir <= 0)
            this.profundidade = 0;
        else
            this.profundidade -= aEmergir;
        return true;
    }

    //overrides
    @Override
    public boolean aumentaVelocidade(double aAdicionar){
        if (this.getVelocidade() + aAdicionar >= this.maxVel)
            return super.aumentaVelocidade(this.maxVel - this.getVelocidade());
        else
            return super.aumentaVelocidade(aAdicionar);
    }

    @Override
    public boolean diminuiVelocidade(double aDiminuir){
        if (this.getVelocidade() - aDiminuir <= 0)
            return super.diminuiVelocidade(this.getVelocidade());
        else
            return super.diminuiVelocidade(aDiminuir);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Registro: %s
                Profundidade: %f03.1
                Lim profundidade: %f03.1
                Lim velocidade: %f03.1""", super.toString(), this.getRegistro(), this.getProfundidade() , this.getLimProfundidade(), this.getVelocidade());
    }
}
