package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		Deck d = new Deck();
		for (int i = 0; i < 60; i++)
			d.Draw();
	}

	@Test
	public void TestDrawSuit() {
		Deck d = new Deck();
		assertEquals(eSuit.CLUBS, d.Draw(eSuit.CLUBS).geteSuit());

	}

	@Test
	public void TestDrawRank() {
		Deck d = new Deck();
		assertEquals(eRank.NINE, d.Draw(eRank.NINE).geteRank());
	}

	@Test
	public void TestDeckRankCount() {
		Deck d = new Deck();
		assertEquals(4, d.DeckRankCount(eRank.JACK));
	}

	@Test
	public void TestDeckSuitCount() {
		Deck d = new Deck();
		assertEquals(13, d.DeckSuitCount(eSuit.DIAMONDS));
	}

}
