# Desafio 8

**Letra a)** Uma exception é uma ocorrência anormal que afeta o funcionamento da aplicação,um evento não esperado que ocorre no sistema quando está em tempo de execução (Runtime). Geralmente quando o sistema captura alguma exceção o fluxo do código fica interrompido, o conceito de exceção foi o mecanismo criado para que o seu programa simplesmente não fosse finalizado ao encontrar problemas em sua execução.

**Letra b)** O conjunto de blocos Try-Catch-Finally é o recurso, à nivel de linguagem de programação, criado para tratar exceções. Este conjunto atua capturando as possíveis exceções em seu código e, com o objetivo de impedir fluxos inesperados, ele mesmo determina o que fazer na ocorrência de exceções.O bloco catch,coloca o tratamento para a exceção que eventualmente ocorra no bloco try. Vale destacar que não necessariamente a exceção ocorrerá mas, caso ela ocorra, o seu código tratará a mesma e evitará comportamentos inesperados e o o bloco finally representa o trecho de código que será executado independente do fato de ter ocorrido a exceção ou não.

**Letra c)** A função do throw é lançar a exceção para o método chamador, ou seja, leva o erro adiante.A relação com os métodos  é levar o erro para ser tratado no try, catch e finally.

**Letra d)** Serve para poder manipular exceções disparadas por métodos de mapeamento (@RequestMapping) do mesmo controller. Tais métodos podem:

-Tratar exceções sem a anotação @ResponseStatus (tipicamente exceções pré-definidas que você não criou)

-Redirecionar o usuário para uma página de erro própria

-Criar uma resposta ao erro totalmente personalizada.


**Letra e)** Serve para repassar a mesma exceção para frente e, dessa forma, outro trecho de código poderá capturar e saber o que vai fazer com a exceção original retendo todas as informações necessárias com o stack trace.


**Letra f)** A annotation serve para permitir usar exatamente as mesmas técnicas de manipulação de exceções mas aplica-las por toda a aplicação, não apenas à controllers individuais.Qualquer classe anotada com @ControllerAdvice torna-se um avido de controller e três tipos de métodos são suportados:

-Método de manipulação de anotações anotados com @ExceptionHandler.

-Método de melhoramento do Modelos (para adicionar dados adicionais ao modelo), anotados com
@ModelAttribute. 

-Método de inicialização de capa (binder – usados para configuração da manipulação de formulários) anotados com
@InitBinder.



