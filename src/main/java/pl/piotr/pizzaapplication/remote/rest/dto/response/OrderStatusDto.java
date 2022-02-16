package pl.piotr.pizzaapplication.remote.rest.dto.response;

import pl.piotr.pizzaapplication.domain.model.OrderStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import pl.piotr.pizzaapplication.domain.model.OrderStatusType;

import java.util.Date;

public class OrderStatusDto {

    private OrderStatusType status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expectedAt;

    public OrderStatusDto(OrderStatusType status, Date createdAt, Date updateAt, Date expectedAt) {
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.expectedAt = expectedAt;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getExpectedAt() {
        return expectedAt;
    }

    public void setExpectedAt(Date expectedAt) {
        this.expectedAt = expectedAt;
    }
}

