package com.lmr.votemanager;

/**
 * �ظ�ͶƱ״̬
 */
public class RepeatVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("do not repeat vote");
	}

}
