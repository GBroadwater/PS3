package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {
		if (this.cardsInDeck.size() != 0)
			return cardsInDeck.remove(0);
		else {
			throw new DeckException(this);
		}
	}

	public Card Draw(eSuit eSuit) {
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public Card Draw(eRank eRank) {
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int DeckSuitCount(eSuit eSuit) {
		int suitCount = 0;
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit)
				suitCount++;
		}
		return suitCount;
	}

	public int DeckRankCount(eRank eRank) {
		int rankCount = 0;
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank)
				rankCount++;
		}
		return rankCount;
	}

	public boolean findCard(Card card) {
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == card.geteRank() && c.geteSuit() == card.geteSuit())
				return true;
		}
		return false;
	}

}
