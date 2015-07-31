package com.zhen.core.util;

import java.util.*;

/**
 * Collection工具类
 */
public class CollectionUtils
{
	
	public static <T> void removeDuplicateWithOrder(List<T> list) {
		List<T> newList = new ArrayList<T>();
		for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
			T element = iter.next();
			if (!newList.contains(element)){
				newList.add(element);
			}
		}
		list.clear();
		list.addAll(newList);
	}

	/**
	 * 判断list是否为空
	 * 
	 * @param list 
	 * @return 为null或为空则返回true，否则返回false
	 */
	public static boolean isEmpty(List<?> list)
	{
		return list == null || list.isEmpty();
	}
	
	/**
	 * 判断list是否为空
	 * 
	 * @param list 
	 * @return 为null或为空则返回true，否则返回false
	 */
	public static boolean isEmpty(Collection<?> collection)
	{
		return collection == null || collection.isEmpty();
	}
	
	/**
	 * 判断Map是否为空
	 * 
	 * @param map 
	 * @return 为null或为空则返回true，否则返回false
	 */
	public static boolean isEmpty(Map<?, ?> map)
	{
		return map == null || map.isEmpty();
	}
	
	/**
	 * 判断Set是否为空
	 * 
	 * @param set 
	 * @return 为null或为空则返回true，否则返回false
	 */
	public static boolean isEmpty(Set<?> set)
	{
		return set == null || set.isEmpty();
	}
	
	public static <T> boolean isEmpty(T[] array)
	{
		return array == null || array.length <= 0;
	}
	
	/**
	 *  从集合all中除去集合beside中的所有元素
	 * @param all 待处理的集合
	 * @param beside 需要被去掉的元素组成的集合
	 * @return 返回all中除了beside中元素以外的其它元素的集合
	 */
	public static List<String> removeAllIgnoreCase(List<String> all, List<String> beside) {
		List<String> rst = new ArrayList<String>();
		if( all == null || all.isEmpty() ) {
			return rst;
		}
		if( beside == null || beside.isEmpty() ) {
			return all;
		}
		
		for (String desc : all) {
			boolean eq = false;
			for (String str : beside) {
				if( (desc+"").equalsIgnoreCase(str) ) {
					eq = true;
					break;
				}
			}
			if( !eq ) {
				rst.add(desc);
			}
		}
		
		return rst;
	}
}
