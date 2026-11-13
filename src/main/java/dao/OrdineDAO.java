package dao;

import model.Elementi;
import model.Ordine;
import model.Prodotto;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//gestiamo anche ElementiDAO
public class OrdineDAO {
    private static final String NOME_TABELLA = "ordine";
    private static final String NOME_S_TABELLA = "elementi";




    public List<Elementi> getEelmentiOrdine(int id_ordine){

        List<Elementi> EOrdinati = new ArrayList<>();
        String query = "SELECT * FROM " + NOME_S_TABELLA +" WHERE id_prodottoK = ? ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Elementi model = new Elementi();

                    model.setId_prodottoK(resultSet.getInt("id_prodottoK"));
                    model.setId_ordineK(resultSet.getInt("id_ordineK"));
                    model.setN_elementi(resultSet.getInt("n_elementi"));
                    model.setTot_parziale(resultSet.getDouble("tot_parziale"));
                    EOrdinati.add(model);

                }
            }

        } catch (SQLException e) {
            System.err.println("Errore : " + e.getMessage());
        }
        return EOrdinati;
    }

    public List<Ordine> getOrdiniCliente(int id_clienteKK){

        List<Ordine> LOrdini = new ArrayList<>();
        String query = "SELECT * FROM " + NOME_S_TABELLA +" WHERE id_clienteKK = ? ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Ordine model = new Ordine();

                    model.setId_ordine(resultSet.getInt("id_ordine"));
                    model.setId_clienteKK(resultSet.getInt("id_clienteKK"));
                    model.setData(resultSet.getDate("data"));
                    model.setTotale(resultSet.getDouble("totale"));
                    LOrdini.add(model);

                }
            }

        } catch (SQLException e) {
            System.err.println("Errore : " + e.getMessage());
        }
        return LOrdini;
    }




}
