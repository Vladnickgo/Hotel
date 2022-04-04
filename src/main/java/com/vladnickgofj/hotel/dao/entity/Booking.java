package com.vladnickgofj.hotel.dao.entity;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private final int id;
    private final Date check_in;
    private final Date check_out;
    private final int roomId;
    private final int night;
    private final Date bookTime;
    private final int bookingStatusId;
    private final int usersId;

//    public Booking(int id, Date check_in, Date check_out, int roomId, int night, Date bookTime, int bookingStatusId, int usersId) {
//        this.id = id;
//        this.check_in = check_in;
//        this.check_out = check_out;
//        this.roomId = roomId;
//        this.night = night;
//        this.bookTime = bookTime;
//        this.bookingStatusId = bookingStatusId;
//        this.usersId = usersId;
//    }


//    public Booking(Builder builder) {
//        id = builder.id;
//        check_in = builder.check_in;
//        check_out = builder.check_out;
//        roomId = builder.roomId;
//        night = builder.night;
//        bookTime = builder.bookTime;
//        bookingStatusId = builder.bookingStatusId;
//        usersId = builder.usersId;
//    }
//
//    public Booking() {
//    }
//
//    public static Builder aBooking() {
//        return new Builder();
//    }
//
//    public static final class Builder {
//        private int id;
//        private Date check_in;
//        private Date check_out;
//        private int roomId;
//        private int night;
//        private Date bookTime;
//        private int bookingStatusId;
//        private int usersId;
//        private Builder() {
//        }
//
//        public Builder id(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder check_in(Date check_in) {
//            this.check_in = check_in;
//            return this;
//        }
//
//        public Builder check_out(Date check_out) {
//            this.check_out = check_out;
//            return this;
//        }
//
//        public Builder roomId(int roomId) {
//            this.roomId = roomId;
//            return this;
//        }
//
//        public Builder night(int night) {
//            this.night = night;
//            return this;
//        }
//
//        public Builder bookTime(Date bookTime) {
//            this.bookTime = bookTime;
//            return this;
//        }
//
//        public Builder bookingStatusId(int bookingStatusId) {
//            this.bookingStatusId = bookingStatusId;
//            return this;
//        }
//
//        public Builder usersId(int usersId) {
//            this.usersId = usersId;
//            return this;
//        }
//
//        public Booking build() {
//            return new Booking(this);
//        }
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public Date getCheck_in() {
//        return check_in;
//    }
//
//    public Date getCheck_out() {
//        return check_out;
//    }
//
//    public int getRoomId() {
//        return roomId;
//    }
//
//    public int getNight() {
//        return night;
//    }
//
//    public Date getBookTime() {
//        return bookTime;
//    }
//
//    public int getBookingStatusId() {
//        return bookingStatusId;
//    }
//
//    public int getUsersId() {
//        return usersId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Booking booking = (Booking) o;
//        return id == booking.id && roomId == booking.roomId && night == booking.night && bookingStatusId == booking.bookingStatusId && usersId == booking.usersId && check_in.equals(booking.check_in) && check_out.equals(booking.check_out) && bookTime.equals(booking.bookTime);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, check_in, check_out, roomId, night, bookTime, bookingStatusId, usersId);
//    }


    public Booking(int id, Date check_in, Date check_out, int roomId, int night, Date bookTime, int bookingStatusId, int usersId) {
        this.id = id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.roomId = roomId;
        this.night = night;
        this.bookTime = bookTime;
        this.bookingStatusId = bookingStatusId;
        this.usersId = usersId;
    }

    public int getId() {
        return id;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getNight() {
        return night;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public int getBookingStatusId() {
        return bookingStatusId;
    }

    public int getUsersId() {
        return usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && roomId == booking.roomId && night == booking.night && bookingStatusId == booking.bookingStatusId && usersId == booking.usersId && Objects.equals(check_in, booking.check_in) && Objects.equals(check_out, booking.check_out) && Objects.equals(bookTime, booking.bookTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, check_in, check_out, roomId, night, bookTime, bookingStatusId, usersId);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", roomId=" + roomId +
                ", night=" + night +
                ", bookTime=" + bookTime +
                ", bookingStatusId=" + bookingStatusId +
                ", usersId=" + usersId +
                '}';
    }
}
