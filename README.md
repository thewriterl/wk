# wk
Teste Para WK Technology - Cálculo IMC

Para rodar o projeto:


		GIT CLONE este repo
    
    
		na raíz do projeto -> mvn install -DskipTests
    
    
		crie um banco de dados MySQL chamado IMC para o usuário root e sem senha
    
          Rode o projeto normalmente, como se roda um projeto spring boot


TROUBLESHOOTING:

	caso queria trocar nome do banco de dados: 
			
			
			altere o campo *spring.datasource.url*  do arquivo application.properties para jdbc:mysql://localhost:3306/{novo nome desejado}
