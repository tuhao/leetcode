package multithread;

public class StaticSingletonDCL {


    private volatile static StaticSingletonDCL instance;

    public static StaticSingletonDCL getInstance() {
        if (instance == null) {
            synchronized (StaticSingletonDCL.class) {
                if (instance == null) {
                    instance = new StaticSingletonDCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        StaticSingletonDCL.getInstance();
    }
}
