import lombok.ToString;

import java.util.Random;

@ToString
public class Department {
    int id;

    public Department() {
        Random random = new Random();
        id = random.nextInt(1,3);
    }
}
