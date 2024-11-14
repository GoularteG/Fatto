create table tarefas(
   id bigint not null auto_increment,
   nome VARCHAR(100) not null,
   custo DECIMAL(10, 2) not null,
   data_limite date,
   ordem_apresentacao int not null unique,

   primary key(id)
);