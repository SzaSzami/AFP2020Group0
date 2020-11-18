package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.SaunaDao;
import hu.uni.eku.tzs.model.Sauna;
import hu.uni.eku.tzs.service.exceptions.GuestTooYoungException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaunaServiceImpl implements SaunaService{

    private final SaunaDao dao;

    @Override
    public void Enter(String name, int age, Date Date) throws GuestTooYoungException {
        final boolean isTooYoung = dao.readAll()
                .stream()
                .anyMatch( cn ->
                        cn.getAge() >= 18);
        if(isTooYoung){
            log.info("Guest {} is too young!", name);
            throw new GuestTooYoungException(String.format("Guest (%s) is too young!", name));
        }
    }


    @Override
    public Collection<Sauna> readAll() {
        return dao.readAll();
    }
}
