package com.example.cats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
public class CatServiceTest {

    @Mock
    CatRepository catRepo;

    @Test
    public void getCatById () throws Exception {

        CatService catService = new CatService(catRepo);

        Optional<Cat> cat = Optional.of(new Cat().withId(1).withName("Boots"));

        when(catRepo.findById(1L)).thenReturn(cat);

        Cat foundCat = catService.findById(1);

        assertThat(foundCat).isEqualTo(cat.get());

        verify(catRepo).findById(1L);

    }

    @Test
    public void getCatByIdNotFound() {
        CatService catService = new CatService(catRepo);

        Optional<Cat> cat = Optional.empty();

        when(catRepo.findById(1L)).thenReturn(cat);

        assertThrows(CatNotFoundException.class, () -> {
            Cat foundCat = catService.findById(1);
        });

        verify(catRepo).findById(1L);
    }

}
