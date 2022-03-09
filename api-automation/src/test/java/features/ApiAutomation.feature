#language: pt

@TestesApi
Funcionalidade: Testar a API de simulações completamente

  @ValidarInserirSimulacao
  Esquema do Cenário: Validar a inserção de simulação
    Dado que eu tenho uma simulacao
    Então cadastro um "<nome>" e "<cpf>" e "<email>" e "<valor>" e "<parcelas>" e "<seguro>" e "<status>"

    Exemplos:
      | nome   | cpf            | email                 | valor    | parcelas | seguro | status |
      | Danilo | 12345678909    | dan@dan.com           | 3000.00  | 3        | false  | 201    |
      | Jose   | 12345678909    | sicreditestes@dan.com | 4000.00  | 5        | true   | 409    |
      | Danilo | 123.456.789-01 | dan@dan.com           | 2000.00  | 3        | true   | 400    |
      | Danilo | 12345678901    | dandan.com            | 2000.00  | 3        | true   | 400    |
      | Danilo | 12345678901    | dan@dan.com           | 999.99   | 3        | false  | 400    |
      | Danilo | 12345678901    | dan@dan.com           | 42000.01 | 3        | true   | 400    |
      | Danilo | 12345678901    | dan@dan.com           | 2000.01  | 1        | false  | 400    |
      | Danilo | 12345678901    | dan@dan.com           | 2000.01  | 49       | true   | 400    |
      | Danilo | 12345678901    | dan@dan.com           | 2000.01  | 4        | teste  | 400    |

  @ConsultaTodasSimulacoesExistentes
  Esquema do Cenário: Validar a consulta de todas as simulacoes
    Dado que consulto todas as simulacoes
    Entao sistema retorna "<status>"

    Exemplos:
      | status |
      | 200    |

  @ConsultaCpfRestricao
  Esquema do Cenário: Validar a consulta de cpf com restrições
    Dado que consulto cpf com restricoes
    Entao sistema realiza a consulta do "<cpf>" restrito e "<status>"

    Exemplos:
      | cpf         | status |
      | 97093236014 | 200    |
      | 60094146012 | 200    |
      | 84809766080 | 200    |
      | 62648716050 | 200    |
      | 26276298085 | 200    |
      | 01317496094 | 200    |
      | 55856777050 | 200    |
      | 19626829001 | 200    |
      | 24094592008 | 200    |
      | 58063164083 | 200    |
      | 12345678909 | 204    |

  @ConsultaCpfSimulacao
  Esquema do Cenário: Validar a consulta de cpf em simulação
    Dado que consulto cpf de uma simulacao
    Entao sistema realiza a consulta do "<cpf>" na simulacao e "<status>"

    Exemplos:
      | cpf         | status |
      | 12345678909 | 200    |
      | 17822386035 | 404    |


  @AlteracaoSimulacao
  Esquema do Cenário: Validar a alteração de uma simulação
    Dado que realizo uma alteracao
    Entao altero um "<nome>" e "<cpf>" e "<email>" e "<valor>" e "<parcelas>" e "<seguro>" e "<status>"

    Exemplos:
      | nome    | cpf         | email         | valor    | parcelas | seguro | status |
      | Danilo  | 12345678901 | dandan.com    | 2000.00  | 3        | true   | 400    |
      | Danilo  | 12345678901 | dan@dan.com   | 999.99   | 3        | false  | 400    |
      | Danilo  | 12345678901 | dan@dan.com   | 42000.01 | 3        | true   | 400    |
      | Danilo  | 12345678901 | dan@dan.com   | 2000.01  | 1        | false  | 400    |
      | Danilo  | 12345678901 | dan@dan.com   | 2000.01  | 49       | true   | 400    |
      | Danilo  | 12345678901 | dan@dan.com   | 2000.01  | 4        | teste  | 400    |
      | Cleiton | 12345678901 | clei@clei.com | 20000.03 | 40       | true   | 200    |
      | Danilo  | 12345678902 | dan@dan.com   | 2000.01  | 4        | true   | 404    |

  @DeletarSimulacao
  Esquema do Cenário: Validar a deleção de uma simulação
    Dado que realizo uma delecao
    Entao informo o "<id>" e "<status>"

    Exemplos:
      | id | status |
      | 35 | 204    |
      | 14 | 404    |

  @ConsultaTodasSimulacoesNaoExistentes
  Esquema do Cenário: Validar a consulta de todas as simulações não existentes
    Dado que consulto todas as simulacoes
    Entao sistema retorna "<status>"

    Exemplos:
      | status |
      | 404    |
