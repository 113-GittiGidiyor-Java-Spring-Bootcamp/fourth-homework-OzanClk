/**
 * This service class is created for common methods.
 */
package dev.patika.fourthhomeworkapplication.servis;


import java.util.Optional;

public interface BaseService<T> {

    Optional<?> save(T object);

    Optional<?> findById(long id);

    Optional<?> update(T object);

    Iterable<?> findByAll();

    void deleteById(int id);

}
