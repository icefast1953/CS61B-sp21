package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

/**
 * Created by hug.
 */

public class TestBuggyAList {
    @Test
  public  void TestThreeAddThreeRemove(){
      AListNoResizing<Integer> rightList =new  AListNoResizing<>();
      BuggyAList<Integer> buggyAList =new BuggyAList<>();
      rightList.addLast(4);
      buggyAList.addLast(4);
      rightList.addLast(5);
      buggyAList.addLast(5);
      rightList.addLast(6);
      buggyAList.addLast(6);
      if(CompareLists(rightList,buggyAList)){
          System.out.println("OK");
      }
      rightList.removeLast();
      buggyAList.removeLast();
      if(CompareLists(rightList,buggyAList)){
          System.out.println("OK");
      }
      rightList.removeLast();
      buggyAList.removeLast();
      if(CompareLists(rightList,buggyAList)){
          System.out.println("OK");
      }
        rightList.removeLast();
        buggyAList.removeLast();
        if(CompareLists(rightList,buggyAList)){
            System.out.println("OK");
        }




  }





  public static Boolean CompareLists(AListNoResizing<Integer> rightList, BuggyAList<Integer> buggyAList){
      if (rightList.getLast() == buggyAList.getLast()){
          return true;
      }
      return false;
  }

  @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> B =new BuggyAList<>();

      int N = 500;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              B.addLast(randVal);
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int size1 = B.size();
          }else if (operationNumber == 2) {
              // removeLast
              if (L.size() == 0 ||B.size() == 0)
              {
                  continue;
              }
              L.removeLast();
              B.removeLast();
      }else if (operationNumber == 3) {
              // getLast
              if (L.size() == 0||B.size() ==0)
              {
                  continue;
              }
              L.getLast();
              B.getLast();
  }
          if (L.size() == 0||B.size() ==0)
          {
              continue;
          }
          if (CompareLists(L,B))
          {
              System.out.println("Ok");
          }else {
              System.out.println("There is sth wrong.");
          };


}}}
