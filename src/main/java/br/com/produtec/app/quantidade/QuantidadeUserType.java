package br.com.produtec.app.quantidade;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import br.com.produtec.app.usertype.ImmutableUserType;

public class QuantidadeUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		BigDecimal value = rs.getBigDecimal(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		else {
			return QuantidadeFactory.INSTANCE.newQuantidade(value);
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.DECIMAL);
		}
		else {
			Quantidade quantidade = (Quantidade) value;
			st.setBigDecimal(index, quantidade.valor);
		}
	}

	@Override
	public Class<?> returnedClass() {
		return Quantidade.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.DECIMAL };
	}

}