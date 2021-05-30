package by.makhon.webapp.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NewsDto {
    private Long userId;
    private Long newsId;
    private String title;
    private String content;
    private String picUrl;
}
