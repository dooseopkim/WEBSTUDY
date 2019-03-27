package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatConverter {
	private static final String PATTERN_MYSQL = "yyyy-MM-dd HH:mm:ss.S";
    private static final String PATTERN_DTO = "yyyy.MM.dd";
    
    private static DateTimeFormatter FORMATTER_MYSQL = DateTimeFormatter.ofPattern(PATTERN_MYSQL);
    private static DateTimeFormatter FORMATTER_DTO = DateTimeFormatter.ofPattern(PATTERN_DTO);

    public static String convertDateTime(String mysqlformat) {
        LocalDateTime dateTime = LocalDateTime.parse(mysqlformat,FORMATTER_MYSQL);
        return dateTime.format(FORMATTER_DTO);
    }

}
