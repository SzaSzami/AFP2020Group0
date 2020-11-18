package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.BillDao;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillServiceImpl implements BillService{
    private final BillDao dao;


    @Override
    public void generate(Bill bill) throws BillAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( cn ->
                        cn.getOwner() == bill.getOwner()
                                &&
                                cn.getUsers() == bill.getUsers()
                                    &&
                                        cn.getItems() == bill.getItems()
                                            &&
                                                cn.getEndstamp() == bill.getEndstamp());
        if(isAlreadyRecorded){
            log.info("Bill {} is already generated!", bill);
            throw new BillAlreadyExistsException(String.format("Bill (%s) already exists!", bill.toString()));

        }
        dao.create(bill);
    }

    @Override
    public Collection<Bill> readAll() {
        return dao.readAll();
    }
}
