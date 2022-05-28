package com.vladnickgofj.hotel.dao.entity;

import java.util.Objects;

public class Room {
    private final int id;
    private final int typeId;
    private final int numberOfBeds;
    private final int statusId;
    private final int price;
    private final int hotelId;

    private Room(Builder builder) {
        id = builder.id;
        typeId = builder.typeId;
        numberOfBeds = builder.numberOfBeds;
        statusId = builder.statusId;
        price = builder.price;
        hotelId = builder.hotelId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private int typeId;
        private int numberOfBeds;
        private int statusId;
        private int price;
        private int hotelId;

        private Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder typeId(int val) {
            typeId = val;
            return this;
        }

        public Builder numberOfBeds(int val) {
            numberOfBeds = val;
            return this;
        }

        public Builder statusId(int val) {
            statusId = val;
            return this;
        }

        public Builder price(int val) {
            price = val;
            return this;
        }

        public Builder hotelId(int val) {
            hotelId = val;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

    public int getId() {
        return id;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getPrice() {
        return price;
    }

    public int getHotelId() {
        return hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && typeId == room.typeId && numberOfBeds == room.numberOfBeds && statusId == room.statusId && price == room.price && hotelId == room.hotelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, numberOfBeds, statusId, price, hotelId);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", numberOfBeds=" + numberOfBeds +
                ", statusId=" + statusId +
                ", price=" + price +
                ", hotelId=" + hotelId +
                '}';
    }

}
