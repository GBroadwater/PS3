package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {
	
	Deck d = new Deck();

	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		for (int i = 0; i < 60; i++)
			d.Draw();
	}

	@Test
	public void TestDrawSuit() {
		assertEquals(eSuit.CLUBS, d.Draw(eSuit.CLUBS).geteSuit());

	}

	@Test
	public void TestDrawRank() {
		assertEquals(eRank.NINE, d.Draw(eRank.NINE).geteRank());
	}

	@Test
	public void TestDeckRankCount() {
		assertEquals(4, d.DeckRankCount(eRank.JACK));
	}

	@Test
	public void TestDeckSuitCount() {
		assertEquals(13, d.DeckSuitCount(eSuit.DIAMONDS));
	}

	@Test
	public void TestFindCard() {
		assertEquals(true, d.findCard(new Card(eSuit.HEARTS, eRank.JACK)));
	}
}
