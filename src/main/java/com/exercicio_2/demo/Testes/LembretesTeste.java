package com.exercicio_2.demo.Testes;
import com.exercicio_2.demo.Entiny.LembreteEntiny;
import com.exercicio_2.demo.Services.LembreteServices;
import com.exercicio_2.demo.Repository.LembreteRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class LembretesTeste {

    @Autowired
    private LembreteServices lembreteServices;

    @MockBean
    LembreteRepository lembreteRepository;

    @BeforeEach
    void insertData(){
        LembreteEntiny lembreteEntiny = new LembreteEntiny();
        lembreteEntiny.setLembrete("MSGmsgSGM");

        Mockito.when(lembreteRepository.save(Mockito.any(LembreteEntiny.class)))
                .thenReturn(lembreteEntiny);
    }
    @Test
    public void cadastrarTest(){
        LembreteEntiny novolembrete = new LembreteEntiny();
        novolembrete.setLembrete("MSGmsgSGM");

        LembreteEntiny lembreteEntiny = lembreteServices.cadastrar(novolembrete);
        assertEquals("MSGmsgSGM", lembreteEntiny.getLembrete());
    }


    @Test
    public void testLembreteVazio() {
        // Crie um lembrete vazio (ou seja, com lembrete = "")
        LembreteEntiny lembreteVazio = new LembreteEntiny();
        lembreteVazio.setLembrete("");

        Mockito.when(lembreteRepository.save(Mockito.any(LembreteEntiny.class))).thenReturn(lembreteVazio);

        LembreteEntiny lembreteEntiny = lembreteServices.cadastrar(lembreteVazio);

        assertTrue(lembreteEntiny.getLembrete().isEmpty());
    }
}


}
