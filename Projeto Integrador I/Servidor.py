# import socket
from socket import *

host = 'localhost'
port = 50000

print(f'HOST: {host}, PORT {port}')

servidor = socket(AF_INET, SOCK_STREAM)
servidor.bind((host, port))
servidor.listen(1)

(con, adr) = servidor.accept()
print(f'Cliente {adr} se conectou')

#Variaveis
logado = False
opcao = 0
valor = 0
valorCliente = 0
falha ='' 
soma = 0
formato = 'utf-8'
#Validação de login
while True:


    while logado == False:
        login = con.recv(1024).decode()
        senha = con.recv(1024).decode()
        if (login == '12345678910' and senha == 'senha@teste'):
            logado = True
            sucesso = ('Logado com sucesso')
            con.send(sucesso.encode(formato))
        if (login != '12345678910' and senha != 'senha@teste'):
            falha = 'falha'
            con.send(falha.encode(formato))
            soma = soma + 1
        if (soma == 3):
                break
    #Recebendo e validando informações do cliente
    while logado == True:
        opcao = con.recv(1024).decode(formato)
        opcao = int(opcao)

        if opcao == 1:
            valor = con.recv(1024).decode(formato)
            valor = float(valor)
            valorCliente = valor + valorCliente
            con.send(str(valorCliente).encode(formato))
        if opcao == 2:
            valor = con.recv(1024).decode(formato)
            valor = float(valor)
            falha = valorCliente - valor
            if falha > 0:
                valorCliente = falha
                con.send(str(valorCliente).encode(formato))
            else:
                con.send(str(falha).encode(formato))
        elif opcao == 3:
            servidor.close()
            break
        
            





