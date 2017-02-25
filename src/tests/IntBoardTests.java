package tests;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;

import experiment.BoardCell;
import experiment.IntBoard;



public class IntBoardTests {
	private BoardCell[][] grid = new BoardCell[4][4];
	private IntBoard board;
	@Before 
	public void initialize(){
		board = new IntBoard(grid);
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
	public void testTarget0_1(){
		BoardCell cell = new BoardCell();
		IntBoard board = new IntBoard();
		board.getCell(0,0);
		board.calcTargets(board, 2);
		Set<BoardCell> t = board.getTargets();
		assertEquals(t.contains(board.getCell()))
	}
	@Test
	public void testTarget0_2(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	@Test
	public void testTarget0_3(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	@Test
	public void testTarget1_0(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	@Test
	public void testTarget1_1(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	@Test
	public void testTarget1_2(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	@Test
	public void testTarget1_3(){
		BoardCell board = new BoardCell();
		board.getCell(0,0);
		board.calcTargets(board, 2);
	}
	

}

