@TypeDefs({
		@TypeDef(name = "dateTime", typeClass = DateTimeUserType.class, defaultForType = DateTime.class),
		@TypeDef(name = "quantidade", typeClass = QuantidadeUserType.class, defaultForType = Quantidade.class)
})
package br.com.produtec.app;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;

import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeUserType;
import br.com.produtec.app.usertype.DateTimeUserType;
