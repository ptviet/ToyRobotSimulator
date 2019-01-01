package com.stevenp.simulator.simulator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

  private Position mockPosition;
  private Board board;

  @Before
  public void setUp() throws Exception {
    mockPosition = mock(Position.class);
    board = new Board(5, 5);
  }

  @Test
  public void isValidPosition() throws Exception {


    when(mockPosition.getX()).thenReturn(6);
    when(mockPosition.getY()).thenReturn(7);
    Assert.assertFalse(board.isValidPosition(mockPosition));


    when(mockPosition.getX()).thenReturn(1);
    when(mockPosition.getY()).thenReturn(1);
    Assert.assertTrue(board.isValidPosition(mockPosition));


    when(mockPosition.getX()).thenReturn(-1);
    when(mockPosition.getY()).thenReturn(-1);
    Assert.assertFalse(board.isValidPosition(mockPosition));
  }
}