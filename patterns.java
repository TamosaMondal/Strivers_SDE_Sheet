/*Example:
Input: ‘N’ = 3

Output: 
* * *
* * *
* * *

public class Solution {
    public static void nForest(int n) {
        // Write your code here
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
*/


/*
Example:
Input:  ‘N’ = 3

Output: 
* 
* *
* * *

public class Solution {
    public static void nForest(int n) {
        // Write your code here
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
*/

/*Example:
Input: ‘N’ = 3

Output: 
1
1 2 
1 2 3

public class Solution {
    public static void nTriangle(int n) {
        // Write your code here
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
*/

/*
Example:
Input: ‘N’ = 3

Output: 

  *
 ***
*****
public class Solution {
    public static void nStarTriangle(int n) {
        // Write your code here
        for(int i=0;i<n;i++){
            //space
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            //star
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }

            //space
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
*/
