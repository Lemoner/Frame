package com.lmr.mybaits.bean;

import java.util.List;
import java.util.Map;

/**
 * Message���Ӧ�Ľӿ�
 */
public interface IMessage {

	public List<Message> queryMessageListByPage(Map<?, ?> paramMap);
	
}
