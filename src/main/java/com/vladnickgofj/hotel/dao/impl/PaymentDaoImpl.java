package com.vladnickgofj.hotel.dao.impl;

import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.dao.PaymentDao;
import com.vladnickgofj.hotel.dao.entity.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImpl extends AbstractCrudDaoImpl<Payment> implements PaymentDao {

    private final static String INSERT_INTO = "INSERT INTO payments(booking_id, user_id, amount) VALUES (?,?,?)";
    private static final String FIND_BY_ID = "SELECT * FROM payments WHERE payment_id=?";
    private static final String FIND_ALL = "SELECT * FROM payments";
    private static final String UPDATE_PAYMENT = "UPDATE payments SET booking_id=?, user_id=?, amount=? WHERE payment_id=?";

    protected PaymentDaoImpl(HikariConnectionPool connector) {
        super(connector, INSERT_INTO, FIND_BY_ID, FIND_ALL, UPDATE_PAYMENT);
    }

    @Override
    protected Payment mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Payment.newBuilder()
                .id(resultSet.getInt("payment_id"))
                .bookingId(resultSet.getInt("booking_id"))
                .userId(resultSet.getInt("user_id"))
                .amount(resultSet.getInt("amount"))
                .build();
    }

    @Override
    protected void mapForInsertStatement(PreparedStatement preparedStatement, Payment entity) throws SQLException {
        preparedStatement.setInt(1, entity.getBookingId());
        preparedStatement.setInt(2, entity.getUserId());
        preparedStatement.setInt(3, entity.getAmount());
    }

    @Override
    protected void mapForUpdateStatement(PreparedStatement preparedStatement, Payment entity) throws SQLException {
        mapForInsertStatement(preparedStatement, entity);
        preparedStatement.setInt(4, entity.getAmount());
    }
}
