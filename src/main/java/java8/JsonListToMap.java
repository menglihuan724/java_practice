package java8;


import org.apache.storm.shade.com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-09-21
 */
public class JsonListToMap {

    public static void main(String[] args) {
        String json = "{\"name\":\"menglihuan\",\"address\":\"chengdu\"}";
        Map<String, Object> a = new HashMap();
        a.put("id", 1);
        a.put("name", "terry724");
        Map<String, Object> b = new HashMap();
        b.put("id", 2);
        b.put("name", "terry7");
        b.put("name", "terry7");
        Map<String, Object> c = new HashMap();
        c.put("id", 1);
        c.put("name", "terry76");
        List<Map<String, Object>> list = Lists.newArrayList(a, b, c);
        if(list.isEmpty()){
            return;
        }
        Map<Object, List<Map<String, Object>>> collect = list.stream().filter(var ->
                var.containsKey("id")
        ).collect(Collectors.groupingBy(var ->
                var.get("id")
        ));

        System.out.print(
                collect
        );

        list.clear();

        System.out.print(
                collect
        );
        User user1 = new JsonListToMap.User();
        user1.setId(1);
        user1.setName("meng");

        User user2 = new JsonListToMap.User();
        user2.setId(1);
        user2.setName("meng2");

        User user3 = new JsonListToMap.User();
        user3.setId(2);
        user3.setName("meng");

        List<User> list2 = Arrays.asList(user1, user2, user3);


//        System.out.print(
//                list2.stream()
//                        .collect(Collectors.groupingBy(user->user.getId()))
//        );
    }

    static class User {
        String name;
        Integer id;


        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
