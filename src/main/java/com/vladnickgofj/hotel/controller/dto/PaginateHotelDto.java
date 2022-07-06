package com.vladnickgofj.hotel.controller.dto;

import java.util.Objects;

public class PaginateHotelDto {
    private final Integer hotelsOnPage;
    private final Integer numberOfPage;

    private PaginateHotelDto(Builder builder) {
        hotelsOnPage = builder.hotelsOnPage;
        numberOfPage = builder.numberOfPage;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer hotelsOnPage;
        private Integer numberOfPage;

        private Builder() {
        }

        public Builder hotelsOnPage(Integer val) {
            hotelsOnPage = val;
            return this;
        }

        public Builder numberOfPage(Integer val) {
            numberOfPage = val;
            return this;
        }

        public PaginateHotelDto build() {
            return new PaginateHotelDto(this);
        }
    }

    public Integer getHotelsOnPage() {
        return hotelsOnPage;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginateHotelDto that = (PaginateHotelDto) o;
        return hotelsOnPage == that.hotelsOnPage && numberOfPage == that.numberOfPage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelsOnPage, numberOfPage);
    }

    @Override
    public String toString() {
        return "PaginateHotelDto{" +
                "hotelsOnPage=" + hotelsOnPage +
                ", numberOfPage=" + numberOfPage +
                '}';
    }
}
