//package dto;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//
//import com.juanantonio.app.entity.User;
//
//public class UserDTO {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id // esto es que el id va a ser de tipo id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	//para el mapeo a nuestra base de datos
//	@NotBlank //para que no se puedan meter datos en blanco
//	@Column( length = 50)
//	private String name;
//
//	@NotBlank
//	@Column( length = 50)
//	private String surname;
//
//	@NotBlank
//	@Column (name="mail", nullable = false, length = 50, unique = true)
//	private String email;
//
//	private boolean enabled;
//	
//	public static User from(UserDTO source) {
//		return new User(source.getusersId(), source.getusers)
//	}
//
//}
