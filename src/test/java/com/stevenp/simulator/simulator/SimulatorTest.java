package com.stevenp.simulator.simulator;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.enums.Direction;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SimulatorTest {

  private final int BOARD_ROWS = 5;
  private final int BOARD_COLUMNS = 5;
  @Rule
  public org.junit.rules.ExpectedException thrown = ExpectedException.none();

  @Test
  public void placeRobot() throws SimulatorException {
    Board board = new Board(BOARD_COLUMNS, BOARD_ROWS);
    Robot robot = new Robot();
    Simulator simulator = new Simulator(board, robot);

    Assert.assertTrue(simulator.placeRobot(new Position(0, 1, Direction.NORTH)));
    Assert.assertTrue(simulator.placeRobot(new Position(2, 2, Direction.SOUTH)));
    Assert.assertFalse(simulator.placeRobot(new Position(6, 6, Direction.WEST)));
    Assert.assertFalse(simulator.placeRobot(new Position(-1, 5, Direction.EAST)));
  }

  @Test
  public void eval() throws SimulatorException {
  }

  @Test
  public void report() throws SimulatorException {
  }
}