package tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;

public interface HelloRepository {
    Hello findHello(String name);

    int increaseCount(String name);

    default int countOf(String name) {
        try {
            Hello hello = findHello(name);
            return hello.getCount();
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }
}
