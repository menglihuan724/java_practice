package bf;

public class DoubleSingletion {
    public  static DoubleSingletion doubleSingletion;
    public  static DoubleSingletion getInstance(){
        if (doubleSingletion==null){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleSingletion.class){
                if (doubleSingletion==null){
                    doubleSingletion=new DoubleSingletion();
                }
            }
        }
        return doubleSingletion;
    }
}