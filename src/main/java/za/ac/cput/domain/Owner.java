package za.ac.cput.domain;
/*
 *Owner.java
 * VuyolwethuKalolo
 * 214015637
 * 06-04-2022
 */


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//import org.jetbrains.annotations.Contract;
@Entity
public class Owner implements Serializable {
    @Id
    @NotNull private int ownerId;
    @NotNull private String ownerName;


    public Owner(Builder builder) {
        this.ownerId = builder.ownerId;
        this. ownerName= builder.ownerName;

    }
    public Owner(){

    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }


    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", OwnerName='" + ownerName + '\'' +
                '}';
    }

    public static class Builder {
        @NotNull private int ownerId;
        @NotNull private String ownerName;

        public Builder setOwnerId(int ownerId) {
            this.ownerId= ownerId;
            return this;
        }

        public Builder setOwnerName(String ownerName) {
            this.ownerName =ownerName ;
            return this;
        }

        public Builder copy(Owner owner) {

            this.ownerId = owner.ownerId;
            this.ownerName = owner.ownerName;
            return this;
        }

        public Owner build(){
            return new Owner(this);
        }



    }


}
