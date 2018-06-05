package Design.chain;


import java.util.ArrayList;
import java.util.List;

public class MyFilter  {
        static class HtmlFilter implements Fliter{
            public HtmlFilter() {
            }
            public String doFilter(String msg) {
                msg=msg.replace("<","&lt").replace(">","&gt");
                return msg;
            }
        }
        static class SentiveFilter implements Fliter{
            public SentiveFilter() {
            }

            public String doFilter(String msg) {
                 msg=msg.replace("fuck","love");
                return msg;
            }
        }
        static class FilterChain implements Fliter{

            List<Fliter> list=new ArrayList<Fliter>();
            public void add(Fliter fliter){
                if (fliter!=null){
                    this.list.add(fliter);
                }

            }

            public String doFilter(String msg) {
                String msg1=msg;
                for (Fliter fliter:list){
                    msg1=fliter.doFilter(msg1);
                }
                return msg1;
            }
        }

    public static void main(String[] args) {
        HtmlFilter htmlFilter=new HtmlFilter();
        SentiveFilter sentiveFilter=new SentiveFilter();
        FilterChain filterChain=new FilterChain();
        filterChain.add(htmlFilter);
        filterChain.add(sentiveFilter);
        String msg="<fuck you>";
        msg=filterChain.doFilter(msg);
        System.out.println(msg);

    }
}