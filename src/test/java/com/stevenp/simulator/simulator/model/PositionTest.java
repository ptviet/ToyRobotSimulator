package com.stevenp.simulator.simulator.model;

import com.stevenp.simulator.simulator.enums.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {
  private Position position;

  @Before
  public void setUp() throws Exception {
    position = new Position(0, 0, Direction.EAST);
  }

  @Test
  public void testGetNextPosition() throws Exception {

    position = position.getNextPosition();
    Assert.assertEquals(position.getX(), 1);
    Assert.assertEquals(position.getY(), 0);
    Assert.assertEquals(position.getDirection(), Direction.EAST);

    position = position.getNextPosition();
    Assert.assertNotEquals(position.getX(), 1);
    Assert.assertEquals(position.getY(), 0);
    Assert.assertEquals(position.getDirection(), Direction.EAST);

    position.setDirection(Direction.NORTH);
    position = position.getNextPosition();

    Assert.assertNotEquals(position.getX(), 1);
    Assert.assertEquals(position.getY(), 1);
    Assert.assertNotEquals(position.getDirection(), Direction.EAST);

  }

}