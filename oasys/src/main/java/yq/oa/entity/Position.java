package yq.oa.entity;

import java.io.Serializable;

/**
 * 职位 实体类
 */
public class Position implements Serializable {

    private static final long serialVersionUID = -3374574782275475118L;
    private int id;
    private String posName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
