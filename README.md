# easyTime - version 0.1
Java DateTimeUtils -- Provide time type and format conversion



由于在公司写项目经常需要进行时间转换，而其他同事还在用以前的日期类型，因此写了这个工具类。

目前只是在自己所在公司项目中使用，因此功能还有待完善，后续会进行改进。



@Author: bighao周启豪 bighao1996@163.com

@Date: 2020/5/21 17:26

@Version 0.1



1.提供java.util.Date、java.time.LocalDateTime、java.time.LocalTime
  这三种时间类型的互相转换

2.提供这三种类型 与 字符串 进行互相转换API

3.提供这三种类型 与 时间戳 进行互相转换API

目前时区默认都是东八区

  java.util.Date          在方法名中简写为 date/Date

  java.time.LocalDateTime 在方法名中简写为 ldt/Ldt

  java.time.LocalTime     在方法名中简写为 ld/Ld