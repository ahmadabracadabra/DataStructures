/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listwithnodesexample;

/**
 *
 * @author Jean Mehta
 */
public class FeetAndInches {

 int f;
  int i;
  FeetAndInches ()
  { f=0;
    i=0;}
  FeetAndInches (int newf, int newi)
  { f=newf;
    i=newi;}
  
   public void setFeet(int newf)
  {f = newf;}
   public void setInches(int newi)
  { i = newi;}
   
   public  int compareTo(FeetAndInches c)
   {int thisInches, inches;
     thisInches = this.f*12 + this.i;
     inches = c.f*12 + c.i;
     if (thisInches < inches)return -1;
     else if (thisInches>inches) return 1;
     else return 0;  
   }
   public String toString()
   { return this.f + " feet and " + this.i + " inches";
   }
}//end FeetAndInches class
    

