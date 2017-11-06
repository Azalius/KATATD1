package azalius.katatennis;

public class TennisGame1 implements TennisGame {

	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1") )
			scoreJoueur1 += 1;
		else
			scoreJoueur2 += 1;
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		
		if (isTie()) {
			score = resultWhenTie();
		} else if (aPlayerHasAvantageOrWin()) {
			score = resultWhenAdvantageOrWin();
		} else {
			for (int i = 1; i <= 2; i++) {
				score = getWrittenValueFromScore(scoreJoueur1);
				score += "-";
				score += getWrittenValueFromScore(scoreJoueur2);
			}
		}
		return score;
	}

	private String getWrittenValueFromScore(int tempScore) {
		switch (tempScore) {
		case 0:
			return "Love";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		default:
			return "Forty";
		}
	}

	private String resultWhenAdvantageOrWin() {
		String score;
		int minusResult = scoreJoueur1 - scoreJoueur2;
		if (minusResult == 1)
			score = "Advantage player1";
		else if (minusResult == -1)
			score = "Advantage player2";
		else if (minusResult >= 2)
			score = "Win for player1";
		else
			score = "Win for player2";
		return score;
	}

	private boolean aPlayerHasAvantageOrWin() {
		return scoreJoueur1 >= 4 || scoreJoueur2 >= 4;
	}

	private String resultWhenTie() {
		String score;
		switch (scoreJoueur1) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}
		return score;
	}

	private boolean isTie() {
		return scoreJoueur1 == scoreJoueur2;
	}
}