from re import I
from socket import *
import PySimpleGUI as sg

#IP / PORT para conectar com o servidor
host = 'localhost'
port = 50000

#Conexão com o Servidor
cliente = socket(AF_INET, SOCK_STREAM)
cliente.connect((host, port))

#Layout login

def login ():

    sg.theme('DarkAmber')
    layout = [

            [sg.Text('CPF', size = (11, 1), font=16)], 
            [sg.InputText(key= 'login', font=10)],
            [sg.Text('Senha', size =(8, 1), font=16)],
            [sg.InputText(key= 'senha', password_char= '*', font=10)],
            [sg.Button('Entrar'), sg.Button('  Sair  ')]
            ]

    return sg.Window('Cirius Bank', layout=layout, finalize=True)

def menu():

    sg.theme('DarkAmber')
    layout =[[sg.Text('Selecione a operação que deseja', size=(30, 1), font=16, justification='c')],
            [sg.Button('Depositar', size=(30, 1), font=16)],
            [sg.Button('Sacar', size=(30, 1), font=16)],
            [sg.Button('Ver Saldo', size=(30, 1), font=16)],
            [sg.Button('  Sair  ')]]

    return sg.Window('Cirius Bank', layout=layout, finalize=True)

def depositar():
    sg.theme('DarkAmber') 
    layout=[[sg.Text('Valor a ser depositado: ', size=(18,1), font=16)],
            [sg.Input(key= 'valorD', font=11)],
            [sg.Button('Confirmar'), sg.Button('Voltar')]]
    
    return sg.Window('Cirius Bank', layout=layout, finalize=True)

def sacar(): 
    sg.theme('DarkAmber')
    layout=[[sg.Text('Valor a ser sacado: ', size=(18,1), font=16)], 
            [sg.Input(key= 'valorS', font= 11)],
            [sg.Button('Confirmar'), sg.Button('Voltar')]]

    return sg.Window('Cirius Bank', layout=layout, finalize=True)


# Criar um loop de leitura de evento
janela1,janela2,janela3,janela4 = login(), None, None, None

#Variaveis
logado = False
opcao = 0
valorCliente = 0
falha ='' 
formato = 'utf-8'
while True:
    window,eventos,valores = sg.read_all_windows()
    # Quando queremos ir para próximo janela
    while logado == False:
        if window == janela1 and eventos == '  Sair  ' in eventos == sg.WINDOW_CLOSED:
                cliente.close()
                break
        if window == janela1 and eventos == 'Entrar':
            cliente.send(valores['login'].encode())
            cliente.send(valores['senha'].encode())

            msg = cliente.recv(1024).decode()

            if (msg == 'Logado com sucesso' or msg == 'sucesso'):
                sg.popup('Bem vindo ao Cirius Bank APP')
                logado = True
                janela2 = menu()
                janela1.hide()
            elif msg == 'falha':
                sg.popup('Falha na autenticação, tente novamente')
    # Comunicação entre cliente e servidor aceita:
    if logado == True:
            if window == janela2 and eventos == '  Sair  ' in sg.WINDOW_CLOSED:
                opcao = '3'
                cliente.send(opcao.encode(formato))
                break

            if window == janela2 and eventos == 'Depositar':
                opcao = '1'
                cliente.send(opcao.encode(formato))

                janela3 = depositar() 
                janela2.hide()

            if window == janela2 and eventos == 'Sacar':
                opcao = '2'
                cliente.send(opcao.encode(formato))
                janela4 = sacar()
                janela2.hide()

            if window == janela2 and eventos == 'Ver Saldo':
                valorCliente = float(valorCliente)
                sg.popup(f'O saldo disponível é: R$ {valorCliente:.2f}')

    if window == janela3 and eventos == 'Voltar':
        opcao = '0'
        cliente.send(opcao.encode(formato))
        valorCliente = cliente.recv(1024)
        janela3.hide()
        janela2.un_hide()

    if window == janela3 and eventos == 'Confirmar':
        cliente.send(valores['valorD'].encode(formato))
        valorCliente = cliente.recv(1024).decode(formato)
        valorCliente = float(valorCliente)
        sg.popup(f'O valor de R$ {valorCliente:.2f} depositado com sucesso')
        janela3.hide()
        janela2.un_hide()

    if window == janela4 and eventos == 'Voltar':
        opcao = '0'
        cliente.send(opcao.encode(formato))
        valorCliente = cliente.recv(1024)
        janela4.hide()
        janela2.un_hide()

    if window == janela4 and eventos == 'Confirmar':
        cliente.send(valores['valorS'].encode(formato))
        falha = cliente.recv(1024).decode(formato)
        falha = float(falha)
        if falha > 0:
            valorCliente = falha
            valorCliente = float(valorCliente)
            sg.popup(f'Saldo atualizado: R$ {valorCliente}')
            janela4.hide()
            janela2.un_hide()
        else:
            sg.popup('Saldo insuficiente, informe outro valor')
            opcao = '2'
            cliente.send(opcao.encode(formato))
    

        
        
        

