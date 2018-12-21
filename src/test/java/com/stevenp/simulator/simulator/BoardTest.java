package com.stevenp.simulator.simulator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

  @Test
  public void isValidPosition() {
    Position mockPosition = mock(Position.class);
    Board board = new Board(5, 5);

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