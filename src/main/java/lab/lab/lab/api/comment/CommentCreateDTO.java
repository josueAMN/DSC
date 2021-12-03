package lab.lab.lab.api.comment;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CommentCreateDTO implements Serializable {
    private String content;
}
