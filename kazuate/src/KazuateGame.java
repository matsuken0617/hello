import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KazuateGame {

    public KazuateGame() {
    }

    public void playGame() {

        // 残り回数
        int limits = 5;
        // 正解乱数生成
        Random rand = new Random();
        int ans = rand.nextInt(90) + 10;
        int num = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "0";
        System.out.println("数当てゲームを開始します．");
        for (int i = 0; i < limits; i++) {
            System.out.println("2桁の整数を入力してください．（あと" + (limits - i) + "回）");
            try {
                line = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.err.println("入出力例外");;
            }
            try {
                num = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                //TODO: handle exception
                System.err.println("整数フォーマット例外，1000を入力します");
                num = 1000;
            }
            
            // 正誤判定
            if (num == ans) {
                System.out.println("正解！");
                return;
            } else {
                System.out.println("残念！間違いです．");
            }
            // 20以上離れている場合
            if (num - ans >= 20) {
                System.out.println("あなたの答えは20以上大きいです．");
            }
            if (num - ans <= -20) {
                System.out.println("あなたの答えは20以上小さいです．");
            }
            
        }

        System.out.println("あなたの負け！正解は" + ans + "でした．");

    }
    
}
