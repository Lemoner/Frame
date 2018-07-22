package com.lmr.votemanager;

/**
 * Õý³£Í¶Æ±×´Ì¬
 */
public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("vote is success");
	}

}
