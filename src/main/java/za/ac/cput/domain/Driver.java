/*
Driver.java
Entity for driver using builder pattern
Author : Zubair Esau (217100554)
Date 05 April 2022

 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Driver implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private String driverId ;
    @NotNull private String deliveryId ;
    @NotNull private String orderId ;
    @NotNull private String driverName;

    public Driver(Builder builder){
        this.driverId = builder.driverId;
        this.deliveryId = builder.deliveryId;
        this.orderId = builder.orderId;
        this.driverName = builder.driverName;
    }

    public Driver() {

    }

    public String getDriverId() {
        return driverId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }

    //Builder pattern class
    public static class Builder {

        @NotNull private String driverId ;
        @NotNull private String deliveryId ;
        @NotNull private String orderId ;
        @NotNull private String driverName;

        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }


        public Builder copy( Driver driver){
            this.driverId = driverId;
            this.deliveryId = deliveryId;
            this.orderId = orderId;
            this.driverName = driverName;
            return this;
        }


        public Driver build(){
            return new Driver(this);
        }



    }


}

