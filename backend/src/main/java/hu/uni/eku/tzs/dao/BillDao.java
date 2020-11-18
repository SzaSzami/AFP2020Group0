package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;

import java.util.Collection;

public interface BillDao {

    void create(Bill bill);

    Collection<Bill> readAll();

    void update(Bill original, Bill updated);

    void delete(Bill bill);
}
