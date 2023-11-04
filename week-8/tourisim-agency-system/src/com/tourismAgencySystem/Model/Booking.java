package com.tourismAgencySystem.Model;

import com.tourismAgencySystem.Helper.DBConnecter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    private int id;
    private int hotel_id;
    private Hotel hotel;
    private int hostel_type_id;
    private HostelType hostel;
    private int season_id;
    private Season season;
    private int room_id;
    private Room room;
    private int room_price_id;
    private RoomPrice rPrice;
    private String name;
    private String phone_num;
    private String book_case;
    private int price;

    public Booking(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getHostel_type_id() {
        return hostel_type_id;
    }

    public void setHostel_type_id(int hostel_type_id) {
        this.hostel_type_id = hostel_type_id;
    }

    public HostelType getHostel() {
        return hostel;
    }

    public void setHostel(HostelType hostel) {
        this.hostel = hostel;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoom_price_id() {
        return room_price_id;
    }

    public void setRoom_price_id(int room_price_id) {
        this.room_price_id = room_price_id;
    }

    public RoomPrice getrPrice() {
        return rPrice;
    }

    public void setrPrice(RoomPrice rPrice) {
        this.rPrice = rPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getBook_case() {
        return book_case;
    }

    public void setBook_case(String book_case) {
        this.book_case = book_case;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public static ArrayList<Booking> searchBookingList(String query){
        ArrayList<Booking> bookingList=new ArrayList<>();
        Booking obj;
        Statement st= null;
        try {
            st = DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
