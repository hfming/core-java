@echo off
@rem @：隐藏当前行的命令 echo off：一个bat处理文件如果执行了echo off命令，那么echo off以下的命令都会隐藏起来，只显示结果。
@rem 注释语句
title 批处理文件练习
color 1C

java -classpath  .\Bat.jar; com.edu.cjlu.hfm.knowledge.BatTest

pause