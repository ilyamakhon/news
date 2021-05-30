package by.makhon.webapp.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommentDto {
    private Integer userId;
    private String commentContent;

}
