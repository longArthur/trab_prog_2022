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
        super.ligado = true;
        return super.isLigado();
    }

    @Override
    public boolean desliga(){
        super.ligado = false;
        return super.isLigado();
    }

    @Override
    public double aumentaVelocidade(double aAdicionar){
        super.velocidade += aAdicionar;
        return true;
    }

    @Override
    public double diminuiVelocidade(double aDiminuir){
        super.velocidade -= aDiminuir;
        return super.velocidade;
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
                Fabricacao: %d/%d/%d
                Velocidade: %f02.1
                Ligado: %b
                Marcha: %d""", super.getMarca(), super.getModelo(),
                super.getFabricacao().getDayOfMonth(), super.getFabricacao().getDayOfMonth(), super.getFabricacao().getYear(),
                super.getVelocidade(), super.isLigado(), this.getMarcha());
    }
}
