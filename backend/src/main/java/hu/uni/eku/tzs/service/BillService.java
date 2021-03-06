package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;

import java.util.Collection;

public interface BillService {

    void generate(Bill bill) throws BillAlreadyExistsException;

    Collection<Bill> readAll();
}