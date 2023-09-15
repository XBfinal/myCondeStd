import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * @Title: demo01
 * @Author 笑霸fianl
 * @Package PACKAGE_NAME
 * @Date 2023/9/8 18:19
 * @描述:
 */
public class demo01 {
//    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("1","1~~~~");
//        map.put("2","2~~~~");
//        map.put("3","3~~~~");
//        map.put("4","4~~~~");
//        Iterator<String> iterator = map.values().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
////        map.forEach((k,v) ->{
////            System.out.println(k);
////            System.out.println(v);
////            System.out.println("=========");
////        });
//
//
////        for (String s: map.values()) {
////            System.out.println(s);
////        }
//
////        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
////        while (iterator.hasNext()){
////
////            System.out.println(iterator.next());
////        }
//
//    }

    public static void main(String[] args) {
////
//        String st ="WellcomTo";
//        System.out.println(st.substring(4,7));

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1,"a");
        map.put(2,"c");
        map.put(3,"d");
        if(map.containsKey(3)){
            map.replace(3,"b");
        }
        System.out.println(map);

    }
}
