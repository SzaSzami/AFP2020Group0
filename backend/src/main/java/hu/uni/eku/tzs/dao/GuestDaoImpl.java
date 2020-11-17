package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class GuestDaoImpl implements GuestDao {

    private final GuestRepository repository;

    @Override
    public void create(Guest guest) {
        repository.save(GuestEntityModelConverter.model2entity(guest));
    }

    @Override
    public Collection<Guest> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> GuestEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Guest original, Guest updated) {
        delete(original);
        create(updated);
    }

    @Override
    public void delete(Guest guest) {
        repository.delete(GuestEntityModelConverter.model2entity(guest));
    }

    private static class GuestEntityModelConverter{

        private static Guest entity2model(hu.uni.eku.tzs.dao.entity.Guest entity){
            return new Guest(
                    entity.getName(),
                    entity.getAge()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Guest model2entity(Guest model){
            return hu.uni.eku.tzs.dao.entity.Guest.builder()
                    .name(model.getName())
                    .age(model.getAge())
                    .build();
        }

    }
}
