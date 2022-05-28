package com.vladnickgofj.hotel.dao.entity;

import java.util.Objects;

public class Payment {
    private final int id;
    private final int bookingId;
    private final int userId;
    private final int amount;

    private Payment(Builder builder) {
        id = builder.id;
        bookingId = builder.bookingId;
        userId = builder.userId;
        amount = builder.amount;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int id;
        private int bookingId;
        private int userId;
        private int amount;

        private Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder bookingId(int val) {
            bookingId = val;
            return this;
        }

        public Builder userId(int val) {
            userId = val;
            return this;
        }

        public Builder amount(int val) {
            amount = val;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    public int getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && bookingId == payment.bookingId && userId == payment.userId && amount == payment.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, userId, amount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}
