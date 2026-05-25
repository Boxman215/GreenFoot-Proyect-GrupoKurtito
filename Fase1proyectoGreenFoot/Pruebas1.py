# =========================
# VIDEOJUEGO SIMPLE
# =========================

# Variables del jugador
vida = 100
puntos = 0

# Función principal
def iniciar_juego():
    global vida, puntos

    print("¡Bienvenido al juego!")

    while vida > 0:
        mostrar_estado()

        opcion = input("\n¿Qué deseas hacer? (explorar/salir): ")

        if opcion.lower() == "explorar":
            explorar()

        elif opcion.lower() == "salir":
            print("Gracias por jugar.")
            break

        else:
            print("Opción no válida.")

# Mostrar información
def mostrar_estado():
    print("\n===== ESTADO =====")
    print("Vida:", vida)
    print("Puntos:", puntos)

# Acción de explorar
def explorar():
    global vida, puntos

    print("\nExplorando...")

    # Aquí puedes agregar enemigos, tesoros, eventos, etc.
    puntos += 10

    print("¡Encontraste un tesoro!")
    print("+10 puntos")

# Iniciar el juego
iniciar_juego()