package br.com.produtec.app.pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import static br.com.produtec.app.pedido.EstadoPedido.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import br.com.produtec.app.usertype.ImmutableUserType;

public class EstadoPedidoUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	private static final BiMap<EstadoPedido, String> valueMap = ImmutableBiMap.of(ABERTO, "A", CANCELADO, "C",
			PARCIALMENTE_CANCELADO, "P", FATURADO, "F", PARCIALMENTE_FATURADO, "S");

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.CHAR };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return EstadoPedido.class;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		if (rs.wasNull()) {
			return null;
		}
		return valueMap.inverse().get(rs.getString(names[0]));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.CHAR);
		} else {
			st.setString(index, valueMap.get(value));
		}
	}

}