import java.time.LocalDate;
import java.util.Scanner;

    public class Aviao extends VeiculoAutomotor {
        Scanner tcl = new Scanner (System.in);
        private Double adicionar;
        private boolean permTaxiTorre = false;
        private boolean taxiPista = false;
        private boolean PermTorDecol = false;
        private boolean Voando;
        private boolean permTorrePous = false;

        private boolean ProtPousPista =false;
        private final double peso;

        private final String codigo;
        public Aviao(String marca, String modelo, LocalDate fabricacao, double Peso, String codigo){
            super(marca, modelo, fabricacao);
            this.peso = Peso;
            this.codigo = codigo;
        }
        //getter


        public String isCodigo() {
            return codigo;
        }
        public double isPeso() {
            return peso;
        }

        public boolean isPermTaxiTorre() {
            return permTaxiTorre;
        }

        public boolean isTaxiPista(){
            return this.taxiPista;
        }

        public boolean isPermTorDecol() {
            return PermTorDecol;
        }

        public boolean isVoando() {
            return Voando;
        }

        public boolean isPermTorrePous() {
            return permTorrePous;
        }

        public boolean isProtPousPista() {
            return ProtPousPista;
        }

        //setter
        public void setPermTaxiTorre(boolean permTaxiTorre) {
            this.permTaxiTorre = permTaxiTorre;
        }

        public void setTaxiPista(boolean taxiPista) {
            this.taxiPista = taxiPista;
        }

        public void setPermTorDecol(boolean permTorDecol) {
            this.PermTorDecol = permTorDecol;
        }

        public void setVoando(boolean voando) {
            this.Voando = voando;
        }

        public void setPermTorrePous(boolean permTorrePous) {
            this.permTorrePous = permTorrePous;
        }

        public void setProtPousPista(boolean protPousPista) {
            ProtPousPista = protPousPista;
        }

        //metodos de decolagem

        public void getPermTaxiTorre() {
            if (super.isLigado() == false) throw new IllegalArgumentException(" O aviao esta desligado");
            else if (isPermTaxiTorre() == true) throw new IllegalArgumentException("-Torre: Permissão ja concedida");
                else {
                    setPermTaxiTorre(true);
                    System.out.println("-Torre: Permissão para taxiamento a pista concedida");
                }
        }

        public void getTaxiPista() {
            if (super.isLigado() == false)throw new IllegalArgumentException(" O aviao esta desligado");
            else{
                if (isPermTaxiTorre() == false) throw new IllegalArgumentException(" Eh necessario a permissao da torre");
                else {
                    if (isTaxiPista() == true) throw new IllegalArgumentException("-Torre: O aviao ja foi taxiado a pista");
                    else setTaxiPista(true);
                }
            }
        }
        public void getPermTorDecol(){
                if (super.isLigado() == false) throw new IllegalArgumentException(" O aviao esta desligado");
                else if (PermTorDecol == true) throw new IllegalArgumentException("-Torre: Permissão ja concedida");
                    else {
                        setPermTorDecol(true);
                        System.out.println("-Torre: Permissão para decolagem concedida");
                    }
        }

        public void getDecolando(){
            if (super.isLigado() == false) throw new IllegalArgumentException(" O aviao esta desligado");
            else if( isTaxiPista() == false) throw new IllegalArgumentException( "O aviao nao esta na pista");
                else if ( isPermTorDecol() == false) throw new IllegalArgumentException( " Permissao para decolagem ainda nao foi concedida");
                    else {
                        //(; super.getVelocidade() <= 280; )
                        System.out.println("Aumentar a velocidade em?");
                        aumentaVelocidade(tcl.nextDouble());
                            for( ;getVelocidade()< 280; ){
                            System.out.println(" Acelere-o a ate 280 Km/h para ele voar");
                            aumentaVelocidade(tcl.nextDouble());
                            }
                        }
                        System.out.println(" O avião esta Voando");
                        setVoando(true);
                        setPermTaxiTorre(false);
                        setTaxiPista(false);
                        setPermTorDecol(false);
                    }
        //metodos da classe pai
        @Override
        public String toString() {
            return String.format("""
                Marca: %s
                Modelo: %s
                Fabricacao: %d/%d/%d
                Velocidade: %f03.1
                Ligado: %b""", this.getMarca(), this.getModelo(),
                    super.getFabricacao().getDayOfMonth(), super.getFabricacao().getDayOfMonth(),super.getFabricacao().getYear(),
                    super.getVelocidade(), super.isLigado(), isPeso(), isCodigo(), isVoando());
        }
        @Override
        public boolean aumentaVelocidade(double aAdicionar){
            if(aAdicionar < 0) throw new IllegalArgumentException( "O aviao nao pode acelerar com um numero negativo");
            else{ if (super.getVelocidade()+aAdicionar > 850) throw new IllegalArgumentException( "O aviao nao pode acelerar mais do que 850 km/h");
                else {
                    super.aumentaVelocidade(aAdicionar);
                    System.out.println(" A velocidade foi aumentada para "+getVelocidade()+" Km/h");
                    return true;
                }
            }
        }
        @Override
        public boolean diminuiVelocidade(double aDiminuir){
            if(aDiminuir < 0) throw new IllegalArgumentException( "O aviao nao pode desacelerar com um numero negativo");
            else if( super.getVelocidade()-aDiminuir < 0) throw new IllegalArgumentException( "Velocidade nao pode ser menor do que 0");
                else super.diminuiVelocidade(aDiminuir);
                    System.out.println(" A velocidade foi diminuida para "+getVelocidade()+" Km/h");
            return true;
        }
        @Override
        public boolean liga() {
            if (super.isLigado() == true) {
                throw new IllegalArgumentException("O aviao ja esta ligado");
            }
            else {
                System.out.println(" o Aviao foi ligado");
                return super.liga();
            }
        }
        @Override
        public boolean desliga() {
            if ( isVoando() == true) throw new IllegalArgumentException("O aviao nao pode ser desligado enquanto voa");
            else {
                if (super.isLigado() == false) {
                    throw new IllegalArgumentException("O aviao ja esta desligado");
                } else {
                    System.out.println(" o Aviao foi desligado");
                    return super.desliga();
                }
            }

        }// metodos de pouso

        public void getPermPousTorre(){
            if ( isVoando() == false) throw new IllegalArgumentException(" O aviao precisa estar voando para pedir permissão para pousar na pista");
            else {
                System.out.println("-Torre: O aviao esta liberado para pousar");
                setPermTorrePous(true);
            }
        }

        public void getProtPousPista(){
            if(isVoando() == false) throw new IllegalArgumentException(" O avião precisa estar voando");
            else if( isPermTorrePous() == false ) throw new IllegalArgumentException("Para pousar eh necessario a permissao da torre");
                else { setProtPousPista(true); System.out.println((" O aviao foi posicionado na cabeceira da pista"));
            }
        }
        public void getReverEmpuxoPouso(){
            if ( isPeso() > 28)
                if(isVoando() == false) throw new IllegalArgumentException(" O avião precisa estar voando");
                else if( isPermTorrePous() == false ) throw new IllegalArgumentException("Para pousar eh necessario a permissao da torre");
                     else if( isProtPousPista() == false) throw new IllegalArgumentException( "Para puxar o reverso eh necessario estar na cabeceira da pista");
                         else {
                        System.out.println(" O reverso foi puxado");
                           diminuiVelocidade(getVelocidade());
                           System.out.println(" o Aviao foi pousado");
                           setPermTorrePous(false);
                           setProtPousPista(false);
                        }
            else if( isPermTorrePous() == false ) throw new IllegalArgumentException("Para pousar eh necessario a permissao da torre");
                else if( isProtPousPista() == false) throw new IllegalArgumentException( "Para puxar o reverso eh necessario estar na cabeceira da pista");
                    else {
                        diminuiVelocidade(getVelocidade());
                        System.out.println(" o Aviao foi pousado");
                        setPermTorrePous(false);
                        setProtPousPista(false);
                        setVoando(false);
                    }
        }

        //protocolos de pouso e decolagem

        public void getProtocoloDecolagem(){
            liga();
            getPermTaxiTorre();
            getTaxiPista();
            getPermTorDecol();
            getDecolando();
        }

        public void getProtocolPouso(){
            getPermPousTorre();
            getProtPousPista();
            getReverEmpuxoPouso();
            desliga();
        }
    }

