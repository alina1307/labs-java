public class Ship extends Thread {
    int containersToTake; //брать
    int containersToLeave; //оставлять
    Port port;
    int currentContainersQuantity; 

    public Ship(String name, int containersToTake, int containersToLeave, Port port) {
        super(name);
        this.containersToTake = containersToTake;
        this.containersToLeave = containersToLeave;
        this.port = port;
        this.currentContainersQuantity = containersToLeave;
        start();
    }
    @Override
    public void run() {
        boolean isChanged = false;
        try {
            while (true) {
                if (!isChanged) {
                    port.askPermission();
                }
                isChanged = false;
                if (containersToLeave != 0 && containersToTake != 0) {
                    containersToTake--;
                    containersToLeave--;
                    isChanged = true;
                } else {
                    if (containersToLeave != 0  ){
                        synchronized (port) {
                            if (port.getContainersCapacity() > port.getCurrentContainersQuantity()) {
                                port.addContainer();
                                containersToLeave--;
                                isChanged = true;
                            }
                        }
                    } else {
                        if (containersToTake != 0 ){
                            synchronized (port) {
                                if (port.getCurrentContainersQuantity() > 0) {
                                    port.takeConatiner();
                                    containersToTake--;
                                    isChanged = true;
                                }
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " has finished his task"); //завершил свою задачу
                            port.returnPermission();
                            break;
                        }
                    }
                }
                if (isChanged){
                    Thread.sleep(10);
                } else {
                    port.returnPermission();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
}
}
