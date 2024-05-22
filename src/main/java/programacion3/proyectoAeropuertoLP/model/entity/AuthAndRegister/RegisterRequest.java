package programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String email;
    private String nickname;
    private String password;
}

