package com.test;

import java.util.Arrays;

public class SCC{

  static int[] hasFriend;
  static int[][] Matrix;
  static int length;
  static int num = 0;
  public static int findCircleNum(int[][] M) {
      hasFriend = new int[M.length];
      Arrays.fill(hasFriend, -1);
      Matrix = M;
      length = M.length;
      
      for (int i = 0; i < length; i++) {
          if (hasFriend[i] == -1) {
              helper(i);
              num++;

          }
      }
      return num;
  }
  
  public static void helper(int i) {
      
      hasFriend[i] = 1;
      for (int j = 0; j < length; j++) {
          
          if (Matrix[i][j] == 1 && i != j && hasFriend[j] == -1) {

              helper(j);
          }
      }
  }

  public static void main(String[] args) {
//  int[][] matrix = {{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//          {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//          {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
//          {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//          {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
//          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//          {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//          {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//          {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//  };
  
  int[][] matrix = {{0,0,1,1,0},
      {1,0,0,0,0},
      {0,1,0,0,0},
      {0,0,0,0,1},
      {0,0,0,0,0}};

  int maxSubNumber = findCircleNum(matrix);
  //this output is:  maxSubNumber:5
  System.out.println("maxSubNumber:"+maxSubNumber);
}

}