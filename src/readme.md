# Java 基礎課程內容
### 一、容量單位
1. 8 bits = 1 Byte 大部分喜歡簡寫，小寫 b 和大寫 B
2. B * 1024 = KB，10 的 3 次方=1000，有時用這個，但實際上是 1024，不是 1000
3. KB MB GB TB PB EB ZB YB，每個單位都差 2 的 10 次方 = 1024
4. 毫秒 ms(minisecond)、微秒 µs(mu-second)、奈秒 ns(nanosecond)、皮秒 ps(picosecond)、fs、as、zs、ys，每個差 10 的 -3 次方
### 二、進制轉換
1. 常用進位為 2 8 10 16，binary octal decimal hexadecimal
2. 非十進位要互轉需先轉成十進位再轉換
3. 小數轉換
4. 可參考：[進位教學](http://www.chwa.com.tw/TResource/VS/book1/ch2/2-5.htm)
### 三、1和2的補數
1. [2的補數](https://zh.wikipedia.org/wiki/%E4%BA%8C%E8%A3%9C%E6%95%B8)
2. 大部分的程式語言都用 2 的補數，java 也是
### 四、JAVA_HOME 和 CLASSPATH
[環境變數](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html)
javac.exe java.exe
### 五、java 版本
+ James Gosling [JAVA之父](https://zh.wikipedia.org/zh-tw/%E8%A9%B9%E5%A7%86%E6%96%AF%C2%B7%E9%AB%98%E6%96%AF%E6%9E%97)
+ SE EE ME FX
+ [長期支援版](https://www.oracle.com/java/technologies/java-se-support-roadmap.html) 8 11 17 21
+ jre jdk jvm 區別
+ [命名規則和關鍵字](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
1. literal 為等號右邊的關鍵字
2. Unicode、英文大小寫、$、_、數字(非開頭)
3. 依照慣例，_只用在 final，且英文全大寫；$不使用，使用駝峰命名法
### 六、main 方法
+ 傳參
+ 註解(單行 多行 文件)
### 七、基本型態 primitive type
+ 整數 byte short int long：沒有小數點的，預設為 int，佔 8 16 32 64 bits
> 0b 開頭為 2 進位(JDK7)；0 開頭為 8 進位；0x 開頭為 16 進位；以上不分大小寫
+ 小數/浮點數 float double：有小數點的，也包括 .0，預設為 double，佔 32 64 bits
> 小數點有誤差，轉成二進位時無法整除
+ 字元 char：用 '' 包起一個字，包括中文，佔 16 bits，跳脫字元 \
> 範圍為 \u0000~\uFFFF，16 的 4 次方，又等於 2 的 16 次方 = 65536，參考 charmap
+ 布林 boolean：不是 true 就是 false，佔 1 bit
+ int 存時間問題 2038
### 八、基本型態轉換
1. byte -> short -> int -> long -> float -> double
2. int -> byte short char 在範圍裡會自動轉換，否則編譯錯誤
### 九、var (JDK10)
1. 只能是區域變數且一定要初始化
2. 不能是參數和回傳值
### 十、運算符
+ % / * - +
> / 取商；%(mod) 取餘
+ += -= *= /= %=
+ < <= > >= == !=
+ NOT ! 和 XOR ^
+ AND 和 OR 
> && & || |
+ ++ --
### 十一、條件
1. if
2. 三元運算子 ?:
3. switch
### 十二、陣列
### 十三、迴圈
1. 無限迴圈
2. for for:
3. while
4. do while
5. break continue 標籤
6. jdk8 foreach Stream.iterate
7. 九九乘法
8. 迴圈練習
### 十四、String
1. 多行(jdk15)
2. 字串池
3. 常用方法
### 十五、Scanner
### 十六、Console
