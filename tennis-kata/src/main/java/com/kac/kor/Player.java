package com.kac.kor;

import static com.kac.kor.PlayerState.ADVANTAGE;
import static com.kac.kor.PlayerState.DEUCE;
import static com.kac.kor.PlayerState.WIN;

public class Player {

	private int score = 0;
	private int advantageCounter = 0;

	public int getScore() {

		return score;
	}

	public void winsBall() {

		if(score == 15){
			score = 30;
		} else if(score == 30){
			score = 40;
		} else if(score == 40){
		  advantageCounter++;
		} else {
			score = 15;
		}
	}

	public PlayerState getResult(Player opponent) {
		if (score == opponent.getScore()) {
			if (score == 40 && advantageCounter == 0) {
				return DEUCE;
			}
			return ADVANTAGE;
		} else {
			return WIN;
		}
	}
}
