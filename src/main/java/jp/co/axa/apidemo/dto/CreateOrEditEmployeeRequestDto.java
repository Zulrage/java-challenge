package jp.co.axa.apidemo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer entity for creation and edition of the employees.
 * <br> Could be transferred in a separate lib project (to be reused by other
 * java projects when contacting this API)
 *
 * @author adolk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrEditEmployeeRequestDto implements Serializable {

    private String name;

    private Integer salary;

    private String department;
}
