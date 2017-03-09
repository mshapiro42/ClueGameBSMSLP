package tests;

import java.util.Set;


import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;

public class AdjacencyAndTargetsTests_BoardPart3 {
	private static Board board;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance and initialize it		
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("ClueLayout.csv", "Legend.txt");		
		board.initialize();
	}
	@Test
	public void testAdjacenciesOnlyWalkways(){
		//This tests the first requirement, only walkways are adjacents
		Set<BoardCell> testList = board.getAdjList(6, 12);
		assertEquals(4, testList.size());
		assertTrue(testList.contains(board.getCellAt(6, 13)));
		assertTrue(testList.contains(board.getCellAt(5, 12)));
		assertTrue(testList.contains(board.getCellAt(6, 11)));
		assertTrue(testList.contains(board.getCellAt(7, 12)));

	}
	@Test
	public void testAdjacenciesInsideRooms(){
		//this tests the second requirement, for a cell within a room
		Set<BoardCell> testList = board.getAdjList(1, 9);
		assertEquals(0, testList.size());

	}
	@Test
	public void testAdjacenciesAllCorners(){
		//this tests the third requirement, each edge, i hope corners are also considered edges
		Set<BoardCell> testList = board.getAdjList(0, 0);
		assertEquals(0, testList.size());
//		assertTrue(testList.contains(board.getCellAt(0, 1)));
//		assertTrue(testList.contains(board.getCellAt(1, 0)));
	
		
//		testList = board.getAdjList(0, 20);
//		assertEquals(2, testList.size());
//		assertTrue(testList.contains(board.getCellAt(0, 19)));
//		assertTrue(testList.contains(board.getCellAt(1, 20)));
//		
//		testList = board.getAdjList(21, 20);
//		assertEquals(2, testList.size());
//		assertTrue(testList.contains(board.getCellAt(20, 20)));
//		assertTrue(testList.contains(board.getCellAt(21, 19)));
//		
//		testList = board.getAdjList(21, 0);
//		assertEquals(2, testList.size());
//		assertTrue(testList.contains(board.getCellAt(20, 0)));
//		assertTrue(testList.contains(board.getCellAt(21, 1)));
	}
	

	
	@Test
	//this tests the fourth requirement, being beside a room that is not a doorway
	public void testAdjacenciesForNotDoorways(){
		Set<BoardCell> testList = board.getAdjList(14, 2);
		assertEquals(3, testList.size());
		assertTrue(testList.contains(board.getCellAt(14, 1)));
		assertTrue(testList.contains(board.getCellAt(13, 2)));
		assertTrue(testList.contains(board.getCellAt(14, 3)));
		
		testList = board.getAdjList(4, 18);
		assertEquals(3, testList.size());
		assertTrue(testList.contains(board.getCellAt(3, 18)));
		assertTrue(testList.contains(board.getCellAt(4, 17)));
		assertTrue(testList.contains(board.getCellAt(5, 18)));
	}
	@Test
	public void testAdjacenciesNeededDirection(){
		//this tests the fifth requirement, being next to a doorway with the needed direction
		Set<BoardCell> testList = board.getAdjList(10, 5);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(10, 6)));
		
		testList = board.getAdjList(4, 9);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(5, 9)));
		
		testList = board.getAdjList(10, 15);
		System.out.println(testList);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(9, 15)));
		
		testList = board.getAdjList(13, 17);
		System.out.println(testList);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(14, 17)));
	}
	@Test
	public void testAdjacenciesAreDoors(){
		//this tests the sixth requirement, being a doorway
		Set<BoardCell> testList = board.getAdjList(6, 2);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(7, 2)));
		
		testList = board.getAdjList(17, 13);
		assertEquals(1, testList.size());
		assertTrue(testList.contains(board.getCellAt(17, 14)));
	}
	@Test
	public void testTargetsAlongWalkways(){
		//this tests the seventh requirement, targets along walkways
		board.calcTargets(21, 7, 1);
		Set<BoardCell> targets= board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCellAt(20, 7)));
		assertTrue(targets.contains(board.getCellAt(21, 6)));	
		
		board.calcTargets(14, 0, 1);
		targets= board.getTargets();
		assertEquals(3, targets.size());
		assertTrue(targets.contains(board.getCellAt(14, 1)));
		assertTrue(targets.contains(board.getCellAt(13, 0)));	
		assertTrue(targets.contains(board.getCellAt(15, 0)));	
	}
	@Test
	public void testTargetsAllowEnter(){
		//this tests the eighth requirement, allowing the user to enter a room
		board.calcTargets(21, 7, 2);
		Set<BoardCell> targets= board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCellAt(19, 7)));
		assertTrue(targets.contains(board.getCellAt(20, 6)));
		
		board.calcTargets(14, 0, 2);
		targets= board.getTargets();
		assertEquals(3, targets.size());
		assertTrue(targets.contains(board.getCellAt(12, 0)));
		assertTrue(targets.contains(board.getCellAt(14, 2)));	
		assertTrue(targets.contains(board.getCellAt(15, 1)));
	}
	@Test
	public void testTargetsWhenLeavingRoom(){
		//this tests the 9th requirement, calculating targets when leaving a room
		board.calcTargets(21, 7, 4);
		Set<BoardCell> targets= board.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(board.getCellAt(17, 7)));
		assertTrue(targets.contains(board.getCellAt(19, 7)));
		assertTrue(targets.contains(board.getCellAt(18, 6)));
		assertTrue(targets.contains(board.getCellAt(20, 6)));
		
		board.calcTargets(14, 0, 2);
		targets= board.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(board.getCellAt(14, 4)));
		assertTrue(targets.contains(board.getCellAt(15, 3)));	
		assertTrue(targets.contains(board.getCellAt(14, 2)));	
		assertTrue(targets.contains(board.getCellAt(15, 1)));
	}
}
