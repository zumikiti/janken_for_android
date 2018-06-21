package to.msn.wings.janken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    /*
    button: gu, tyoki, pa
    TextView: player, playerRes, com, comRes, result
              winCnt, loseCnt, drawCnt,totalCnt, winPer
     */

    private int totalCnt; //総バトル数
    private int drawCnt; //引き分け数
    private int loseCnt; //負け数
    private int winCnt; //勝ち数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_onclick(View view){

        //player側の手
        TextView txt = (TextView)findViewById(R.id.playerRes);
        int player_hand = 0;
        //view.getIdでクリックしたボタンを判定
        // 0:gu, 1:tyoki, 2:par
        switch (view.getId()){
            case R.id.gu:
                txt.setText("ぐー");
                player_hand = 0;
                break;
            case R.id.tyoki:
                txt.setText("ちょき");
                player_hand = 1;
                break;
            case R.id.pa:
                txt.setText("ぱー");
                player_hand = 2;
        }

        //com側の手
        TextView com = (TextView)findViewById(R.id.comRes);

        //randomでcomの手を設定
        Random random = new Random();
        int n = random.nextInt(3);
        int com_hand = 0;
        // 0:gu, 1:tyoki, 2:par
        if (n == 0){
            com.setText("ぐー");
            com_hand = 0;
        } else if (n == 1){
            com.setText("ちょき");
            com_hand = 1;
        } else {
            com.setText("ぱー");
            com_hand = 2;
        }

        // 総対戦数をカウントアップ
        TextView total = (TextView) findViewById(R.id.totalCnt);
        totalCnt++;
        total.setText("総数：" + String.valueOf(totalCnt));

        // じゃんけんの勝敗判定
        TextView result = (TextView) findViewById(R.id.result);
        int judge = (player_hand - com_hand + 3)%3;
        if (judge == 0) {
            //あいこの場合
            TextView draw = (TextView) findViewById(R.id.drawCnt);
            drawCnt++;
            draw.setText("引き分け数：" + String.valueOf(drawCnt));
            result.setText("あいこ");
        } else if (judge == 1) {
            //負けの場合
            TextView lose = (TextView) findViewById(R.id.loseCnt);
            loseCnt++;
            lose.setText("負け数：" + String.valueOf(loseCnt));
            result.setText("あなたの負け");
        } else if (judge == 2){
            //勝ちの場合
            TextView win = (TextView) findViewById(R.id.winCnt);
            winCnt++;
            win.setText("勝ち数：" + String.valueOf(winCnt));
            result.setText("あなたの勝ち");
        }

        // 勝率計算
        TextView per = (TextView) findViewById(R.id.winPer);
        double winPer = (double) winCnt / (double) totalCnt * 100;
        per.setText("勝率：" + String.format("%.2f", winPer) + "%");
    }
}
