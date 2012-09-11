package br.com.produtec.app.notafiscal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import br.com.produtec.app.usertype.ImmutableUserType;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class EstadoNotaFiscalUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	private static final BiMap<EstadoNotaFiscal, String> valueMap =
			ImmutableBiMap.of(EstadoNotaFiscal.FATURADA, "F",
			EstadoNotaFiscal.CANCELADA, "C");

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.CHAR };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return EstadoNotaFiscal.class;
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
		}
		else {
			st.setString(index, valueMap.get(value));
		}
	}

}