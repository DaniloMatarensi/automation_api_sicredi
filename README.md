# automation_api_sicredi
Teste Danilo Automation API Sicredi

Ao realizar o desenvolvimento da automação e executar, foi encontrado alguns bugs:

1 - As regras de negócio não estão funcionando, ex: permitiu cadastrar uma simulação com cpf com pontuação (POST).
2 - As regras de negócio não estão funcionando, ex: permitiu alterar uma simulação com valor abaixo de 1000 reais (PUT).
3 - O (DELETE) faz diversas vezes a mesma deleção de ID, deleta IDs inexistentes e isso diferente da regra de negócio.


![cpf com pontuacao](https://user-images.githubusercontent.com/20939192/157394053-78129220-37f9-4473-8986-cd3d9526efd5.PNG)
![cpf duplicado está retornando status errado](https://user-images.githubusercontent.com/20939192/157394070-9d70e8ee-3937-4744-89e5-b05862c7d7c0.PNG)
