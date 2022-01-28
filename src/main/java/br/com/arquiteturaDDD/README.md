# Desafio 9

**Letra a)** Trata se de uma solução geral para um problema que ocorre com frequência dentro de um determinado contexto no projeto de software. Um padrão de projeto não é um projeto finalizado que pode ser diretamente transformado em código fonte ou de máquina, ele é uma descrição ou modelo (template) de como resolver um problema que pode ser usado em muitas situações diferentes.

**Letra b)**

- Os padrões de criação são aqueles que abstraem e/ou adiam o processo criação dos objetos.
  Um exemplo: Builder é um padrão de projeto de software criacional que permite a separação da construção de um objeto complexo da sua representação, de forma que o mesmo processo de construção possa criar diferentes representações.

- Os padrões estruturais se preocupam com a forma como classes e objetos são compostos para formar estruturas maiores.
  Exemplo:  Um proxy, em sua forma mais geral, é uma classe que funciona como uma interface para outra coisa. O proxy pode fazer interface com qualquer coisa: uma conexão de rede, um grande objeto na memória, um arquivo ou algum outro recurso caro ou impossível de duplicar.

- Os padrões de comportamento se concentram nos algoritmos e atribuições de responsabilidades entre os objetos.
  Exemplo:Em Orientação a Objetos, é um padrão GOF cuja principal função é evitar a dependência entre um objeto receptor e um objeto solicitante.

**Letra c)** A arquitetura de software representa a estrutura ou as estruturas do sistema, que consiste em componentes de software, propriedades externamente visíveis dos componentes e os relacionamentos entre eles.Essa estruturação, apesar de parecer trabalhosa para profissionais não habituados a ela, visa facilitar a organização dos componentes e melhorar a flexibilidade e portabilidade do sistema, gerando muito mais facilidade de manutenção,um código bem estruturado e organizado facilita a criação de interfaces bem definidas com componentes e funcionalidades já testados, permitindo o reúso de código e melhorando a assistência, já que possíveis alterações tendem a ficar restritas àquele trecho de código.

**Letra d)** Nesse projeto até o momento estamos utilizando a arquitetura em camadas, pois os componentes de uma  são organizados em camadas horizontais onde cada uma desempenha um papel específico na aplicação.

**Letra g)** SOLID é um acrônimo dos cinco primeiros princípios da programação orientada a objetos e design de código identificados por Robert C. Martin (ou Uncle Bob) por volta do ano 2000. O acrônimo SOLID foi introduzido por Michael Feathers, após observar que os cinco princípios poderiam se encaixar nesta palavra.

S = SRP = Principio da Responsabilidade Única, Uma classe deve ter um, e somente um, motivo para mudar.

O = OCP= Princípio Aberto-Fechado, Você deve ser capaz de estender um comportamento de uma classe, sem modificá-lo.

L = LSP	= Princípio da Substituição de Liskov, As classes base devem ser substituíveis por suas classes derivadas.

I = ISP = Princípio da Segregação da Interface, Muitas interfaces específicas são melhores do que uma interface única.

D = DIP = Princípio da inversão da dependência, Dependa de uma abstração e não de uma implementação.

**Letra h)** Foram usados os principios, single Responsability Principle, já que cada classe no projeto tem apenas uma razão para alterar seu estado, ou seja, cumpre uma única função, services implementam a lógica da aplicação, repositório geram a herança das propriedades necessárias para persistência no banco de dados, controllers expõe os endpoints e assim por diante. Também utilizamos o princípio da substituição de Liskov, já que os DTOs, classes drevidas das nossas entidades, foram passados ao invés das entidades elas mesmas durante o desafio 6 sem maiores problemas.No caso das nossas interfaces estendendo o JPA repository estamos instanciando o principio aberto-fechado.


