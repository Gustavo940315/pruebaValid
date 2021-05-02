package co.com.clients.router;

public class RouterConsts {

	/*
	 * Controller
	 */
	public static final String INITIAL_PATH = "clients/v1";
	public static final String POST_MAPPING_SAVE_CLIENT = "clients/save";
	public static final String POST_MAPPING_UPDATE_CLIENT = "clients/update";
	public static final String GET_MAPPING_FINDALL_CLIENT = "clients/all";
	
	/*
	 * Exceptions
	 */
	public static final String EXCEPTION_FINDALL_CLIENT = "No se pudo consultar los registros de la base de datos";
	public static final String EXCEPTION_SAVE_CLIENT = "No se pudo guarda la informacion del cliente";
	public static final String EXCEPTION_UPDATE_CLIENT = "No se puedo actualizar la informacion del cliente";
	public static final String EXCEPTION_FINDBYID_CLIENT = "No se puedo consultar el cliente en la base de datos";
	public static final String EXCEPTION_BAD_RQ_CLIENT = "Los campos nombre o/y apellido vienen vacios o nulos";
	public static final String EXCEPTION_BAD_RQ_CLIENT_ID = "El ID del cliente no puede ser 0";
	public static final String EXCEPTION_FINDBYID_CLIENT_BD = "No se encontro el ID del cliente en la Base de Datos";

}
