package com.hfm.collection.set.treeset;


import com.hfm.entity.People;
import java.util.Comparator;

/**
 * 自定义比较器
 * @author hfm
 */
public class IdComparator implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		if(o1.getId() == o2.getId()){
			return 0;
		}else{
			return 1;
		}
	}
}
