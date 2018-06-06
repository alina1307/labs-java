import java.util.ArrayList;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        Port port = new Port(3, 5000, 1000);
        List<Ship> ships = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ships.add(new Ship("Корабль " + i, 260, 100, port));
        }
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ships.forEach((ship) -> {
        try {
           ship.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
          }
        });
        System.out.println("All ships have finished their task");
    }
}
