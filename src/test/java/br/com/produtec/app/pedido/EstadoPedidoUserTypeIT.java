package br.com.produtec.app.pedido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.config.ProdutecConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
public class EstadoPedidoUserTypeIT {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Test
	public void test() throws SQLException {
		Pedido pedido = Pedido.newPedido(123);
		pedido.estadoPedido = EstadoPedido.PARCIALMENTE_FATURADO;
		entityManager.persist(pedido);

		@SuppressWarnings("deprecation")
		Connection connection = entityManager.unwrap(Session.class).connection();
		PreparedStatement pst = connection.prepareStatement("select estado_pedido from Pedido where id = ?");
		pst.setLong(1, pedido.getId());
		ResultSet rs = pst.executeQuery();
		assertTrue(rs.next());
		String value = rs.getString(1);
		assertEquals("S", value);
	}

}