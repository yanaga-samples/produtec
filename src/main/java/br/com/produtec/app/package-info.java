@TypeDefs({
		@TypeDef(name = "dateTime", typeClass = DateTimeUserType.class, defaultForType = DateTime.class),
		@TypeDef(name = "estadoPedido", typeClass = EstadoPedidoUserType.class, defaultForType = EstadoPedido.class),
		@TypeDef(name = "percentual", typeClass = PercentualUserType.class, defaultForType = Percentual.class),
		@TypeDef(name = "quantidade", typeClass = QuantidadeUserType.class, defaultForType = Quantidade.class)
})
package br.com.produtec.app;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;

import br.com.produtec.app.pedido.EstadoPedido;
import br.com.produtec.app.pedido.EstadoPedidoUserType;
import br.com.produtec.app.percentual.Percentual;
import br.com.produtec.app.percentual.PercentualUserType;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeUserType;
import br.com.produtec.app.usertype.DateTimeUserType;

