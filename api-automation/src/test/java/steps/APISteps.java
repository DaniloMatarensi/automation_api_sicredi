package steps;

import apiactions.APIActions;
import io.cucumber.java.bs.I;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.sl.In;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import tests.APITests;

public class APISteps {
    APIActions apiActions = new APIActions();
    APITests apiTests = new APITests();
    private Response responseBody;

    @Dado("que eu tenho uma simulacao")
    public void que_eu_tenho_uma_simulacao() {
        System.out.println("pass");
    }

    @Entao("cadastro um {string} e {string} e {string} e {string} e {string} e {string} e {string}")
    public void entao_cadastro_simulacao(String nome, String cpf, String email, String valor, String parcelas, String seguro, String status) {

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("nome", nome);
        bodyParams.put("cpf", cpf);
        bodyParams.put("email", email);
        bodyParams.put("valor", Double.parseDouble(valor));
        bodyParams.put("parcelas", Integer.parseInt(parcelas));
        bodyParams.put("seguro", Boolean.parseBoolean(seguro));

        responseBody = apiActions.apiPostSimulacoes(bodyParams);
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }
// ---------------------------------------------------------------------------------------------------


    @Dado("que consulto todas as simulacoes")
    public void que_consulto_todas_as_simulacoes() {
        System.out.println("pass");
    }

    @Entao("sistema retorna {string}")
    public void entaoCadastroSimulacao(String status)
    {
        responseBody = apiActions.apiGetSimulacoes();
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }
// ---------------------------------------------------------------------------------------------------

    @Dado("que consulto cpf com restricoes")
    public void que_consulto_com_restricoes() {
        System.out.println("pass");
    }

    @Entao("sistema realiza a consulta do {string} restrito e {string}")
    public void consulta_cpf_restrito(String cpf, String status)
    {
        responseBody = apiActions.apiGetCpf(cpf);
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }

// ---------------------------------------------------------------------------------------------------

    @Dado("que consulto cpf de uma simulacao")
    public void que_consulto_cpf_de_simulacao() {
        System.out.println("pass");
    }

    @Entao("sistema realiza a consulta do {string} na simulacao e {string}")
    public void consulta_cpf_simulacao(String cpf, String status)
    {
        responseBody = apiActions.apiGetSimulacoesCpf(cpf);
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }

// ---------------------------------------------------------------------------------------------------

    @Dado("que realizo uma alteracao")
    public void que_realizo_uma_alteracao() {
        System.out.println("pass");
    }

    @Entao("altero um {string} e {string} e {string} e {string} e {string} e {string} e {string}")
    public void entao_altero_simulacao(String nome, String cpf, String email, String valor, String parcelas, String seguro, String status) {

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("nome", nome);
        bodyParams.put("cpf", cpf);
        bodyParams.put("email", email);
        bodyParams.put("valor", Double.parseDouble(valor));
        bodyParams.put("parcelas", Integer.parseInt(parcelas));
        bodyParams.put("seguro", Boolean.parseBoolean(seguro));

        responseBody = apiActions.apiPutCpf(cpf, bodyParams);
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }

// ---------------------------------------------------------------------------------------------------

    @Dado("que realizo uma delecao")
    public void que_realizo_delecao() {
        System.out.println("pass");
    }

    @Entao("informo o {string} e {string}")
    public void informo_id(String id, String status)
    {
        responseBody = apiActions.apiDeleteSimulacoes(id);
        apiTests.CompareStatus(Integer.parseInt(status), responseBody);
    }

}
