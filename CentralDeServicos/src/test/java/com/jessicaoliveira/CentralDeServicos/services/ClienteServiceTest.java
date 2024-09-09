package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.domain.Pessoa;
import com.jessicaoliveira.CentralDeServicos.dtos.ClienteDTO;
import com.jessicaoliveira.CentralDeServicos.repositories.ClienteRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.PessoaRepository;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.DataIntegratyViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    public static final String CPF_JA_CADASTRADO_NA_BASE_DE_DADOS = "CPF já cadastrado na base de dados!";
    public static final int ID = 1;
    public static final String NOME = "Betina Campos";
    public static final String CPF = "842.464.790-47";
    public static final String TELEFONE = "(74)99154-1907";
    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    private Cliente cliente;

    private ClienteDTO clienteDTO;

    //Inicializa os mocks e cria objetos de teste
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente(ID, NOME, CPF, TELEFONE);
        clienteDTO = new ClienteDTO();
        clienteDTO.setNome(NOME);
        clienteDTO.setCpf(CPF);
        clienteDTO.setTelefone(TELEFONE);
    }


    @Test
    void whenFindByIdThenReturnClientOfId() {
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));

        Cliente foundClient = clienteService.findById(ID);

        assertNotNull(foundClient);
        assertEquals(Cliente.class, foundClient.getClass());
        assertEquals(ID, foundClient.getId());
    }

    @Test
    void whenFindAllThenReturnAll() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

        List<Cliente> clientes = clienteService.findAll();

        assertNotNull(clientes);
        assertEquals(Cliente.class, clientes.get(0).getClass());
        assertEquals(ID, clientes.size());
    }

    @Test
    void whenCreateThenReturnAClient() {
        when(pessoaRepository.findByCPF(anyString())).thenReturn(null);
        when(clienteRepository.save(any())).thenReturn(cliente);

        Cliente createdCliente = clienteService.create(clienteDTO);

        assertNotNull(createdCliente);
        assertEquals(Cliente.class, createdCliente.getClass());
        assertEquals(NOME, createdCliente.getNome());
    }

    @Test
    void whenUpdateThenReturnAClient() {
        // Cliente existente no banco
        Cliente existingCliente = new Cliente(ID, "Atualizar Nome", CPF, TELEFONE);
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(existingCliente));
        when(pessoaRepository.findByCPF(anyString())).thenReturn(null);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(existingCliente);

        Cliente updatedCliente = clienteService.update(ID, clienteDTO);

        assertNotNull(updatedCliente);
        assertEquals(NOME, updatedCliente.getNome());
        assertEquals(CPF, updatedCliente.getCpf());
        assertEquals(TELEFONE, updatedCliente.getTelefone());
    }


    @Test
    void whenDeleteThenReturnSuccess() {
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));

        clienteService.delete(ID);

        verify(clienteRepository, times(ID)).deleteById(anyInt());
    }

    // Testes Exceptions

    @Test
    void whenCreateThenThrowExceptionForExistingCPF() {
        Cliente existingPessoa = new Cliente();
        existingPessoa.setId(ID);
        when(pessoaRepository.findByCPF(anyString())).thenReturn(existingPessoa);

        DataIntegratyViolationException thrown = assertThrows(
                DataIntegratyViolationException.class,
                () -> clienteService.create(clienteDTO),
                "Esperava-se que create() lançasse DataIntegratyViolationException, mas isso não aconteceu"
        );

        assertTrue(thrown.getMessage().contains(CPF_JA_CADASTRADO_NA_BASE_DE_DADOS));
    }

    @Test
    void whenUpdateThenThrowExceptionForExistingCPF() {
        Cliente existingPessoa = new Cliente();
        existingPessoa.setId(2);
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));
        when(pessoaRepository.findByCPF(anyString())).thenReturn(existingPessoa);

        DataIntegratyViolationException exception = assertThrows(
                DataIntegratyViolationException.class,
                () -> clienteService.update(ID, clienteDTO),
                "Esperava-se que update() lançasse DataIntegratyViolationException, mas isso não aconteceu"
        );

        assertTrue(exception.getMessage().contains(CPF_JA_CADASTRADO_NA_BASE_DE_DADOS));
    }


    @Test
    void whenDeleteThenThrowExceptionForClientWithOrders(){
        Cliente clientWithOrders = mock(Cliente.class);
        OS ordersOfService = new OS();
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(clientWithOrders));
        when(clientWithOrders.getList()).thenReturn(Arrays.asList(ordersOfService));

        DataIntegratyViolationException exception = assertThrows(
                DataIntegratyViolationException.class, () -> clienteService.delete(ID),
                "Esperava-se que delete() lançasse DataIntegratyViolationException, mas isso não aconteceu"
        );

        assertTrue(exception.getMessage().contains("Pessoa possui Ordens de Serviço, não pode ser deletado!"));
    }
}