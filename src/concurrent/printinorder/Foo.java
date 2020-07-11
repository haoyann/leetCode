package concurrent.printinorder;


/**
 * 按照 first->second->third 的顺序执行
 */
public class Foo {


    private volatile int firstPrint = 0;

    private volatile int secondPrint = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstPrint = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstPrint == 0) {
        }
        printSecond.run();
        secondPrint = 1;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondPrint == 0) {

        }
        printThird.run();
    }

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {

            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {

            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {

            }
        }).start();

        Thread.sleep(10000);
    }
}
