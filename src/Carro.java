import java.time.LocalDate;

public class Carro extends VeiculoAutomotor{

    //atributos
    private final int marcha;
    private final int LimiteMarca;

    //construtores
    public Carro(String marca, String modelo, LocalDate fabricacao) {
        super(marca, modelo, fabricacao);

        this.marcha = 0;
        this.LimiteMarca = 5;
    }
}
