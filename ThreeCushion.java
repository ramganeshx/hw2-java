package hw2;

import api.BallType;
import api.PlayerPosition;
import static api.PlayerPosition.*;
import static api.BallType.*;

/**
 * Class that models the game of three-cushion billiards.
 * 
 * @author Ram Ganesh
 */
public class ThreeCushion {

	/*
	 * instance variable that tracks player A points.
	 */
	private int playerApoints;

	/*
	 * instance variable that tracks player B points
	 */
	private int playerBpoints;

	/*
	 * instance variable that tracks what inning number it is. Declared as 1 in
	 * constructor
	 */
	private int inning;

	/*
	 * my winner is my instance variable name for lagwinner; declared in constructer
	 */
	private PlayerPosition winner;

	/*
	 * instance variable just declaring that PLAYER_A from the player position api
	 * enum is set equal to PlayerA
	 */
	private PlayerPosition PlayerA = PLAYER_A;
	/*
	 * instance variable just declaring that PLAYER_A from the player position api
	 * enum is set equal to PlayerN
	 */
	private PlayerPosition PlayerB = PLAYER_B;

	/*
	 * instance variable accounting for number of shots in the inning
	 */
	private int shots;

	/*
	 * instance variable assigning the color of the cueball for playerA
	 */
	private BallType cueBall;

	/*
	 * instance varuable assigning the color of the cueball for PlayerB
	 */
	private BallType cueBall2;

	/*
	 * instance variable assigning from the current player, what the cueball color
	 * is
	 */
	private BallType currentCueBall;

	/*
	 * instance variable that represents the number of points to win, defined in
	 * constructor
	 */
	private int designatedPoints;

	/*
	 * instance variable for when the cue stick strikes the ball
	 */
	private boolean stickStrike;

	/*
	 * instance variable for when a point is scored, can be assigned to playerA or B
	 * when he scores a legal point
	 */
	private boolean scorePoint;

	/*
	 * instance variable for when a foul is called. if foul called, inning ends, and
	 * turns are switched
	 */
	private boolean foulCalled;

	/*
	 * instance for variable for if the inning is started or not. inning started =
	 * false when a new inning occurs (ex. foul , endshot)
	 */
	private boolean inningStarted;

	/*
	 * instance variable for if a break shot has been chosen or not
	 */
	private boolean breakShot;


	/*
	 * instance variable for amount of times the cushion has been hit by the ball
	 */
	private int cushionImpact;

	/*
	 * instance variable representing who the current player is
	 */
	private PlayerPosition currentPlayer;

	/*
	 * instance variable for when the stick strikes the ball type
	 */
	private BallType saveStick;

	
	private boolean gameOver;

	private boolean bankShot;

	/*
	 * instance variable for if shot is started or not
	 */
	private boolean shotStarted;

	private int ballHit;

	private boolean validShot;

	private boolean chosenLag;

	//private int redStrike;

	// private boolean breakShotChosen;

	// private boolean yellowWhiteBallStrike;

	// TODO: EVERTHING ELSE GOES HERE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The method below is provided for you and you should not modify it.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.

	public String toString() {
		String fmt = "Player A%s: %d, Player B%s: %d, Inning: %d %s%s";
		String playerATurn = "";
		String playerBTurn = "";
		String inningStatus = "";
		String gameStatus = "";

		if (getInningPlayer() == PLAYER_A) {
			playerATurn = "*";
		} else if (getInningPlayer() == PLAYER_B) {
			playerBTurn = "*";
		}
		if (isInningStarted()) {
			inningStatus = "started";
		} else {
			inningStatus = "not started";
		}
		if (isGameOver()) {
			gameStatus = ", game result final";
		}
		return String.format(fmt, playerATurn, getPlayerAScore(), playerBTurn, getPlayerBScore(), getInning(),
				inningStatus, gameStatus);
	}

	public ThreeCushion(PlayerPosition lagWinner, int pointsToWin) {
		// TODO Auto-generated constructor stub

		// stickStrike = false;
		winner = lagWinner;

		designatedPoints = pointsToWin;

		gameOver = false;

		inning = 1;

		chosenLag = false;

		// inningStarted = false;

		// bankShot = isBankShot();
	}

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player A*: X Player B: Y, Inning: Z</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which player is at the
	 * table this inning. The number after the player's name is their score. Z is
	 * the inning number. Other messages will appear at the end of the string.
	 * 
	 * @return one-line string representation of the game state
	 */

	public int getInning() {
		// TODO Auto-generated method stub

		return inning;
	}

	public int getPlayerBScore() {
		// TODO Auto-generated method stub

		return playerBpoints;
	}

	public int getPlayerAScore() {
		// TODO Auto-generated method stub

		return playerApoints;
	}

	// a new inning is started after a foul or a end shot

	public boolean isInningStarted() {
		// TODO Auto-generated method stub

		/*
		 * if(breakChosen) {
		 * 
		 * struck = true;
		 * 
		 * }
		 */

		// return stickStrike;

		return inningStarted;
	}

	public PlayerPosition getInningPlayer() {

		return currentPlayer;
		// TODO Auto-generated method stub
	}

	public void lagWinnerChooses(boolean selfbreak, BallType cueball) {
		// The lag winner chooses to take the break shot and take the white

		breakShot = true;
		// gameOver = true;

		if (winner == PlayerA) {

			cueBall = cueball;

			// cueBall = cueball;
			// cueball = yellow;

			if (selfbreak) {

				/*
				 * breakShotA = true;
				 * 
				 * breakShotB = false;
				 */
				// cueBall = cueball;

				currentPlayer = PlayerA;

			} else {

				// breakShotB = true;

				// breakShotA = false;

				currentPlayer = PlayerB;
			}

		} else if (winner == PlayerB) {

			// cueBall2 = cueball;
			// cueball = white;

			cueBall2 = cueball;

			if (selfbreak) {

				// breakShotB = true;
				// breakShotA = false;

				currentPlayer = PlayerB;
			} else {
				// breakShotB = false;
				// breakShotA = true;

				currentPlayer = PlayerA;

			}

		}

		if (cueBall == WHITE) {

			// cueHitA = YELLOW;
			cueBall2 = YELLOW;

		} else if (cueBall2 == WHITE) {

			// cueHitB = YELLOW;
			cueBall = YELLOW;
		}

		if (currentPlayer == PlayerA) {
			currentCueBall = cueBall;
		} else if (currentPlayer == PlayerB) {

			currentCueBall = cueBall2;
		}

		// breakChosen = true;
		// inningStarted = true;

		chosenLag = true;

	}

	public BallType getCueBall() {

		/*
		 * if (currentPlayer == PlayerA) { currentCueBall = cueBall; } else if
		 * (currentPlayer == PlayerB) {
		 * 
		 * currentCueBall = cueBall2; }
		 */
		return currentCueBall;

		/*
		 * BallType ball = null;
		 * 
		 * if (currentPlayer == PlayerA) {
		 * 
		 * 
		 * ball = white;
		 * 
		 * } else {
		 * 
		 * ball = yellow; }
		 * 
		 * if (currentPlayer == PlayerB) {
		 * 
		 * ball = yellow; }
		 * 
		 * else {
		 * 
		 * ball = white; }
		 * 
		 * return ball;
		 * 
		 */
	}

	public boolean isBreakShot() {
		// TODO Auto-generated method stub

		return breakShot;

		/*
		 * if (inning == 1 && shots == 0) { // && breakChosen) {
		 * 
		 * return true;
		 * 
		 * }
		 * 
		 * else { return false; }
		 */
	}

	/*
	 * Indicates the cue stick has struck the given ball. If a shot has not already
	 * begun, indicates the start of a new shot. If this method is called while a
	 * shot is still in progress (i.e., endShot() has not been called for the
	 * previous shot), the player has committed a foul (see the method foul()).
	 * 
	 * Also, if the player strikes anything other than their own cue ball, they
	 * committed a foul. Calling this method signifies both the start of a shot and
	 * the start of an inning, assuming a shot or inning has not already begun,
	 * respectively. Even if a foul has been committed, calling this method is
	 * considered the start of a shot. That includes even the case when the player
	 * strikes a ball other than their own cue ball. It is expected that the
	 * endShot() method will be called in any case to indicate the end of the shot
	 * 
	 * No play can begin until the lag player has chosen who will break (see
	 * lagWinnderChooses). If this method is called before the break is chosen, it
	 * should do nothing. If this method is called after the game has ended, it
	 * should do nothing.
	 */
	public void cueStickStrike(BallType ball) {

		// gameOver = false;
		/*
		 * if (shots == 0) {
		 * 
		 * breakChosen = true; } else if (shots > 0) { breakChosen = false;
		 * 
		 * }
		 */

		/*
		 * if (playerApoints == designatedPoints || playerBpoints == designatedPoints) {
		 * 
		 * gameOver = true; }
		 */

		if (gameOver) {

			inningStarted = false;
			shotStarted = false;
		} else {
			inningStarted = true;
			bankShot = false;
			// inning = inning + 1;
		}

		if (validShot) {

			inningStarted = true;

		}
		/*
		 * if(inning == 1) {
		 * 
		 * inningStarted = true; breakShot = true;
		 * 
		 * }
		 * 
		 * shotStarted = true;
		 * 
		 * if(ball == currentCueBall) {
		 * 
		 * validShot = true; } else { validShot = false; foul(); }
		 */
		if (!gameOver && breakShot) {

			if (currentPlayer == PlayerA) {

				currentCueBall = cueBall;
			} else if (currentPlayer == PlayerB) {

				currentCueBall = cueBall2;
			}

			if (ball == currentCueBall) {

				// shots += 1;

				stickStrike = true;

				// inningStarted = true;

			} else if (ball != currentCueBall) {

				// stickStrike = false;

				// inningStarted = false;

				foul();

			}

			// isInningStarted();
		}

		if (inning == 1 && shots == 0) { // && breakChosen) {

			breakShot = true;

		}

		else {
			breakShot = false;
		}

		/*
		 * if(breakShot && saveStick == currentCueBall && saveBall == RED) {
		 * 
		 * breakShot = true;
		 * 
		 * } else {
		 * 
		 * foul(); //breakShot = false;
		 * 
		 * 
		 * 
		 * }
		 */

		if (stickStrike) {

			shotStarted = true;
			inningStarted = true;

		} else if (!stickStrike) {

			inningStarted = false;
			shotStarted = false;
		}

		/*
		 * if (breakChosen && gameOver == false) {
		 * 
		 * breakChosen = true;
		 * 
		 * if (shotInProgress) {
		 * 
		 * foulCalled = true;
		 * 
		 * shots += 1;
		 * 
		 * breakChosen = false; }
		 * 
		 * }
		 */

		// stickStrike = true;

		// shotInProgress = true;

		saveStick = ball;

	}

	public boolean isShotStarted() {
		// TODO Auto-generated method stub

		/*
		 * if (stickStrike) {
		 * 
		 * struck = true; } else if (!stickStrike) {
		 * 
		 * struck = false; }
		 */

		return shotStarted;
	}

// if player A does not get the point then it is player b turn and inning started = false
	public void endShot() {
		// TODO Auto-generated method stub
		// All balls have stopped motion.

		/*
		 * if player A goes first his cue ball is white a new inning would mean player b
		 * goes playber b cue ball is yellow every new inning the cue ball is different
		 */

		// if player keeps scoring points he keeps his turn

		// breakChosen = false;

		shotStarted = false;

		if (currentPlayer == PlayerA && (cushionImpact >= 3 && ballHit == 2)) {

			playerApoints += 1;

			inningStarted = true;

			currentPlayer = PlayerA;

			currentCueBall = cueBall;

		} else if (currentPlayer == PlayerA && (cushionImpact < 3 || ballHit < 2)) {

			currentPlayer = PlayerB;

			inningStarted = false;

			currentCueBall = cueBall2;

			// inning++;

		} else if (currentPlayer == PlayerB && (cushionImpact >= 3 && ballHit == 2)) {

			playerBpoints += 1;

			inningStarted = true;

			currentPlayer = PlayerB;

			currentCueBall = cueBall2;

		} else if (currentPlayer == PlayerB && (cushionImpact < 3 || ballHit < 2)) {

			inningStarted = false;

			currentPlayer = PlayerA;

			currentCueBall = cueBall;

			// inning++;

		}

		if (stickStrike && !gameOver) {

			inning++;

			stickStrike = false;

			/*
			 * if (currentPlayer == PlayerA) {
			 * 
			 * currentPlayer = PlayerB;
			 * 
			 * } else {
			 * 
			 * currentPlayer = PlayerA; }
			 */
		}

		if (cushionImpact >= 3 && stickStrike == true && ballHit == 2) {

			bankShot = true;
		} else {

			bankShot = false;
		}

		if (playerApoints == designatedPoints || playerBpoints == designatedPoints) {

			inning = 1;
			gameOver = true;
		}

		cushionImpact = 0;
		ballHit = 0;
		stickStrike = false;

	}

	/*
	 * A foul immediately ends the player's inning, even if the current shot has not
	 * yet ended. When a foul is called, the player does not score a point for the
	 * shot. A foul may also be called before the inning has started. In that case
	 * the player whose turn it was to shot has their inning forfeited and the
	 * inning count is increased by one. No foul can be called until the lag player
	 * has chosen who will break (see lagWinnerChooses()). If this method is called
	 * before the break is chosen, it should do nothing If this method is called
	 * after the game has ended, it should do nothing.
	 */
	public void foul() {
		// TODO Auto-generated method stub
		// three cushions have to be hit before last ball is hit
		// you have to hit red ball during break shot
		// if (gameOver == false) { // ) {

		/*
		 * if (gameOver == false && (currentPlayer != PlayerA && currentPlayer !=
		 * PlayerB)) {
		 * 
		 * inning = 1; foul();
		 * 
		 * }
		 */

		inningStarted = false;
		
		/*
		 * if(foulCalled && currentPlayer == PlayerA) {
		 * 
		 * currentPlayer = PlayerB; } if(foulCalled && currentPlayer == PlayerB) {
		 * 
		 * currentPlayer = PlayerA; }
		 */

		if (!gameOver && chosenLag) {

			if (!stickStrike) {
				foulCalled = true;
				inning++;

			} else if (currentPlayer == PlayerB && cueBall2 == YELLOW && (saveStick == RED || saveStick == WHITE)) {

				foulCalled = true;

				// currentPlayer = PlayerA;

				inning++;

				// inningStarted = false;

			} else if (currentPlayer == PlayerB && cueBall2 == WHITE && (saveStick == RED || saveStick == YELLOW)) {

				foulCalled = true;

				// currentPlayer = PlayerA;

				inning++;

				// inningStarted = false;

			}

			else if (currentPlayer == PlayerA && cueBall == WHITE && (saveStick == RED || saveStick == YELLOW)) {

				foulCalled = true;

				// currentPlayer = PlayerB;

				inning++;

			} else if (currentPlayer == PlayerA && cueBall == YELLOW && (saveStick == RED || saveStick == WHITE)) {

				foulCalled = true;

				// currentPlayer = PlayerB;

				inning++;

			}

			if (foulCalled) {

				endShot();

			}
			
				scorePoint = false;

				// currentInningPlayer = false;
				/*
				 * if(currentPlayer == PlayerA) {
				 * 
				 * currentPlayer = PlayerB;
				 * 
				 * currentCueBall = cueBall2; inning++;
				 * 
				 * inningStarted = false;
				 * 
				 * } else if (currentPlayer == PlayerB) {
				 * 
				 * currentPlayer = PlayerA;
				 * 
				 * currentCueBall = cueBall;
				 * 
				 * inning++;
				 * 
				 * inningStarted = false; }
				 * 
				 */
			}

			if (!foulCalled) {

				scorePoint = true;

				if (currentPlayer == PlayerA) {

					playerApoints++;
				} else if (currentPlayer == PlayerB) {

					playerBpoints++;
				}

			}
			if(currentPlayer == PlayerB) {
				currentPlayer = PlayerA;
				
			} else if(currentPlayer == PlayerB) {
				
				currentPlayer = PlayerA;
			}

		}
		/*
		 * if (currentPlayer == PlayerA) {
		 * 
		 * currentPlayer = PlayerB; } else if (currentPlayer == PlayerB) {
		 * 
		 * currentPlayer = PlayerA; }
		 */
		// stickStrike = false;

	

	/*
	 * Indicates the player's cue ball has struck the given ball. A ball strike
	 * cannot happen before a stick strike. If this method is called before the
	 * start of a shot (i.e., cueStickStrike() is called), it should do nothing. If
	 * this method is called after the game has ended, it should do nothing.
	 */

	// add inning in foul and end shot

	public void cueBallStrike(BallType ball) {

		/*
		 * if(breakShot) if(ball != RED) {
		 * 
		 * foul(); shotValid = false; }
		 */

		if (!gameOver) {

			// if(breakShot && )
			if (stickStrike && currentCueBall != ball) {

				ballHit = 2;

				if (currentPlayer == PlayerA) {

					if (scorePoint && ballHit == 2) {

						playerApoints += 1;
					} else if (currentPlayer == PlayerB) {
						if (scorePoint && ballHit == 2) {

							playerBpoints += 1;
						}

					}

				}

				// inning++;
				// inningStarted = false;

			}

		}


	}

	public void cueBallImpactCushion() {
		// TODO Auto-generated method stub

		cushionImpact += 1;

	}

	/**
	 * Returns true if and only if the most recently completed shot was a bank shot.
	 * A bank shot is when the cue ball impacts the cushions at least 3 times and
	 * then strikes both object balls.
	 * 
	 * @return
	 */
	public boolean isBankShot() {

		/*
		 * if (stickStrike) {
		 * 
		 * struckBall = true; }
		 */

		/*
		 * if (cushionImpact >= 3 && stickStrike == true && ballHit == 2) {
		 * 
		 * return true; } else {
		 * 
		 * return false; }
		 */

		return bankShot;

	}

	public boolean isGameOver() {

		/*
		 * int PLAYER_A = 0; int PLAYER_B = 0; if (PLAYER_A == 100 || PLAYER_B == 100) {
		 * return false; }
		 */

		// boolean gameOver = false;

		/*
		 * if (playerApoints == designatedPoints || playerBpoints == designatedPoints) {
		 * 
		 * gameOver = true; }
		 */

		return gameOver;
	}

}
