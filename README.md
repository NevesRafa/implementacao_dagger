<h1>Projeto Implementação Dagger2 Android com SQLite Room e Kotlin</h1>

<h2>Funcionalidades</h2>
<ul>
  <li>Utilização do Dagger2 para a injeção de dependências em toda a aplicação;</li>
  <li>Implementação do SQLite Room para persistência de dados;</li>
  <li>Utilização da linguagem Kotlin;</li>
  <li>Implementação da arquitetura Clean.</li>
</ul>

<p>Este projeto tem como objetivo fornecer um exemplo simples de como utilizar Dagger2 em um projeto Android com a linguagem Kotlin, além de demonstrar como integrar o SQLite Room em uma aplicação Android.</p>

<h2>Estrutura do projeto</h2>
<p>O projeto segue a arquitetura Clean, estando estruturado em três camadas:</p>
<ul>
  <li><strong>domain</strong>: contém os casos de uso e as entidades de negócio;</li>
  <li><strong>data</strong>: responsável por conter as classes e interfaces relacionadas à persistência de dados, utilizando o SQLite Room, bem como as implementações dos repositórios definidos na camada de domínio;</li>
  <li><strong>presentation</strong>: contém as classes relacionadas à interface com o usuário, como as atividades, adaptadores e view models, além das interfaces de entrada e saída.</li>
</ul>

<p>Além das camadas mencionadas, o projeto também possui o pacote <strong>di</strong>, contendo as classes relacionadas à configuração do Dagger2.</p>
