package tests;
//Blake Sanders
//Jonny Morsicato 
import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;

import experiment.BoardCell;
import experiment.IntBoard;



public class IntBoardTests { 
	private BoardCell[][] grid = new BoardCell[4][4];
	private IntBoard board;
	private Set<BoardCell> testList = new HashSet<BoardCell>();
	@Before 
	public void initialize(){ // This gets called for every test 
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				BoardCell c = new BoardCell(i,j);
				grid[i][j] = c;
			}
		}
		board = new IntBoard(grid);
		board.calcAdjacencies();
	}


	@Test
	public void testAdjacency0_0()
	{
		BoardCell cell = board.getCell(0,0);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertEquals(2, testList.size());
	}


	@Test
	public void testAdjacency3_3(){
		BoardCell cell = board.getCell(3,3);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacency1_3(){
		BoardCell cell = board.getCell(1,3);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(0, 3)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(3, testList.size());
	}

	@Test
	public void testAdjacency3_0(){
		BoardCell cell = board.getCell(3,0);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(2, 0)));
		assertTrue(testList.contains(board.getCell(3, 1)));
		assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency1_1(){
		BoardCell cell = board.getCell(1,1);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testAdjacency2_2(){
		BoardCell cell = board.getCell(2,2);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertEquals(4, testList.size());
	}

	@Test
	public void testTarget0_0(){
		BoardCell cell = board.getCell(0,0);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCell(1,0)));
		assertTrue(targets.contains(board.getCell(0,1)));

	}
	@Test
	public void testTarget0_1(){
		BoardCell cell = board.getCell(0,1);
		board.calcTargets(cell, 2);
		Set<BoardCell> targets = board.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(board.getCell(2,1)));
		assertTrue(targets.contains(board.getCell(1,0)));
		assertTrue(targets.contains(board.getCell(1,2)));
		assertTrue(targets.contains(board.getCell(0,3)));


	}
	@Test
	public void testTarget1_1(){
		BoardCell cell = board.getCell(1,1);
		board.calcTargets(cell, 3);
		Set<BoardCell> targets = board.getTargets();
		assertEquals(8, targets.size());
		assertTrue(targets.contains(board.getCell(0,1)));
		assertTrue(targets.contains(board.getCell(1,0)));
		assertTrue(targets.contains(board.getCell(3,0)));
		assertTrue(targets.contains(board.getCell(3,2)));
		assertTrue(targets.contains(board.getCell(2,3)));
		assertTrue(targets.contains(board.getCell(2,1)));
		assertTrue(targets.contains(board.getCell(0,3)));
		assertTrue(targets.contains(board.getCell(1,2)));
	}
	@Test
	public void testTarget3_0(){
		BoardCell cell = board.getCell(3,0);
		board.calcTargets(cell, 4);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCell(1,0)));
		assertTrue(targets.contains(board.getCell(0,1)));
		assertTrue(targets.contains(board.getCell(1,2)));
		assertTrue(targets.contains(board.getCell(2,1)));
		assertTrue(targets.contains(board.getCell(3,2)));
		assertTrue(targets.contains(board.getCell(2,3)));
	}
	@Test
	public void testTarget0_3(){
		BoardCell cell = board.getCell(0,3);
		board.calcTargets(cell, 5);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCell(2,0)));
		assertTrue(targets.contains(board.getCell(0,2)));
		assertTrue(targets.contains(board.getCell(1,3)));
		assertTrue(targets.contains(board.getCell(3,1)));
		assertTrue(targets.contains(board.getCell(1,1)));
		assertTrue(targets.contains(board.getCell(2,2)));
		assertTrue(targets.contains(board.getCell(3,3)));
		assertTrue(targets.contains(board.getCell(0,0)));

	}
	@Test
	public void testTarget1_2(){
		BoardCell cell = board.getCell(1,2);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCell(1,1)));
		assertTrue(targets.contains(board.getCell(2,2)));
		assertTrue(targets.contains(board.getCell(0,2)));
		assertTrue(targets.contains(board.getCell(1,3)));
	}
	@Test
	public void testTarget1_3(){
		BoardCell cell = board.getCell(1,3);
		board.calcTargets(cell, 2);
		Set<BoardCell> targets = board.getTargets();
		assertTrue(targets.contains(board.getCell(0,2)));
		assertTrue(targets.contains(board.getCell(2,2)));
		assertTrue(targets.contains(board.getCell(3,3)));
		assertTrue(targets.contains(board.getCell(1,1)));
	}


}

