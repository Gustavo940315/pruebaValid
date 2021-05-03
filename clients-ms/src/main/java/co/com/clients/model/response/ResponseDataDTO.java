package co.com.clients.model.response;

import java.util.List;

import co.com.clients.model.entity.ModelClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDataDTO {

	private List<ModelClientEntity> body;
    private String statusCode;
    private String statusCodeValue;

}
