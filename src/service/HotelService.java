package service;

import dao.Idao;
import model.Hotel;

public class HotelService {
    private final Idao<Hotel> hotelIDao;

    public HotelService(Idao<Hotel> hotelIDao) {
        this.hotelIDao = hotelIDao;
    }

    public Hotel salvar(Hotel hotel) {
        hotelIDao.salvar(hotel);
        return hotel;
    }
}
