package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Sauna;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SaunaDaoImpl implements SaunaDao {

    private final SaunaRepository repository;

    @Override
    public void create(Sauna sauna) {
        repository.save(SaunaEntityModelConverter.model2entity(sauna));
    }

    @Override
    public Collection<Sauna> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> SaunaEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Sauna original, Sauna updated) {
        delete(original);
        create(updated);
    }

    @Override
    public void delete(Sauna sauna) {
        repository.delete(SaunaEntityModelConverter.model2entity(sauna));
    }

    private static class SaunaEntityModelConverter{

        private static Sauna entity2model(hu.uni.eku.tzs.dao.entity.Sauna entity){
            return new Sauna(
                    entity.getName(),
                    entity.getAge(),
                    entity.getAllowed(),
                    entity.getDate()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Sauna model2entity(Sauna model){
            return hu.uni.eku.tzs.dao.entity.Sauna.builder()
                    .name(model.getName())
                    .age(model.getAge())
                    .allowed(model.getAllowed())
                    .date(model.getDate())
                    .build();
        }

    }
}
