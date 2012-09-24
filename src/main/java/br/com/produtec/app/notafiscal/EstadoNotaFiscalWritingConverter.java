package br.com.produtec.app.notafiscal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@WritingConverter
public class EstadoNotaFiscalWritingConverter implements Converter<EstadoNotaFiscal, String> {

	private static final BiMap<EstadoNotaFiscal, String> valueMap = ImmutableBiMap.of(EstadoNotaFiscal.FATURADA, "F",
			EstadoNotaFiscal.CANCELADA, "C");

	@Override
	public String convert(EstadoNotaFiscal source) {
		return valueMap.get(source);
	}

}