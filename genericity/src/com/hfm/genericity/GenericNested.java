package com.hfm.genericity;

import com.hfm.entity.Citizen;

import java.util.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 17:56
 */
public class GenericNested {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<String, ArrayList<Citizen>>();
        ArrayList<Citizen> list = new ArrayList<Citizen>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威", list);
        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Citizen> value = entry.getValue();
            System.out.println("户主：" + key);
            System.out.println("家庭成员：" + value);
        }
    }
}
