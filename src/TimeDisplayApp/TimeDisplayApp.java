package TimeDisplayApp;

public class TimeDisplayApp {
    public static void main(String[] args) {
        Thread timeDisplayThread = new Thread(new TimeDisplay());
        timeDisplayThread.start();
        Thread messageDisplayThread = new Thread( new MessageDisplay());
        messageDisplayThread.start();
    }
}