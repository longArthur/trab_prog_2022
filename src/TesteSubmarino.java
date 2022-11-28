
import java.time.LocalDate;

public class TesteSubmarino {
    public static void main(String[] args) {
        Submarino teste = new Submarino("Ford", "Jabiraca",LocalDate.of(1999,12,30),"ABC-1234",300,200);
        System.out.println(teste.getMarca().equals("Ford"));
        System.out.println(teste.getModelo().equals("Jabiraca"));
        System.out.println(teste.getFabricacao().equals(LocalDate.of(1999,12,30)));
        System.out.println(teste.getRegistro().equals("ABC-1234"));
        System.out.println(teste.getProfundidade() == 0);
        System.out.println(teste.getLimProfundidade() == 300);
        System.out.println(teste.getMaxVel() == 200);
        System.out.println(!teste.aumentaVelocidade(10));
        System.out.println(teste.getVelocidade() == 0);
        System.out.println(!teste.submerge(20));
        System.out.println(teste.getProfundidade() == 0);
        System.out.println(teste.liga());
        System.out.println(teste.isLigado());
        System.out.println(teste.aumentaVelocidade(10));
        System.out.println(teste.getVelocidade() == 10);
        System.out.println(teste.aumentaVelocidade(10000));
        System.out.println(teste.getVelocidade() == 200);
        System.out.println(!teste.aumentaVelocidade(-1));
        System.out.println(teste.getVelocidade() == 200);
        System.out.println(teste.aumentaVelocidade(0));
        System.out.println(teste.getVelocidade() == 200);
        System.out.println(!teste.desliga());
        System.out.println(!teste.isLigado());
        System.out.println(teste.liga());
        System.out.println(teste.submerge(20));
        System.out.println(teste.getProfundidade() == 20);
        System.out.println(teste.submerge(300));
        System.out.println(teste.getProfundidade() == 300);
        System.out.println(!teste.submerge(-1));
        System.out.println(teste.getProfundidade() == 300);
        System.out.println(teste.submerge(0));
        System.out.println(teste.getProfundidade() == 300);
        System.out.println(!teste.diminuiVelocidade(-1));
        System.out.println(teste.getVelocidade() == 200);
        System.out.println(teste.diminuiVelocidade(0));
        System.out.println(teste.getVelocidade() == 200);
        System.out.println(teste.diminuiVelocidade(10));
        System.out.println(teste.getVelocidade() == 190);
        System.out.println(teste.diminuiVelocidade(2000));
        System.out.println(teste.getVelocidade() == 0);
        System.out.println(!teste.emerge(-1));
        System.out.println(teste.getProfundidade() == 300);
        System.out.println(teste.emerge(0));
        System.out.println(teste.getProfundidade() == 300);
        System.out.println(teste.emerge(10));
        System.out.println(teste.getProfundidade() == 290);
        System.out.println(teste.emerge((2000)));
        System.out.println(teste.getProfundidade() == 0);
        System.out.println(teste.emerge(20));
        System.out.println(teste.getVelocidade() == 0);
        System.out.println(teste.toString().equals("""
                Marca: Ford
                Modelo: Jabiraca
                Fabricacao: 30/12/1999
                Velocidade: 0,0
                Ligado: true
                Registro: ABC-1234
                Profundidade: 0,0
                Lim profundidade: 300,0
                Lim velocidade: 200,0""") || teste.toString().equals("""
                Marca: Ford
                Modelo: Jabiraca
                Fabricacao: 30/12/1999
                Velocidade: 0.0
                Ligado: true
                Registro: ABC-1234
                Profundidade: 0.0
                Lim profundidade: 300.0"""));



        //TODO public boolean equals(Object obj) {}

        //TODO public int compareTo(VeiculoAutomotor obj){}

    }
}
