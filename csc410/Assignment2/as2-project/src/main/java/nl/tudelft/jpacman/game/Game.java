package nl.tudelft.jpacman.game;

import java.util.List;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Level.LevelObserver;
import nl.tudelft.jpacman.level.Player;

/**
 * A basic implementation of a Pac-Man game.
 * 
 * @author Jeroen Roosen 
 */
public abstract class Game implements LevelObserver {

	/**
	 * <code>true</code> if the game is in progress.
	 */
	private boolean inProgress;
	
	/**
	 * <code>true</code> if the NPCs are frozen.
	 */
	private boolean inFrozen;
	
	
	/**
	 * Object that locks the start and stop methods.
	 */
	private final Object progressLock = new Object();

	/**
	 * Creates a new game.
	 */
	protected Game() {
		inProgress = false;
		inFrozen = false;
	}

	/**
	 * Starts or resumes the game.
	 */
	public void start() {
		synchronized (progressLock) {
			if (isInProgress()) {
				return;
			}
			if (getLevel().isAnyPlayerAlive()
					&& getLevel().remainingPellets() > 0) {
				inProgress = true;
				getLevel().addObserver(this);
				getLevel().start();
			}
		}
	}

	/**
	 * Pauses the game.
	 */
	public void stop() {
		synchronized (progressLock) {
			if (!isInProgress()) {
				return;
			}
			inProgress = false;
			getLevel().stop();
		}
	}
	
	/**
	 * freezes the npc.
	 */
	public void freeze() {
		if (! this.isFrozen()) {
			this.getLevel().freeze();
			inFrozen = true;
		} else {
			this.getLevel().freeze();
			inFrozen = false;
		}
	}
		

	/**
	 * @return <code>true</code> iff the game is started and in progress.
	 */
	public boolean isInProgress() {
		return inProgress;
	}
	
	/**
	 * @return <code>true</code> iff the game is started and in progress.
	 */
	public boolean isFrozen() {
		return inFrozen;
	}
	
	/**
	 * @return An immutable list of the participants of this game.
	 */
	public abstract List<Player> getPlayers();

	/**
	 * @return The level currently being played.
	 */
	public abstract Level getLevel();

	/**
	 * Moves the specified player one square in the given direction.
	 * 
	 * @param player
	 *            The player to move.
	 * @param direction
	 *            The direction to move in.
	 */
	public void move(Player player, Direction direction) {
		if (isInProgress()) {
			// execute player move.
			getLevel().move(player, direction);
		}
	}
	
	@Override
	public void levelWon() {
		start();
	}
	
	@Override
	public void levelLost() {
		stop();
	}
}
