package model.user;

import apis.Notificar;
import apis.NotificarXEMAIL;
import apis.NotificarXSMS;
import apis.NotificarXWPP;
import lombok.AllArgsConstructor;
import lombok.Data;
import model.sucursal.Ubicacion;

@Data
@AllArgsConstructor
public class Contacto {
    private String NombreDeUsuario;
    private Ubicacion ubicacion;
    private int telefono;
    private String mail;
    private Notificar medioDeNotificacion;

    public Contacto(String nombreDeUsuario, Ubicacion ubicacion, int telefono, String mail, String medioDeNotificacion) {
        NombreDeUsuario = nombreDeUsuario;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.mail = mail;

        switch (medioDeNotificacion) {
            case "mail":
                this.medioDeNotificacion = new NotificarXEMAIL();
                break;
            case "SMS":
                this.medioDeNotificacion = new NotificarXSMS();
                break;
            case "Wpp":
                this.medioDeNotificacion = new NotificarXWPP();
                break;
        }

    }

    public void notificar(){
        this.medioDeNotificacion.notificar(this);
    }

}
