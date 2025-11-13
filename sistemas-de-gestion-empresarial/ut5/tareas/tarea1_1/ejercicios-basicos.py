import math

# ================================
# EJERCICIOS BÁSICOS DE PYTHON
# ================================

# EJERCICIO 1
# Pide dos números enteros al usuario y muestra la suma y la división entera del primero entre el segundo.
def ejercicio_1():
    value_a = int(input("Inserte el primer número... "))
    value_b = int(input("Inserte el segundo número... "))
    print(f"La suma de {value_a} + {value_b} = {value_a + value_b}")
    print(f"La división de {value_a} / {value_b} = {value_a // value_b}")
# ejercicio_1()

# EJERCICIO 2
# Pide un número entero y muestra si es positivo, negativo o cero usando if, elif y else.
def ejercicio_2():
    value = int(input("Inserte el numero... "))
    if (value > 0):
        print(f"{value} es un número positivo")
    elif(value < 0):
        print(f"{value} es un número negativo")
    else:
        print("El valor es 0")
# ejercicio_2()

# EJERCICIO 3
# Pide el nombre y la comida favorita de una persona y muestra:
# "<nombre> quiere comer <comida>" usando .format().
def ejercicio_3():
    name = input("Inserte su nombre... ")
    favourite_food = input("Inserte su comida favorita... ")
    result = "{} quiere comer {}".format(name, favourite_food)
# ejercicio_3()

# EJERCICIO 4
# Pide una palabra y muestra su primer carácter y su último carácter usando índices.
def ejercicio_4():
    word = input("Dame una palabra... ")
    print(f"El primer caracter de la palabra '{word}' es '{word[0]}' y el último es '{word[-1]}'")
# ejercicio_4()

# EJERCICIO 5
# Crea una lista vacía, agrega los números 1, 2 y 3 con append. Luego elimina el último con pop y muestra la lista antes y después.
def ejercicio_5():
    values = []
    print(f"Lista antes de añadir valores -> {values}")
    values.append(1)
    values.append(2)
    values.append(3)
    print(f"Lista antes del pop -> {values}")
    values.pop()
    print(f"Lista después del pop -> {values}")
# ejercicio_5()

# EJERCICIO 6
# Dada la lista [10, 20, 30, 40, 50, 60], muestra:
# - Los elementos del índice 1 al 2
# - Desde el índice 2 al final
# - La lista invertida
def ejercicio_6():
    values = [10, 20, 30, 40, 50, 60]
    print(f"Elementos del indice 1 al 2: {values[1:3]}")
    print(f"Elementos desde el índice 2 hasta el final: {values[2:]}")
    print(f"Lista invertida: {values[::-1]}")
# ejercicio_6()

# EJERCICIO 7
# Pide un número al usuario y comprueba si está dentro de la lista [3, 6, 9, 12].
def ejercicio_7():
    allowed_values = [3, 6, 9, 12]
    value = int(input("Dame un número... "))
    result = "está en la lista" if value in allowed_values else "no está en la lista"
    print(f"El número {value} {result} {allowed_values}")
# ejercicio_7()

# EJERCICIO 8
# Declara a = 5 y b = 10. Intercambia sus valores sin usar una variable auxiliar.
def ejercicio_8():
    a = 5
    b = 10
    print(f"Antes del cambio -> {a=}, {b=}")
    a, b = b, a
    print(f"Después del cambio -> {a=}, {b=}")
# ejercicio_8()

# EJERCICIO 9
# Crea un diccionario con claves "nombre", "edad" y "ciudad". 
# Pide una clave al usuario y muéstrala usando get. Si no existe, muestra "Clave no encontrada".
def ejercicio_9():
    person = {
        "nombre": "Jesús",
        "edad": "23 casi 24 (cumplo en una semana c:<)",
        "ciudad": "Los Realejos"
    }
    person_key = input("¿Qué deseas saber de esta persona? (nombre|edad|ciudad) -> ").lower().strip()
    print(person.get(person_key, "Clave no encontrada"))
# ejercicio_9()

# EJERCICIO 10
# Dado a = {1, 2, 3, 4} y b = {3, 4, 5, 6}, muestra su intersección, unión y diferencia.
def ejercicio_10():
    a = {1, 2, 3, 4}
    b = {3, 4, 5, 6}
    print(f"Intersección: {a.intersection(b)}")
    print(f"Unión: {a.union(b)}")
    print(f"Diferencia de A: {a.difference(b)}")
    print(f"Diferencia de B: {b.difference(a)}")
# ejercicio_10()

# EJERCICIO 11
# Dada la lista ["perro", "gato", "ratón"], recórrela y muestra "<animal> es un mamífero".
def ejercicio_11():
    animals = ["perro", "gato", "ratón"]
    for animal in animals:
        print(f"{animal} es un mamífero")
# ejercicio_11()

# EJERCICIO 12
# Imprime los números del 0 al 5 usando range.
def ejercicio_12():
    for num in range(6):
        print(num)
# ejercicio_12()

# EJERCICIO 13
# Imprime los números del 1 al 5 usando un bucle while.
def ejercicio_13():
    num = 1
    while num <= 5:
        print(num)
        num += 1
# ejercicio_13()

# EJERCICIO 14
# Pide un número y muestra su inverso (1/n). 
# Si el usuario introduce 0, captura la excepción y muestra un mensaje de error.
def ejercicio_14():
    value = int(input("Dame un número... "))
    try:
        print(f"Su inverso es {1 / value}")
    except:
        print("ERROR: El número es 0")
# ejercicio_14()

# EJERCICIO 15
# Define una función suma(a, b) que devuelva la suma de ambos. 
# Pide valores al usuario y muestra el resultado.
def ejercicio_15():
    def suma(a: int, b: int) -> int:
        return a + b

    value_a = int(input("Inserte el primer valor... "))
    value_b = int(input("Inserte el segundo valor... "))
    values_sum = suma(value_a, value_b)
    print(f"La suma de {value_a} + {value_b} = {values_sum}")
# ejercicio_15()

# EJERCICIO 16
# Crea una función sumar_todo(*numeros) que devuelva la suma de todos los argumentos recibidos.
def ejercicio_16():
    def sumar_todo(*values: int) -> int:
        return sum(values)
    print(f"La suma de 2 + 4 + 7 = {sumar_todo(2, 4, 7)}")
    print(f"La suma de 2 + 1 + 6 + 1 = {sumar_todo(2, 1, 6, 1)}")
    print(f"La suma de 1 + 1 = {sumar_todo(1, 1)}")
# ejercicio_16()

# EJERCICIO 17
# Usa filter y una lambda para obtener los números mayores que 5 de la lista [3, 4, 5, 6, 7].
def ejercicio_17():
    values = [3, 4, 5, 6, 7]
    filtered_values = list(filter(lambda v: v > 5, values))
    print(f"Los numeros mayores que 5 de {values} son {filtered_values}")
# ejercicio_17()

# EJERCICIO 18
# Genera una lista con el cuadrado de los números del 0 al 4 usando comprensión de listas.
def ejercicio_18():
    print([value**2 for value in range(5)])
# ejercicio_18()

# EJERCICIO 19
# Crea una clase Humano con atributo nombre y método decir(mensaje). 
# Crea un objeto y prueba el método.
class Human:
    def __init__(self, name):
        self.name = name

    def say(self, message: str):
        print(f"Hola, soy {self.name} y creo que {message}")

def ejercicio_19():
    me = Human("Jesus")
    me.say("Silksong debe ser candidato a GOTY")
# ejercicio_19()

# EJERCICIO 20
# Pide un número y muestra su raíz cuadrada y su valor redondeado hacia arriba usando math.sqrt y math.ceil.
def ejercicio_20():
    value = float(input("Dame un número... "))
    print(f"Su raiz cuadrada: {math.sqrt(value)}")
    print(f"Su valor redondeado hacia arriba: {math.ceil(value)}")
# ejercicio_20()

# EJERCICIO 21 
# Crea un programa que pida repetidamente el nombre y la nota de alumnos (0–10).
# Cuando se introduzca un nombre vacío:
#   - Muestra cuántos alumnos se registraron
#   - Calcula la nota media
#   - Muestra el alumno con mejor nota
#   - Muestra el alumno con peor nota
# Usa listas y/o diccionarios.
def ejercicio_21():
    students = []
    while True:
        name = input("Dame el nombre del estudiante (o dejalo en blanco para terminar el programa) -> ")
        if not name:
            break
        mark = int(input("Dame su nota -> "))
        students.append({ "name": name, "mark": mark })
    count = len(students)
    print(f"Hay {count} alumnos registrados.")
    avg_mark = sum(mark for mark in [student["mark"] for student in students]) / count
    print(f"La nota media es {avg_mark}")
    sorted_students_by_mark = sorted(students, key=lambda s: s['mark'], reverse=True)
    print(f"El estudiante con mejor nota es: {sorted_students_by_mark[0]["name"]}")
    print(f"El estudiante con peor nota es: {sorted_students_by_mark[-1]["name"]}")
# ejercicio_21()

# EJERCICIO 22 
# Pide al usuario una frase y:
#   1. Cuenta y muestra el número total de caracteres.
#   2. Cuenta y muestra el número de palabras.
#   3. Muestra cuántas veces aparece cada vocal (a, e, i, o, u).
#   4. Determina y muestra la palabra más larga.
def ejercicio_22():
    phrase = input("Dame una frase... ")
    print(f"La frase tiene {len(phrase)} caracteres.")
    words = phrase.split(" ")
    print(f"La frase tiene {len(words)} palabras.")
    vowels_ocurrencies = {}
    for char in phrase:
        if char.lower() in ["a", "e", "i", "o", "u"]:
            vowels_ocurrencies[char] = vowels_ocurrencies.get(char, 0) + 1
    print(f"La frequencia de vocales son: {vowels_ocurrencies}")
    sorted_words_by_length = sorted(words, key=lambda w: len(w), reverse=True)
    print(f"La palabra más larga de la frase es {sorted_words_by_length[0]}")
# ejercicio_22()

# EJERCICIO 23 
# Crear una clase CuentaBancaria con:
#   - Atributo titular
#   - Atributo saldo (inicia en 0)
#   - Método depositar(cantidad)
#   - Método retirar(cantidad)
#   - Método mostrar_informacion()
# El programa principal debe:
#   - Crear una cuenta
#   - Aceptar operaciones del usuario:
#       "d cantidad" para depositar
#       "r cantidad" para retirar
#       "salir" para terminar
#   - Al finalizar, mostrar el estado final de la cuenta.
class BankAccount:
    def __init__(self, titular, amount):
        self.titular = titular
        self.amount = amount
    
    def deposit(self, amount: int):
        self.amount += amount
    
    def withdraw(self, amount: int):
        self.amount -= amount
    
    def show_info(self):
        print(f"La cuenta de {self.titular} tiene un saldo de: {self.amount}")

def ejercicio_23():
    my_account = BankAccount("Jesus", 100)
    while True:
        print("Acciones del banco")
        print("Depositar - d <cantidad>")
        print("Retirar - r <cantidad>")
        print("Salir de la aplicacion - salir")
        operation = input("¿Qué desea realizar? -> ")
        if operation == "salir":
            break
        parts = operation.split(" ")
        match parts[0]:
            case "d":
                my_account.deposit(int(parts[1]))
            case "r":
                my_account.withdraw(int(parts[1]))
            case _:
                print("Operacion no reconocida")
    my_account.show_info()
# ejercicio_23()