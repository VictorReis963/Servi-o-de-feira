# ferrmentas utilizadas
* JDK (Java Development Kit):	O motor de toda a aplicação Java. Contém o compilador (javac) e a máquina virtual (java/JVM). Java 21.0.9-ms, utilizada para a compilação e execução.

* SDKMAN!:	Gerenciador de Versões de SDKs.	Ferramenta que gerencia a versão do Java 21 no  ambiente Codespace.

# expicação 
O projeto utiliza uma Stack de Desenvolvimento (Pilha de Desenvolvimento) que combina ferramentas de nuvem, gerenciamento de versões e o kit de desenvolvimento Java.

Esta stack garante que, mesmo em um ambiente de desenvolvimento remoto (como o Codespace), o código seja compilado, empacotado e executado corretamente, encontrando todos os arquivos de recurso (.csv).

O compilador javac do JDK é responsável por traduzir seu algoritmo em uma linguagem que a máquina virtual entende.


# Tutorial de Execução para Teste da Aplicação
Para testar a aplicação corretamente,precisamos garantir que o compilador e a JVM saibam onde encontrar o código e os recursos.

Assumindo que você estamos agora no diretório raiz do projeto (o nível onde estão as pasta src e o README ), siga os passos no seu terminal:


# 1. Limpa compilações anteriores (opcional, mas recomendado)
* Este comando compila todos os seus arquivos .java e coloca os resultados (.class) na pasta classes.

rm -rf classes
mkdir classes

# 2. Compila todos os arquivos Java
# javac -d [Diretório de Saída] -cp [Classpath para dependências] [Arquivos .java]
javac -d classes -cp . src/main/java/br/com/frutasemcasa/**/*.java

find src/main/java -name "*.java" > sources.txt
javac -d classes -cp . @sources.txt


* Passo 3 : Execução com Classpath (O Teste Final)
Este é o passo que interliga a execução do java com a localização do  algoritmo e dos dados CSV. O uso do dois-pontos (:) é obrigatório para ambientes Linux (Codespace).


# O comando diz à JVM para procurar classes na pasta 'classes' E recursos em 'src/main/resources'
java -cp classes:src/main/resources br.com.frutasemcasa.Main
O que o -cp faz:
classes: É o local onde a JVM encontra o Bytecode (.class).

src/main/resources: É o local onde a JVM encontra os arquivos de recurso (Plano.csv, Produto.csv), conforme o  DataLoader espera.

Se a execução for bem-sucedida, você verá a saída completa do caso de uso, confirmando que todos os componentes da stack funcionaram em conjunto.
