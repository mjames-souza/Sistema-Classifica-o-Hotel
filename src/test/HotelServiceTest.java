package test;

import dao.config.ConfigJDBC;
import dao.impl.HotelDaoH2;
import model.Hotel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.HotelService;

import static org.junit.jupiter.api.Assertions.*;

class HotelServiceTest {
    private static final Logger LOGGER = Logger.getLogger(HotelServiceTest.class);
    private final HotelService hotelService = new HotelService(new HotelDaoH2(new ConfigJDBC()));

    public HotelServiceTest() {
    }

    @BeforeAll
    static void ConfigLog() {
        BasicConfigurator.configure();
    }
    @Test
    public void cadastrarHotel() {
        Hotel hotel1 = this.hotelService.salvar(new Hotel("Hotel Beiramar", "Avenida Transversal", "12", "Maceió", "Alagoas", "true"));
        Hotel hotel2 = this.hotelService.salvar(new Hotel("Hotel Barramar", "Avenida Beira Mar", "78", "Barra de São Miguel", "ALagoas", "true"));
        Hotel hotel3 = this.hotelService.salvar(new Hotel("Hotel Aquarius", "Avenida do Futuro", "64", "Aracaju", "Sergipe", "false"));
        Hotel hotel4 = this.hotelService.salvar(new Hotel("Brisa Tower", "Avenida Tenente Augusto Pereira", "990", "Natal", "Rio Grande do Norte", "true"));
        Hotel hotel5 = this.hotelService.salvar(new Hotel("Hotel Manguaba", "Avenida Coletora", "54", "Marechal Deodoro", "Alagoas", "false"));
    }
}