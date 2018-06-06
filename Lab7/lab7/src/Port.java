import java.util.ArrayList;
import java.util.List;

public class Port {
    private int quantityDock; //кол-во пристаней
    private int containersCapacity; //вместимость контейнера
    private int currentContainersQuantity; 

    List<Thread> ships = new ArrayList<>();
    public Port(int QuantityDock, int containersCapacity, int currentContainersQuantity) {
        this.quantityDock = QuantityDock;
        this.containersCapacity = containersCapacity;
        this.currentContainersQuantity = currentContainersQuantity;
    }
    public int getContainersCapacity() { 
        return containersCapacity;
    }
    public int getCurrentContainersQuantity() { 
        return currentContainersQuantity;
    }
    public void addContainer() { 
        currentContainersQuantity++;
    }
    public void takeConatiner() { 
        currentContainersQuantity--;
    }

    public synchronized void askPermission(){
        while (quantityDock == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ships.add(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + " has received permission");
        quantityDock--;
    }

    public synchronized void returnPermission(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is leaving dock");
        System.out.println("Current containers quantity in Port: " + currentContainersQuantity);
        if (ships.contains(Thread.currentThread())) {
            quantityDock++;
        }
        ships.remove(Thread.currentThread());
        notifyAll();  
    }
}
