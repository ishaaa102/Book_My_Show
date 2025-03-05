package com.tekion.bookmyshow.model;

public class Theatre {
    private int id; //pk
    private String name;
    private Address address;

    public Theatre(String theatreName, Address address) {
        this.name = theatreName;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Theatre{name='"+name+ "', address:"+address+"}";
    }
}
