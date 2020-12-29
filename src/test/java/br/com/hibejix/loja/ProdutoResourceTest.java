package br.com.hibejix.loja;

import br.com.hibejix.loja.domain.Produto;
import br.com.hibejix.loja.util.DatabaseLifeCycle;
import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifeCycle.class)
public class ProdutoResourceTest {

    @Test
    @DataSet("ds-produtos.yml")
    @DBUnit(caseSensitiveTableNames = true, escapePattern = "\"?\"")
    public void testUm() {
        Assert.assertEquals(1, Produto.count());
    }

}