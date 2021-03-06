package lab.lab.lab.api.comment;

import lab.lab.lab.api.discipline.Discipline;
import lombok.*;
import lab.lab.lab.api.user.User;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name="comment_generator",sequenceName = "comment_sequence", allocationSize = 1)
    private Long id;
    private String content;
    @ManyToOne()
    private Discipline discipline;
    @ManyToOne
    private User user;
}
