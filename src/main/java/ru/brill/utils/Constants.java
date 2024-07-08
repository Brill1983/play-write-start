package ru.brill.utils;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final String NOTHING_FOUND = "По данному запросу результатов не найдено";
    public static final String IP_RESTRICTED = "Доступ запрещен. Запросы, поступившие с вашего IP-адреса, похожи на автоматические";
}
