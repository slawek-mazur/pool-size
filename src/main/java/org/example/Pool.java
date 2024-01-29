package org.example;

public class Pool {

  int poolSize(int[] bars) {
    if (null == bars || bars.length < 2) {
      return 0;
    }

    final int n = bars.length;
    int startIndex = -1;
    for (int i = 0; i < n; i++) {
      if (bars[i] > 0) {
        startIndex = i;
        break;
      }
    }

    if (startIndex == -1 || startIndex == n - 1) {
      return 0;
    }

    int pool = 0, localPools = 0, barsHeight = 0, maxRightBar = bars[startIndex],
        leftBarIndex = startIndex, localLeftBarIndex = startIndex;

    for (int i = startIndex + 1; i < n; i++) {
      int bar = bars[i];

      if (bar > 0) {
        if (bar >= maxRightBar) {
          pool += poolSize(leftBarIndex, i, bars) - barsHeight;
          maxRightBar = bar;
          leftBarIndex = localLeftBarIndex = i;
          // drop local pools info
          barsHeight = 0;
          localPools = 0;
        } else {
          // accumulate local pools
          barsHeight += bar;
          localPools += poolSize(localLeftBarIndex, i, bars);
          localLeftBarIndex = i;
        }
      } else {
        // nothing to do here ?
      }
    }
    return pool + localPools;
  }

  private static int poolSize(int from, int to, int[] bars) {
    int startHeight = bars[from];
    int endHeight = bars[to];
    int distance = to - from - 1;

    return Math.min(startHeight, endHeight) * distance;
  }
}