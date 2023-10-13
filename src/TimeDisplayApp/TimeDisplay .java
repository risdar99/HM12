package TimeDisplayApp;

class TimeDisplay extends Thread {
    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep(5000);
                System.out.println("Минуло 5 секунд");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}