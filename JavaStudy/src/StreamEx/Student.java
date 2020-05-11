package StreamEx;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private boolean isMale;
    private int hak;
    private int ban;
    private int score;
    private sex isSex;
    enum sex{
        남,
        여
    }
}

enum Level {
    HIGH,
    MID,
    LOW
}
