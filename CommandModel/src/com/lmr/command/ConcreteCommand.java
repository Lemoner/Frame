package com.lmr.command;

/**
 * ���������ɫ
 */
public class ConcreteCommand implements Command {

	/**
	 * ������Ӧ�Ľ����߶���
	 */
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		this.receiver=receiver;
	}
	
	@Override
	public void execute() {
		//ͨ����ת�������߶������Ӧ�������ý�����������ִ�й���
		receiver.action();
	}

}
