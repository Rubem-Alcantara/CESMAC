#Bibliotecas
from time import sleep
import os
from modulos import *

#Vetor
valores = [0, 4.50, 5.10, 3.49, 25.00]

#Sistema
inicio()
sleep(0.5)

while True:
    menu()
    try:
        opcao = int(input('\nEscolha o produto que deseja comprar: '))
        quantidade = int(input('Digite a quantidade de unidades do produto: '))
        valor_total = valores[opcao] * quantidade
    except IndexError:
        print('Opcão digitada é invalida!!')
        sleep(1)
        os.system('cls')
        continue
    valor_cliente = float(input('Digite o valor em Reais dado pelo cliente: '))
    troco = (valor_cliente - valor_total)

    if valor_cliente >= valor_total:
        print(f'\nSe o cliente pagar a compra com R$ {valor_cliente} e comprar {quantidade} unidades de um produto no valor de R$ {valores[opcao]}')
        print(f'O troco devolvido a ele será de R$ {troco:.2f}\n')
        sleep(1)
        encerramento()
        sleep(2.5)
        break
    else:
        inicio()
        print('Quantidade em Reais insuficiente, insira um novo valor!')
        sleep(2)
        os.system('cls')
    
