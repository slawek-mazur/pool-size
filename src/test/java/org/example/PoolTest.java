package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PoolTest {

  private static final Pool POOL = new Pool();

  @Test
  void testEmptyInput() {

    Assertions.assertEquals(0, POOL.poolSize(null));
    Assertions.assertEquals(0, POOL.poolSize(new int[0]));
    Assertions.assertEquals(0, POOL.poolSize(new int[]{10}));
  }

  @Test
  void testNonEmptyInput() {

    Assertions.assertEquals(0, POOL.poolSize(new int[]{1, 3}));
    Assertions.assertEquals(0, POOL.poolSize(new int[]{1, 11, 21, 31}));
    Assertions.assertEquals(0, POOL.poolSize(new int[]{0, 0, 3}));
    Assertions.assertEquals(55, POOL.poolSize(new int[]{10, 0, 0, 0, 5, 0, 0, 10}));
    Assertions.assertEquals(56, POOL.poolSize(new int[]{10, 0, 0, 0, 5, 0, 0, 10, 0, 1}));
  }

  @Test
  void testSinglePool() {

    Assertions.assertEquals(1, POOL.poolSize(new int[]{1, 0, 3}));
  }

  @Test
  void testManyPools() {

    Assertions.assertEquals(5, POOL.poolSize(new int[]{1, 0, 3, 0, 3, 0, 1}));
    Assertions.assertEquals(6, POOL.poolSize(new int[]{4, 0, 3, 0, 2, 0, 1, 0, 0, 0}));
    Assertions.assertEquals(9, POOL.poolSize(new int[]{1, 0, 3, 0, 5, 0, 7}));
  }
}