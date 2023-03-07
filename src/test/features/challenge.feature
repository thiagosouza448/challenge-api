#language:pt

@usuarios
Funcionalidade: Usuarios

  Contexto: Servico : usuarios
    Dado que eu acesso tenha usuarios cadastrados

  @addUser
  Cenario: Adicionar um novo usuario
    Quando  eu faco uma requisicao POST para usuarios
    Entao  o codigo de status da resposta deve ser "201"
    E valido a resposta do usuario criado

  @uniqueUser
  Cenario: Listar um unico usuario
    Quando  Faco uma requisicao GET na api para o usuario "1"
    Entao  o codigo de status da resposta deve ser "200"

  @allUsers
  Cenario: Listar todos os usuarios
    Dado eu faco uma requisicao GET para usuarios
    Entao o codigo de status da resposta deve ser "200"
    E o corpo da resposta deve ser uma lista de usuários validos

  @UserNotFound
  Cenario: Verificar codigo de status para usuario inexistente
    Quando  Faco uma requisicao GET na api para o usuario "100"
    Entao  o codigo de status da resposta deve ser "404"

   @userUpdate
  Cenario: Update de um usuario
    Quando eu faco uma requisicao PUT para usuario "1"
    Entao  o codigo de status da resposta deve ser "200"
    E valido a resposta do usuario criado

