package dao.impl;

import dao.Idao;
import dao.config.ConfigJDBC;
import model.Hotel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDaoH2 implements Idao<Hotel> {
    private static final Logger LOGGER = Logger.getLogger(HotelDaoH2.class);
    private final ConfigJDBC configJDBC;

    public HotelDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    public Hotel salvar(Hotel hotel) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "INSERT INTO hoteis" +
                        "(nome, rua, numero, cidade, estado, estrelas)" +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                hotel.getNomeFilial(),
                hotel.getRua(),
                hotel.getNumero(),
                hotel.getCidade(),
                hotel.getEstado(),
                hotel.getCincoEstrelas()
        );
        try {
            int count = 0;
            stmt = connection.createStatement();
            LOGGER.info("Conexão bem sucedida!");
            stmt.executeUpdate(query, 1);
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                ++count;
                System.out.println("ID: " + count);
            }

            stmt.close();
            connection.close();
            LOGGER.info("Conexão Interrompida");
        } catch (SQLException var7) {
            LOGGER.error("Algo deu errado:");
            var7.printStackTrace();
        }

        return hotel;

    }
}
