package hello.hello_spring;
import hello.hello_spring.domain.Member;

import java.util.*;

public class FindValueFromMap {
    public static void main(String[] args)
    {
        // Creating an empty Map

        // practice 1
        Map<String, String> data = new HashMap<>();
        data.put("dataA", "DataAA");
        data.put("dataB", "DataBB");
        data.put("dataC", "DataCC");
        data.put("dataD", "DataDD");

        // i want find "dataBB"
        // code -
        String findValue = "DataBB";
        // normal code style
        for (String s : data.keySet()) {
            if (data.get(s).equals(findValue)) {
                System.out.println(s);
            }
        }

        // lambda code style
        data.values() // data.keySet()
                .stream() // java stream function
                .filter(s -> s.equals(findValue))
                .findAny(); //


        // practice 2
        /* shortcut key to use system print*/
        /*
        soutv
        soutp
        soutm
        sout
        */

        Map<String, Member> data2 = new HashMap<>();
        data2.put("dataA", new Member(1L, "name1"));
        data2.put("dataB", new Member(2L, "name2"));
        data2.put("dataC", new Member(3L, "name3"));
        data2.put("dataD", new Member(4L, "name4"));
        //find value : Member name "name3"

        String findValue2 = "name3";
        // normal code style
        for (String s : data2.keySet()) {
            Member m = data2.get(s);
            if (m.getName().equals(findValue2)) {
                System.out.println(m.getId() +" // "+ m.getName());
            }
        }
        // lambda code style
        data2.values() // map values
                .stream() // java stream function
                .filter(member -> member.getName().equals("name3"))
                .findAny(); // get data



        /*
        System.out.println("data2 = " + data2);
        System.out.println("FindValueFromMap.main");
        System.out.println("args = " + Arrays.toString(args));
        */

//        String targetKey = data2.get(dataC).;
//        System.out.println(retreivedData2);
        //System.out.println("value : " + getKey("dataC").getClass(3L));



        // system.out.println("value" + data2.get(dataC, 3L));

    }
}