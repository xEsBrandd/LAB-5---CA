# Ejercicio-5
Elaboración del ejercicio 5: Polimorfismo vía herencia - UVG Card Battle (Temario A).

### Participantes:
- Brandón Endervy Fuentes Bautista - 26515.
- Alvaro Elias Flores Pardo - 261868.

### Requisitos Funcionales
- Se debe implementar una lista polimórfica que guarde los tipos de cartas.
- Al iniciar se cargan 10 cartas iniciales de distintos tipos.
- **Carta de Catedráticos:** Pertenecen a un departamento, tienen puntos de "llamadas de atención" y "tiempo de atención".
- **Carta de Materia:** Aportan créditos pero tienen niveles de dificultad.
- **Carta de Eventos Campus:** Efectos que afectan el tablero.
- Se comparten atributos: ID, nombre, costo de energía y descripción.
- Existe un método abstracto: `jugarCarta()` que dependiendo del tipo de carta tiene distintos efectos.
- Existe un menú en la terminal que muestra las opciones que puede hacer el usuario.
- Se presentan las cartas en la terminal con sus características para que lo vea el usuario.
- Se ordenan las cartas por el costo de energía. Y se debe usar una interfaz `Comparable`.

### Buenas Prácticas Necesarias
- Implementar herencia y polimorfismo.
- Usar overloading.
- Las clases deben tener encapsulación y métodos getters/setters.
- Override de métodos `toString` y de `equals`.

---

## Clases

### Carta
Sirve como clase abstracta que define la estructura base para todas las cartas del juego, permitiendo el uso de polimorfismo y la implementación de la interfaz `Comparable`.

#### Atributos
- **id: int, privado.** Identifica de forma única cada carta dentro del mazo.
- **nombre: String, privado.** Nombra a las cartas.
- **costoEnergia: int, privado.** Almacena el costo requerido al jugar.
- **descripcion: String, privado.** Texto que explica la carta.

#### Métodos
- **Carta(id: int, nombre: String, costoEnergia: int, descripcion: String): público.** Inicializar de forma controlada los atributos comunes heredados por las subclases.
- **jugarCarta(tablero: Tablero): void, abstracto, público.** Definir el método abstracto que obliga a cada subclase a implementar su efecto específico al interactuar con el tablero.
- **compareTo(otra: Carta): int, público.** Comparar instancias de cartas en función de su `costoEnergia` para habilitar el ordenamiento nativo.
- **toString(): String, público.** Escribe los datos de la carta en formato de texto.
- **getId(): int, público.** Otorgar acceso al atributo `id`.
- **getNombre(): String, público.** Otorgar acceso al atributo `nombre`.
- **getCostoEnergia(): int, público.** Otorgar acceso al atributo `costoEnergia`.
- **getDescripcion(): String, público.** Otorgar acceso al atributo `descripcion`.

---

### CartaCatedratico
Modelar el comportamiento y estado de las cartas asociadas a docentes universitarios, aplicando recargos o penalizaciones de atención en el tablero.

#### Atributos
- **departamento: String, privado.** Indicar el área a la que pertenece el catedrático.
- **llamadasAtencion: int, privado.** Almacenar la cantidad de llamados de atención que impone el catedrático al estudiante.
- **tiempoAtencion: int, privado.** Guardar los minutos o unidades de atención requeridos.

#### Métodos
- **CartaCatedratico(id: int, nombre: String, costoEnergia: int, descripcion: String, departamento: String, llamadasAtencion: int, tiempoAtencion: int): público.** Construir la instancia inicializando los atributos base mediante la superclase y asignando los propios de catedrático.
- **jugarCarta(tablero: Tablero): void, público.** Modificar el estado del tablero sumando las llamadas y el tiempo de atención acumulados.
- **toString(): String, público.** Convertir los datos completos de la carta de catedrático a formato de texto.

---

### CartaMateria
Representar asignaturas académicas que otorgan créditos y poseen dificultad.

#### Atributos
- **creditos: int, privado.** Determinar la cantidad de créditos que da la materia.
- **dificultad: int, privado.** Representar la exigencia académica que se suma al tablero.

#### Métodos
- **CartaMateria(id: int, nombre: String, costoEnergia: int, descripcion: String, creditos: int, dificultad: int): público.** Asignar el estado inicial de créditos y dificultad junto a los atributos heredados.
- **jugarCarta(tablero: Tablero): void, público.** Incrementar los créditos y ajustar la dificultad actual en el tablero.
- **toString(): String, público.** Presentar en texto detallado los créditos y la dificultad de la materia.

---

### CartaEventoCampus
Representar eventos globales o situaciones de la vida universitaria que alteran el entorno de juego.

#### Atributos
- **cambioEnergia: int, privado.** Valor numérico de energía que suma o resta el evento al tablero.
- **cambioDificultad: int, privado.** Alteración en el nivel de dificultad general provocada por el evento.

#### Métodos
- **CartaEventoCampus(id: int, nombre: String, costoEnergia: int, descripcion: String, cambioEnergia: int, cambioDificultad: int): público.** Constructor que inicializa los campos heredados de `Carta` y el efecto del evento.
- **jugarCarta(tablero: Tablero): void, público.** Modificar los recursos y parámetros globales del tablero según el evento.
- **toString(): String, público.** Generar el texto descriptivo del evento y sus modificaciones en el tablero.

---

### Tablero
Modela el estado global y las condiciones de la partida en el entorno virtual del juego.

#### Atributos
- **energiaDisponible: int, privado.** Almacena la cantidad actual de energía que el jugador puede gastar.
- **creditosAcumulados: int, privado.** Guarda el total de créditos académicos obtenidos a lo largo de la partida.
- **dificultadActual: int, privado.** Indica el nivel de dificultad o exigencia vigente en la partida.
- **llamadasAtencionAcumuladas: int, privado.** Mantiene la suma de llamadas de atención acumuladas.
- **tiempoAtencionAcumulado: int, privado.** Mantiene el total de tiempo de atención registrado.

#### Métodos
- **Tablero(energiaInicial: int): público.** Constructor que inicializa el tablero configurando la energía inicial y estableciendo los demás contadores en cero.
- **consumirEnergia(cantidad: int): boolean, público.** Evalúa si hay suficiente energía, la descuenta si es posible y retorna verdadero; de lo contrario, retorna falso sin modificar nada.
- **modificarEnergia(cantidad: int): void, público.** Aumenta o disminuye la energía disponible del tablero según el efecto aplicado.
- **agregarCreditos(cantidad: int): void, público.** Incrementa los créditos acumulados del jugador.
- **modificarDificultad(cantidad: int): void, público.** Ajusta el nivel de dificultad actual del tablero.
- **agregarLlamadasAtencion(cantidad: int): void, público.** Suma llamadas de atención al acumulado total del tablero.
- **agregarTiempoAtencion(cantidad: int): void, público.** Acumula tiempo de atención consumido.
- **toString(): String, público.** Devuelve un resumen formateado del estado actual de todos los indicadores del tablero.

---

### Mazo
Administra la colección polimórfica de cartas, permitiendo la búsqueda, el registro, el listado y el ordenamiento del catálogo.

#### Atributos
- **cartas: ArrayList\<Carta\>, privado.** Lista única polimórfica que almacena los diversos tipos de cartas registradas.

#### Métodos
- **Mazo(): público.** Constructor que inicializa la colección de cartas como un arreglo dinámico vacío.
- **cargarCartasIniciales(): void, público.** Registra al menos 10 cartas predefinidas de los distintos tipos al iniciar el programa.
- **agregarCarta(carta: Carta): void, público.** Agrega una nueva carta al mazo.
- **listarCartas(): List\<Carta\>, público.** Devuelve la lista completa de cartas guardadas.
- **buscarCarta(id: int): Carta, público.** Sobrecarga de método que busca y devuelve una carta coincidente con el ID proporcionado.
- **buscarCarta(nombre: String): Carta, público.** Sobrecarga de método que busca y devuelve una carta coincidente con el nombre indicado.
- **ordenarPorEnergia(): void, público.** Ordena las cartas contenidas en la lista en función de su costo de energía haciendo uso de `Comparable`.

---

### VistaConsola
Maneja la interacción con el usuario mediante la terminal, administrando la lectura de datos de entrada y el despliegue de salidas en texto.

#### Atributos
- **entrada: Scanner, privado.** Lector de consola para capturar las respuestas y comandos ingresados por el usuario.

#### Métodos
- **VistaConsola(): público.** Constructor que inicializa el objeto `Scanner` para la lectura de la terminal.
- **mostrarMenu(): void, público.** Muestra en pantalla el menú interactivo con las opciones disponibles.
- **leerEntero(mensaje: String): int, público.** Muestra un mensaje en consola, solicita un número entero y controla excepciones de formato.
- **leerTexto(mensaje: String): String, público.** Muestra un mensaje en consola y retorna la cadena de texto ingresada por el usuario.
- **mostrarCartas(cartas: List\<Carta\>): void, público.** Recorre e imprime las características de una lista de cartas.
- **mostrarCarta(carta: Carta): void, público.** Imprime en pantalla la información detallada de una carta en particular.
- **mostrarTablero(tablero: Tablero): void, público.** Imprime en pantalla la información detallada del tablero.
- **mostrarMensaje(mensaje: String): void, público.** Muestra mensajes informativos o de alerta en la consola.

---

### ControladorJuego
Coordina la aplicación actuando como intermediario entre la lógica del modelo (`Mazo`, `Tablero`) y la interfaz de terminal (`VistaConsola`) bajo el patrón MVC.

#### Atributos
- **mazo: Mazo, privado.** Referencia al catálogo que administra la colección de cartas.
- **tablero: Tablero, privado.** Referencia al tablero que mantiene el estado global del juego.
- **vista: VistaConsola, privado.** Referencia al conector encargado de la entrada y salida de datos por consola.

#### Métodos
- **ControladorJuego(mazo: Mazo, tablero: Tablero, vista: VistaConsola): privado.** Constructor que asigna las instancias de los componentes necesarios para la operación del juego.
- **iniciar(): void, público.** Inicia la aplicación, ejecuta la carga inicial de cartas y mantiene el flujo del menú principal.
- **procesarOpcion(opcion: int): void, público.** Evalúa la opción seleccionada por el usuario y deriva la ejecución al flujo correspondiente.
- **listarCartas(): void, público.** Solicita la lista de cartas al mazo y las envía a la vista para su despliegue.
- **buscarPorId(): void, público.** Solicita el ID a la vista, busca la carta mediante el mazo y despliega el resultado.
- **buscarPorNombre(): void, público.** Solicita el nombre a la vista, realiza la búsqueda en el mazo y muestra la carta obtenida.
- **ordenarCartas(): void, público.** Ordena las cartas por costo de energía e informa al usuario del resultado.
- **jugarCarta(): void, público.** Permite al usuario seleccionar una carta, verifica la energía disponible, ejecuta el efecto de la carta en el tablero e informa la actualización.

---

### Main (Principal)
Punto de entrada al programa encargada de la ejecución inicial.

#### Atributos
*(Esta clase no posee atributos)*

#### Métodos
- **main(args: String[]): void, static, público.** Método principal que instancia los objetos del modelo, la vista y el controlador para arrancar la aplicación.