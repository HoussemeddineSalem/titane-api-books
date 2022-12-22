package dev.titane.apibooks.utils;

import dev.titane.apibooks.entities.Book;
import dev.titane.apibooks.models.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jsr330")
public interface BookMapper {

    Book toDAO(BookDTO bookDTO);

    BookDTO toDTO(Book book);

    @Mapping(target = "id", ignore = true)
    void updateDAO(BookDTO bookDTO, @MappingTarget Book book);
}
