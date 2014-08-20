Programação Concorrente
======================

ATPS

ETAPA 1 (tempo para realização: 5 horas)
 * Aula-tema: Revisão sobre Sistemas Operacionais. Conceitos básicos de sistemas operacionais e multiprogramação. Processos concorrentes.

Passo 2 (Equipe)
Escolher qual deverá ser a linguagem de programação que será utilizada, bem como estimar alguns parâmetros iniciais de concorrência. 
Para isso, deverão ser criados agentes baseados em thread nas linguagens __C e Java__ que consumam, de um buffer de __5000 posições previamente preenchido__ (ou seja, será implementado apenas o consumidor), cada um dos 
pedidos (um struct na implementação em C e um objeto na implementação em Java). 


O consumidor eliminará continuamente os pedidos do buffer e seu tempo de processamento será simulado por uma pausa de __10000 milissegundos__. Ao final de cada processamento, deverá ser preenchido um log com a __identificação da thread__, a __identificação do pedido__, o horário de __início__ e o horário de __término__ do processamento. Quando o buffer estiver esgotado, as threads serão bloqueadas. Por ora, não há a necessidade de se preocupar com a exclusão mútua necessária entre os diversos consumidores.

Passo 3 (Equipe)

Fazer um experimento no qual sejam __iniciadas quantidades distintas de threads simultâneas (1, 10, 50, 100, 500, 1000)__. Para cada uma dessas quantidades, faça 10 execuções – até que o buffer esteja vazio - e armazenem o tempo de execução para uma delas. Criar uma __tabela__ na qual conste o __tempo de cada um dos testes__ para as duas linguagens e o __tempo médio__ para cada quantidade. Fazer ainda um __quadro de resumo__ comparativo no qual constem os __tempos médios de execução__ para cada quantidade de threads e o __tempo de desenvolvimento__ por linguagem. Por fim, traçar um gráfico dos tempos médios e as quantidades de threads.
