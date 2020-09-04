package com.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

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

  public static void main(String[] args) throws ParseException {
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
  
//  int[][] matrix = {{0,0,1,1,0},
//      {1,0,0,0,0},
//      {0,1,0,0,0},
//      {0,0,0,0,1},
//      {0,0,0,0,0}};
//
//  int maxSubNumber = findCircleNum(matrix);
//  //this output is:  maxSubNumber:5
//  System.out.println("maxSubNumber:"+maxSubNumber);
    
    Test test = Test.FAILED;
    
    System.out.println(test.getVal());
    
}

  enum Test{
    ACTIVE(null),
    FAILED(1),
    SUCCESS(2);
    
    private Integer val;
    
    private Test(Integer val) {
      this.val = val;
    }
    
    private Integer getVal() {
      return val;
    }
  }
}