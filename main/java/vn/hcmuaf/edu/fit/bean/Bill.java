package vn.hcmuaf.edu.fit.bean;

import org.jdbi.v3.core.mapper.Nested;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Bill implements Serializable {
    private int id;
    private String name;
    private LocalDateTime date;
    private String status;
    private String note;
    @Nested()
    private BillDetail billDetail;
    @Nested("user")
    private User user;

    public Bill() {
    }

    public Bill(int id, String name, LocalDateTime date, String status, String note, BillDetail billDetail, User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.note = note;
        this.billDetail = billDetail;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Nested()
    public BillDetail getBillDetail() {
        return billDetail;
    }

    @Nested()
    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
    }

    @Nested("user")
    public User getUser() {
        return user;
    }

    @Nested("user")
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", billDetail=" + billDetail +
                ", user=" + user +
                '}';
    }
}
