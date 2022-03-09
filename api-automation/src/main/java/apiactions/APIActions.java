package apiactions;

import io.restassured.response.Response;
import org.json.JSONObject;

public class APIActions {

    public Response apiPostSimulacoes(JSONObject bodyParams) {


        String endpointPath = "simulacoes";
        Response response = APIMethods.postMethod(endpointPath, bodyParams);
        return response;
    }

// ---------------------------------------------------------------------------------------------------


    public Response apiGetCpf(String cpfNumber) {
        String endpointPath = "restricoes/" + cpfNumber;
        Response response = APIMethods.getMethod(endpointPath);
        return response;
    }

    public Response apiGetSimulacoes() {
        String endpointPath = "simulacoes";
        Response response = APIMethods.getMethod(endpointPath);
        return response;
    }

    public Response apiGetSimulacoesCpf(String cpf) {
        String endpointPath = "simulacoes/" + cpf;
        Response response = APIMethods.getMethod(endpointPath);
        return response;
    }

// ---------------------------------------------------------------------------------------------------

    public Response apiPutCpf(String cpfNumber, JSONObject bodyParams) {
        String endpointPath = "simulacoes/" + cpfNumber;
        Response response = APIMethods.putMethod(endpointPath, bodyParams);
        return response;
    }

// ---------------------------------------------------------------------------------------------------

    public Response apiDeleteSimulacoes(String idNumber) {
        String endpointPath = "simulacoes/" + idNumber;
        Response response = APIMethods.deleteMethod(endpointPath);
        return response;
    }


}
