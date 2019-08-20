package com.revature.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Reimbursement
 */
@XmlRootElement
public class Reimbursement {
    private int id;
    private float amount;
    private String type;
    private String aproval;
    private String employeuname;

    public Reimbursement() {
    };

    public Reimbursement(int id, String type, float amount, String aproval, String employeuname) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.aproval = "pending";
        this.employeuname = employeuname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAproval() {
        return aproval;
    }

    public void setAproval(String aproval) {
        this.aproval = aproval;
    }

 

    public String getEmployeuname() {
        return employeuname;
    }

    public void setEmployeuname(String employeuname) {
        this.employeuname = employeuname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(amount);
        result = prime * result + ((aproval == null) ? 0 : aproval.hashCode());
        result = prime * result + ((employeuname == null) ? 0 : employeuname.hashCode());
        result = prime * result + id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reimbursement other = (Reimbursement) obj;
        if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
            return false;
        if (aproval == null) {
            if (other.aproval != null)
                return false;
        } else if (!aproval.equals(other.aproval))
            return false;
        if (employeuname == null) {
            if (other.employeuname != null)
                return false;
        } else if (!employeuname.equals(other.employeuname))
            return false;
        if (id != other.id)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reimbursement [amount=" + amount + ", aproval=" + aproval + ", employeuname=" + employeuname + ", id="
                + id + ", type=" + type + "]";
    }
     
}