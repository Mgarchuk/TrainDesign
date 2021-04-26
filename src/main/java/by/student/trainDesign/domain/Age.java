package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class Age {
    public static Map<Byte, Age> agesList = new HashMap<>();
    private final byte value;

    private static final Logger logger = LoggerFactory.getLogger(Age.class.getName());

    public Age(byte value) {
        checkArgument(value >= 0, "Age must be >= 0");
        checkArgument(value <= 125, "Age must be <= 125");
        this.value = value;

        logger.info("Age created");
    }

    public int intValue() {
        return value;
    }

    public static Age of(int integerAge) { /// мб не инт, а сразу байт?
        byte byteAge = (byte) integerAge;
        Age age = agesList.get(byteAge);
        if (age != null) {
            return age;
        }
        age = new Age(byteAge);
        agesList.put(byteAge, age);
        return age;
    }
}