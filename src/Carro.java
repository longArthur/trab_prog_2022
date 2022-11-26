import java.time.LocalDate;

public class Carro extends VeiculoAutomotor{

    //atributos
    private int marcha;
    private final int limiteMarca;

    //construtores
    public Carro(String marca, String modelo, LocalDate fabricacao, int limiteMarcha) {
        super(marca, modelo, fabricacao);

        this.marcha = 0;
        this.limiteMarca = limiteMarcha;
    }

    //getters
    public int getMarcha(){ return this.marcha; }

    public int getLimiteMarca(){ return this.limiteMarca; }

    //metodos
    @Override
    public boolean liga(){

        if(!super.isLigado() && this.marcha == 0) {

            super.liga();

            return super.isLigado();
        }

        return false;
    }

    @Override
    public boolean desliga(){

        if(this.isLigado() && this.marcha == 0) {

            super.desliga();

            return super.isLigado();
        }

        return false;
    }

    @Override
    public boolean aumentaVelocidade(double aAdicionar) {

        double limiteMax = this.marcha * 20;

        if (super.isLigado() && this.marcha > 0) {

            if (aAdicionar < 0) {
                return false;
            }

            if (super.getVelocidade() + aAdicionar > limiteMax) {

                super.aumentaVelocidade(limiteMax - super.getVelocidade());

                return true;
            }

            else {

                super.aumentaVelocidade(aAdicionar);

                    return true;
            }
        }

        return false;
    }

    @Override
    public boolean diminuiVelocidade(double aDiminuir){

        if(super.isLigado() && super.getVelocidade() > 0){

            if(aDiminuir < 0){

                return false;
            }

            if(super.getVelocidade() - aDiminuir < 0){

                super.diminuiVelocidade(super.getVelocidade());

                    return true;

            }

            else {

                super.diminuiVelocidade(aDiminuir);

                return true;
            }
        }

        return false;
    }

    public void aumentaMarcha(int aMarcha){

        if(this.marcha < this.limiteMarca) {

            this.marcha++;
        }
    }

    public void diminuiMarcha(int aMarcha){

        if(this.marcha > 0){

            this.marcha--;
        }
    }
    @Override
    public String toString() {
        return String.format("""
                Marca: %s
                Modelo: %s
                Fabricacao: %d/%s/%d
                Velocidade: %f02.1
                Ligado: %b
                Marchas: %d""", super.getMarca(), super.getModelo(),
                super.getFabricacao().getDayOfMonth(), super.getFabricacao().getMonth(), super.getFabricacao().getYear(),
                super.getVelocidade(), super.isLigado(), this.getLimiteMarca());
    }
}
