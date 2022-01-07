package apidemo3.model;

import lombok.Data;
import org.noear.solon.validation.annotation.NotNull;

import java.io.Serializable;

@Data
public class AppxModel implements Serializable {
    private int agroup_id;
    @NotNull
    private String note;
    private String app_key;
    private int app_id;
    private int ar_is_examine;
}
