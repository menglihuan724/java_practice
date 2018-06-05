package Design.bf;

import java.util.ArrayList;

public class DoubleSingletion {
    public  static DoubleSingletion doubleSingletion;
    public  static DoubleSingletion getInstance(){
        ArrayList a=new ArrayList();
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