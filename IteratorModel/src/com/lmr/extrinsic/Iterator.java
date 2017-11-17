package com.lmr.extrinsic;

/**
 * 迭代接口
 */
public interface Iterator {

	/**
	 * 移动到第一个元素
	 */
	public void first();
	
	/**
	 * 移动到下一个元素
	 */
	public void next();
	
	/**
	 * 是否迭代结束
	 * @return	true迭代结束<br>
	 * 			false还有元素未迭代
	 */
	public boolean isDone();
	
	/**
	 * 返回当前迭代的元素
	 * @return	当前迭代的元素
	 */
	public Object currentItem();
	
}
