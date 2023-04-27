package demo4013.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AppxModel implements Serializable {
    private int agroup_id;
    private String note;
    private String app_key;
    private int app_id;
    private int ar_is_examine;
}
