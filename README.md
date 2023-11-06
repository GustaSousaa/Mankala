# Jogo Kalah em Java

Este é um jogo Kalah simples implementado em Java. O jogo segue as regras padrão do Kalah, onde dois jogadores competem para capturar mais sementes que o adversário.

## Regras do Jogo

O jogo Kalah segue as seguintes regras gerais:

- O tabuleiro possui 6 casas (cavas) para cada jogador e 2 silos (armazéns) no final.
- No início, cada cava tem 4 sementes, e os silos estão vazios.
- Cada jogador move sementes de uma de suas cavas para as cavas seguintes no sentido anti-horário.
- Se a última semente cair no silo do jogador, ele ganha outra jogada.
- Se a última semente cair em uma cava vazia do jogador, ele captura todas as sementes da cava oposta e as coloca em seu silo.
- O jogo termina quando um dos jogadores não tem mais sementes em suas cavas. O jogador com mais sementes em seu silo vence. Em caso de empate, não há vencedor.

## Estrutura do Projeto

A aplicação é dividida em várias classes:

- `Jogo`: A classe principal que controla o jogo, a vez dos jogadores e as regras do Kalah.
- `Fazenda`: Representa o tabuleiro do jogo, incluindo cavas e silos.
- `Cava`: Representa as cavas no tabuleiro.
- `Silo`: Representa os silos dos jogadores.
- `Semente`: Uma classe simples que representa as sementes.
- `Fazendeiro`: Representa os jogadores do jogo.

## Requisitos do Projeto

A aplicação atende aos seguintes requisitos:

- RF-1) A aplicação mostra o estado do tabuleiro (as casas e os armazéns de cada jogador, o número de sementes em cada casa e armazém, e a vez do jogador) e aguarda uma jogada do jogador. O jogador deve escolher uma das casas do seu lado do tabuleiro que tenha pelo menos uma semente.
- RF-2) Se o jogador escolher uma casa válida, a aplicação pega todas as sementes dessa casa e as distribui uma a uma nas casas seguintes, no sentido anti-horário.
- RF-3) Se a última semente cair no armazém do jogador, ele ganha outra jogada. Se a última semente cair em uma casa vazia do seu lado do tabuleiro, ele captura todas as sementes da casa oposta e as coloca no seu armazém.
- RF-4) O jogo termina quando um dos jogadores não tiver mais sementes no seu lado do tabuleiro. Nesse caso, o outro jogador coloca todas as sementes restantes no seu armazém. O vencedor é o jogador que tiver mais sementes no seu silo. Em caso de empate, não há vencedor.
- RF-5) A aplicação deve validar a jogada. Isso é: ela deve verificar se o jogador fez uma jogada válida de acordo com as regras e se aquela era de fato sua vez de jogar.

## Como Jogar

1. Compile o código Java.

2. Execute o jogo a partir da classe `Jogo`.

3. Siga as instruções no console para fazer as jogadas. Você deve escolher uma cava válida (com pelo menos uma semente) quando for sua vez.

4. O jogo continuará até que uma das condições de término seja atendida: um jogador não tem mais sementes em suas cavas.

5. O vencedor é o jogador com mais sementes em seu silo. Em caso de empate, não há vencedor.

## Personalização

Este é um jogo Kalah básico e pode ser personalizado e aprimorado conforme necessário. Você pode adicionar funcionalidades adicionais, como interface gráfica, regras personalizadas ou inteligência artificial para jogar contra o computador.

## Contribuições

Se você deseja contribuir para este projeto, sinta-se à vontade para fazer um fork e enviar um pull request. Estamos abertos a melhorias e novas funcionalidades.

## Autores

- [Enzo Maneira]

