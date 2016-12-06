package nl.tudelft.jpacman.freeze;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;

public class freezeGameTest {

	private Launcher launcher;
	private Game game;
	
	/**
	 * Launch the user interface.
	 */
	@Before
	public void setUpPacman() {
		launcher = new Launcher();
		launcher.launch();
		game = launcher.getGame();
	}
	
	/**
	 * Quit the user interface when we're done.
	 */
	@After
	public void tearDown() {
		launcher.dispose();
	}
	
	/**
	 * Validates the state of freeze when it is hasn't started yet
	 */
	@Test
	public void noStart() {
		game.freeze();
		assertTrue(game.isFrozen());
	}
	
	/**
	 * Validates the state of freeze when it just started
	 */
	@Test
	public void noStartFreeze() {
		game.freeze();
		assertFalse(game.isInProgress());
	}
	
	/**
	 * Validates the state of freeze when it just started
	 */
	@Test
	public void startAndFreeze() {
		game.start();
		game.freeze();
		assertTrue(game.isFrozen());
	}
	

	/**
	 * Validates the state of freeze when it is stoped
	 */
	@Test
	public void stopAndFreeze() {
		game.stop();
		game.freeze();
		assertTrue(game.isFrozen());
	}
		
	@Test
	public void freezeAndUnfreeze() {
		game.start();
		game.freeze(); // freeze all NPCs
		game.freeze();	// unfreeze all NPCs
		assertFalse(game.isFrozen());
	}
	
	@Test
	public void startAndFreezeAndStop() {
		game.start();
		game.freeze();
		game.stop();
		assertTrue(game.isFrozen());
		assertFalse(game.isInProgress());
	}
	
	@Test
	public void startAndStopAndFreeze() {
		game.start();
		game.stop();
		game.freeze();
		assertTrue(game.isFrozen());
		assertFalse(game.isInProgress());
	}
	
	@Test
	public void freezeAndStartAndStop() {
		game.freeze();
		game.start();
		game.stop();
		assertTrue(game.isFrozen());
		assertFalse(game.isInProgress());
	}
	
	@Test
	public void freezeAndStopAndStart() {
		game.freeze();
		game.stop();
		game.start();
		assertTrue(game.isFrozen());
		assertTrue(game.isInProgress());
	}
	
	@Test
	public void stopAndFreezAndStart() {
		game.stop();
		game.freeze();
		game.start();
		assertTrue(game.isFrozen());
		assertTrue(game.isInProgress());
	}
	
	@Test
	public void startAndFreezeAndUnfreeze() {
		game.start();
		game.freeze();
		game.freeze();
	}
	
	@Test
	public void startAndFreezeAndStartAndUnfreeze() {
		game.start();
		game.freeze();
		game.start();
		game.freeze(); // unfreeze
	}
	
	@Test
	public void startAndFreezeAndStopAndUnfreeze() {
		game.start();
		game.freeze();
		game.stop();
		game.freeze(); // unfreeze
	}
	
	@Test
	public void startAndFreezeAndStartAndStopAndUnfreeze() {
		game.start();
		game.freeze();
		game.start();
		game.stop();
		game.freeze();
	}


}
