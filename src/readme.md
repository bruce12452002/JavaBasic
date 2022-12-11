# Java 基礎課程內容
### 一、容量單位
1. 8 bits = 1 Byte 大部分喜歡簡寫，小寫 b 和大寫 B
2. B * 1024 = KB，10 的 3 次方=1000，有時用這個，但實際上是 1024，不是 1000
3. KB MB GB TB PB EB ZB YB，每個單位都差 2 的 10 次方 = 1024
4. 毫秒 ms(minisecond)、微秒 us(mu-second)、奈秒 ns(nanosecond)、ps(picosecond)，每個差 2 的 -10 次方
### 二、進制轉換
1. 常用進位為 2 8 10 16
2. 非十進位要互轉需先轉成十進位再轉換
3. 小數轉換
4. 可參考：http://www.chwa.com.tw/TResource/VS/book1/ch2/2-5.htm
### 三、1和2的補數
1. https://zh.wikipedia.org/wiki/%E4%BA%8C%E8%A3%9C%E6%95%B8
2. 大部分的程式語言都用 2 的補數，java 也是
### 四、JAVA_HOME 和 CLASSPATH
https://docs.oracle.com/javase/tutorial/essential/environment/paths.html
### 五、java 版本
+ SE EE ME FX
+ jre jdk jvm 區別
### 六、基本型態
1. 整數 byte short int long：沒有小數點的，預設為 int，佔 8 16 32 64 bits
> 0b 開頭為 2 進位；0 開頭為 8 進位；0x 開頭為 16 進位；以上不分大小寫
2. 小數/浮點數 float double：有小數點的，也包括 .0，預設為 double，佔 32 64 bits
> 小數點有誤差，轉成二進位時無法整除
4. 字元 char：用 '' 包起一個字，包括中文，佔 16 bits，跳脫字元 \
> 範圍為 \u0000~\uFFFF，16 的 4 次方，又等於 2 的 16 次方 = 65536，參考 charmap
4. 布林 boolean：為是 true 就是 false，佔 1 bit
### 七、基本型態轉換
### 八、運算符
1. % / * - +
> / 取商；%(mod) 取餘
2. += -= *= /= %=
3. > >= < <= == !=
4. NOT ! 和 XOR ^
5. AND 和 OR 
> && & || |
6. ++ --
