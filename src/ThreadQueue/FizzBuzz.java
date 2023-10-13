package ThreadQueue;

public class FizzBuzz {
    private int value;
    private int counter = 1;
    private StringBuilder result = new StringBuilder();

    public FizzBuzz(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int value = 30;
        FizzBuzz fizzBuzz = new FizzBuzz(value);
        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(fizzBuzz.getOutput());
    }

    public synchronized void fizz() {
        while (counter < value) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                result.append("fizz, ");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (counter < value) {
            if (counter % 5 == 0 && counter % 3 != 0) {
                result.append("buzz, ");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                result.append("fizzbuzz, ");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (counter < value) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                result.append(counter).append(", ");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized String getOutput() {
        return result.toString();
    }
}