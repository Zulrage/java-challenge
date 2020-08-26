package jp.co.axa.apidemo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee data transfer entity for rest.
 * <br> Could be transferred in a separate lib project (to be reused by other
 * java projects when contacting this API)
 *
 * @author bertrand.hieronymus
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {

    private Long id;

    private String name;

    private Integer salary;

    private String department;
}
