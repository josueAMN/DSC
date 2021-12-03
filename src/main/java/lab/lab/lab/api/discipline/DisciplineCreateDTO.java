package lab.lab.lab.api.discipline;

import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
public class DisciplineCreateDTO implements Serializable {
    private String name;
}
