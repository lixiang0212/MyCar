package com.lx.abcdemo.info;

import java.util.Comparator;

/**
 * 
 * @author xiaanming
 *
 */
public class PinyinComparator implements Comparator<Car> {

	@Override
	public int compare(Car car, Car t1) {
		String pinyin = new CharacterParser().getSelling(car.getName());
		String pinyin1= new CharacterParser().getSelling(t1.getName());
		String sortString = pinyin.substring(0, 1).toUpperCase();
		String sortString1 = pinyin1.substring(0, 1).toUpperCase();
		return sortString.compareTo(sortString1);
	}
}
