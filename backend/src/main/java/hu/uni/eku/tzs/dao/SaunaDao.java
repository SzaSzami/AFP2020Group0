package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Sauna;

import java.util.Collection;

public interface SaunaDao {

    void create(Sauna sauna);

    Collection<Sauna> readAll();

    void update(Sauna original, Sauna updated);

    void delete(Sauna sauna);
}
