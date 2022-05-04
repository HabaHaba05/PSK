package mif.vu.mappers;

import mif.vu.dtos.CreateAuthorDto;
import mif.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorMappers {
    public Author CreateAuthorDtoToAuthor(CreateAuthorDto dto){
        Author author = new Author();
        author.setName(dto.name);
        return author;
    }
}
