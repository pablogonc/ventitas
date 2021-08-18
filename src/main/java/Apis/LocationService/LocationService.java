package Apis.LocationService;

import Apis.LocationService.dto.LocationResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.store.Ubicacion;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class LocationService {

    public Ubicacion getUbicacion(String direccion) throws Exception {

        WebClient client = WebClient.create("https://geocode.search.hereapi.com/v1/geocode");

        ObjectMapper objectMapper = new ObjectMapper();

        MultivaluedMap<String , String > headers = new MultivaluedHashMap<>();


        Response response = client
                .headers(headers)
                .query("q",direccion+", Argentina")
                .query("apikey","6Kaz7SdLzmzPxG7dziGOyBQImtiXdkRQ7BvWTFrEsQY")
                .get();

        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);
        switch (status){
            case 200:
                return  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(responseBody, LocationResponse.class).detalles.get(0).getubicacion();

            case 400:
                throw new Exception("Error: offset no valido");
            case 401:
                throw new Exception("Error: acceso no autorizado");
            default:
                throw new Exception("Error en la llamada a /api/hogares");
        }

    }

}
