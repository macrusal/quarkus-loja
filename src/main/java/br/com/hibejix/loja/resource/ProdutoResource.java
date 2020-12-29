package br.com.hibejix.loja.resource;

import br.com.hibejix.loja.domain.Produto;
import br.com.hibejix.loja.domain.dto.ProdutoDTO;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Optional;

/**
 * @author macrusal on 29/12/20
 * @project quarkus-loja
 */
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    @Tag(name = "produto")
    public List<Produto> get() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    @Tag(name = "produto")
    public Response post(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.nome = dto.nome;
        produto.valor = dto.valor;
        produto.persist();
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Tag(name = "produto")
    public void put(@PathParam("id") Long id, ProdutoDTO dto) {
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        if(produtoOptional.isEmpty()) {
            throw new NotFoundException("Produto não existe");
        }
        Produto produto = produtoOptional.get();
        produto.nome = dto.nome;
        produto.valor = dto.valor;
        produto.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Tag(name = "produto")
    public void delete(@PathParam("id") Long id) {
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        produtoOptional.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException("Produto não existe");
        });
    }
}
