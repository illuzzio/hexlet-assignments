package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Validator {
    public static List<String> validate(Object object) throws IllegalArgumentException, IllegalAccessException {
        var emptyFields = new ArrayList<String>();
        var fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        emptyFields.add(field.getName());
                    }
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }

        return emptyFields;
    }

    public static Map<String, List<String>> advancedValidate(Object object)
            throws IllegalArgumentException, IllegalAccessException {
        Map<String, List<String>> invalidFields = new HashMap<>();
        var fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    if (field.get(object) == null) {
                        errors.add("can not be null");
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    if (field.get(object) instanceof String lengthValue) {
                        if (lengthValue.length() < minLength.minLength()) {
                            errors.add("length less than " + minLength.minLength());
                        }
                    }
                }
                if (!errors.isEmpty()) {
                    invalidFields.put(field.getName(), errors);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return invalidFields;
    }
}
// END
