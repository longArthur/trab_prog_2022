
import java.time.LocalDate;
import java.util.ArrayList;

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

        Submarino teste2 = new Submarino("Ford", "Jabiraca",LocalDate.of(1999,12,30),"A3C-1234",29,3);
        Submarino teste3 = new Submarino("Ford", "Jabiraca",LocalDate.of(1929,12,30),"A3C-1234",29,3);
        Submarino teste4 = new Submarino("Ford", "jaca",LocalDate.of(1999,12,30),"A3C-1234",29,3);
        Submarino teste5 = new Submarino("toyota", "Jabiraca",LocalDate.of(1999,12,30),"A3C-1234",29,3);
        Submarino teste6 = new Submarino("Ford", "Jabiraca",LocalDate.of(1999,12,30),"A39-1234",9,32222);
        System.out.println(!teste.equals(teste2));
        System.out.println(!teste.equals(teste3));
        System.out.println(!teste.equals(teste4));
        System.out.println(!teste.equals(teste5));
        System.out.println(teste2.equals(teste6));

        ArrayList<VeiculoAutomotor> arraySorteado = new ArrayList<>();
        arraySorteado.add(teste5);
        arraySorteado.add(teste3);
        arraySorteado.add(teste2);
        arraySorteado.add(teste6);
        arraySorteado.add(teste);
        arraySorteado.add(teste6);
        arraySorteado.add(teste4);
        ArrayList<VeiculoAutomotor> array = new ArrayList<>();
        array.add(teste2);
        array.add(teste6);
        array.add(teste3);
        array.add(teste);
        array.add(teste5);
        array.add(teste6);
        array.add(teste4);
        array.sort(null);
        System.out.println(array.equals(arraySorteado));

    }
}
