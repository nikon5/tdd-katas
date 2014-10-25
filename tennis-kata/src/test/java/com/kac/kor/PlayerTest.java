package com.kac.kor;

import org.junit.Before;
import org.junit.Test;

import static com.kac.kor.PlayerState.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

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

		player.winsBall();

		assertEquals(15, player.getScore());
	}

	@Test
	public void playerWinsSecondBall(){

		player.winsBall();
		player.winsBall();

		assertEquals(30, player.getScore());
	}

	@Test
	public void playerWinsThirdBall(){

		score40Points(player);

		assertEquals(40, player.getScore());
	}

	@Test
	public void ifPlayerHas40AndWinsTheBallThenWinsGame(){

		Player opponent  = new Player();
		score40Points(player);

		player.winsBall();

		assertEquals(WIN, opponent.getResult(player));
	}

	@Test
	public void BothPlayersHave40Points(){

		Player opponent  = new Player();

		score40Points(player);
		score40Points(opponent);

		assertEquals(DEUCE, opponent.getResult(player));
		assertEquals(DEUCE, player.getResult(opponent));
	}

	private void score40Points(Player player) {

		player.winsBall();//15
		player.winsBall();//30
		player.winsBall();//40
	}

}
//1. Each player can have either of these points in one game 0 15 30 40
//2. If you have 40 and you win the ball you win the game, however there are special rules.

//3. If both have 40 the players are deuce.
// a. If the game is in deuce, the winner of a ball will have advantage and
// game ball.
// b. If the player with advantage wins the ball he wins the game
// c. If the player without advantage wins
// they are back at deuce.