package TimeDisplayApp;

public class MessageDisplay extends Thread{
   @Override
    public void run(){
       while (true){
           long currentTime = System.currentTimeMillis();
           System.out.println("Поточний час :" +currentTime / 1000);
           try{
               Thread.sleep(1000);
           } catch (InterruptedException e){
               e.printStackTrace();
           }
       }
   }
}
