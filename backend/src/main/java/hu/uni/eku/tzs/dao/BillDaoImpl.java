package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BillDaoImpl implements BillDao {

    private final BillRepository repository;

    @Override
    public void create(Bill bill) {
        repository.save(BillEntityModelConverter.model2entity(bill));
    }

    @Override
    public Collection<Bill> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> BillEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Bill original, Bill updated) {

    }

    @Override
    public void delete(Bill bill) {

    }

    private static class BillEntityModelConverter{

        private static Bill entity2model(hu.uni.eku.tzs.dao.entity.Bill entity){
            return new Bill(
                    entity.getOwner(),
                    entity.getUsers(),
                    entity.getItems(),
                    entity.getEndstamp()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Bill model2entity(Bill model){
            return hu.uni.eku.tzs.dao.entity.Bill.builder()
                    .owner(model.getOwner())
                    .users(model.getUsers())
                    .items(model.getItems())
                    .endstamp(model.getEndstamp())
                    .build();
        }

    }
}
