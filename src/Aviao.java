import java.time.LocalDate;
import java.util.Objects;

public class Aviao extends VeiculoAutomotor {
    private final String codigo;
    private final double maxVel;
    private final double maxAltitude;
    private final double velDecolagem;
    private boolean voando;
    private double altitude;

    public Aviao(String marca, String modelo, LocalDate fabricacao, String codigo, double maxVel, double velDecolagem, double maxAltitude){
        super(marca, modelo, fabricacao);
        Objects.requireNonNull(codigo, "codigo nao pode ser nulo");
        if (maxVel < 0) throw new IllegalArgumentException("velocidade maxima nao pode ser negativa");
        if (velDecolagem > maxVel) throw new IllegalArgumentException("velocidade decolagem nao pode ser maior do que velocidade maxima");
        if (velDecolagem < 0) throw new IllegalArgumentException("velocidade decolagem nao pode ser menor que 0");
        if (maxAltitude < 10) throw new IllegalArgumentException("maxAltitude nao pode ser menor que 10m");

        this.codigo = codigo;
        this.maxVel = maxVel;
        this.velDecolagem = velDecolagem;
        this.maxAltitude = maxAltitude;
        this.voando = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean isVoando() {
        return this.voando;
    }

    public double getMaxVel() {
        return this.maxVel;
    }

    public double getVelDecolagem() {
        return this.velDecolagem;
    }

    public double getMaxAltitude() {
        return maxAltitude;
    }

    public double getAltitude() {
        return altitude;
    }
    //metodos de decolagem

    public boolean decola(){
        if (this.isLigado() && (this.getVelocidade() >= this.velDecolagem)) {
            this.voando = true;
            this.altitude += 10;
            return true;
        }
        else
            return false;
    }

    public boolean pouso(){
        this.voando = false;
        this.altitude = 0;
        return false;
    }

    public boolean aumentaAltitude(double aAumentar) {
        if (aAumentar < 0) return false;

        if (this.voando) {
            if (this.altitude + aAumentar > this.maxAltitude){
                this.altitude = this.maxAltitude;
            }
            else
                this.altitude += aAumentar;
            return true;
        } else
            return false;
    }

    public boolean diminuiAltitude(double aDiminuir) {
        if (aDiminuir < 0) return false;

        if (this.voando){
            if (this.altitude - aDiminuir < 10){
                this.altitude = 10;
            }
            else
                this.altitude -= aDiminuir;
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Codigo: %s
                Velocidade maxima: %03.1f
                Altitude maxima: %03.1f
                Voando: %b
                Velocidade de Decolagem: %03.1f
                Altitude: %03.1f""", super.toString(), this.codigo, this.maxVel, this.maxAltitude, this.voando, this.velDecolagem, this.altitude); // TODO TOSTRING
    }

    @Override
    public boolean aumentaVelocidade(double aAdicionar){
        if (this.getVelocidade() + aAdicionar >= this.maxVel)
            return super.aumentaVelocidade(this.maxVel - this.getVelocidade());
        else
            return this.aumentaVelocidade(aAdicionar);
    }
    @Override
    public boolean diminuiVelocidade(double aDiminuir){
        double maxDiminuir = (voando) ? (velDecolagem) : 0;

        if (this.getVelocidade() - aDiminuir <= maxDiminuir)
            return super.diminuiVelocidade(this.getVelocidade() - maxDiminuir);
        else
            return super.diminuiVelocidade(aDiminuir);
    }
    @Override
    public boolean desliga() {
        if (this.isVoando())
            return true;
        else
            return super.desliga();
    }
}