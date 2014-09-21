package com.kac.kor;
public class Player {

	private int score = 0;

	public int getScore() {

		return score;
	}

	public void winBall() {

		if(score == 15){
			score = 30;
		} else if(score == 30){
			score = 40;
		}else{
			score = 15;
		}
	}
}
