package ru.eisbrecher.springboot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_number")
    private String carNumber;

    @Column //Если имена в таблице совпадают, то не надо указывать имя колонки
    private String violator;

    @Column
    private String officer;

    @Column
    private String protocol_drafter;

    @Column
    private LocalDateTime protocol_time;

    @Column
    private int forfeit;

    @Column
    private boolean court;

    @Column
    private boolean payed;

    public Fine(String carNumber, String violator, String officer, String protocol_drafter, LocalDateTime protocol_time, int forfeit, boolean court, boolean payed) {
        this.carNumber = carNumber;
        this.violator = violator;
        this.officer = officer;
        this.protocol_drafter = protocol_drafter;
        this.protocol_time = protocol_time;
        this.forfeit = forfeit;
        this.court = court;
        this.payed = payed;
    }

    public Fine() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getViolator() {
        return violator;
    }

    public void setViolator(String vialator) {
        this.violator = vialator;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getProtocol_drafter() {
        return protocol_drafter;
    }

    public void setProtocol_drafter(String protocol_drafter) {
        this.protocol_drafter = protocol_drafter;
    }

    public LocalDateTime getProtocol_time() {
        return protocol_time;
    }

    public void setProtocol_time(LocalDateTime protocol_time) {
        this.protocol_time = protocol_time;
    }

    public int getForfeit() {
        return forfeit;
    }

    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }

    public boolean isCourt() {
        return court;
    }

    public void setCourt(boolean court) {
        this.court = court;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", vialator='" + violator + '\'' +
                ", officer='" + officer + '\'' +
                ", protocol_drafter='" + protocol_drafter + '\'' +
                ", protocol_time=" + protocol_time +
                ", forfeit=" + forfeit +
                ", court=" + court +
                ", payed=" + payed +
                '}';
    }
}
