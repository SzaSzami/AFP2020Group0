package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.service.exceptions.GuestAlreadyExistsException;

import java.util.Collection;

public interface GuestService {

    void record(Guest guest) throws GuestAlreadyExistsException;

    Collection<Guest> readAll();
}
