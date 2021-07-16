package com.marcos.ciss;

import com.marcos.ciss.repository.FuncionarioRepository;
import com.marcos.ciss.resource.FuncionarioResource;
import com.marcos.ciss.service.FuncionarioService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(FuncionarioResource.class)
@AutoConfigureMockMvc
public class FuncionarioResourceIntegrationTest {

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @MockBean
    private FuncionarioService funcionarioService;

    @MockBean
    private ApplicationEventPublisher publisher;

    @MockBean
    private FuncionarioResource funcionarioResource;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listarFuncionarios() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/funcionarios")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void buscarFuncionarioPeloId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/funcionarios/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void removerFuncionario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/funcionarios/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void salvarFuncionarioValido() throws Exception {
        String funcionario = "{\"nome\": \"marcos\", \"sobrenome\" : \"daniel\", \"email\" : \"marcos.mdbbr@gmail.com\", \"numeroNis\" : \"05245856325\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/funcionarios").content(funcionario)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void salvarFuncionarioInvalido() throws Exception {
        String funcionario = "{\"nome\": \"marcos\", \"sobrenome\" : \"\", \"email\" : \"marcos.mdbbr@gmail.com\", \"numeroNis\" : \"05245856325\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/funcionarios").content(funcionario)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
