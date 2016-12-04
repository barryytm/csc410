package nl.tudelft.jpacman.board;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class JPFBoardTest {
	
	private Board board;
	
	private static final int MAX_X = 4;
	private static final int MAX_Y = 4;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MID_X = (MIN_X + MAX_X) / 2;
	private static final int MID_Y = (MIN_Y + MAX_Y) / 2;
	
	@Before
	public void setUp() {
		Square[][] grid = new Square[MAX_X - MIN_X + 1][MAX_Y - MIN_Y + 1];
		
		for (int i = MIN_X; i <= MAX_X; i++) {
			for (int j = MIN_Y; j <= MAX_Y; j++) {
				grid[i][j] = mock(Square.class);
			}
		}
		
		board = new Board(grid);
	}

	@Test
	public void WithInBoardTest() {
		assertTrue(board.withinBorders(MID_X, MID_Y));
	}
	
	@Test
	public void OnMinXTest() {
		assertTrue(board.withinBorders(MIN_X, MID_Y));
	}
	
	@Test
	public void OneLessThanMinXTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MID_Y));
	}
	
	@Test
	public void OneMoreThanMinXTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MID_Y));
	}
	
	@Test
	public void OnMaxXTest() {
		assertTrue(board.withinBorders(MAX_X, MID_Y));
	}
	
	@Test
	public void OneLessThanMaxXTest() {
		assertTrue(board.withinBorders(MAX_X - 1, MID_Y));
	}
	
	@Test
	public void OneMoreThanMaxXTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MID_Y));
	}
//	---------------------------------------
	@Test
	public void OnMinYTest() {
		assertTrue(board.withinBorders(MID_X, MIN_Y));
	}
	
	@Test
	public void OneLessThanMinYTest() {
		assertFalse(board.withinBorders(MID_X, MIN_Y - 1));
	}
	
	@Test
	public void OneMoreThanMinYTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MIN_Y + 1));
	}
	
	@Test
	public void OnMaxYTest() {
		assertTrue(board.withinBorders(MID_X, MAX_Y));
	}
	
	@Test
	public void OneLessThanMaxYTest() {
		assertTrue(board.withinBorders(MID_X, MAX_Y - 1));
	}
	
	@Test
	public void OneMoreThanMaxYTest() {
		assertFalse(board.withinBorders(MID_X, MAX_Y + 1));
	}
	
//----------------left top corner
	
	//topleftcorner centre
	@Test
	public void leftTopCornerTest() {
		assertTrue(board.withinBorders(MIN_X, MAX_Y));
	}
	//topleft North West corner
	@Test
	public void leftTopCornerNorthWestTest() {
		assertFalse(board.withinBorders(MIN_X -1, MAX_Y + 1));
	}
	//topleft North corner
	@Test
	public void leftTopCornerNorthTest() {
		assertFalse(board.withinBorders(MIN_X, MAX_Y + 1));
	}
	//topleft North East corner
	@Test
	public void leftTopCornerNorthEastTest() {
		assertFalse(board.withinBorders(MIN_X + 1, MAX_Y + 1));
	}
	//topleft West corner
	@Test
	public void leftTopCornerWestTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MAX_Y));
	}
	//topleft East corner
	@Test
	public void leftTopCornerEastTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MAX_Y));
	}
	//topleftcorner South West 
	@Test
	public void leftTopCornerSouthWestTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MAX_Y - 1));
	}
	//topleftcorner  South 
	@Test
	public void leftTopCornerSouthTest() {
		assertTrue(board.withinBorders(MIN_X, MAX_Y - 1));
	}
	//topleftcorner South East 
	@Test
	public void leftTopCornerSouthEastTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MAX_Y - 1));
	}
	
	//----------------Right top corner

	//toprightcorner centre
	@Test
	public void rightTopCornerTest() {
		assertTrue(board.withinBorders(MAX_X, MAX_Y));
	}
	//topright North West corner
	@Test
	public void rightTopCornerNorthWestTest() {
		assertFalse(board.withinBorders(MAX_X - 1, MAX_Y + 1));
	}
	//topright North corner
	@Test
	public void rightTopCornerNorthTest() {
		assertFalse(board.withinBorders(MAX_X, MAX_Y + 1));
	}
	//topright North East corner
	@Test
	public void rightTopCornerNorthEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MAX_Y + 1));
	}
	//topright West corner
	@Test
	public void rightTopCornerWestTest() {
		assertTrue(board.withinBorders(MAX_X - 1, MAX_Y));
	}
	//topright East corner
	@Test
	public void rightTopCornerEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MAX_Y));
	}
	//toprightcorner South West 
	@Test
	public void rightTopCornerSouthWestTest() {
		assertTrue(board.withinBorders(MAX_X - 1, MAX_Y - 1));
	}
	//toprightcorner  South 
	@Test
	public void rightTopCornerSouthTest() {
		assertTrue(board.withinBorders(MAX_X, MAX_Y - 1));
	}
	//toprightcorner South East 
	@Test
	public void rightTopCornerSouthEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MAX_Y - 1));
	}

	//----------------left bottom corner

	//bottomleftcorner centre
	@Test
	public void leftBottomCornerTest() {
		assertTrue(board.withinBorders(MIN_X, MIN_Y));
	}
	//bottomleft North West corner
	@Test
	public void leftBottomCornerNorthWestTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MIN_Y + 1));
	}
	//bottomleft North corner
	@Test
	public void leftBottomCornerNorthTest() {
		assertTrue(board.withinBorders(MIN_X, MIN_Y + 1));
	}
	//bottomleft North East corner
	@Test
	public void leftBottomCornerNorthEastTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MIN_Y + 1));
	}
	//bottomleft West corner
	@Test
	public void leftBottomCornerWestTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MIN_Y));
	}
	//bottomleft East corner
	@Test
	public void leftBottomCornerEastTest() {
		assertTrue(board.withinBorders(MIN_X + 1, MIN_Y));
	}
	//bottomleftcorner South West 
	@Test
	public void leftBottomCornerSouthWestTest() {
		assertFalse(board.withinBorders(MIN_X - 1, MIN_Y - 1));
	}
	//bottomleftcorner  South 
	@Test
	public void leftBottomCornerSouthTest() {
		assertFalse(board.withinBorders(MIN_X, MIN_Y - 1));
	}
	//bottomleftcorner South East 
	@Test
	public void leftBottomCornerSouthEastTest() {
		assertFalse(board.withinBorders(MIN_X + 1, MIN_Y - 1));
	}
	
	//----------------right bottom corner

	//bottomrightcorner centre
	@Test
	public void rightBottomCornerTest() {
		assertTrue(board.withinBorders(MAX_X, MIN_Y));
	}
	//bottomright North West corner
	@Test
	public void rightBottomCornerNorthWestTest() {
		assertTrue(board.withinBorders(MAX_X - 1, MIN_Y + 1));
	}
	//bottomright North corner
	@Test
	public void rightBottomCornerNorthTest() {
		assertTrue(board.withinBorders(MAX_X, MIN_Y + 1));
	}
	//bottomright North East corner
	@Test
	public void rightBottomCornerNorthEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MIN_Y + 1));
	}
	//bottomright West corner
	@Test
	public void rightBottomCornerWestTest() {
		assertTrue(board.withinBorders(MAX_X - 1, MIN_Y));
	}
	//bottomright East corner
	@Test
	public void rightBottomCornerEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MIN_Y));
	}
	//bottomrightcorner South West 
	@Test
	public void rightBottomCornerSouthWestTest() {
		assertFalse(board.withinBorders(MAX_X - 1, MIN_Y - 1));
	}
	//bottomrightcorner  South 
	@Test
	public void rightBottomCornerSouthTest() {
		assertFalse(board.withinBorders(MAX_X, MIN_Y - 1));
	}
	//bottomrightcorner South East 
	@Test
	public void rightBottomCornerSouthEastTest() {
		assertFalse(board.withinBorders(MAX_X + 1, MIN_Y - 1));
	}
	
}
