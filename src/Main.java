import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Aviao boing = new Aviao("Boeing", "737", LocalDate.of(1999,5,23),27, "CR - 136");
        boing.getProtocoloDecolagem();
        boing.getProtocolPouso();
        boing.toString();
    }
}