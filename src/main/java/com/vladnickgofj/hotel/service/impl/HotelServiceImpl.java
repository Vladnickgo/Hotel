package com.vladnickgofj.hotel.service.impl;

import com.vladnickgofj.hotel.controller.dto.HotelDto;
import com.vladnickgofj.hotel.controller.dto.PaginateHotelDto;
import com.vladnickgofj.hotel.dao.HotelDao;
import com.vladnickgofj.hotel.dao.entity.Hotel;
import com.vladnickgofj.hotel.service.HotelService;
import com.vladnickgofj.hotel.service.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelRepository;
    private final Mapper<HotelDto, Hotel> hotelMapper;

    public HotelServiceImpl(HotelDao hotelRepository, Mapper<HotelDto, Hotel> hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public List<HotelDto> findAll(PaginateHotelDto paginateHotelDto) {
        List<Hotel> all = hotelRepository
                .findAll(firstRecordOnPageNumber(paginateHotelDto), paginateHotelDto.getHotelsOnPage());
        return all.stream().map(hotelMapper::mapEntityToDto).collect(Collectors.toList());

    }

    private Integer firstRecordOnPageNumber(PaginateHotelDto paginateHotelDto) {
        int pages = getPages(paginateHotelDto);
        return paginateHotelDto.getHotelsOnPage() * ((Math.min(paginateHotelDto.getNumberOfPage(), pages)) - 1);
    }

    @Override
    public Integer getPages(PaginateHotelDto paginateHotelDto) {
        int size = hotelRepository.findAll().size();
        return size / paginateHotelDto.getHotelsOnPage() + (size % paginateHotelDto.getHotelsOnPage() > 0 ? 1 : 0);
    }
}
