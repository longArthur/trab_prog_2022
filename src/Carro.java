import java.time.LocalDate;

public class Carro extends VeiculoAutomotor{

    //atributos
    private int marcha;
    private final int limiteMarcha;

    //construtores
    public Carro(String marca, String modelo, LocalDate fabricacao, int limiteMarcha) {
        super(marca, modelo, fabricacao);
        if (limiteMarcha < 0) throw new IllegalArgumentException("limite de marcaha nao pode ser negativo");

        this.marcha = 0;
        this.limiteMarcha = limiteMarcha;
    }

    //getters
    public int getMarcha(){
        return this.marcha;
    }

    public int getLimiteMarcha(){
        return this.limiteMarcha;
    }

    //metodos
    @Override
    public boolean liga(){
        if(this.marcha == 0)
            return super.liga();
        return this.isLigado();
    }

    @Override
    public boolean aumentaVelocidade(double aAdicionar) {
        double limiteMax = this.marcha * 20;
        if (this.getVelocidade() + aAdicionar >= limiteMax)
            return super.aumentaVelocidade(limiteMax - this.getVelocidade());
        else
            return this.aumentaVelocidade(aAdicionar);
    }

    public void aumentaMarcha(int aMarcha){
        if(this.marcha < this.limiteMarcha)
            this.marcha++;
    }

    public void diminuiMarcha(int aMarcha){
        if(this.marcha > 0)
            this.marcha--;
        this.diminuiVelocidade(this.getVelocidade() - this.marcha * 20);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Marchas: %d
                Marcha atual: %d""", super.toString(), this.getLimiteMarcha(), this.getMarcha());
    }
}
