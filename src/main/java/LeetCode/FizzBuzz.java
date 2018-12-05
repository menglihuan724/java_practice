package LeetCode;

/**
 * Created by menglihuan on 2017/4/2.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        String[] b=dosometing(15);
        for (String a:dosometing(15)
             ) {
            System.out.println(a);
        }
    }
    public static  String[] dosometing(int num){
        String[] array=new String[num+1];
        for (int i=1;i<num+1;i++){
            if (i%3==0&&i%5!=0){
                array[i]="Fizz";
            }else if(i%5==0&&i%3!=0){
                array[i]="Buzz";
            }else if(i%3==0&&i%5==0){
                array[i]="FizzBuzz";
            }else {
                array[i]=Integer.toString(i);
            }
        }

       /* public List<String> fizzBuzz(int n) {
            List<String> ret = new ArrayList<String>(n);
            for(int i=1,fizz=0,buzz=0;i<=n ;i++){
                fizz++;
                buzz++;
                if(fizz==3 && buzz==5){
                    ret.add("FizzBuzz");
                    fizz=0;
                    buzz=0;
                }else if(fizz==3){
                    ret.add("Fizz");
                    fizz=0;
                }else if(buzz==5){
                    ret.add("Buzz");
                    buzz=0;
                }else{
                    ret.add(String.valueOf(i));
                }
            }
            return ret;
        }*/
        return array;
    }
}
