import java.time.LocalDate;

public class Transformer extends Carro{
    private boolean transformado;

    public Transformer(String marca, String modelo, LocalDate fabricacao, int limiteMarcha) {
        super(marca,modelo,fabricacao,limiteMarcha);

        transformado = false;
    }

    public boolean isTransformado() {
        return this.transformado;
    }

    public boolean transformar(){
        if (!isLigado()) return false;

        transformado = !transformado;
        if(transformado){
            if (this.getVelocidade() > 20)
                this.diminuiVelocidade(this.getVelocidade() - 20);
            this.diminuiMarcha(this.getMarcha());
        }
        else{
            this.diminuiVelocidade(this.getVelocidade());
        }
        return true;
    }

    //overrides
    @Override
    public boolean aumentaVelocidade(double aAdicionar){
        if(transformado){
            if (this.getVelocidade() + aAdicionar >= 20)
                return super.aumentaVelocidade(20 - this.getVelocidade());
            else
                return this.aumentaVelocidade(aAdicionar);
        }
        else
            return super.aumentaVelocidade(aAdicionar);
    }

    @Override
    public void diminuiMarcha(int aMarcha) {
        if (!transformado)
            super.diminuiMarcha(aMarcha);
    }

    @Override
    public void aumentaMarcha(int aMarcha){
        if(!transformado)
            super.aumentaMarcha(aMarcha);
    }

    @Override
    public String toString(){
        return String.format("""
                %s
                Transformado: %b""",super.toString(), this.transformado);
    }
}

