package com.lmr.mybaits.bean;

import java.util.List;
import java.util.Map;

/**
 * Message表对应的接口
 */
public interface IMessage {

	public List<Message> queryMessageListByPage(Map<?, ?> paramMap);
	
}
