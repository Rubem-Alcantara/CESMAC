from time import sleep
import os

def mercado():
    print('='*15)
    print('BIG BOM PREÇO')
    print('='*15)
def encerramento():
    print('='*34)
    print('Obrigado por ter comprado conosco')
    print('   O programa será encerrado   ')
    print('='*34)

input('Aperte "Enter", para iniciar o programa')
sleep(1)

while True:
    mercado()
    produto = float(input('Digite o valor do produto: '))
    quantidade = int(input('Digite a quantidade de unidades do produto: '))
    valor_cliente = float(input('Digite o valor em Reais dado pelo cliente: '))
    valor_total = produto * quantidade
    troco = (valor_total - valor_cliente)

    if valor_cliente >= valor_total:
        print(f'Se o cliente pagar a compra com uma nota de R$ {valor_cliente} e comprar {quantidade} unidades de um produto no valor de R$ {produto}')
        print(f'O troco devolvido a ele será de R$ {troco}')
        sleep(1)
        encerramento()
        sleep(3)
        break
    else:
        mercado()
        print('Quantidade de Reais insuficiente, insira um novo valor!')
        sleep(2)
        os.system('cls')

