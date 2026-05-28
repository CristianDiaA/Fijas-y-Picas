package usu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private int intentos=0;
    private String numeroG;
    private String nombre;
    private int tiempo=0;

}
