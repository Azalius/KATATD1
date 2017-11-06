package azalius.katatennis;

public class TennisGame1 implements TennisGame {
	
	private static final String[] scorePossible = {"Love", "Fifteen", "Thirty", "Forty"};
	private static final String winMessage = "Win for ";
	private static final String advantageMessage = "Advantage ";
	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1Name) )
			scoreJoueur1 += 1;
		else if (playerName.equals(player2Name) )
			scoreJoueur2 += 1;
	}

	public String getScore() {
		String score;		
		if (isTie()) {
			score = resultWhenTie();
		} else if (aPlayerHasAvantageOrWin()) {
			score = resultWhenAdvantageOrWin();
		} else {
			score = getScoreStandard();
		}
		return score;
	}

	private String getScoreStandard() {
		String score;
		score = getWrittenValueFromScore(scoreJoueur1);
		score += "-";
		score += getWrittenValueFromScore(scoreJoueur2);
		return score;
	}

	private String getWrittenValueFromScore(int score) {
		return scorePossible[score];
	}

	private String resultWhenAdvantageOrWin() {
		String score;
		int minusResult = scoreJoueur1 - scoreJoueur2;
		if (minusResult == 1)
			score = advantageMessage+ this.player1Name;
		else if (minusResult == -1)
			score = advantageMessage+ this.player2Name;
		else if (minusResult >= 2)
			score = winMessage + this.player1Name;
		else
			score = winMessage+ this.player2Name;
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