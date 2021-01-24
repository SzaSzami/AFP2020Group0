package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException.java;
import org.mockito.Mockito;

class Test
{

    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new BillServiceImpl(dao);
    }

    @Test
    void generate() throws BillAlreadyExistsException {
        Bill bill = new Bill();
        service.generate(bill);
        verify(dao).generate(any());
    }

    @Test
    void generateExistingBill() {
        Bill bill = new Bill(0,0);
        when(dao.readAll()).thenReturn(List.of(bill));
        assertThrows(BillAlreadyExistsException.class, () -> service.generate(bill));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Bill> daoResponse = List.of(
                new Bill(),
                new Bill(),
                new Bill(),
                new Bill()
        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Bill> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }

}
