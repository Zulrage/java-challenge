package jp.co.axa.apidemo.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Error DTO for rest response.
 * <br> Could be transferred in a separate lib project (to be reused by other
 * java projects when contacting this API)
 *
 * @author bertrand.hieronymus
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto implements Serializable {

    private String message;

    private List<String> details;

}
