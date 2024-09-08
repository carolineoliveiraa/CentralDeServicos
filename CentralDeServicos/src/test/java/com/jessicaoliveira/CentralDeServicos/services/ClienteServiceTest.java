package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.dtos.ClienteDTO;
import com.jessicaoliveira.CentralDeServicos.repositories.ClienteRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.PessoaRepository;
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
        cliente = new Cliente(1, "Betina Campos", "842.464.790-47", "(74)99154-1907");
        clienteDTO = new ClienteDTO();
        clienteDTO.setNome("Betina Campos");
        clienteDTO.setCpf("842.464.790-47");
        clienteDTO.setTelefone("(74)99154-1907");
    }


    @Test
    void whenFindByIdThenReturnClientOfId() {
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));

        Cliente foundClient = clienteService.findById(1);

        assertNotNull(foundClient);
        assertEquals(Cliente.class, foundClient.getClass());
        assertEquals(1, foundClient.getId());
    }

    @Test
    void whenFindAllThenReturnAll() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

        List<Cliente> clientes = clienteService.findAll();

        assertNotNull(clientes);
        assertEquals(Cliente.class, clientes.get(0).getClass());
        assertEquals(1, clientes.size());
    }

    @Test
    void whenCreateThenReturnAClient() {
        when(pessoaRepository.findByCPF(anyString())).thenReturn(null);
        when(clienteRepository.save(any())).thenReturn(cliente);

        Cliente createdCliente = clienteService.create(clienteDTO);

        assertNotNull(createdCliente);
        assertEquals(Cliente.class, createdCliente.getClass());
        assertEquals("Betina Campos", createdCliente.getNome());
    }

    @Test
    void whenUpdateThenReturnAClient() {
        // Cliente existente no banco
        Cliente existingCliente = new Cliente(1, "Atualizar Nome", "842.464.790-47", "(74)99154-1907");
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(existingCliente));
        when(pessoaRepository.findByCPF(anyString())).thenReturn(null);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(existingCliente);

        Cliente updatedCliente = clienteService.update(1, clienteDTO);

        assertNotNull(updatedCliente);
        assertEquals("Betina Campos", updatedCliente.getNome());
        assertEquals("842.464.790-47", updatedCliente.getCpf());
        assertEquals("(74)99154-1907", updatedCliente.getTelefone());
    }


    @Test
    void whenDeleteThenReturnSuccess() {
        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));

        clienteService.delete(1);

        verify(clienteRepository, times(1)).deleteById(anyInt());
    }
}