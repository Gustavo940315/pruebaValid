package co.com.clients.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientSaveRequestDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private boolean procesado;
	private String estado;
}
