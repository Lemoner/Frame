package com.lmr.votemanager;

import java.util.HashMap;
import java.util.Map;

/**
 * Õ∂∆±π‹¿Ì
 */
public class VoteManager {

	private VoteState state=null;
	
	private Map<String, String> mapVote=new HashMap<>();
	
	private Map<String, Integer> mapVoteCount=new HashMap<>();

	public Map<String, String> getMapVote() {
		return mapVote;
	}

	public Map<String, Integer> getMapVoteCount() {
		return mapVoteCount;
	}

	public void setState(VoteState state) {
		this.state = state;
	}
	
	public void vote(String user, String voteItem){
		
		int count=mapVoteCount.getOrDefault(user, 0);
		
		count++;
		mapVoteCount.put(user, count);
		
		if(count==1){
			
		}
		
	}
	
}
