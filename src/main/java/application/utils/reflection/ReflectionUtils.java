package application.utils.reflection;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionUtils {
    public static<T> void updateReflection(T object, T result, EntityManager entityManager) {

        Field[] objFields = object.getClass().getDeclaredFields();

        Arrays.stream(objFields)
                .filter(field -> field.isAnnotationPresent(Id.class))
                .peek(q -> q.setAccessible(true))
                .forEach(field -> {
                    try {
                        if(field.get(object)!=null){
                            field.set(object, field.get(result));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        entityManager.merge(result);
    }
}
