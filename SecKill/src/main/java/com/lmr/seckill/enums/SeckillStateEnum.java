package com.lmr.seckill.enums;

/**
 * ��ɱ״̬ö����
 */
public enum SeckillStateEnum {

	SUCCESS(1,"��ɱ�ɹ�"),
	END(0,"��ɱ����"),
    REPEAT_KILL(-1,"�ظ���ɱ"),
    INNER_ERROR(-2,"ϵͳ�쳣"),
    DATE_REWRITE(-3,"���ݴ۸�");
	
	private int state;
	private String infor;
	
	SeckillStateEnum(int state, String infor) {
		this.state = state;
		this.infor = infor;
	}

	public int getState() {
		return state;
	}
	
	public String getInfor() {
		return infor;
	}
	
	
	
}
