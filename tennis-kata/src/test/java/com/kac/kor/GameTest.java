package com.kac.kor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

	private Player player;

	@Before
	public void setup() {
		player = new Player();
	}

	@Test
	public void playerStartsGameWithZeroPoints(){

		assertEquals(0, player.getScore());
	}

	@Test
	public void playerWinsFirstBall(){

		player.winBall();

		assertEquals(15, player.getScore());
	}

	@Test
	public void playerWinsSecondBall(){

		player.winBall();
		player.winBall();

		assertEquals(30, player.getScore());
	}

	@Test
	public void playerWinsThirdBall(){

		player.winBall();
		player.winBall();
		player.winBall();

		assertEquals(40, player.getScore());
	}


}
//1. Each player can have either of these points in one game 0 15 30 40