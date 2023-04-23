package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.role;
import mc.tech.com.repository.roleRepository;
import mc.tech.com.service.implementation.IService;

import java.util.Optional;
@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Slf4j
public class ServiceRole  implements IService<role,Integer> {
    private final roleRepository repository;
    @Override
    public role save(role role) {


        return this.repository.save(role);
    }

    @Override
    public Optional<role> read(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void delete(int deleteById) {

    }
}
