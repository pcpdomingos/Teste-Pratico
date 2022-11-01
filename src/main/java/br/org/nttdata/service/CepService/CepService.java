package br.org.nttdata.service.CepService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import br.org.nttdata.model.Endereco;
import br.org.nttdata.model.ModelCliente;
import br.org.nttdata.repository.ClienteRepository;
import br.org.nttdata.repository.EnderecoRepository;

@Service
public class CepService {
	
	private final static String VIA_CEP_URL = "https://viacep.com.br/ws/";
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public String consultarAPI(String cep) throws IOException {
		
		String urlParaChamada = VIA_CEP_URL + cep + "/json";
		String rep = "";

        URL url = new URL(urlParaChamada);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();


        BufferedReader respostaViaCep = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        ObjectMapper mapper = new ObjectMapper();
        rep = respostaViaCep.lines().collect(Collectors.joining());
        Endereco emp2 = mapper.readValue(rep, Endereco.class);
        

        while (respostaViaCep.ready()) {
        	rep = respostaViaCep.lines().collect(Collectors.joining());
        }
        
        System.out.println(emp2.getBairro());

        return rep;
	} 
	
	public Endereco consultarAPIRetornandoEndereco(String cep) throws IOException {
		
		String urlParaChamada = VIA_CEP_URL + cep + "/json";
		String rep = "";

        URL url = new URL(urlParaChamada);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();


        BufferedReader respostaViaCep = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        ObjectMapper mapper = new ObjectMapper();
        rep = respostaViaCep.lines().collect(Collectors.joining());
        Endereco emp2 = mapper.readValue(rep, Endereco.class);
        

       

        return emp2;
	}
	
	public void cadastrarEndereco(String cep, String email)
	{
		try {
			Endereco endereco = consultarAPIRetornandoEndereco(cep);
			ModelCliente cliente = clienteRepository.findByEmail(email);
			
			endereco.setCliente(cliente);
			enderecoRepository.save(endereco);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}


