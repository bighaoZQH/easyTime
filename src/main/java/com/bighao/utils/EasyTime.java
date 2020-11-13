package com.bighao.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @Author: bighao周启豪 bighao1996@163.com
 * @Date: 2020/5/21 17:26
 * @Version 1.0
 *
 * 1.提供java.util.Date、java.time.LocalDateTime、java.time.LocalTime
 *   这三种时间类型的互相转换
 * 2.提供这三种类型 与 字符串 进行互相转换API
 * 3.提供这三种类型 与 时间戳 进行互相转换API
 *
 * 目前时区默认都是东八区
 *
 *   java.util.Date          在方法名中简写为 date/Date
 *   java.time.LocalDateTime 在方法名中简写为 ldt/Ldt
 *   java.time.LocalTime     在方法名中简写为 ld/Ld
 */
public class EasyTime {

    /**
     * 时间格式化 到天
     */
    public static final DateTimeFormatter DTF_TO_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 时间格式化 到月
     */
    public static final DateTimeFormatter DTF_TO_MM = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * 时间格式化 到秒
     */
    public static final DateTimeFormatter DTF_TO_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /**
     * Date 转 LocalDateTime ，默认时区为东8区
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLdt(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }


    /**
     * LocalDateTime 转 Date，默认时区为东8区
     *
     * @param localDateTime
     * @return
     */
    public static Date ldtToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }


    /**
     * LocalDate 转 Date，默认时区为东8区
     *
     * @param localDate
     * @return
     */
    public static Date ldToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * Date 转 LocalDate，默认时区为东8区
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLd(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime().toLocalDate();
    }


    /**
     * LocalDate 转 时间戳
     *
     * @param localDate
     * @return
     */
    public static long ldToTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime 转 时间戳
     *
     * @param localDateTime
     * @return
     */
    public static long ldtToTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }


    /**
     * 时间戳 转 LocalDate
     *
     * @param timestamp
     * @return
     */
    public static LocalDate timestampToLd(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * 时间戳 转 LocalDate
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime timestampToLdt(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }


    /**
     * Date 转 字符串
     *
     * @param date
     * @return
     */
    public static String dateToStr(Date date, DateTimeFormatter dtf) {
        return dateToLdt(date).format(dtf);
    }

    /**
     * 字符串 转 LocalDateTime
     *
     * @param timeStr 字符串形式的日期
     * @param dtf     日期格式化转换器
     * @return
     */
    public static LocalDateTime strToLdt(String timeStr, DateTimeFormatter dtf) {
        return LocalDateTime.parse(timeStr, dtf);
    }

    /**
     * 字符串 转 LocalDate
     *
     * @param timeStr 字符串形式的日期
     * @param dtf     日期格式化转换器
     * @return
     */
    public static LocalDate strToLd(String timeStr, DateTimeFormatter dtf) {
        return LocalDate.parse(timeStr, dtf);
    }


    /**
     * 字符串 转 date
     *
     * @param timeStr
     * @param dtf
     * @return
     */
    public static Date strToDate(String timeStr, DateTimeFormatter dtf) {
        String dtfStr = dtf.toString();
        if (DTF_TO_DD.toString().equals(dtfStr) || DTF_TO_MM.toString().equals(dtfStr)) {
            return ldToDate(LocalDate.parse(timeStr, dtf));
        } else if (DTF_TO_SS.toString().equals(dtfStr)) {
            return ldtToDate(LocalDateTime.parse(timeStr, dtf));
        }
        return ldToDate(LocalDate.parse(timeStr, dtf));
    }


    /**
     * 获取本月最后一天最后一秒
     *
     * @param now
     * @return
     */
    public static LocalDateTime lastDayAndLastSecondsOfMonth(LocalDate now) {
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        return LocalDateTime.of(lastDay, LocalTime.MAX);
    }

    /**
     * 获取本月第一天第一秒
     *
     * @param now
     * @return
     */
    public static LocalDateTime firstDayAndFirstSecondsOfMonth(LocalDate now) {
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        return LocalDateTime.of(firstDay, LocalTime.MIN);
    }


}
