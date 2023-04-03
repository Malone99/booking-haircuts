package mc.tech.com.service.implementation;

import java.util.Optional;

public interface IService<T,ID>  {

    T save(T t);
    Optional<T > read(ID id);
    void delete(int deleteById);
}