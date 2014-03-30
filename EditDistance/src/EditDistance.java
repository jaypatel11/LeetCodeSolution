/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/12/13
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {


    public static void main( String args[]){

        String s1 = "sitting";
        String s2 = "kitten";
        System.out.println(findDistance(s1, s2));

    }

    private static int findDistance(String s, String t) {


        int m=s.length();
        int n=t.length();
        int[][] d=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            d[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            d[0][j]=j;
        }
        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    d[i][j]=d[i-1][j-1];
                }
                else{
                    d[i][j]=min((d[i-1][j]+1),(d[i][j-1]+1),(d[i-1][j-1]+1));
                }
            }
        }
        printArray(d);
        return(d[m][n]);
    }

    public static int min(int a,int b,int c){
        return(Math.min(Math.min(a,b),c));
    }

    public static void printArray(int a[][]){

        for(int i = 0; i < a.length; i++){

            for(int j = 0; j < a[i].length; j++)

                System.out.print(a[i][j]+ " ");

            System.out.println();
        }
    }
}
