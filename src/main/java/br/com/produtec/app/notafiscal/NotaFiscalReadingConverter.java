package br.com.produtec.app.notafiscal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@ReadingConverter
public class NotaFiscalReadingConverter implements Converter<String, EstadoNotaFiscal> {

	private static final BiMap<EstadoNotaFiscal, String> valueMap = ImmutableBiMap.of(EstadoNotaFiscal.FATURADA, "F",
			EstadoNotaFiscal.CANCELADA, "C");

	@Override
	public EstadoNotaFiscal convert(String source) {
		return valueMap.inverse().get(source);
	}

}
