package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.domain.Tecnico;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Prioridade;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Status;
import com.jessicaoliveira.CentralDeServicos.dtos.OSDTO;
import com.jessicaoliveira.CentralDeServicos.repositories.OSRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class OsServiceTest {

    public static final Integer ID = 1;
    public static final String OBSERVACOES = "Trocar componentes";
    public static final Prioridade PRIORIDADE = Prioridade.ALTA;
    public static final Status STATUS = Status.ANDAMENTO;

    @InjectMocks
    private  OsService osService;

    @Mock
    private OSRepository osRepository;

    @Mock
    private TecnicoService tecnicoService;

    @Mock
    private ClienteService clienteService;

    private OS os;
    private OSDTO osdto;
    private Tecnico tecnico;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tecnico = new Tecnico(1, "Valdir Cezar", "592.864.340-30", "(98)98698-1896");
        cliente = new Cliente(3, "Betina Campos", "842.464.790-47","(74)99154-1907");
        os = new OS(ID, PRIORIDADE, OBSERVACOES, STATUS, tecnico, cliente);
        osdto = new OSDTO(ID, OBSERVACOES, PRIORIDADE.getCod(), STATUS.getCod(), tecnico.getId(), cliente.getId());
    }

    @Test
    void whenFindByIdThenReturnOsInstance() {
        when(osRepository.findById(anyInt())).thenReturn(Optional.of(os));

        OS foundOS = osService.findById(ID);

        assertNotNull(foundOS);
        assertEquals(OS.class, foundOS.getClass());
        assertEquals(ID, foundOS.getId());
        verify(osRepository, times(1)).findById(ID);
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }
}