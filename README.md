Programação Concorrente
======================

ATPS

ETAPA 1 (tempo para realização: 5 horas)
 * Aula-tema: Revisão sobre Sistemas Operacionais. Conceitos básicos de sistemas operacionais e multiprogramação. Processos concorrentes.

Passo 2 (Equipe)
Escolher qual deverá ser a linguagem de programação que será utilizada, bem como estimar alguns parâmetros iniciais de concorrência. 
Para isso, deverão ser criados agentes baseados em thread nas linguagens C e Java que consumam, de um buffer de 5000 posições previamente preenchido (ou seja, será implementado apenas o consumidor), cada um dos 
pedidos (um struct na implementação em C e um objeto na implementação em Java). 


O consumidor eliminará continuamente os pedidos do buffer e seu tempo de processamento será simulado por uma pausa de 10000 milissegundos. Ao final de cada processamento, 
deverá ser preenchido um log com a identificação da thread, a identificação do pedido, o 
horário de início e o horário de término do processamento. Quando o buffer estiver esgotado, 
as threads serão bloqueadas. Por ora, não há a necessidade de se preocupar com a exclusão 
mútua necessária entre os diversos consumidores.

Passo 3 (Equipe)

Fazer um experimento no qual sejam iniciadas quantidades distintas de threads simultâneas 

(1, 10, 50, 100, 500, 1000). Para cada uma dessas quantidades, faça 10 execuções – até que o 

buffer esteja vazio - e armazenem o tempo de execução para uma delas. Criar uma tabela na 

qual conste o tempo de cada um dos testes para as duas linguagens e o tempo médio para 

cada quantidade. Fazer ainda um quadro de resumo comparativo no qual constem os tempos 

médios de execução para cada quantidade de threads e o tempo de desenvolvimento por 

linguagem. Por fim, traçar um gráfico dos tempos médios e as quantidades de threads.