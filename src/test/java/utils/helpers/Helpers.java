package utils.helpers;

public class Helpers {

    public static void delay(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
