package nl.tudelft.jpacman.freeze;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.CollisionMap;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.npc.NPC;

public class freezeTest {
	
	/**
	 * The level under test.
	 */
	private Level level;

	/**
	 * An NPC on this level.
	 */
	private final NPC ghost = mock(NPC.class);

	/**
	 * Starting position 1.
	 */
	private final Square square1 = mock(Square.class);

	/**
	 * Starting position 2.
	 */
	private final Square square2 = mock(Square.class);

	/**
	 * The board for this level.
	 */
	private final Board board = mock(Board.class);
	
	/**
	 * The collision map.
	 */
	private final CollisionMap collisions = mock(CollisionMap.class);


	@Before
	public void setUp() {
		final long defaultInterval = 100L;
		level = new Level(board, Lists.newArrayList(ghost), Lists.newArrayList(
				square1, square2), collisions);
		when(ghost.getInterval()).thenReturn(defaultInterval);
	}
	/**
	 * Validates the state of freeze when it is hasn't started yet
	 */
	@Test
	public void noStart() {
		assertFalse(level.isFrozen());
	}
	
	/**
	 * Validates the state of freeze when it just started
	 */
	@Test
	public void noStartFreeze() {
		level.freeze();
		assertFalse(level.isInProgress());
	}
	
	/**
	 * Validates the state of freeze when it just started
	 */
	@Test
	public void startAndFreeze() {
		level.start();
		level.freeze();
		assertTrue(level.isFrozen());
	}
	

	/**
	 * Validates the state of freeze when it is stoped
	 */
	@Test
	public void stopAndFreeze() {
		level.stop();
		level.freeze();
		assertTrue(level.isFrozen());
	}
		
	@Test
	public void freezeAndUnfreeze() {
		level.start();
		level.freeze(); // freeze all NPCs
		level.freeze();	// unfreeze all NPCs
		assertFalse(level.isFrozen());
	}
	
	@Test
	public void startAndFreezeAndStop() {
		level.start();
		level.freeze();
		level.stop();
		assertTrue(level.isFrozen());
		assertFalse(level.isInProgress());
	}
	
	@Test
	public void startAndStopAndFreeze() {
		level.start();
		level.stop();
		level.freeze();
		assertTrue(level.isFrozen());
		assertFalse(level.isInProgress());
	}
	
	@Test
	public void freezeAndStartAndStop() {
		level.freeze();
		level.start();
		level.stop();
		assertTrue(level.isFrozen());
		assertFalse(level.isInProgress());
	}
	
	@Test
	public void freezeAndStopAndStart() {
		level.freeze();
		level.stop();
		level.start();
		assertTrue(level.isFrozen());
		assertTrue(level.isInProgress());
	}
	
	@Test
	public void stopAndFreezAndStart() {
		level.stop();
		level.freeze();
		level.start();
		assertTrue(level.isFrozen());
		assertTrue(level.isInProgress());
	}
	
	@Test
	public void startAndFreezeAndUnfreeze() {
		level.start();
		level.freeze();
		level.freeze();
	}
	
	@Test
	public void startAndFreezeAndStartAndUnfreeze() {
		level.start();
		level.freeze();
		level.start();
		level.freeze(); // unfreeze
	}
	
	@Test
	public void startAndFreezeAndStopAndUnfreeze() {
		level.start();
		level.freeze();
		level.stop();
		level.freeze(); // unfreeze
	}
	
	@Test
	public void startAndFreezeAndStartAndStopAndUnfreeze() {
		level.start();
		level.freeze();
		level.start();
		level.stop();
		level.freeze();
	}
}
