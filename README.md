# 無限じゃんけん

![demo](https://camo.qiitausercontent.com/e58ee09e871c25ea49b3571b6fcf076523c980c9/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f3138353834362f38343161383461332d336631612d633435372d313535342d6336363235343761373439342e706e67)

## こだわり
ただのじゃんけんの勝敗判定だけではオリジナル感がないので、総対戦数や勝敗数、勝率を表示できるようにした。

## 苦労した点
### じゃんけんの勝敗判定。 
初めは、ifの条件分岐で行おうとしたが、冗長化してしまった。 
調べた結果、それぞれの手に0,1,2と値を付け以下の計算式で判定ができる事がわかった。 

```
int judge = ([自分の手] - [相手の手] + 3)%3;
if (judge == 0) {あいこ}
if (judge == 1) {負け}
if (judge == 2) {勝ち}
```
