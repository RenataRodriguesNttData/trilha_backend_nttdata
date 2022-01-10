# Desafio 2


**Letra a)** Programação Orientada a Objetos trata se de um paradigma, um modelo de análise, projeto e programação que se baseia em tentar aproximar o mundo real do mundo virtual, através da criação e interação entre objetos, atributos, códigos, métodos, entre outros. O criador da programação orientada a objetos foi Alan Kay, por volta de 1970, segundo Kay, “o computador ideal deveria funcionar como um organismo vivo, isso é, cada célula se relaciona com outras a fim de alcançar um objetivo, mas cada uma funciona de forma autônoma. As células poderiam também reagrupar-se para resolver outro problema, ou desempenhar outras funções”. Durante suas atividades, ele idealizou a criação de um aparelho chamado Dynabook. Era uma espécie de tablet com teclado físico (isso em plena década de 70). Para que o Dynabook se tornasse realidade, era necessário o desenvolvimento de uma linguagem de programação por meio da qual pudesse ser construído o sistema do aparelho.
Foi então que surgiu a primeira linguagem de programação orientada a objetos: o Smalltalk. A linguagem de POO de Alan Kay foi a primeira a contar com os conceitos de classes, objetos, atributos e métodos. a POO estipula que tudo é um objeto.

Seus pilares são: 

1 - Abstração- Responsável por criar a identidade do objeto, que deve ser unica dentro do projeto. Característica do objeto, que se trata das propriedades do objeto e Ações que o objeto irá executar, chamadas de métodos, que são variadas depedendo do tipo de situação ocorrida.

2 - Encapsulamento - O encapsulamento é uma técnica que adiciona segurança à aplicação em uma programação orientada a objetos, o encapsulamento é implementado através de getters e setters, responsáveis por retornar e setar o valor da propriedade, adicionando camadas de proteção ao objeto.

3 - Herança - o reuso de código é uma de suas vantagens de destaque e ela se dá por herança. Essa característica otimiza a produção da aplicação em tempo e linhas de código,por exemplo, a criança herda diretamente do pai e indiretamente do avô e do bisavô. Em programação, a lógica é similar. Assim, os objetos filhos herdam as características e ações de seus ancestrais.

4 - Polimorfismo - O poliformismo permite herdar um método de classe pai e atribuir uma nova implementação para o método pré-definido.


**Letra b)**  A abstração é o ponto inicial para a criação de programas utilizando POO. Nesse momento que extraimos as características para criarmos um objeto. Exemplo: Um software para administrar as contas de clientes em um banco, as propriedades seriam, nome, número da conta, número da agência, cpf, saldo e os métodos seriam sacar dinheiro, depositar, transferir,pagar contas.

**Letra c)** Encapsular os dados significa evitar que estes sofram acessos indevidos. Para isso, é criada uma estrutura que contém métodos que podem ser utilizados por qualquer outra classe, sem causar inconsistências no desenvolvimento de um código, isso é feito por meio de dois métodos: os getters e os setters. O getters tem o objetivo de retornar o valor que lhe foi pedido, mas de forma que não prejudica a integridade do dado em si, já o setters recebe como argumento uma informação, que pode ser qualquer tipo de dado suportado pela linguagem.Exemplo: seguindo com o exemplo da conta bancária, usando os atributos nome e saldo e o método depositar.o novo saldo será o somatório entre o valor atual mais o depósito acrescido de 10%,se os atributos puderem ser acessados diretamente em qualquer trecho do código, haverá o risco de o saldo ser alterado sem passar pelo método de depositar. Para evitar isso, podemos usar os métodos get e set para evitar o acesso direto,para proteger as variáveis nome e saldo, utilizamos os métodos get saldo e set saldo. Antes disso, no entanto, é preciso alterar o nível de acesso das variáveis de pública para privada. 


**Letra d)** A herança permite criar uma nova classe a partir de uma já existente,também chamada de subclasses, provém da subclasse,classe recém-criada que contém atributos e métodos da "classe mãe". A principal vantagem da herança é a capacidade para definir novos atributos e métodos para a subclasse, que se somam aos atributos e métodos herdados. Exemplo: uma classe base que serviria como um modelo genérico pode ser a classe Conta com os campos Nome e cpf. Já uma classe derivada poderia ser Conta2 com os campos Nome e cpf herdados da classe Conta1, acrescido do campo saldo.


**Letra e)** Polimorfismo como um princípio a partir do qual as classes derivadas de uma única classe base são capazes de invocar os métodos que, embora apresentem a mesma assinatura, comportam-se de maneira diferente para cada uma das classes derivadas. Exemplo: a classe cliente1 e Cliente2 são objetos de um banco, mas o saldo deles podem ser somados de forma diferentes. 

**Letra f)** As vantagens de POO são: 

- POO permite representar melhor o mundo real em  programas. Praticamente tudo no mundo pode ser descrito como um conjunto de propriedades e ações, que é exatamente como os objetos são organizados. Ao representar melhor o mundo, os programas POO podem resolver melhor os problemas reais.

- Os programas POO são mais fáceis de ler e entender. Como não precisa escrever as propriedades e ações para cada personagem, os programas ficam muito mais curtos, isso os torna mais fáceis de ler e entender.

- Pode ser mais rápido programar com POO. POO facilita a reutilização de objetos em outros programas. Em vez de criar código a partir do zero, pode-se usar um objeto ou método existente e alterá-lo para se adequar ao programa.

- É mais fácil criar grandes programas. Como a POO ajuda a eliminar o código desnecessário, é mais fácil criar programas maiores e mais complexos.

- Os programas POO são mais fáceis de modificar e manter. Com a POO é fácil fazer alterações nos objetos existentes,também pode se usar objetos existentes para criar novos objetos com pequenas modificações.
