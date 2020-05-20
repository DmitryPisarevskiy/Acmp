import java.util.Scanner;

public class task0951 {
    static Scanner sc;

    public static void main(String[] args) {
        sc=new Scanner(System.in);
        short n=sc.nextShort();
        short m=sc.nextShort();
        short k=sc.nextShort();
        boolean[][] f=new boolean[n][m];
        boolean[][] ff=new boolean[n][m];
        boolean ill=false;
        short s;
        short x;
        short y;
        for (int i = 1; i <=k; i++) {
            x=sc.nextShort();
            y=sc.nextShort();
            f[x-1][y-1]=true;
            ff[x-1][y-1]=true;
        }
        s=0;
        do {
            ill=true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!f[i][j]) {
                        if (i-1>=0) {
                            if (f[i-1][j]) {
                                ff[i][j]=true;
                            }
                        }
                        if (i+1<=n-1) {
                            if (f[i+1][j]) {
                                ff[i][j]=true;
                            }
                        }
                        if (j-1>=0) {
                            if (f[i][j-1]) {
                                ff[i][j]=true;
                            }
                        }
                        if (j+1<=m-1) {
                            if (f[i][j+1]) {
                                ff[i][j]=true;
                            }
                        }
                        if (!ff[i][j]) {
                            ill=false;
                        }
                    }

                }
            }
            if (!ill){
                for (int i = 0; i <n; i++) {
                    for (int j = 0; j < m; j++) {
                        f[i][j]=ff[i][j];
                    }
                }
            }
            s+=1;
        } while (!ill);
        System.out.print(s);
    }
}
