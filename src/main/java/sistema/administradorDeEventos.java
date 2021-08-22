package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class administradorDeEventos {
    Map<String, List<Observador>> observadores = new HashMap<>();

    public administradorDeEventos(String... operationes) {
        for (String operacion : operationes) {
            this.observadores.put(operacion, new ArrayList<>());
        }
    }

    public void suscribir(String eventType, Observador observador) {
        List<Observador> users = observadores.get(eventType);
        users.add(observador);
    }

    public void desuscribir(String eventType, Observador observador) {
        List<Observador> users = observadores.get(eventType);
        users.remove(observador);
    }

    public void notificar(String tipoEvento,String... argumentos ) {
        List<Observador> usuarios = observadores.get(tipoEvento);
        for (Observador observador : usuarios) {
            observador.update(tipoEvento,argumentos);
        }
    }


}
