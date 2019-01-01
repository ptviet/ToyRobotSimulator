package com.stevenp.simulator.simulator.service;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.enums.Direction;
import com.stevenp.simulator.simulator.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SimulatorImplTest {

  private Simulator simulator;

  @Before
  public void setUp() throws Exception {
    simulator = new SimulatorImpl();
    simulator.initBoard(new Board(5, 5));
    simulator.initRobot(new Robot());
  }

  @Rule
  public org.junit.rules.ExpectedException thrown = ExpectedException.none();

  @Test
  public void placeRobot() throws SimulatorException {

    Assert.assertTrue(simulator.placeRobot(new Position(0, 1, Direction.NORTH)));
    Assert.assertTrue(simulator.placeRobot(new Position(2, 2, Direction.SOUTH)));
    Assert.assertFalse(simulator.placeRobot(new Position(6, 6, Direction.WEST)));
    Assert.assertFalse(simulator.placeRobot(new Position(-1, 5, Direction.EAST)));
  }

  @Test(expected = SimulatorException.class)
  public void testPlacingExceptions() throws SimulatorException {
    simulator.placeRobot(null);
    simulator.placeRobot(new Position(0, 1, null));
  }

  @Test
  public void simulate() throws SimulatorException {

    simulator.simulate("PLACE 0,0,NORTH");
    Assert.assertEquals("0,0,NORTH", simulator.report());

    simulator.simulate("MOVE");
    simulator.simulate("RIGHT");
    simulator.simulate("MOVE");
    Assert.assertEquals("1,1,EAST", simulator.report());

    // if it goes out of the board it ignores the command
    for (int i = 0; i < 10; i++)
      simulator.simulate("MOVE");
    Assert.assertEquals("5,1,EAST", simulator.report());

    //rotate on itself
    for (int i = 0; i < 4; i++)
      simulator.simulate("LEFT");
    Assert.assertEquals("5,1,EAST", simulator.report());

  }

  @Test(expected = SimulatorException.class)
  public void testInvalidCommand() throws SimulatorException {
    // invalid commands - typos
    simulator.simulate("REPORT");
    simulator.simulate("PLACE12NORTH");
    simulator.simulate("LEFFT");
    simulator.simulate("RIGHTT");
    simulator.simulate("MOOV");
  }

}