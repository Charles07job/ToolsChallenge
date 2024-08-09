create table transacao(

    id BIGSERIAL not null PRIMARY KEY,
    cartao varchar(20) not null,
    valor varchar(100) not null,
    data_hora TIMESTAMP not null,
    estabelecimento varchar(100) not null,
    nsu varchar(100) null,
    codigo_autorizacao varchar(100) null,
    status_transacao varchar(100) null,
    tipo varchar(100) not null,
    parcelas varchar(2) not null
);