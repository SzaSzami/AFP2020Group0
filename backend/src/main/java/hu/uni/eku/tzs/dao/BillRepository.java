package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Integer> {
}
