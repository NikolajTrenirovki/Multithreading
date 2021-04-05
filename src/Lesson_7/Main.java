package Lesson_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    List list = Collections.synchronizedList(new ArrayList<>());

    public List getList() {
        return list;
    }
}
